package com.crazyit.firstboot.ch02;

import com.crazyit.firstboot.app.config.CrazyitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ch02")

public class Ch02Controller {

    private final CrazyitProperties crazyitProperties;

    @Autowired
    public Ch02Controller(CrazyitProperties crazyitProperties) {
        this.crazyitProperties = crazyitProperties;
    }

    @GetMapping("mixedCompoundType")
    public CrazyitProperties mixedCompoundType() {
        return crazyitProperties;
    }
}
