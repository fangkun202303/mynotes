package com.moduls.mynotes.mapper;

import com.moduls.mynotes.pojo.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 客户mapper
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-21
 */
@Mapper
@Repository
public interface CustomerMapper {

    @Select("select customerid, code, name, sex, phone, carnum, address, createtime from customer where customerid=#{customerId}")
    Customer getCustomerById(@Param("customerId") Integer customerId);

    @Insert("insert into customer (customerid, code, name, sex, phone, carnum, address, createtime) values (#{code}, #{name}, #{sex}, #{phone}, #{carNum}, #{address}, #{createTime} )")
    Integer save(Customer customer);

    @Update("update customer set name=#{name}, sex=#{sex}, phone=#{phone}, carnum=#{carNum}, address=#{address} where customerid=#{customerId}")
    Integer update(Customer customer);

    @Delete("delete from customer where customerid=#{customerId}")
    Integer delete(@Param("customerId") Integer customerId);

    @Select("select customerid, code, name, sex, phone, carnum, address, createtime from customer where createtime<#{after} and createtime> #{before}")
    List<Customer> listOfCustomer(String before, String after);
}
