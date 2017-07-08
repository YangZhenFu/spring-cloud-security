package com.spring.cloud.security.admin.rest;

import com.spring.cloud.security.admin.biz.MenuBiz;
import com.spring.cloud.security.admin.entity.Menu;
import com.spring.cloud.security.admin.vo.MenuTree;
import com.spring.cloud.security.common.rest.BaseController;
import com.spring.cloud.security.common.util.TreeUtil;
import com.spring.cloud.security.admin.constant.CommonConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 菜单管理Action
 * @author yangzhenfu
 * @version 2017年7月7日 下午14:01:09
 */
@Controller
@RequestMapping("menu")
public class MenuController extends BaseController<MenuBiz, Menu> {
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> list(String title) {
        Example example = new Example(Menu.class);
        if (StringUtils.isNotBlank(title))
            example.createCriteria().andLike("title", "%" + title + "%");
        return baseBiz.selectByExample(example);
    }

    @RequestMapping(value = "/sys", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getSys() {
        Menu menu = new Menu();
        menu.setParentId(CommonConstant.ROOT);
        return baseBiz.selectList(menu);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuTree> listMenu(Integer parentId) {
        try {
            if (parentId == null) {
                parentId = this.getSys().get(0).getId();
            }
        } catch (Exception e) {
            return new ArrayList<MenuTree>();
        }
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        Example example = new Example(Menu.class);
        Menu parent = baseBiz.selectById(parentId);
        example.createCriteria().andLike("path", parent.getPath() + "%").andNotEqualTo("id",parent.getId());
        for (Menu menu : baseBiz.selectByExample(example)) {
            node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees,parent.getId());
    }
}
