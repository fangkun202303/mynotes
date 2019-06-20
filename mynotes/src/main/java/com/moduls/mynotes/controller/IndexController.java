package com.moduls.mynotes.controller;

import com.moduls.mynotes.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-20
 */
@RestController
public class IndexController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String getStr(){
        return testService.getStr();
    }
}
