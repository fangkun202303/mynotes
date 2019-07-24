package com.moduls.mynotes.service.impl;

import com.moduls.mynotes.mapper.RepairMapper;
import com.moduls.mynotes.pojo.Repair;
import com.moduls.mynotes.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-24
 */
@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public Repair getRepairById(Integer repairId) {
        Repair repairById = repairMapper.getRepairById(repairId);
        return repairById;
    }

    @Override
    public Integer save(Repair repair) {
        Integer save = repairMapper.save(repair);
        return save==1? 1:2;
    }

    @Override
    public Integer update(Repair repair) {
        Integer update = repairMapper.update(repair);
        return update==1? 1:2;
    }

    @Override
    public Integer delete(Integer repairId) {
//        Integer delete = repairMapper.delete(repairId);
//        return delete==1? 1:2;
        System.out.printf("这个repairId是："+repairId);
        return 1;
    }

    @Override
    public List<Repair> listOfRepair(String customerCode) {
        return repairMapper.listOfRepair(customerCode);
    }
}
