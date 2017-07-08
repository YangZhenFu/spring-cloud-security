package com.spring.cloud.security.admin.biz;

import com.spring.cloud.security.admin.entity.User;
import com.spring.cloud.security.common.biz.BaseBiz;
import com.spring.cloud.security.common.constant.UserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.spring.cloud.security.admin.mapper.UserMapper;

/**
 *	用户管理Service
 * @author yangzhenfu
 * @create 2017-07-06 16:23
 */
@Service
public class UserBiz extends BaseBiz<UserMapper,User> {

    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    public void updateById(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.updateById(entity);
    }
}
