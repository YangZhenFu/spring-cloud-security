package com.spring.cloud.security.admin.mapper;

import com.spring.cloud.security.admin.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * 用户管理Mapper接口
 * @author yangzhenfu
 * @createtime 2017年7月6日 上午9:42:53
 * @classname UserMapper.java
 */
public interface UserMapper extends Mapper<User> {
    public List<User> selectMemberByGroupId(@Param("groupId") int groupId);
    public List<User> selectLeaderByGroupId(@Param("groupId") int groupId);
}