package com.moduls.mynotes.service.impl;

import com.moduls.mynotes.mapper.CustomerMapper;
import com.moduls.mynotes.mapper.RepairMapper;
import com.moduls.mynotes.pojo.Customer;
import com.moduls.mynotes.pojo.Orders;
import com.moduls.mynotes.pojo.Repair;
import com.moduls.mynotes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: CustomerService的实现
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-24
 */
@Service
@SuppressWarnings("all")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public Customer getCustomerById(Long customerId) {
        if(customerId<=0 && customerId!=null){
            Customer customer = customerMapper.getCustomerById(customerId);
            List<Repair> repairs = repairMapper.listOfRepair(customer.getCustomerId());
            customer.setRepairs(repairs);
            return customer;
        }
        return null;
    }

    @Transactional
    @Override
    public Integer save(Orders orders) {
        Customer customer=new Customer();
        customer.setName(orders.getName());
        customer.setSex(orders.getSex());
        customer.setPhone(orders.getPhone());
        customer.setCustomerId(orders.getCustomerId());
        customer.setCarNum(orders.getCarNum());
        customer.setCreateTime(orders.getCreateTime());
        customer.setAddress(orders.getAddress());
        customer.setCustomerId(System.currentTimeMillis());
        Integer save = customerMapper.save(customer);



        Repair repair=new Repair();
        repair.setItem(orders.getItem());
        repair.setCost(orders.getCost());
        repair.setCreateTime(orders.getCreateTime());
        repair.setCustomerid(customer.getCustomerId());

        Integer save1 = repairMapper.save(repair);

        if(save==1 && save1==1){
            return 1;
        }else{
            return 2;
        }
    }

    @Transactional
    @Override
    public Integer update(Orders orders) {
        Customer customer=new Customer();
        customer.setName(orders.getName());
        customer.setSex(orders.getSex());
        customer.setPhone(orders.getPhone());
        customer.setCustomerId(orders.getCustomerId());
        customer.setCarNum(orders.getCarNum());
        customer.setCreateTime(orders.getCreateTime());
        customer.setAddress(orders.getAddress());

        Repair repair=new Repair();
        repair.setItem(orders.getItem());
        repair.setCost(orders.getCost());
        repair.setCreateTime(orders.getCreateTime());
        repair.setCustomerid(orders.getCustomerId());
        repair.setRepairId(orders.getRepairId());
        Integer update = customerMapper.update(customer);

        Integer update1 = repairMapper.update(repair);

        if(update==1 && update1==1){
            return 1;
        }else{
            return 2;
        }
    }

    @Transactional
    @Override
    public Integer delete(Long customerId , Integer repairId) {
        if(customerId>0 && customerId!=null && repairId>0 && repairId!=null){
            Integer delete = customerMapper.delete(customerId);
            Integer delete1 = repairMapper.delete(repairId);
            if(delete==1 && delete1==1){
                return 1;
            }else{
                return 2;
            }
        }
        return 2;
    }

    @Override
    public List<Orders> listOfCustomer(String date,Long customerId) {
        if(!date.isEmpty() ){
            List<Orders> orders=new ArrayList<>();
            Customer customer = customerMapper.getCustomerById(customerId);
            List<Repair> repairs = repairMapper.listOfRepair(customer.getCustomerId());
            repairs.stream().forEach(e->{
                Orders o=new Orders(customer.getCustomerId(),customer.getName(),customer.getSex(),customer.getPhone(),
                        customer.getCarNum(),customer.getAddress(),customer.getCreateTime(),e.getRepairId(),
                        e.getItem(),e.getCost());
                orders.add(o);
            });
            return orders;
        }
        return null;
    }

    @Override
    public List<Orders> listCustomerInToday(String date,String kname, String knum) {
        if(date.isEmpty()){
            return null;
        }else{
            List<Customer> customers =null;
            if(StringUtils.isEmpty(kname) && StringUtils.isEmpty(knum)){
                customers =customerMapper.listCustomerInToday(date);
            }else if(!StringUtils.isEmpty(kname) && StringUtils.isEmpty(knum)){
                customers=customerMapper.listCustomerInTodayByName(date,kname);
            }else if(StringUtils.isEmpty(kname) && !StringUtils.isEmpty(knum)){
                customers=customerMapper.listCustomerInTodayByNum(date,knum);
            }else if(!StringUtils.isEmpty(kname) && !StringUtils.isEmpty(knum)){
                customers=customerMapper.listCustomerInTodayByNumAndName(date,knum,kname);
            }
            List<Repair> repairs = repairMapper.listRepairInToday(date);
            List<Orders> orders=new ArrayList<>();
            customers.stream().forEach(c->{
                List<Repair> list = repairs.stream().filter(r -> String.valueOf(r.getCustomerid().toString()).equals(c.getCustomerId().toString())).collect(Collectors.toList());
                list.stream().forEach(repair -> {
                    Orders o=new Orders(c.getCustomerId(),c.getName(),c.getSex(),c.getPhone(),
                            c.getCarNum(),c.getAddress(),c.getCreateTime(),repair.getRepairId(),
                            repair.getItem(),repair.getCost());
                    orders.add(o);
                });
            });
            return orders;
        }
    }
}
