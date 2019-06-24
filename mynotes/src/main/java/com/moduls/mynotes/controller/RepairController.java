package com.moduls.mynotes.controller;

import com.moduls.mynotes.pojo.Repair;
import com.moduls.mynotes.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-24
 */
@RestController
@RequestMapping("repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @PostMapping("save")
    public Integer save(Repair repair){
        return repairService.save(repair);
    }

    @PutMapping("update")
    public Integer update (Repair repair){
        return repairService.update(repair);
    }

    @DeleteMapping("delete")
    public Integer delete(Integer repairId){
        return repairService.delete(repairId);
    }
}
