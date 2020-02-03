package com.misiai.controller;

import com.misiai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@SessionAttributes(value = {"user"}, types = {String.class})
@Controller
@RequestMapping("/test")
public class TestController {
    private static final String SUCCESS = "success";

    @RequestMapping("/test")
    public String test() {
        return SUCCESS;
    }

    // @ResponseBody
    @RequestMapping("/testJson")
    public User testJson() {
        User user = new User("wudao", 14);
        System.out.println("testJson");
        return user;
    }

    @RequestMapping("/testForward")
    public String testForward() {

        return "forward:/test/testForward2";
    }

    @RequestMapping("/testForward2")
    public String testForward2() {
        return SUCCESS;
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {

        return "redirect:/second.jsp";
    }


    @RequestMapping("/testRedirect2")
    public String testRedirect2() {

        return SUCCESS;
    }


    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute User user) {
        System.out.println("testModelAttribute方法中的user：" + user);
        System.out.println("testModelAttribute方法");
        return SUCCESS;
    }

    // 该方法会先于其他方法执行
    @ModelAttribute
    public void ModelAttribute(Map<String, Object> map) {
        User user = new User("无道", 13);
        // System.out.println("数据库中查到的某条记录 ：" + user);
        // 将user保存起来，保存的方法可以用之前学到的Map
        map.put("user", user);
    }


    @RequestMapping("/testSession")
    public String testSession(Map<String, Object> map) {
        User user = new User("kuan", 18);
        map.put("user", user);
        map.put("Misiai", "misiai.com");
        return SUCCESS;
    }

    /**
     * 目标方法可以添加Map类型的参数。
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("name", Arrays.asList("Tom", "Tim", "Mike"));
        return SUCCESS;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        // 添加模型数据到modelAndView
        modelAndView.addObject("time", new Date());

        return modelAndView;

    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        String kuan = request.getParameter("kuan");
        System.out.println("Kuan：" + kuan);
        return SUCCESS;
    }

    @RequestMapping("/testDomainParam")
    public String testDomainParam(User user) {
        System.out.println("User:" + user);
        return SUCCESS;
    }

    /**
     * 请求Cookie绑定
     */
    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("Cookie JSESSIONID的值：" + cookie);
        return SUCCESS;
    }

    /**
     * 获取请求头的值
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "kuan") String kuan) {
        System.out.println("请求头kuan的值：" + kuan);
        return SUCCESS;
    }

    /**
     * 请求参数
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String user, @RequestParam("age") Integer age) {
        System.out.println("用户名：" + user + ", 年龄：" + age);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRestful", method = RequestMethod.DELETE)
    public String testRestful() {
        System.out.println("DELETE请求方式");
        return SUCCESS;
    }

    @RequestMapping("/testPathVar/{id}")
    public String testPathVar(@PathVariable("id") Integer id) {
        System.out.println("testPathVar：" + id);
        return SUCCESS;
    }


    @RequestMapping("/testAnt/*")
    public String testAnt() {
        return SUCCESS;
    }

    /**
     * 测试请求请求头
     */
    @RequestMapping(value = "/testHeader", headers = {"Accept-Encoding: gzip, deflate, br"})
    public String testHeader() {
        return SUCCESS;
    }

    /**
     * 测试请求参数
     * 表示：携带有Username，且参数age!=18
     */
    @RequestMapping(value = "/testParam", params = {"username", "age!=18"})
    public String testParam() {
        return SUCCESS;
    }

    /**
     * 测试指定方法
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        return SUCCESS;
    }


    @RequestMapping(value = "/map")
    public String testMapping() {
        System.out.println("Hello Test Mapping");
        return SUCCESS;
    }
}
