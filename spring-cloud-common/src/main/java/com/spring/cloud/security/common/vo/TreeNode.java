package com.spring.cloud.security.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.spring.cloud.security.common.vo.TreeNode;

/**
 * 树形节点实体VO
 * @author yangzhenfu
 * @createtime 2017-05-15 16:41
 */
public class TreeNode {
    protected int id;
    protected int parentId;

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    List<TreeNode> children = new ArrayList<TreeNode>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void add(TreeNode node){
        children.add(node);
    }
}
