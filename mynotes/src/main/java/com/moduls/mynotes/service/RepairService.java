package com.moduls.mynotes.service;

import com.moduls.mynotes.pojo.Repair;

import java.util.List;

/**
 * @description: Repair的service
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-24
 */
public interface RepairService {

    Repair getRepairById(Integer repairId);

    Integer save(Repair repair);

    Integer update(Repair repair);

    Integer delete(Integer repairId);

    List<Repair> listOfRepair(Long customerId);
}
