<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="returnSearchForm">
          <el-form-item label="退货状态">
            <el-select v-model="returnSearchForm.returnStatus">
              <el-option value="1" label="全部"></el-option>
              <el-option value="2" label="退货寄回"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="订单号">
            <el-input v-model="returnSearchForm.orderNumber"></el-input>
          </el-form-item>
          <el-form-item label="收货人">
            <el-input v-model="returnSearchForm.consignee"></el-input>
          </el-form-item>
          <el-form-item label="退货更新时间">
            <el-date-picker
              v-model="returnSearchForm.updateTime"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="searchReturn"
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
            @click="showEditDialog"
            type="primary"
          >
            退货寄回
          </el-button>
          <el-button
            type="success"
            @click="ensureDeleteReturn"
          >
            退货成功
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteReturn"
          >
            退货取消
          </el-button>
        </el-button-group>
        <el-table
          :data="returnData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="returnTable"
        >
          <el-table-column
            type="selection"
          >
          </el-table-column>
          <el-table-column
            label="退货单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="订单号"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="主订单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="商品名称"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="商品售价"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="收货人"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="联系方式"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="实际支付"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="审核状态"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="申请时间"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="退货状态"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="退货更新时间"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="店铺名称"
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
      <el-dialog
        title="删除规格"
        :visible="deleteDialog"
        @close="deleteDialog = false"
      >
        <div style="margin-bottom: 20px;">
          确认删除所选规格？
        </div>
        <el-button
          type="primary"
          @click="sureDeleteReturns"
        >
          确定
        </el-button>
        <el-button
          @click="deleteDialog = false"
        >
          取消
        </el-button>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'return',
    data() {
      return {
        currentPage: 1,
        returnData: [
          {
            id: 1,
            returnName: '图书',
            sort: 1,
            pid: 0
          },
          {
            id: 2,
            returnName: '家用电器',
            sort: 2,
            pid: 0
          },
          {
            id: 11,
            returnName: '小说',
            sort: 3,
            pid: 1
          }
        ],
        dialogVisible: false,
        deleteDialog: false,
        deleteReturnIds: [],
        returnSearchForm: {
          returnStatus: '',
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
      searchReturn() {

      },
      showEditDialog(e) {
        e.stopPropagation()
        this.dialogVisible = true
      },
      ensureDeleteReturn() {
        if (this.deleteReturnIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.returnTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteReturnIds = val.map(item => item.id)
      },
      sureDeleteReturns() {
        this.deleteDialog = false
      }
    }
  }
</script>

<style scoped>

</style>
