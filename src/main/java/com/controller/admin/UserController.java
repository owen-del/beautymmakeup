package com.controller.admin;

import cn.hutool.core.lang.Console;
import com.entity.Category;
import com.entity.User;
import com.response.ResponseResult;
import com.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户管理
     * @param name
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView goods(@RequestParam(value = "name", defaultValue = "") String name, ModelAndView modelAndView) {
        List<User> userList = userService.findLikeName(name);
        modelAndView.setViewName("/admin/user/user");
        modelAndView.addObject("list", userList);
        return modelAndView;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        userService.deleteById(id);
        return "redirect:/admin/user/user";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return userService.deleteBatch(ids);
    }

    /**
     * 锁定或放开
     * @param id
     * @return
     */
    @RequestMapping(value = "/lockOrOpen/{id}", method = RequestMethod.GET)
    public String lockOrOpen(@PathVariable("id") Long id) {
        // 删除
        userService.lockOrOpen(id);
        return "redirect:/admin/user/user";
    }

    /**
     * 批量锁定或解锁
     * @param ids
     * @param status 1：锁定；0：解锁
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lockOrOpenBatch", method = RequestMethod.POST)
    public ResponseResult lockOrOpenBatch(@RequestParam(value = "ids[]") Long[] ids, @RequestParam(value = "status") Integer status) {
        return userService.lockOrOpenBatch(ids, status);
    }

    /**
     * 添加或修改
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/editOneself", method = RequestMethod.GET)
    public ModelAndView editOneself(HttpServletRequest request, ModelAndView modelAndView) {
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        User user = userService.findById(loginUser.getId());
        modelAndView.setViewName("/admin/oneself/oneselfInfo");
        modelAndView.addObject("user", user);
        modelAndView.addObject("op", "修改个人信息");
        return modelAndView;
    }


    @RequestMapping(value = "/saveOrUpdateOneself", method = RequestMethod.POST)
    public String saveOrUpdateOneself(User user) {
        userService.saveOrUpdate(user);
        return "redirect:/admin/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/user/addOrEdit");
        modelAndView.addObject("op", "用户添加");
        return modelAndView;
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(User user) {
        userService.saveOrUpdate(user);
        return "redirect:/admin/user/user";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        User user = userService.findById(id);
        modelAndView.setViewName("/admin/oneself/oneselfInfo");
        modelAndView.addObject("user", user);
        modelAndView.addObject("op", "修改用户信息");
        return modelAndView;
    }


}
