package com.moduls.mynotes.service.impl;

import com.moduls.mynotes.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-20
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getStr() {
        return "ceshi";
    }
}
