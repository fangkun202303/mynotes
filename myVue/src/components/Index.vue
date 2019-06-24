<template>
  <div>
    <!-- 列表  START-->
    <el-button type="primary" @click="chengShowValue()">添加</el-button>
    <div v-if="showA">
    <el-table
      :data="tableData"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
      
    >
      <!-- <el-table-column></el-table-column> @row-click="selected(scope.row)" -->
      <el-table-column prop="date" label="日期" sortable width="180"></el-table-column>
      <el-table-column prop="name" label="姓名" sortable width="180"></el-table-column>
      <el-table-column  prop="address" label="地址"></el-table-column>
        <el-table-column fixed="right" label="操作" width="200">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small" >查看</el-button>
            <el-button type="text" size="small" @click="updateRow(scope.row)">编辑</el-button>
            <el-button type="text" size="small" @click="deleteRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>      
    </el-table>
      
      <!-- <el-table :data="tableData" border style="width: 100%">
        <el-table-column fixed prop="date" label="日期" width="150"></el-table-column>
        <el-table-column prop="name" label="姓名" width="120"></el-table-column>
        <el-table-column prop="province" label="省份" width="120"></el-table-column>
        <el-table-column prop="city" label="市区" width="120"></el-table-column>
        <el-table-column prop="address" label="地址" width="500"></el-table-column>
        <el-table-column prop="zip" label="邮编" width="120"></el-table-column>
        <el-table-column fixed="right" label="操作" width="200">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small" >查看</el-button>
            <el-button type="text" size="small" @click="updateRow(scope.row)">编辑</el-button>
            <el-button type="text" size="small" @click="deleteRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table> -->
      <!-- <el-button-group>
        <el-button type="primary" icon="el-icon-arrow-left">上一页</el-button>
        <el-button type="primary">
          下一页
          <i class="el-icon-arrow-right el-icon--right"></i>
        </el-button>
      </el-button-group> -->
    </div>
    <!-- 列表  END -->
    <div v-if="showB" style="width: 50%;margin-left: 20%;">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="活动名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="活动区域">
          <el-select v-model="form.region" placeholder="请选择活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="即时配送">
          <el-switch v-model="form.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="活动性质">
          <el-checkbox-group v-model="form.type">
            <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
            <el-checkbox label="地推活动" name="type"></el-checkbox>
            <el-checkbox label="线下主题活动" name="type"></el-checkbox>
            <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="特殊资源">
          <el-radio-group v-model="form.resource">
            <el-radio label="线上品牌商赞助"></el-radio>
            <el-radio label="线下场地免费"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="活动形式">
          <el-input type="textarea" v-model="form.desc"></el-input>
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
import IndexAdd from '@/components/IndexAdd'

export default {
  name: "Index",
  data() {
    return {
      tableData: [
        {
          id: 1,
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        },
        {
          id: 2,
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄"
        },
        {
          id: 3,
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄",
          hasChildren: true
        },
        {
          id: 4,
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄"
        }
      ],
      showA: true,
      showB: false,
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
    };
  },
  mounted(){

  },
  methods: {
    chengShowValue(){
      this.showA=false;
      this.showB=true;
    },
    handleClick(row) {
        console.log(row);
    },
    updateRow(row){
      this.showA=false;
      this.showB=true;
    },
    deleteRow(row){

    },
    onSubmit() {
        console.log('submit!');
      this.showA=true;
      this.showB=false;
    },
    cancel(){
      this.showA=true;
      this.showB=false;
    },
    load(tree, treeNode, resolve) {
      setTimeout(() => {
        resolve([
          {
            id: 31,
            date: "2016-05-01",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1519 弄"
          },
          {
            id: 32,
            date: "2016-05-01",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1519 弄"
          }
        ]);
      }, 1000);
    },
    selected(row){
      console.log(row)
    }
  }
};
</script>
<style scope>
</style>

