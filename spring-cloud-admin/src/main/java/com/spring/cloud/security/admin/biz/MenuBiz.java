package com.spring.cloud.security.admin.biz;

import com.spring.cloud.security.admin.entity.Menu;
import com.spring.cloud.security.common.biz.BaseBiz;
import com.spring.cloud.security.admin.constant.CommonConstant;
import org.springframework.stereotype.Service;
import com.spring.cloud.security.admin.mapper.MenuMapper;

/**
 *  菜单管理Service
 * @author yangzhenfu
 * @create 2017-07-07 10:34
 */
@Service
public class MenuBiz extends BaseBiz<MenuMapper,Menu> {
    @Override
    public void insertSelective(Menu entity) {
        if(CommonConstant.ROOT == entity.getParentId()){
            entity.setPath("/"+entity.getCode());
        }else{
            Menu parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath()+"/"+entity.getCode());
        }
        super.insertSelective(entity);
    }

    @Override
    public void updateById(Menu entity) {
        if(CommonConstant.ROOT == entity.getParentId()){
            entity.setPath("/"+entity.getCode());
        }else{
            Menu parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath()+"/"+entity.getCode());
        }
        super.updateById(entity);
    }
}
