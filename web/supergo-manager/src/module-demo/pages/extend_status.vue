<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="extendStatusSearchForm">
          <el-form-item label="属性名称">
            <el-input v-model="extendStatusSearchForm.name"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="onSubmit"
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
            @click="addExtendStatus"
            type="primary"
          >
            新增
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteExtendStatus"
          >
            删除
          </el-button>
        </el-button-group>
        <el-table
          :data="extendStatusData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="extendStatusTable"
        >
          <el-table-column type="selection">
          </el-table-column>
          <el-table-column
            label="属性ID"
            prop="attributeId"
          >
          </el-table-column>
          <el-table-column
            label="属性名称"
            prop="attributeName"
          >
          </el-table-column>
          <el-table-column
            label="属性key"
            prop="attributeKey"
          >
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="editExtendStatus($event, scope.row)"
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
            :page-size="currentSize"
            layout="prev, pager, next, jumper, sizes, total"
            :total="currentTotal"
            style="float: right;"
          >
          </el-pagination>
        </div>
      </el-card>
      <new-extend-status :extendStatusTitle="extendStatusTitle" :dialog-visible.sync="dialogVisible" :attributeData="attributeData" :findAllExtendStatus="findAllExtendStatus" :edit="edit"/>
    </div>
  </div>
</template>

<script>
  import NewExtendStatus from "./newextendstatus"
  export default {
    name: 'extend-status',
    components: {NewExtendStatus},
    data() {
      return {
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        extendStatusData: [],
        dialogVisible: false,
        deleteDialog: false,
        deleteExtendStatusIds: [],
        extendStatusSearchForm: {
          name: ''
        },
        extendStatusTitle: '',
        attributeData: null,
        edit: false
      }
    },
    methods: {
      onSubmit() {
        let data = {}
        if (this.extendStatusSearchForm.name) {
          data.name = this.extendStatusSearchForm.name
        }
        this.$axios({
          url: `/9999/extendStatus/query/${this.currentPage}/${this.currentSize}`,
          method: 'post',
          data
        }).then(({data}) => {
          this.extendStatusData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      addExtendStatus(e) {
        this.extendStatusTitle = '新增'
        this.attributeData = {
          attributeName: '',
          attributeKey: '',
          attributeOptions: "[]",
          attributeId: null
        }
        this.edit = false
        this.showEditDialog(e)
      },
      editExtendStatus(e, row) {
        this.extendStatusTitle = '修改'
        this.attributeData = row
        this.showEditDialog(e)
        this.edit = true
      },
      findAllExtendStatus() {
        this.$axios({
          url: `/local9999/attr/getAll`,
          method: 'get',
          params: {
            page: this.currentPage,
            rows: this.currentSize
          }
        }).then(({data}) => {
          console.log(data)
          this.extendStatusData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllExtendStatus()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllExtendStatus()
      },
      showEditDialog(e) {
        e.stopPropagation()
        this.dialogVisible = true
      },
      rowClick(row) {
        this.$refs.extendStatusTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteExtendStatusIds = val.map(item => item.id)
      },
      ensureDeleteExtendStatus() {
        if (this.deleteExtendStatusIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何品牌！请选择品牌后再进行操作！',
            type: 'warning'
          })
        }
      },
      sureDeleteExtendStatus() {
        this.$axios({
          url: '/9999/extendStatus/delete',
          method: 'post',
          data: this.deleteExtendStatusIds
        }).then(({data}) => {
          if (data.code === 200) {
            this.$message({
              message: '删除所选品牌成功！',
              type: 'success'
            })
            this.findAllExtendStatus()
            this.deleteDialog = false
          }
        })
      }
    },
    mounted() {
      this.findAllExtendStatus()
    }
  }
</script>

<style scoped>

</style>
