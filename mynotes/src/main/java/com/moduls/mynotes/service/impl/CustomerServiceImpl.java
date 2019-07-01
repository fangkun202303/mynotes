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

import java.util.ArrayList;
import java.util.List;

/**
 * @description: CustomerService的实现
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-24
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public Customer getCustomerById(Integer customerId) {
        if(customerId<=0 && customerId!=null){
            Customer customer = customerMapper.getCustomerById(customerId);
            List<Repair> repairs = repairMapper.listOfRepair(customer.getCode());
            customer.setRepairs(repairs);
            return customer;
        }
        return null;
    }

    @Transactional
    @Override
    public Integer save(Customer customer) {
        return customerMapper.save(customer)==1? 1:2;
    }

    @Transactional
    @Override
    public Integer update(Customer customer) {
        return customerMapper.update(customer)==1? 1:2;
    }

    @Transactional
    @Override
    public Integer delete(Integer customerId) {
        if(customerId<=0 && customerId!=null){
            return customerMapper.delete(customerId)==1? 1:2;
        }
        return null;
    }

    @Override
    public List<Orders> listOfCustomer(String before, String after,Integer customerId) {
        if(!before.isEmpty() && !after.isEmpty()){
            List<Orders> orders=new ArrayList<>();
//            List<Customer> customers = customerMapper.listOfCustomer(before, after);
//            customers.stream().forEach(e->{
//                List<Repair> repairs = repairMapper.listOfRepair(e.getCode());
//                repairs.stream().forEach(item->{
//                    Orders o=new Orders(
//                            e.getCustomerId(),e.getCode(),e.getName(),e.getSex(),e.getPhone(),
//                            e.getCarNum(),e.getAddress(),e.getCreateTime(),
//                            item.getItem(),item.getPartsCode(),item.getPartsname(),
//                            item.getPartsPrice(),item.getCost()
//                    );
//                    orders.add(o);
//                });
//            });
            Customer customer = customerMapper.getCustomerById(customerId);
            List<Repair> repairs = repairMapper.listOfRepair(customer.getCode());
            repairs.stream().forEach(e->{
                Orders o=new Orders(customer.getCustomerId(),customer.getCode(),customer.getName(),customer.getSex(),customer.getPhone(),
                        customer.getCarNum(),customer.getAddress(),customer.getCreateTime(),e.getRepairId(),
                        e.getItem(),e.getCost());
                orders.add(o);
            });
            return orders;
        }
        return null;
    }
}
