package com.moduls.mynotes.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 客户
 * @program: mynotes
 * @author: fangkun
 * @version： 1.0.0
 * @create: 2019-06-21
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 8735132092273200831L;
    private Integer customerId;
    private String code;
    private String name;
    private Integer sex;
    private String phone;
    private String carNum;
    private String address;
    private String createTime;
    private List<Repair> repairs;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", carNum='" + carNum + '\'' +
                ", address='" + address + '\'' +
                ", createTime='" + createTime + '\'' +
                ", repairs=" + repairs +
                '}';
    }
}
