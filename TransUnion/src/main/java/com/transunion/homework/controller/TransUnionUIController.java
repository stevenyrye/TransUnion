package com.transunion.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class TransUnionUIController {
    //@RequestMapping(value = { "/", "/{path:^(?!api$).*$}", "/**/{path:^(?!api$).*$}" })
    @RequestMapping(value = { "/" })
    public String forward() {
        return "forward:/index.html";
    }
}
