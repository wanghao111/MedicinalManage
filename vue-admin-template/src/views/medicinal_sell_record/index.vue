<template>
  <div>
    <div class="container">
      <div style="display:inline-block;width:10%;height:50%">
        <button style="width:75%;height:30px;color:blue" v-on:click="showCreate">售药</button>
      </div>
      <div  style="display:inline-block;width:50%;height:50%;text-align:right">
          <span>药品代码</span>
          <input type="text" v-model="params.mCode" style="margin:10px;width:35%;height:30px"/>
      </div>
      <div  style="display:inline-block;width:40%;height:50%;text-align:right">
          <span>药品名称</span>
          <input type="text" v-model="params.mName" style="margin:10px;width:46%;height:30px"/>
          <button v-on:click="searchButton" style="visibility:hidden;width:20%;height:30px;margin-left:10px;color:green">搜索</button>
      </div>
    </div>
    <div class="container">
      <div style="display:inline-block;width:10%;height:50%">
        <button style="visibility:hidden;width:75%;height:30px;color:blue" v-on:click="showCreate">购药</button>
      </div>
      <div  style="display:inline-block;width:50%;height:50%;text-align:right">
          <span>购药人姓名</span>
          <input type="text" v-model="params.buyerName" style="margin:10px;width:35%;height:30px"/>
      </div>
      <div  style="display:inline-block;width:40%;height:50%;text-align:right">
          <span>购药人工号</span>
          <input type="number" v-model="params.buyerNumber" style="margin:10px;width:46%;height:30px"/>
          <button v-on:click="searchButton" style="width:20%;height:30px;margin-left:10px;color:green">搜索</button>
      </div>
    </div>
     
    <div class="app-container">
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="Loading"
        border
        fit
        highlight-current-row
      >
        <el-table-column align="center" label="ID">
          <template slot-scope="scope">
            {{ scope.$index }}
          </template>
        </el-table-column>
        <el-table-column label="药品代码" align="center">
          <template slot-scope="scope">
            {{ scope.row.medicinalCode }}
          </template>
        </el-table-column>
        <el-table-column label="药品名称" align="center">
          <template slot-scope="scope">
            <span>{{ scope.row.medicinalName }}</span>
          </template>
        </el-table-column>
        <el-table-column label="数量"  align="center">
          <template slot-scope="scope">
            {{ scope.row.count }}
          </template>
        </el-table-column>
        <el-table-column label="单价"  align="center">
          <template slot-scope="scope">
            {{ scope.row.unitPrice }}
          </template>
        </el-table-column>
        <el-table-column label="总价"  align="center">
          <template slot-scope="scope">
            {{ scope.row.totalPrice }}
          </template>
        </el-table-column>
        <el-table-column label="购药人工号"  align="center">
          <template slot-scope="scope">
            {{ scope.row.buyerNumber }}
          </template>
        </el-table-column>
        <el-table-column label="购药人姓名"  align="center">
          <template slot-scope="scope">
            {{ scope.row.buyerName }}
          </template>
        </el-table-column>
         <el-table-column label="购药时间"  align="center">
          <template slot-scope="scope">
            {{ scope.row.createTime }}
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="d1" align="right">
        <a href="javascript:void(0);" style="margin-left:5px" v-on:click="pageFunc('firstPage')">首页</a>
        <a href="javascript:void(0);" style="margin-left:5px" v-on:click="pageFunc('prePage')">上一页</a>
        <input type='text' style="margin-left:5px" v-model.number="params.currentPage" v-on:keyup.enter="inputenter"/>
        <span style="margin-left:5px">/ {{params.totalPage}}页</span>
        <a href="javascript:void(0);" style="margin-left:5px" v-on:click="pageFunc('nextPage')">下一页</a>
        <a href="javascript:void(0);" style="margin-left:5px" v-on:click="pageFunc('lastPage')">尾页</a>
    </div>
    <el-dialog :title="params.textMap[params.dialogStatus]" :visible.sync="params.dialogFormVisible">
      <el-form class="small-space" label-position="left" label-width="80px"
               style='width: 300px; margin-left:50px;'>
        <el-form-item label="药品代码" required>
          <el-select v-model="medicinalBuyerRecord.medicinalCode" :filter-method="handleMedicinalCOdeFilter" @change="searchMedicinalCode" filterable placeholder="请选择">
              <el-option v-for="item in medicinalCodeOptions"
                :label="item.text"
                :key="item.key"
                :value="item.value"
              >
              </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="药品代码" required>
            <el-input type="text"  v-model="medicinalBuyerRecord.medicinalName" :disabled="params.dialogStatus==='update'" v-bind:readonly="true">
          </el-input>
        </el-form-item>
        <el-form-item label="单价">
          <el-input type="text" v-model="medicinalBuyerRecord.unitPrice" v-bind:readonly="true" >
          </el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input type="text" v-model.number="medicinalBuyerRecord.count">
          </el-input>
        </el-form-item>
        <el-form-item label="购药人工号">
          <el-input type="number" v-model="medicinalBuyerRecord.buyerNumber">
          </el-input>
        </el-form-item>
        <el-form-item label="购药人姓名">
          <el-input type="text" v-model="medicinalBuyerRecord.buyerName">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelCreateBuyRecord">取 消</el-button>
        <el-button v-if="params.dialogStatus==='create'" type="success" @click="createMedicinalBuyRecord">创 建</el-button>
        <!-- <el-button type="primary" v-else @click="updateMedicinal">修 改</el-button> -->
      </div>
    </el-dialog>
  </div>
</template>

<stype>
  .pager{
    width: 100px;
    margin: 0 auto;
    margin-top: 10px;
    height: 48px;
    line-height: 48px;
    align: right;
  }
</stype>
<style>
  .d1 {
    width: 100%;
    height: 30px;
    padding: 20px;
  }
  .container {
    width: 100%;
    height: 30%;
    padding: 20px;
  }
</style>
<style>
  input{
    width: 40px;
    height: 20px;
  }
</style>
  

<script>
import { getList,create,update,deleteMedi} from '@/api/medicinalsellrecord'
import { getList as getMedicinalList} from '@/api/medicinal'

export default {
  data() {
    return {
      list: null,
      listLoading: false,
      params: {
        currentPage: 1,
        totalPage: 1,
        mCode: '',
        mName: '',
        dialogStatus: '',
        dialogFormVisible: false,
        textMap: {
          update: '编辑',
          create: '新建用户'
        },
      },
      medicinalBuyerRecord: {
        medicinalCode: '',
        medicinalName: '',
        unitPrice: 0,
        count: 0,
        totalPrice:0,
        buyerName: '',
        buyerNumber: 0
      },
      medicinalCodeOptions: [
        // {text: 't1',key: 'k1', value: 'v1'},
        // {text: 't2',key: 'k2', value: 'v2'},
        // {text: 't3',key: 'k3', value: 'v3'}
      ]
    }
  },
  created() {
    this.fetchData(this.params)
  },
  methods: {
    fetchData(p) {
      var pageQuery={
        page: p.currentPage,
        pageSize: 5,
        medicinalCode: p.mCode,
        medicinalName: p.mName,
        buyerName: p.buyerName,
        buyerNumber: p.buyerNumber
      }
      
      this.listLoading = false
      getList(pageQuery).then(response => {
        console.log(response)
        this.list = response.data.list
        this.listLoading = false
        this.params.totalPage=response.data.totalPage
        this.params.currentPage=response.data.currentPage
      })
      console.log('opsops')
    },
    pageFunc(p) {
      if(p=='firstPage') {
        this.params.currentPage=1
      } else if(p=='prePage') {
        if(this.params.currentPage > 1) {
          this.params.currentPage=this.params.currentPage-1
        }
      } else if(p=='nextPage') {
        if(this.params.currentPage < this.params.totalPage) {
          this.params.currentPage=this.params.currentPage+1;
        }
      } else if(p=='lastPage') {
        this.params.currentPage=this.params.totalPage
      }
      this.fetchData(this.params)
    },
    inputenter() {
      this.fetchData(this.params)
      console.log(this.params)
    },
    searchButton() {
      this.fetchData(this.params)
      console.log(this.params)
    },
    showCreate() {
        this.params.dialogStatus='create'
        this.params.dialogFormVisible=true
    },
    showUpdate(medicinal) {
        this.params.dialogStatus='update'
        this.params.dialogFormVisible=true
        this.medicinal=medicinal
    },
    createMedicinalBuyRecord() {
      console.log(this.medicinalBuyerRecord)
      create(this.medicinalBuyerRecord).then(response =>{
        console.log(response)
        this.fetchData(this.params)
        this.params.dialogFormVisible=false
        this.resetMedicinal()
      })
    },
    
    cancelCreateBuyRecord() {
      this.params.dialogFormVisible = false
      this.resetMedicinal()
    },
  
    resetMedicinal() {
      this. medicinalBuyerRecord={
        medicinalCode: '',
        medicinalName: '',
        unitPrice: 0,
        count: 0,
        totalPrice:0,
        buyerName: '',
        buyerNumber: 0
      },
      this.medicinalCodeOptions=[]
    },
    handleMedicinalCOdeFilter(data) {
        this.medicinalCodeOptions=[]
        var pageQuery={
        page: this.params.currentPage,
        pageSize: 10000,
        code: data,
      }
      getMedicinalList(pageQuery).then(response => {
        response.data.list.forEach(element => {
          this.medicinalCodeOptions.push({text: element.code,value: element})
        });
        console.log(this.medicinalCodeOptions)
      })
    },
    searchMedicinalCode(data) {
       this. medicinalBuyerRecord={
        medicinalCode: data.code,
        medicinalName: data.name,
        unitPrice: data.unitPrice,
        count: 0,
        totalPrice:0,
        buyerName: '',
        buyerNumber: 0
      }
    }
    
  }
}
</script>
