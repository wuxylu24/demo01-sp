package com.shp.demo.admin.api.entity.authority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.shp.demo.common.base.bo.BaseBo;


@Data
@NoArgsConstructor
@TableName("sys_auth")
@ApiModel(value = "Authority",description = "权限设置")
public class Authority extends BaseBo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 权限名称
     * */
    private String authName;
    /**
     * 权限代码
     * */
    private String authCode;
    /**
     * 权限url
     * */
    private String authUrl;

}
