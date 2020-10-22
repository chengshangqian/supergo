<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="returnBillSearchForm">
          <el-form-item label="退款单状态">
            <el-select v-model="returnBillSearchForm.returnBillStatus">
              <el-option value="1" label="全部"></el-option>
              <el-option value="2" label="退款寄回"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="订单号">
            <el-input v-model="returnBillSearchForm.orderNumber"></el-input>
          </el-form-item>
          <el-form-item label="退款单">
            <el-input v-model="returnBillSearchForm.consignee"></el-input>
          </el-form-item>
          <el-form-item label="退款时间">
            <el-date-picker
              v-model="returnBillSearchForm.updateTime"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="searchReturnBill"
            >
              查询
            </el-button>
          </el-form-item>
        </el-form>
      </el-card>
      <el-card>
        <el-button-group
          style="margin-bottom: 20px;"
        >
          <el-button
            type="success"
            @click="ensureDeleteReturnBill"
          >
            退款成功
          </el-button>
          <el-button
            @click="showEditDialog"
            type="danger"
          >
            退款失败
          </el-button>
          <el-button
            type="warning"
            @click="ensureDeleteReturnBill"
          >
            取消退款
          </el-button>
        </el-button-group>
        <el-table
          :data="returnBillData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="returnBillTable"
        >
          <el-table-column
            type="selection"
          >
          </el-table-column>
          <el-table-column
            label="退款单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="退货单号"
            prop="returnBillName"
          >
          </el-table-column>
          <el-table-column
            label="订单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="主订单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="收货人"
            prop="returnBillName"
          >
          </el-table-column>
          <el-table-column
            label="联系方式"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="审核状态"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="申请时间"
            prop="returnBillName"
          >
          </el-table-column>
          <el-table-column
            label="退货状态"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="退货更新时间"
            prop="returnBillName"
          >
          </el-table-column>
          <el-table-column
            label="供应商名称"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="showEditDialog"
              >
                修改
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <div style="overflow: hidden;">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[10, 20, 30, 40, 50]"
            :page-size="10"
            layout="prev, pager, next, jumper, sizes, total"
            :total="200"
            style="float: right;"
          >
          </el-pagination>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'returnBill',
    data() {
      return {
        currentPage: 1,
        returnBillData: [
          {
            id: 1,
            returnBillName: '图书',
            sort: 1,
            pid: 0
          },
          {
            id: 2,
            returnBillName: '家用电器',
            sort: 2,
            pid: 0
          },
          {
            id: 11,
            returnBillName: '小说',
            sort: 3,
            pid: 1
          }
        ],
        dialogVisible: false,
        deleteDialog: false,
        deleteReturnBillIds: [],
        returnBillSearchForm: {
          returnBillStatus: '',
          orderNumber: '',
          consignee: '',
          updateTime: ''
        }
      }
    },
    methods: {
      onSubmit() {

      },
      handleSizeChange() {

      },
      handleCurrentChange() {

      },
      searchReturnBill() {

      },
      showEditDialog(e) {
        e.stopPropagation()
        this.dialogVisible = true
      },
      ensureDeleteReturnBill() {
        if (this.deleteReturnBillIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.returnBillTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteReturnBillIds = val.map(item => item.id)
      },
      sureDeleteReturnBills() {
        this.deleteDialog = false
      }
    }
  }
</script>

<style scoped>

</style>
