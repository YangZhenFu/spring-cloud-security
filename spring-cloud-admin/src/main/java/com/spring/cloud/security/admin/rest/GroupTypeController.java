package com.spring.cloud.security.admin.rest;

import com.spring.cloud.security.admin.biz.GroupTypeBiz;
import com.spring.cloud.security.admin.entity.GroupType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.spring.cloud.security.admin.biz.UserBiz;
import com.spring.cloud.security.admin.entity.User;
import com.spring.cloud.security.common.msg.TableResultResponse;
import com.spring.cloud.security.common.rest.BaseController;

import tk.mybatis.mapper.entity.Example;

/**
 * @Description 组类型管理Action
 * @author yangzhenfu
 * @version 2017年7月9日 上午11:15:14
 */
@Controller
@RequestMapping("groupType")
public class GroupTypeController extends BaseController<GroupTypeBiz,GroupType> {

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<GroupType> page(int limit, int offset, String name){
        Example example = new Example(User.class);
        if(StringUtils.isNotBlank(name))
            example.createCriteria().andLike("name", "%" + name + "%");
        int count = baseBiz.selectCountByExample(example);
        PageHelper.startPage(offset, limit);
        return new TableResultResponse<GroupType>(count,baseBiz.selectByExample(example));
    }

}
