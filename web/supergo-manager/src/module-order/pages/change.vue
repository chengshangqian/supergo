<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="changeSearchForm">
          <el-form-item label="换货状态">
            <el-select v-model="changeSearchForm.changeStatus">
              <el-option value="1" label="全部"></el-option>
              <el-option value="2" label="换货寄回"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="订单号">
            <el-input v-model="changeSearchForm.orderNumber"></el-input>
          </el-form-item>
          <el-form-item label="收货人">
            <el-input v-model="changeSearchForm.consignee"></el-input>
          </el-form-item>
          <el-form-item label="换货更新时间">
            <el-date-picker
              v-model="changeSearchForm.updateTime"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="searchChange"
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
            换货寄回
          </el-button>
          <el-button
            type="success"
            @click="ensureDeleteChange"
          >
            换货成功
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteChange"
          >
            换货取消
          </el-button>
        </el-button-group>
        <el-table
          :data="changeData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="changeTable"
        >
          <el-table-column
            type="selection"
          >
          </el-table-column>
          <el-table-column
            label="换货单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="订单号"
            prop="changeName"
          >
          </el-table-column>
          <el-table-column
            label="主订单号"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="商品名称"
            prop="changeName"
          >
          </el-table-column>
          <el-table-column
            label="商品售价"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="收货人"
            prop="changeName"
          >
          </el-table-column>
          <el-table-column
            label="联系方式"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="实际支付"
            prop="changeName"
          >
          </el-table-column>
          <el-table-column
            label="审核状态"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="申请时间"
            prop="changeName"
          >
          </el-table-column>
          <el-table-column
            label="换货状态"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="换货更新时间"
            prop="changeName"
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
          @click="sureDeleteChanges"
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
    name: 'change',
    data() {
      return {
        currentPage: 1,
        changeData: [
          {
            id: 1,
            changeName: '图书',
            sort: 1,
            pid: 0
          },
          {
            id: 2,
            changeName: '家用电器',
            sort: 2,
            pid: 0
          },
          {
            id: 11,
            changeName: '小说',
            sort: 3,
            pid: 1
          }
        ],
        dialogVisible: false,
        deleteDialog: false,
        deleteChangeIds: [],
        changeSearchForm: {
          changeStatus: '',
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
      searchChange() {

      },
      showEditDialog(e) {
        e.stopPropagation()
        this.dialogVisible = true
      },
      ensureDeleteChange() {
        if (this.deleteChangeIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.changeTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteChangeIds = val.map(item => item.id)
      },
      sureDeleteChanges() {
        this.deleteDialog = false
      }
    }
  }
</script>

<style scoped>

</style>
