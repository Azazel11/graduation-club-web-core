package com.feng.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author rf
 * @since 2019-04-26
 */
@Data
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动地点
     */
    private String site;
    /**
     * 活动举行时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd HH:mm")
    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private Date holdTime;
    /**
     * 活动介绍
     */

    private String introduce;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd HH:mm")
    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private Date applyTime;

    private Integer activityTypeId;

}
