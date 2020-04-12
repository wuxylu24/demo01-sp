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
@TableName("sys_menu")
@ApiModel(value = "Menu",description = "菜单设置")
public class Menu extends BaseBo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父级菜单主键
     */
    private Long pid;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuPath;

    /**
     * 菜单编号
     */
    private String menuCode;

}
