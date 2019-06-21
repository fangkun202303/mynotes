package com.moduls.mynotes.mapper;

import com.moduls.mynotes.pojo.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

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
    Insert update(Customer customer);

    @Delete("delete from customer where customerid=#{customerId}")
    Insert delete(Insert customerId);
}
