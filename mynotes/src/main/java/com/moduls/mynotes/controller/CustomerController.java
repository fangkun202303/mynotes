package com.moduls.mynotes.controller;

import com.moduls.mynotes.pojo.Customer;
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
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RepairService repairService;

    @GetMapping("getCustomerById")
    public Map<String,Object> getCustomerById(Integer customerId){
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
    public Map<String,Object> save(Customer customer){
        Map<String,Object> map=new HashMap<>();
        if(customer==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.save(customer));
            return map;
        }
    }

    @PutMapping("update")
    public Map<String,Object> update(Customer customer){
        Map<String,Object> map=new HashMap<>();
        if(customer==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.update(customer));
            return map;
        }
    }

    @DeleteMapping("delete")
    public Map<String,Object> delete(Integer customerId){
        Map<String,Object> map=new HashMap<>();
        if(customerId<=0 || customerId==null){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.delete(customerId));
            return map;
        }
    }

    @GetMapping("listOfCondition")
    public Map<String,Object> listOfCustomer(String before, String after){
        Map<String,Object> map=new HashMap<>();
        if(before.isEmpty() || after.isEmpty()){
            map.put("code",0);
            map.put("data",null);
            return map;
        }else{
            map.put("code",1);
            map.put("data",customerService.listOfCustomer(before,after));
            return map;
        }
    }
}
