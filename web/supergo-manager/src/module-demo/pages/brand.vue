<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="brandSearchForm">
          <el-form-item label="品牌名称">
            <el-input v-model="brandSearchForm.name"></el-input>
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
            @click="addBrand"
            type="primary"
          >
            新增
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteBrand"
          >
            删除
          </el-button>
        </el-button-group>
        <el-table
          :data="brandData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="brandTable"
        >
          <el-table-column type="selection">
          </el-table-column>
          <el-table-column
            label="品牌ID"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="品牌名称"
            prop="name"
          >
          </el-table-column>
          <el-table-column
            label="品牌首字母"
            prop="firstChar"
          >
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="editBrand($event, scope.row)"
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
      <new-brand :dialogVisible.sync="dialogVisible" :brandTitle="brandTitle" :editBrandItem="editBrandItem" :findAllBrand="findAllBrand"/>
      <el-dialog
        title="删除品牌"
        :visible="deleteDialog"
        @close="deleteDialog = false"
      >
        <div style="margin-bottom: 20px;">
          确认删除所选品牌？
        </div>
        <el-button
          type="primary"
          @click="sureDeleteBrands"
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
  import NewBrand from "./newbrand"
  export default {
    name: 'brand',
    components: {NewBrand},
    data() {
      return {
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        brandData: [],
        dialogVisible: false,
        deleteDialog: false,
        deleteBrandIds: [],
        brandSearchForm: {
          name: ''
        },
        brandTitle: '',
        editBrandItem: null
      }
    },
    methods: {
      onSubmit() {
        let data = {}
        if (this.brandSearchForm.name) {
          data.name = this.brandSearchForm.name
        }
        this.$axios({
          url: `/9999/brand/query/${this.currentPage}/${this.currentSize}`,
          method: 'post',
          data
        }).then(({data}) => {
          this.brandData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      addBrand(e) {
        this.brandTitle = '新增'
        this.editBrandItem = {
          name: '',
          firstChar: ''
        }
        this.showEditDialog(e)
      },
      editBrand(e, row) {
        this.brandTitle = '修改'
        this.editBrandItem = row
        this.showEditDialog(e)
      },
      findAllBrand() {
        this.$axios({
          url: `/9999/brand/query/${this.currentPage}/${this.currentSize}`,
          method: 'post',
          data: {}
        }).then(({data}) => {
          this.brandData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllBrand()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllBrand()
      },
      showEditDialog(e) {
        e.stopPropagation()
        this.dialogVisible = true
      },
      rowClick(row) {
        this.$refs.brandTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteBrandIds = val.map(item => item.id)
      },
      ensureDeleteBrand() {
        if (this.deleteBrandIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何品牌！请选择品牌后再进行操作！',
            type: 'warning'
          })
        }
      },
      sureDeleteBrands() {
        this.$axios({
          url: '/9999/brand/delete',
          method: 'post',
          data: this.deleteBrandIds
        }).then(({data}) => {
          if (data.code === 200) {
            this.$message({
              message: '删除所选品牌成功！',
              type: 'success'
            })
            this.findAllBrand()
            this.deleteDialog = false
          }
        })
      }
    },
    mounted() {
      this.findAllBrand()
    }
  }
</script>

<style scoped>

</style>
