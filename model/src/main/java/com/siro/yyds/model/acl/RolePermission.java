package com.siro.yyds.model.acl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.siro.yyds.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色权限
 * </p>

 */
@Data
@ApiModel(description = "角色权限")
@TableName("acl_role_permission")
public class RolePermission extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "roleid")
	@TableField("role_id")
	private Long roleId;

	@ApiModelProperty(value = "permissionId")
	@TableField("permission_id")
	private Long permissionId;

}

