package com.controller;

import com.entity.User;
import com.response.ResponseResult;
import com.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

// 处理登录业务的Controller
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param account
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("captcha") String captcha, HttpServletRequest request){
        // 从session中获取验证码
        String verifyCode = Optional.ofNullable(request.getSession().getAttribute("verifyCode")).map(Object::toString).orElse("");
        if (captcha.equalsIgnoreCase(verifyCode)) {
            User user = userService.findUserByAccountAndPassword(account, password);
            AtomicReference<ResponseResult> responseResult = new AtomicReference<>();
            Optional.ofNullable(user).ifPresentOrElse(u -> {
                if ("正常".equals(u.getStatus())) {
                    responseResult.set(ResponseResult.SUCCESS("登录成功"));
                }else {
                    responseResult.set(ResponseResult.FAILED("账号状态异常"));
                }
            },() ->{
                responseResult.set(ResponseResult.FAILED("用户名或密码错误"));
            });
            return responseResult.get();
        }else {
            return ResponseResult.FAILED("验证码错误");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult register(User user){
        return userService.save(user);

    }


}
