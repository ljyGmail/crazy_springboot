package com.crazyit.firstboot.app;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

import java.net.BindException;

public class MyAnalyzer extends AbstractFailureAnalyzer<BindException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, BindException cause) {
        cause.printStackTrace();
        return new FailureAnalysis("程序启动出错，程序绑定的端口被占用: " + cause.getMessage(),
                "请先停止占用8080端口的程序后再运行本应用或使用server.port改变本应用的端口", cause);
    }
}
