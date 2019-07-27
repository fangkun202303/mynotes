package com.moduls.mynotes.mapper;

import com.moduls.mynotes.pojo.Repair;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 维修
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-21
 */
@Mapper
@Repository
public interface RepairMapper {

    @Select("select repairid, item, partscode, partsname, partsprice, cost, createtime, customerid from repair where repairid=#{repairId}")
    Repair getRepairById(@Param("repairId") Integer repairId);

    @Insert("insert into repair ( item, partscode, partsname, partsprice, cost, createtime, customerid) values ( #{item}, #{partsCode}, #{partsname}, #{partsPrice}, #{cost}, #{createTime}, #{customerid})")
    Integer save(Repair repair);

    @Update("update repair set item=#{item}, cost=#{cost},createTime=#{createTime} where repairid=#{repairId}")
    Integer update(Repair repair);

    @Delete("delete from repair where repairid=#{repairId}")
    Integer delete(@Param("repairId") Integer repairId);

    @Select("select repairid, customercode, item, partscode, partsname, partsprice, cost, createtime, customerid from repair where customerid=#{customerId}")
    List<Repair> listOfRepair(@Param("customerId") Long customerId);

    @Select("select repairid, item, partscode, partsname, partsprice, cost, createtime, customerid from repair where createtime=#{date}")
    List<Repair> listRepairInToday(@Param("date") String date);
}
