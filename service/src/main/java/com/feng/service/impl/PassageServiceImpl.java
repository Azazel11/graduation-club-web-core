package com.feng.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.feng.dao.FileMapper;
import com.feng.dao.PassageMapper;
import com.feng.dao.PassageTypeMapper;

import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import com.feng.enums.ErroEnum;
import com.feng.exception.BusinessException;
import com.feng.service.PassageService;
import com.feng.vo.PassagePageVo;
import com.feng.vo.PassageVo;
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
 * @since 2019-03-03
 */
@Service
public class PassageServiceImpl implements PassageService {
    @Autowired
    private PassageMapper passageMapper;
    @Autowired
    private PassageTypeMapper passageTypeMapper;
    @Autowired
    private FileMapper fileMapper;

    @Override
    public PassageVo getTopN(int n, Passage search) {

        PassageType passageType = null;
        Wrapper<Passage> passageWrapper = new EntityWrapper<>();
        if (search != null && search.getPassageTypeId() != 0) {
            passageWrapper.eq("passage_type_id", search.getPassageTypeId());
            passageType = passageTypeMapper.selectById(search.getPassageTypeId());
        }
        passageWrapper.orderBy("publish_time", false);
        PageHelper.startPage(1, n);
        List<Passage> passageList = passageMapper.selectList(passageWrapper);
        return new PassageVo(passageType, passageList);
    }

    @Override
    public PassagePageVo getPageWithTypeList(int pageNum, int pageSize, Integer passageTypeId) {
        PassageType passageType = null;
        Wrapper<Passage> passageWrapper = new EntityWrapper<>();
        if (passageTypeId != null) {
            passageWrapper.eq("passage_type_id", passageTypeId);
            passageType = passageTypeMapper.selectById(passageTypeId);
        }
        passageWrapper.orderBy("publish_time", false);
        PageHelper.startPage(pageNum, pageSize);
        List<Passage> passageList = passageMapper.selectList(passageWrapper);
        return new PassagePageVo(passageType, new PageInfo<>(passageList));
    }

    @Override
    @Cacheable(value = "passage")
    public Passage getInfoById(Integer id) {
        Passage passageFileDto = passageMapper.getInfoById(id);
        if (passageFileDto == null) {
            throw new BusinessException(ErroEnum.BUSINESS_EXCEPTION.setMsg("文章不存在"));
        }
        return passageFileDto;
    }

}
