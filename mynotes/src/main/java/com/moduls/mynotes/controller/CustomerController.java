package com.moduls.mynotes.controller;

import com.moduls.mynotes.pojo.Customer;
import com.moduls.mynotes.pojo.Orders;
import com.moduls.mynotes.pojo.Repair;
import com.moduls.mynotes.service.CustomerService;
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
@SuppressWarnings("all")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RepairService repairService;

    @GetMapping("getCustomerById")
    public Map<String,Object> getCustomerById(Long customerId){
        Map<String,Object> map=new HashMap<>();
        if(customerId<=0 || customerId==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.getCustomerById(customerId));
            return map;
        }
    }

    @PostMapping("save")
    public Map<String,Object> save(Orders orders){
        Map<String,Object> map=new HashMap<>();
        if(orders==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.save(orders));
            return map;
        }
    }

    @PutMapping("update")
    public Map<String,Object> update(Orders orders){
        Map<String,Object> map=new HashMap<>();
        if(orders==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.update(orders));
            return map;
        }
    }

    @DeleteMapping("delete")
    public Map<String,Object> delete(Long customerId , Integer repairId){
        Map<String,Object> map=new HashMap<>();
        if(customerId<=0 || customerId==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.delete(customerId,repairId));
            return map;
        }
    }

    @GetMapping("listOfCondition")
    public Map<String,Object> listOfCustomer(String date,Long customerId){
        Map<String,Object> map=new HashMap<>();
        if(date.isEmpty()){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.listOfCustomer(date,customerId));
            return map;
        }
    }

    @GetMapping("/listCustomerInToday")
    public Map<String,Object> listCustomerInToday(String date,String kname, String knum){
        Map<String,Object> map=new HashMap<>();
        if(date.isEmpty()){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.listCustomerInToday(date,kname,knum));
            return map;
        }
    }
}
