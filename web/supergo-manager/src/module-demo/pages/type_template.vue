<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card>
        <div style="margin-bottom: 20px">
          <el-button-group>
            <el-button type="primary" @click="dialogVisible = true">
              新增
            </el-button>
            <el-button type="danger" @click="ensureDeleteTypeTemplate">
              删除
            </el-button>
          </el-button-group>
        </div>
        <el-table
          :data="dataList"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="typeTemplateTable"
        >
          <el-table-column type="selection">
          </el-table-column>
          <el-table-column prop="id" label="模板ID">
          </el-table-column>
          <el-table-column prop="name" label="分类模板名称">
          </el-table-column>
          <el-table-column prop="brandIds" label="关联品牌">
            <template slot-scope="scope">
              <span>
                {{JSON.parse(scope.row.brandIds).map(item => item.text).join(',')}}
              </span>
            </template>
          </el-table-column>
          <el-table-column prop="specIds" label="关联规格">
            <template slot-scope="scope">
              <span>
                {{JSON.parse(scope.row.specIds).map(item => item.text).join(',')}}
              </span>
            </template>
          </el-table-column>
          <el-table-column prop="customAttributeItems" label="扩展属性">
            <template slot-scope="scope">
              <span>
                {{JSON.parse(scope.row.customAttributeItems).map(item => item.text).join(',')}}
              </span>
            </template>
          </el-table-column>
        </el-table>
        <div style="overflow: hidden">
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
        <new-template :dialogVisible.sync="dialogVisible"/>
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
            @click="sureDeleteTypeTemplate"
          >
            确定
          </el-button>
          <el-button
            @click="deleteDialog = false"
          >
            取消
          </el-button>
        </el-dialog>
      </el-card>
    </div>
  </div>
</template>

<script>
  import NewTemplate from "./newtemplate"

  export default {
    name: 'type-template',
    components: {NewTemplate},
    data() {
      return {
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        dataList: [],
        dialogVisible: false,
        deleteDialog: false,
        deleteTypeTemplateIds: []
      }
    },
    methods: {
      ensureDeleteTypeTemplate() {
        if (this.deleteTypeTemplateIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      findAllTemplate() {
        this.$axios({
          url: `/9999/template/getAll`,
          method: 'post',
          params: {
            pageNum: this.currentPage,
            size: this.currentSize
          },
          data: {}
        }).then(({data}) => {
          this.dataList = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllTemplate()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllTemplate()
      },
      rowClick(row) {
        this.$refs.typeTemplateTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteTypeTemplateIds = val.map(item => item.id)
      },
      sureDeleteTypeTemplate() {
        this.$axios({
          url: '/9999/template/delete',
          method: 'post',
          data: this.deleteTypeTemplateIds
        }).then(({data}) => {
          if (data.code === 200) {
            this.$message({
              message: '删除所选模板成功！',
              type: 'success'
            })
            this.findAllTemplate()
            this.deleteDialog = false
          }
        })
      }
    },
    mounted() {
      this.findAllTemplate()
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

</style>
