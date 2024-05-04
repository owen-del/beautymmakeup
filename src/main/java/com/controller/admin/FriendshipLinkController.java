package com.controller.admin;

import com.entity.Category;
import com.entity.FriendshipLink;
import com.response.ResponseResult;
import com.service.FriendshipLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/friendshipLink")
public class FriendshipLinkController {

    @Autowired
    private FriendshipLinkService friendshipLinkService;

    /**
     * 友情链接
     * @param name
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/friendshipLink", method = RequestMethod.GET)
    public ModelAndView goods(@RequestParam(value = "name", defaultValue = "") String name, ModelAndView modelAndView) {
        List<FriendshipLink> friendshipLinkList = friendshipLinkService.findByNameLike(name);
        modelAndView.setViewName("/admin/friendshipLink/friendshipLink");
        modelAndView.addObject("list", friendshipLinkList);
        return modelAndView;
    }


    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        // 删除
        friendshipLinkService.deleteById(id);
        return "redirect:/admin/friendshipLink/friendshipLink";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public ResponseResult deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        return friendshipLinkService.deleteBatch(ids);
    }

    /**
     * 添加或修改
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, ModelAndView modelAndView) {
        FriendshipLink friendshipLink = friendshipLinkService.findById(id);
        modelAndView.setViewName("/admin/friendshipLink/addOrEdit");
        modelAndView.addObject("friendshipLink", friendshipLink);
        modelAndView.addObject("op", "信息修改");
        return modelAndView;
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(FriendshipLink friendshipLink) {
        friendshipLinkService.saveOrUpdate(friendshipLink);
        return "redirect:/admin/friendshipLink/friendshipLink";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/friendshipLink/addOrEdit");
        modelAndView.addObject("op", "新增信息");
        return modelAndView;
    }

}
