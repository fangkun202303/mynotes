package com.moduls.mynotes.service;

import com.moduls.mynotes.pojo.Customer;
import com.moduls.mynotes.pojo.Orders;

import java.util.List;

/**
 * @description: Customer的service
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-24
 */
public interface CustomerService {

    Customer getCustomerById(Integer customerId);

    Integer save(Customer customer);

    Integer update(Customer customer);

    Integer delete(Integer customerId);

    List<Orders> listOfCustomer(String before, String after,Integer customerId);
}
