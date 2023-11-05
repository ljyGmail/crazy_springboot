package com.crazyit.firstboot.app.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {
    @Value("${crazyit.greeting2}")
    private String greeting2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("-----SecondServlet-----");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("为Spring Boot添加的第二个Servlet，信息：" + greeting2);
    }
}
