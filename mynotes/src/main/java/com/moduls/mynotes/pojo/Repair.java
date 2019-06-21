package com.moduls.mynotes.pojo;

import java.io.Serializable;

/**
 * @description: 维修表
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-21
 */
public class Repair implements Serializable {
    private static final long serialVersionUID = 8735132092273200830L;
    private Integer repairId;
    private String code;
    private String item;
    private String partsCode;
    private String partsname;
    private Double partsPrice;
    private Double cost;
    private String createTime;
    private Integer customerId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPartsCode() {
        return partsCode;
    }

    public void setPartsCode(String partsCode) {
        this.partsCode = partsCode;
    }

    public String getPartsname() {
        return partsname;
    }

    public void setPartsname(String partsname) {
        this.partsname = partsname;
    }

    public Double getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(Double partsPrice) {
        this.partsPrice = partsPrice;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", code='" + code + '\'' +
                ", item='" + item + '\'' +
                ", partsCode='" + partsCode + '\'' +
                ", partsname='" + partsname + '\'' +
                ", partsPrice=" + partsPrice +
                ", cost=" + cost +
                ", createTime='" + createTime + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
