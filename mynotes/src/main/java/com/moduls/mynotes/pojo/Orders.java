package com.moduls.mynotes.pojo;

/**
 * @description: 客户维修单据
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-07-01
 */
public class Orders {
    private Long customerId;
    private String name;
    private String sex;
    private String phone;
    private String carNum;
    private String address;
    private String createTime;
    private Integer repairId;
    private String item;
    private String partsCode;
    private String partsname;
    private Double partsPrice;
    private Double cost;

    public Orders(Long customerId, String name, String sex, String phone,
                  String carNum, String address, String createTime, Integer repairId, String item, Double cost) {
        this.customerId = customerId;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.carNum = carNum;
        this.address = address;
        this.createTime = createTime;
        this.repairId=repairId;
        this.item = item;
        this.cost = cost;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Orders setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Orders setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Orders setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Orders setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCarNum() {
        return carNum;
    }

    public Orders setCarNum(String carNum) {
        this.carNum = carNum;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Orders setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Orders setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getItem() {
        return item;
    }

    public Orders setItem(String item) {
        this.item = item;
        return this;
    }

    public String getPartsCode() {
        return partsCode;
    }

    public Orders setPartsCode(String partsCode) {
        this.partsCode = partsCode;
        return this;
    }

    public String getPartsname() {
        return partsname;
    }

    public Orders setPartsname(String partsname) {
        this.partsname = partsname;
        return this;
    }

    public Double getPartsPrice() {
        return partsPrice;
    }

    public Orders setPartsPrice(Double partsPrice) {
        this.partsPrice = partsPrice;
        return this;
    }

    public Double getCost() {
        return cost;
    }

    public Orders setCost(Double cost) {
        this.cost = cost;
        return this;
    }
}
