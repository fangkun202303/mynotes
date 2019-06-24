package com.moduls.mynotes.service.impl;

import com.moduls.mynotes.mapper.CustomerMapper;
import com.moduls.mynotes.mapper.RepairMapper;
import com.moduls.mynotes.pojo.Customer;
import com.moduls.mynotes.pojo.Repair;
import com.moduls.mynotes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            List<Repair> repairs = repairMapper.listOfRepair(customerId);
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
    public List<Customer> listOfCustomer(String before, String after) {
        if(!before.isEmpty() && !after.isEmpty()){
            return customerMapper.listOfCustomer(before,after);
        }
        return null;
    }
}
