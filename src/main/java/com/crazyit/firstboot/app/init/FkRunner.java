package com.crazyit.firstboot.app.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FkRunner implements ApplicationRunner {

    // 该run()方法将在应用启动完成之前执行
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("模拟对SpringApplication执行初始化，下面获取运行参数");
        System.out.println("getSourceArgs: " + Arrays.toString(args.getSourceArgs()));
        System.out.println("getOptionValues: " + args.getOptionValues("book.name"));
        System.out.println("getNonOptionArgs: " + args.getNonOptionArgs());
    }
}
