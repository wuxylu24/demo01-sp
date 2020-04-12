package com.shp.demo.common.base.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wuxylu
 */
@Data
public abstract class BaseBo implements Serializable {

    private LocalDateTime createTime;

    private Long createUser;

    private LocalDateTime updateTime;

    private Long updateUser;
}
