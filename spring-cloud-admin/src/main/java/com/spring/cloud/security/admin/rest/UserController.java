package com.spring.cloud.security.admin.rest;

import com.github.pagehelper.PageHelper;
import com.spring.cloud.security.admin.biz.UserBiz;
import com.spring.cloud.security.admin.entity.User;
import com.spring.cloud.security.common.msg.TableResultResponse;
import com.spring.cloud.security.common.rest.BaseController;
import com.spring.cloud.security.common.msg.ListRestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description 用户管理Action
 * @author yangzhenfu
 * @version 2017年7月6日 下午5:01:09
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController<UserBiz,User> {

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<User> page(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1")int offset, String name){
        Example example = new Example(User.class);
        if(StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
            example.createCriteria().andLike("username", "%" + name + "%");
        }
        int count = baseBiz.selectCountByExample(example);
        PageHelper.startPage(offset, limit);
        return new TableResultResponse<User>(count,baseBiz.selectByExample(example));
    }


}
