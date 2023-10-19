package org.fkit.app;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    public String bark() {
        return "来自Dog的测试方法";
    }
}
