package com.neu.his.mbg.dao;


//import com.neu.his.mbg.model.SmsPermission;
//import com.neu.his.mbg.model.SmsRolePermissionRelation;
import com.neu.his.mbg.model.SmsPermission;
import com.neu.his.mbg.model.SmsRolePermissionRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: SmsRolePermissionDao
 * @description: TODO
 * @author Zain
 * @date 2023/5/3014:22
 */

@Mapper
public interface SmsRolePermissionDao {
    /**
     * 根据角色获取权限
     * <p>author:szh
     */
    List<SmsPermission> getPermissionList(@Param("roleId") Long roleId);

    /**
     * 批量插入角色和权限关系
     * <p>author:szh
     */
    int insertList(@Param("list") List<SmsRolePermissionRelation> list);



}
