<template>
  <div>
    <!-- 列表  START-->
    <div v-if="showA">
    <div>
          客户姓名：
      <el-input placeholder="请输入姓名" v-model="kname" style="width: 15%;"></el-input>
      客户车牌号：
      <el-input placeholder="请输入车牌号" v-model="knum" style="width: 15%;"></el-input>
      维修时间：
      <el-date-picker v-model="dateValue" @change="getDate()" type="date" placeholder="选择日期" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd"></el-date-picker>
      <el-button type="primary" icon="el-icon-search" @click="getDate()">搜索</el-button>
      <el-button type="primary" @click="resetValue()">重置</el-button>
      <el-button type="primary" @click="chengShowValue()">添加</el-button>
    </div>
      <el-table
        :data="tableData"
        style="width: 100%;margin-bottom: 20px;"
        row-key="customerId"
        border
        :tree-props="{children: 'children'}"
      >
        <el-table-column prop="name" label="姓名" sortable width="180"></el-table-column>
        <el-table-column prop="sex" label="性别" sortable width="180" :formatter="sexFormatter"></el-table-column>
        <el-table-column prop="phone" label="联系方式" sortable width="180"></el-table-column>
        <el-table-column prop="carNum" label="车牌号" sortable width="180"></el-table-column>
        <el-table-column prop="address" label="地址" sortable width="180"></el-table-column>
        <el-table-column prop="item" label="维修项目" sortable width="180"></el-table-column>
        <el-table-column prop="cost" label="维修价格" sortable width="180"></el-table-column>
        <el-table-column fixed="right" label="操作" width="200">
          <template slot-scope="scope">
            <!--            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>-->
            <el-button type="text" size="small" @click="updateRow(scope.row)">编辑</el-button>
            <el-button type="text" size="small" @click="deleteRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 列表  END -->
    <div v-if="showB" style="width: 50%;margin-left: 20%;">
      <el-form ref="form" :model="form" label-width="120px">
        <el-form-item label="客户名称">
          <el-input v-model="form.name" placeholder="请输入客户名称" style="width: 100%;margin-right: 0;"></el-input>
        </el-form-item>
        <el-form-item label="客户性别">
          <el-select v-model="form.sex" placeholder="请选择客户性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户联系方式">
          <el-input v-model="form.phone" placeholder="请输入客户联系方式" style="width: 100%;margin-right: 0;"></el-input>
        </el-form-item>
        <el-form-item label="客户车牌号">
          <el-input v-model="form.carNum" placeholder="请输入客户车牌号" style="width: 100%;margin-right: 0;"></el-input>
        </el-form-item>
        <el-form-item label="维修内容">
          <el-input v-model="form.item" placeholder="请输入维修内容" style="width: 100%;margin-right: 0;"></el-input>
        </el-form-item>
        <el-form-item label="维修费用">
          <el-input v-model="form.cost" placeholder="请输入维修费用" style="width: 100%;margin-right: 0;"></el-input>
        </el-form-item>
        <el-form-item label="维修时间">
          <el-date-picker
            v-model="form.createTime"
            @change="getDateInForm()"
            type="date"
            placeholder="选择日期"
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="客户地址">
          <el-input v-model="form.address" placeholder="请输入客户地址" style="width: 100%;margin-right: 0;"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button @click="cancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import qs from "qs";
let moment = require("moment");
import { Message } from "element-ui";
export default {
  name: "Index",
  data() {
    return {
      // row.sex == '',
      // sexFormatter:sexFormatter == '1' ? "男" : "女",
      tableData: [],
      showA: true,
      showB: false,
      form: {
        customerId: "",
        code: "",
        name: "",
        sex: "",
        phone: "",
        carNum: "",
        address: "",
        createTime: "",
        item: "",
        partsCode: "",
        partsname: "",
        partsPrice: "",
        cost: 0,
        repairId: ""
      },
      dateValue: "",
      kname: "",
      knum: "",
    };
  },
  mounted() {
    // 初始化页面数据
    this.initMyvue();

    // 获取列表数据
    this.getAll();
  },
  methods: {
    initMyvue() {
      this.dateValue = new Date();
    },
    sexFormatter(row, column) {
      return row.sex == "1" ? "男" : "女";
    },

    // 重置事件
    resetValue(){
      this.kname="";
      this.knum="";
      this.dateValue = new Date();
      // 回复开始打开的状态
      this.getAll();
    },
    // 添加的点击事件
    chengShowValue() {
      this.showA = false;
      this.showB = true;
      this.form = {
        customerId: "",
        code: "",
        name: "",
        sex: "",
        phone: "",
        carNum: "",
        address: "",
        createTime: "",
        item: "",
        partsCode: "",
        partsname: "",
        partsPrice: "",
        cost: 0
      };
    },
    handleClick(row) {
      console.log(row);
    },
    updateRow(row) {
      this.showA = false;
      this.showB = true;
      this.form = row;
    },
    deleteRow(row) {
      const ordersId = { repairId: row.repairId, customerId: row.customerId };
      this.$axios.delete("mynotes/delete?" + qs.stringify(ordersId)).then(data => {
        if (data.data.code == "1") {
          Message.success("删除成功！");
        } else {
          Message.error("删除失败！");
        }
        this.getAll();
      });
    },
    onSubmit() {
      const orders = {
        customerId: this.form.customerId,
        code: this.form.code,
        name: this.form.name,
        sex: this.form.sex,
        phone: this.form.phone,
        carNum: this.form.carNum,
        address: this.form.address,
        createTime: this.form.createTime,
        item: this.form.item,
        partsCode: this.form.partsCode,
        partsname: this.form.partsname,
        partsPrice: this.form.partsPrice,
        cost: this.form.cost,
        repairId: this.form.repairId
      };
      if (orders.customerId == "") {
        // add
        this.$axios.post("mynotes/save?" + qs.stringify(orders)).then(result => {
          if (result.data.code == "1") {
            Message.success("添加成功！");
          } else {
            Message.error("添加失败！");
          }
          this.showA = true;
          this.showB = false;
          this.getAll();
        });
      } else {
        // update
        this.$axios.put("mynotes/update?" + qs.stringify(orders)).then(result => {
          if (result.data.code == "1") {
            Message.success("修改成功！");
          } else {
            Message.error("修改失败！");
          }
          this.showA = true;
          this.showB = false;
          this.getAll();
        });
      }
    },
    cancel() {
      this.showA = true;
      this.showB = false;
    },
    getDate() {
      const that = this;
      const param={
        date: moment(this.dateValue).format("YYYY-MM-DD")
      };
      if(this.kname!=="" && this.kname!==null){
        param["kname"]=this.kname;
      }
      if(this.knum!=="" && this.knum!==null){
        param["knum"]=this.knum;
      }
      
      this.$axios
        .get("mynotes/listCustomerInToday?" + qs.stringify(param))
        .then(result => {
          if (result.data.code == "1") {
            that.tableData = result.data.data;
          }
        });
    },
    getDateInForm() {},

    getAll() {
      const that = this;
      this.$axios
        .get(
          "mynotes/listCustomerInToday?" +
            qs.stringify({ date: moment(this.dateValue).format("YYYY-MM-DD") })
        )
        .then(result => {
          if (result.data.code == "1") {
            that.tableData = result.data.data;
          }
        });
    }
  }
};
</script>
<style scope>
</style>

