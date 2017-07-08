package com.spring.cloud.security.admin.mapper;

import com.spring.cloud.security.admin.entity.Group;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
/**
 * 用户组类型管理Mapper接口
 * @author yangzhenfu
 * @createtime 2017年7月8日 下午16:24:13
 * @classname GroupMapper.java
 */
public interface GroupMapper extends Mapper<Group> {
    public void deleteGroupMembersById (@Param("groupId") int groupId);
    public void deleteGroupLeadersById (@Param("groupId") int groupId);
    public void insertGroupMembersById (@Param("groupId") int groupId,@Param("userId") int userId);
    public void insertGroupLeadersById (@Param("groupId") int groupId,@Param("userId") int userId);
}