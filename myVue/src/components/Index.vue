<template>
  <div>
    <!-- 列表  START-->
    <div v-if="showA">
      <el-date-picker v-model="dateValue" @change="getDate()" type="date" placeholder="选择日期" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd" ></el-date-picker>
      <el-button type="primary" @click="chengShowValue()">添加</el-button>
      <el-table
        :data="tableData"
        style="width: 100%;margin-bottom: 20px;"
        row-key="customerId"
        border
        lazy
        :load="load"
        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
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
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
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
          <el-input v-model="form.name" placeholder="请输入客户名称"></el-input>
        </el-form-item>
        <el-form-item label="客户性别">
          <el-select v-model="form.sex" placeholder="请选择客户性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户联系方式">
          <el-input v-model="form.phone" placeholder="请输入客户联系方式"></el-input>
        </el-form-item>
        <el-form-item label="客户车牌号">
          <el-input v-model="form.carNum" placeholder="请输入客户车牌号"></el-input>
        </el-form-item>
        <el-form-item label="维修内容">
          <el-input v-model="form.item" placeholder="请输入维修内容"></el-input>
        </el-form-item>
        <el-form-item label="维修费用">
          <el-input v-model="form.cost" placeholder="请输入维修费用"></el-input>
        </el-form-item>
        <el-form-item label="维修时间">
          <el-date-picker v-model="form.createTime" @change="getDateInForm()" type="date" placeholder="选择日期" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd" ></el-date-picker>
        </el-form-item>
        <el-form-item label="客户地址">
          <el-input v-model="form.address" placeholder="请输入客户地址"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button @click="cancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import qs from 'qs';
export default {
  name: "Index",
  data() {
    return {
      tableData: [
        {
          customerId: 1,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "1",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12,
        },
        {
          customerId: 2,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "1",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12,
          hasChildren: true
        },
        {
          customerId: 3,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "1",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12,
        },
        {
          customerId: 4,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "1",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12,
        },
        {
          customerId: 5,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "1",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12,
        }
      ],
      showA: true,
      showB: false,
      form: {
        customerId: '',
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
      },
      dateValue: ""
    };
  },
  mounted() {},
  methods: {
    sexFormatter(row, column) {
      return row.sex == 1 ? "男" : "女";
    },
    // 添加的点击事件
    chengShowValue() {
      this.showA = false;
      this.showB = true;
      this.form={
        customerId: '',
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
      }
    },
    handleClick(row) {
      console.log(row);
    },
    updateRow(row) {
      this.showA = false;
      this.showB = true;
      this.form=row;
    },
    deleteRow(row) {
      const ordersId ={repairId:1};
      this.$axios.post("/repair/delete?"+qs.stringify(ordersId))
      .then(data=>{
        console.log(data)
      })
    },
    onSubmit() {
      this.showA = true;
      this.showB = false;
      console.log(this.form);
    },
    cancel() {
      this.showA = true;
      this.showB = false;
    },
    load(tree, treeNode, resolve) {
      resolve([
        {
          customerId: 11,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "男",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          repairId:1,
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12
        },
        {
          customerId: 12,
          code: "wangxiaohu",
          name: "王小虎",
          sex: "女",
          phone: "13240714417",
          carNum: "豫S8976A",
          address: "河南省郑州市金水区XXX",
          createTime: "2016-05-02",
          repairId: 2,
          item: "换发动机机油",
          partsCode: "",
          partsname: "",
          partsPrice: "",
          cost: 59.12
        }
      ]);
    },
    selected(row) {
      console.log(row);
    },
    getDate() {
      console.log(this.dateValue);
    },
    getDateInForm(){

    }
  }
};
</script>
<style scope>
</style>

