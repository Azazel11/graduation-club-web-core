package com.feng.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.ClubMapper;
import com.feng.dao.ClubTypeMapper;
import com.feng.entity.Club;
import com.feng.entity.ClubType;
import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import com.feng.enums.ErroEnum;
import com.feng.exception.BusinessException;
import com.feng.service.ClubService;
import com.feng.vo.ClubInfoVo;
import com.feng.vo.ClubPageVo;
import com.feng.vo.ClubVo;
import com.feng.vo.PassagePageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rf
 * @since 2019-04-14
 */
@Service
public class ClubServiceImpl extends ServiceImpl<ClubMapper, Club> implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private ClubTypeMapper clubTypeMapper;

    @Override
    public ClubPageVo getPageWithTypeList(int pageNum, int pageSize, Integer clubTypeId) {
        ClubType clubType = null;
        Wrapper<Club> clubWrapper = new EntityWrapper<>();
        if (clubTypeId != null) {
            clubWrapper.eq("club_type_id", clubTypeId);
            clubType = clubTypeMapper.selectById(clubTypeId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Club> clubList = clubMapper.selectList(clubWrapper);
        return new ClubPageVo(clubType,new PageInfo<>(clubList));
    }

    @Override
    @Cacheable(value = "club")
    public Club getById(Serializable num) {
        Club club = clubMapper.selectById(num);
        if (club == null) {
            throw new BusinessException(ErroEnum.BUSINESS_EXCEPTION.setMsg("社团不存在"));
        }
        return club;
    }

}
