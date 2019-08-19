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

    Customer getCustomerById(Long customerId);

    Integer save(Orders orders);

    Integer update(Orders orders);

    Integer delete(Long customerId , Integer repairId);

    List<Orders> listOfCustomer(String date,Long customerId);

    List<Orders> listCustomerInToday(String date,String kname, String knum);
}
