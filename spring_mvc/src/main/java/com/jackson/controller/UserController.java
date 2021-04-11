package com.jackson.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.entity.User;
import com.jackson.entity.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller(value = "userController")
public class UserController {

    @RequestMapping(value = "/returnString")
    public String pageStringSkip() {
        System.out.println("userController save() running");


        // return 要跳轉的視圖
        return "success";
    }

    @RequestMapping(value = "/returnMNV")
    public ModelAndView pageModelAndViewSkip() {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("userController save() running");

        // 設置模型數據
        modelAndView.addObject("username", "jackson");

        // 設置視圖名稱
        modelAndView.setViewName("success");


        return modelAndView;
    }

    @RequestMapping(value = "/returnMNVParam")
    public ModelAndView pageModelAndViewSkip2(ModelAndView modelAndView) {
        modelAndView.addObject("username", "model and view as param");

        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/reqParam")
    public String requestParam(HttpServletRequest request) {

        request.setAttribute("username", "request set");


        return "success";
    }

    @RequestMapping(value = "/respParam")
    public void responseParam(HttpServletResponse response) throws IOException {

        // 囘寫字符串
        response.getWriter().write("Hello World!");

    }

    @RequestMapping(value = "/respBody")
    @ResponseBody
    public String respBody() throws IOException {

        // 囘寫字符串
        return "Hello @ResponseBody";

    }

    @RequestMapping(value = "/jsonBody")
    @ResponseBody
    public String jsonBody() throws IOException {

        User user = new User("jackson", 20);


        ObjectMapper objectMapper = new ObjectMapper();


        String userJson = objectMapper.writeValueAsString(user);

        System.out.println("jsonBody()...");

        System.out.println(userJson);

        return userJson;

    }

    @RequestMapping(value = "/mvcJsonBody")
    @ResponseBody
    // 期望SpringMVC自動將User轉換成JSON字符串
    public User mvcJsonBody() throws IOException {

        User user = new User("jackson", 20);

        return user;
    }

    /* -------------------------------獲取請求參數----------------------------------------- */
    @RequestMapping(value = "/getPrimReqParam")
    @ResponseBody
    // 獲得基本類型請求參數
    // 參數名稱需和請求參數的name一致，參數值能夠自動映射
    public void getReqParam(String username, int age) {
        // 這種情況 若無這兩參數 會報錯
        System.out.println("username = " + username);
        System.out.println("age = " + age);
    }

    @RequestMapping(value = "/getPojoReqParam")
    @ResponseBody
    // 獲得POJO類型請求參數
    // POJO參數的屬性名與請求參數的name一致，參數值能夠自動映射
    public void getPojoReqParam(User user) {
        System.out.println(user);
    }

    @RequestMapping(value = "/getArrReqParam")
    @ResponseBody
    // 獲得POJO類型請求參數
    // POJO參數的屬性名與請求參數的name一致，參數值能夠自動映射
    public void getArrReqParam(String[] strings) {
        System.out.println(Arrays.toString(strings));
    }

    @RequestMapping(value = "/getListReqParam")
    @ResponseBody
    // 獲得List類型請求參數
    //
    public void getListReqParam(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping(value = "/getJsonReqParam")
    @ResponseBody
    // 獲得List類型請求參數
    //
    public void getJsonReqParam(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping(value = "/reqParamMapping")
    @ResponseBody
    // 參數映射
    //
    public void reqParamMapping(@RequestParam(value = "name", required = false, defaultValue = "user") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/restfulParam/{name}")
    @ResponseBody
    // 參數映射
    //
    public void restfulParam(@PathVariable(value = "name", required = true) String username) {
        System.out.println(username);
    }



    @RequestMapping(value = "/typeConvert")
    @ResponseBody
    // 類型轉換
    // default: http://localhost:8080/typeConvert?date=2021/04/11%2011:08:45 OK
    //
    public void typeConvert(Date date) {
        System.out.println(date);
    }


    @RequestMapping(value = "/servletAPI")
    @ResponseBody
    // 原始ServletAPI對象作爲 參數注入
    // HttpServletRequest
    // HttpServletResponse
    // HttpSession
    public void servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("session = " + session);
    }


    @RequestMapping(value = "/reqHeader")
    @ResponseBody
    // 獲取請求頭
    //
    public void reqHeader(@RequestHeader(value = "Host", required = true) String host) {
        System.out.println("host = " + host);
    }

    @RequestMapping(value = "/reqCookie")
    @ResponseBody
    // 獲取請求頭
    //
    public void reqCookie(@CookieValue(value = "JSESSIONID", required = true) String sessionId) {
        System.out.println("sessionId = " + sessionId);
    }

    @RequestMapping(value = "/fileUpload")
    @ResponseBody
    // 文件上傳
    //
    public void fileUpload(String name, MultipartFile uploadFile, MultipartFile uploadFile2, MultipartFile uploadFile3) throws IOException {
        System.out.println("name = " + name);

        // 獲得文件名稱
        String originalFilename = uploadFile.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);

        // 保存文件
        uploadFile.transferTo(new File("C:\\Users\\Administrator\\Desktop\\fileupload.txt"));
    }

    @RequestMapping(value = "/fileUploads")
    @ResponseBody
    // 文件上傳
    //
    public void fileUploads(String name, MultipartFile[] uploadFiles) throws IOException {
        System.out.println("name = " + name);
        String originalFilename = null;
        for (MultipartFile uploadFile : uploadFiles) {
            // 獲得文件名稱
            originalFilename = uploadFile.getOriginalFilename();
            System.out.println("originalFilename = " + originalFilename);

            // 保存文件
            uploadFile.transferTo(new File("C:\\Users\\Administrator\\Desktop\\" + originalFilename));

        }
    }
}
