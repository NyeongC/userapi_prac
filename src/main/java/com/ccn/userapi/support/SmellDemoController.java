package com.ccn.userapi.support;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SmellDemoController {

    private final SmellDemoService svc;

    SmellDemoController(SmellDemoService svc) {
        this.svc = svc;
    }

    @GetMapping("/smell/ping")
    public String ping() {
        svc.calcScore(3);
        svc.swallow();
        svc.joinBadly(List.of("a","b","c"));
        svc.complexLogic(1, 2, 3);
        return "ok";
    }
}
