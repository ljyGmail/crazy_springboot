package com.crazyit.firstboot.app.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Value("${crazyit.greeting}")
    private String greeting;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("-----FirstServlet-----");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("为Spring Boot添加第一个Servlet，信息: " + greeting);
    }
}
