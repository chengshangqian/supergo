<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card>
        <el-button-group
          style="margin-bottom: 20px;"
        >
          <el-button
            @click="showEditDialog"
            type="primary"
          >
            新建
          </el-button>
          <el-button
            type="success"
            @click="ensureDeleteReturn"
          >
            删除
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteReturn"
          >
            开启
          </el-button>
          <el-button
            type="success"
            @click="ensureDeleteReturn"
          >
            屏蔽
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteReturn"
          >
            生成静态页面
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
            label="广告ID"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="分类ID"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="标题"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="URL"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="广告开始时间"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="广告结束时间"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="图片"
            prop="id"
          >
            <template slot-scope="scope">
              <img :src="scope.row.img">
            </template>
          </el-table-column>
          <el-table-column
            label="排序"
            prop="returnName"
          >
          </el-table-column>
          <el-table-column
            label="状态"
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
      <new-advertisement :dialogVisible.sync="dialogVisible"/>
    </div>
  </div>
</template>

<script>
  import NewAdvertisement from "./newadvertisement";
  export default {
    name: 'return',
    components: {NewAdvertisement},
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
