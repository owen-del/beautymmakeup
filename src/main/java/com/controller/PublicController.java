package com.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.io.FileUtil;
import com.response.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.AccessException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// 开放的Controller
@Controller
@RequestMapping("/public")
public class PublicController {

    // 登录获取图片验证码
    @ResponseBody
    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    public void getccode(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(150, 40, 5, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        shearCaptcha.write(response.getOutputStream());
        //获取验证码中的文字内容
        request.getSession().setAttribute("verifyCode", shearCaptcha.getCode());

    }

    @ResponseBody
    @PostMapping("/upload")
    public ResponseResult upload(@RequestParam("file")  MultipartFile file, HttpServletRequest request) throws IOException {
        String uploadPath = request.getServletContext().getRealPath("/upfile");
        try {
            // 获取上传文件的原始文件名
            String fileName = file.getOriginalFilename();
            //重命名文件
            String saveFileName = UUID.randomUUID().toString() + '.' + FileUtil.extName(fileName);
            // 构造文件保存的路径
            String filePath = Paths.get(uploadPath, saveFileName).toString();
            // 获取上传目录的绝对路径
            Path absolutePath = Paths.get(uploadPath).toAbsolutePath();
            // 构造文件的绝对路径
            String absoluteFilePath = Paths.get(absolutePath.toString(), saveFileName).toString();
            // 将上传的文件传输到指定位置
            file.transferTo(new File(absoluteFilePath));
            // 返回文件保存的路径
            Map<String, String> map = new HashMap<>();
            map.put("AbsolutePath", filePath.replace("\\" , "/"));
            map.put("RelativePath", filePath.replace(request.getServletContext().getRealPath("/"),"/").replace("\\" , "/"));
            return ResponseResult.SUCCESS("文件上传成功").setData(map);
        } catch (IOException e) {
            throw new AccessException(e.getMessage());
        }

    }


}
