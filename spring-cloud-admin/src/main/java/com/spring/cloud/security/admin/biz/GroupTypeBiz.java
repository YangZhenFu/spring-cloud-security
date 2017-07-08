package com.spring.cloud.security.admin.biz;

import org.springframework.stereotype.Service;

import com.spring.cloud.security.admin.entity.GroupType;
import com.spring.cloud.security.admin.mapper.GroupTypeMapper;
import com.spring.cloud.security.common.biz.BaseBiz;

/**
 * 分组类型管理Service
 * @author yangzhenfu
 * @create 2017-07-08 11:48
 */
@Service
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper,GroupType> {
}
