package com.spring.cloud.security.admin.vo;

import com.spring.cloud.security.common.vo.TreeNode;

/**
 * 用户组管理实体VO
 * @author yangzhenfu
 */
public class GroupTree extends TreeNode {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
