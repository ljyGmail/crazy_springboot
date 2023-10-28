package com.crazyit.firstboot.ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Map;

@RestController
@Profile("prod")
@RequestMapping("ch02")
public class ProdController {

    private final DataSource dataSource;

    @Autowired
    public ProdController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("configConvertProfile")
    public Map<String, String> configConvertProfile() throws Exception {
        return Map.of("class", "产品场的控制器", "数据库", dataSource.getConnection().getCatalog());
    }
}