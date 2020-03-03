package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.entity.Activity;
import com.feng.vo.ActivityPageVo;
import com.feng.vo.ActivityVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
public interface ActivityService extends IService<Activity> {
    ActivityVo getTopN(int n, Activity search);

    ActivityPageVo getPageWithTypeList(int pageNum, int pageSize, Integer activityTypeId);

    Activity getInfoById(Integer id);

}
