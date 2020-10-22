<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item v-for="breadcrumbItem in nowCategoryBreadList" :key="breadcrumbItem.id" @click.native="changeNowCategory(breadcrumbItem)">{{breadcrumbItem.text}}</el-breadcrumb-item>
        </el-breadcrumb>
      </el-card>
      <el-card>
        <el-button-group
          style="margin-bottom: 20px;"
        >
          <el-button
            @click="newCategoryData"
            type="primary"
          >
            新增
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteCategory"
          >
            删除
          </el-button>
        </el-button-group>
        <el-table
          :data="categoryData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="categoryTable"
        >
          <el-table-column
            type="selection"
          >
          </el-table-column>
          <el-table-column
            label="分类ID"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="分类名称"
            prop="name"
          >
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                v-show="nowCategoryBreadList.length < 3"
                type="text"
                @click="findChildrenCategory(scope.row)"
              >
                查询下级
              </el-button>
              <el-button
                type="text"
                @click="editCategory($event, scope.row)"
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
      <new-category :dialog-visible.sync="dialogVisible" :findAllCategory="findAllCategory" :parentId="parentId" :edit-category-data="editCategoryData"/>
      <el-dialog
        title="删除商品分类"
        :visible="deleteDialog"
        @close="deleteDialog = false"
      >
        <div style="margin-bottom: 20px;">
          确认删除所选分类？
        </div>
        <el-button
          type="primary"
          @click="sureDeleteCategories"
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

  import NewCategory from "./newcategory"
  export default {
    name: 'category',
    components: {NewCategory},
    data() {
      return {
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        parentId: 0,
        categoryData: [],
        dialogVisible: false,
        deleteDialog: false,
        deleteCategoryIds: [],
        nowCategoryBreadList: [
          {
            id: 0,
            text: '顶级分类列表'
          }
        ],
        editCategoryData: {
          id: null,
          name: ''
        }
      }
    },
    methods: {
      onSubmit() {

      },
      findAllCategory() {
        this.$axios({
          url: `/9999/itemCat/getByParentIdAndPage/${this.currentPage}/${this.currentSize}/${this.parentId}`,
          method: 'get'
        }).then(({data}) => {
          this.categoryData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllCategory()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllCategory()
      },
      showEditDialog(e) {
        e.stopPropagation()
        this.dialogVisible = true
      },
      ensureDeleteCategory() {
        if (this.deleteCategoryIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何分类！请选择分类后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.categoryTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteCategoryIds = val.map(item => item.id)
      },
      sureDeleteCategories() {
        this.$axios({
          url: '/9999/itemCat/delete',
          method: 'post',
          data: this.deleteCategoryIds
        }).then(({data}) => {
          if (data.code === 200) {
            this.$message({
              message: '删除所选分类成功！',
              type: 'success'
            })
            this.findAllCategory()
            this.deleteDialog = false
          }
        })
      },
      findChildrenCategory(row) {
        this.deleteCategoryIds = []
        this.parentId = row.id
        this.nowCategoryBreadList = [...this.nowCategoryBreadList, {id: row.id, text: row.name}]
        this.findAllCategory()
      },
      changeNowCategory(breadItem) {
        this.deleteCategoryIds = []
        this.nowCategoryBreadList.forEach((item, index) => {
          if (breadItem.id === item.id) {
            this.nowCategoryBreadList = this.nowCategoryBreadList.slice(0, index + 1)
            this.parentId = item.id
            this.findAllCategory()
          }
        })
      },
      newCategoryData() {
        this.dialogVisible = true
        this.editCategoryData = {
          id: null,
            name: ''
        }
      },
      editCategory(e, row) {
        e.stopPropagation()
        this.dialogVisible = true
        this.editCategoryData = {
          id: row.id,
          name: row.name
        }
      }
    },
    mounted() {
      this.findAllCategory()
    }
  }
</script>

<style scoped>

</style>
