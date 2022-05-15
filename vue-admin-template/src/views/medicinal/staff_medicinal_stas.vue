<template>
  <div>
    <div class="container">
      
      <div  style="display:inline-block;width:40%;height:50%;text-align:right">
          <span>统计月份</span>
          <input type="text" v-model="params.month" style="margin:10px;width:46%;height:30px"/>
          <button v-on:click="searchButton" style="width:20%;height:30px;margin-left:10px;color:green">生成人员药品统计报表</button>
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
        <!-- <el-table-column align="center" label="ID">
          <template slot-scope="scope">
            {{ scope.$index }}
          </template>
        </el-table-column> -->
        <el-table-column label="购药人工号" align="center">
          <template slot-scope="scope">
            {{ scope.row.buyerNumber }}
          </template>
        </el-table-column>
        <el-table-column label="购药人姓名" align="center">
          <template slot-scope="scope">
            {{ scope.row.buyerName }}
          </template>
        </el-table-column>
        <el-table-column label="购药总额" align="center">
          <template slot-scope="scope">
            <span>{{ scope.row.totalPrice }}</span>
          </template>
        </el-table-column>
        <!-- <el-table-column label="购药月份"  align="center">
          <template slot-scope="scope">
            {{ scope.row.month }}
          </template>
        </el-table-column> -->
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
import { pageMedicinalReserveStas,gensummary,pageSellSummary} from '@/api/medicinalsellrecord.js'


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
        month: ''
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
      medicinalCodeOptions: []
    }
  },
  created() {
    var pageQuery={
        currentPage: 1,
        pageSize: 5,
        month : "2022-05"
      }
    this.fetchData(pageQuery)
  },
  methods: {
    fetchData(p) {
      var pageQuery={
        page: p.currentPage,
        pageSize: 5,
        month: p.month
      }
      
      this.listLoading = false
      pageSellSummary(pageQuery).then(response => {
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
      // this.fetchData(this.params)
    //   pageSellSummary(this.params).then(response => {
    //     console.log(response)
    //     this.fetchData(this.params)
    //   })
    //   console.log(this.params)
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
  
    resetMedicinal() {
      this. medicinalBuyerRecord={
        medicinalCode: '',
        medicinalName: '',
        unitPrice: 0,
        count: 0,
        totalPrice:0,
        buyerName: '',
        buyerNumber: 0
      }
    },
    handleMedicinalCOdeFilter(data) {
        var pageQuery={
        page: this.params.currentPage,
        pageSize: 10000,
        code: data,
      }
      getMedicinalList(pageQuery).then(response => {
        response.data.list.forEach(element => {
          this.medicinalCodeOptions.push({text: element.code,value: element.name})
        });
        console.log(this.medicinalCodeOptions)
      })
    },
    searchMedicinalCode(data) {
      this.medicinalCodeOptions=[]
    },
    convertReserveType(type) {
        if (type == 1) {
          return '增加库存'
        } else if (type ==2) {
          return '扣减库存'
        } else {
          return '未知操作'
        }
    }
  }
}
</script>
