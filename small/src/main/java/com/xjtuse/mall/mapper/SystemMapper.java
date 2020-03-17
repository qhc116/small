package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.system.*;
import com.xjtuse.mall.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 失了秩
 * @date 2020/3/14 16:18
 * @description
 */
public interface SystemMapper {
    void storageCreate(@Param("storage") Storage storage);

    List<AdminRes> queryadminList(@Param("pageUtil") PageUtil pageUtil, @Param("username") String username);

    int queryAdminCount(@Param("username") String username);

    List<LabelValue> queryRoleOptions();

    void updateAdminById(@Param("admin") Admin admin);

    List<Role> queryAdminRoles(@Param("pageUtil") PageUtil pageUtil,@Param("role")  Role role);

    int selectRolesCount(@Param("role") Role role);

    void updateRoleById(@Param("role") Role role);

    void setRoleDeleted(@Param("role") Role role);
}
