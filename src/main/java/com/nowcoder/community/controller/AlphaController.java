package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
//给类声明一个路径
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    //给方法声明一个路径， 服务器 能够访问这个方法
    @RequestMapping("/hello")
    //加一个注解进行声明，表示返回的是字符串
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }
    //处理请求的方法
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));
        System.out.println(request.getParameter("name"));

        //返回响应数据
        //返回网页类型的文本
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer = response.getWriter();){

            writer.write("<hl>牛客网</hl>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET请求 如何处理

    //查询所有学生的数据
    // /student?current=1&limit=20
    //指定只有request.get
    @RequestMapping(path="/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            //可以不传
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    //参数成为路径的一部分
    // /student/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";

    }

    //POST 请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }


    //响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    //不加@ResponseBody 默认返回网页
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name", "北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    //响应json数据，异步请求：访问了服务器 但是当前网页不刷新
    // Java对象 -> JSON字符串 -> JS对象/其他任何对象
    @RequestMapping(path="/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",30);
        emp.put("salary", 3000);
        return emp;
    }

    @RequestMapping(path="/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",30);
        emp.put("salary", 3000);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","张三2");
        emp.put("age",30);
        emp.put("salary", 3000);
        list.add(emp);

        return list;
    }
}
