<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="specificationSearchForm">
          <el-form-item label="规格名称">
            <el-input v-model="specificationSearchForm.specificationName"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="searchSpecification"
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
            @click="newSpecificationOption"
            type="primary"
          >
            新增
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteSpecification"
          >
            删除
          </el-button>
        </el-button-group>
        <el-table
          :data="specificationData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionChange"
          ref="specificationTable"
        >
          <el-table-column
            type="selection"
          >
          </el-table-column>
          <el-table-column
            label="规格ID"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="规格名称"
            prop="specName"
          >
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="editSpecification($event, scope.row)"
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
      <new-specification
        :dialog-visible.sync="dialogVisible"
        :findAllSpecification="findAllSpecification"
        :editSpecificationData="editSpecificationData"
      />
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
          @click="sureDeleteSpecifications"
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
  import NewSpecification from "./newspecification"

  export default {
    name: 'specification',
    components: {NewSpecification},
    data() {
      return {
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        specificationData: [],
        dialogVisible: false,
        deleteDialog: false,
        deleteSpecificationIds: [],
        specificationSearchForm: {
          specificationName: ''
        },
        editSpecificationData: {
          id: null,
          optionList: [],
          specName: ''
        }
      }
    },
    methods: {
      onSubmit() {

      },
      findAllSpecification() {
        this.$axios({
          url: `/9999/specification/getAll`,
          method: 'post',
          params: {
            pageNum: this.currentPage,
            size: this.currentSize
          },
          data: {}
        }).then(({data}) => {
          console.log(data)
          this.specificationData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllSpecification()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllSpecification()
      },
      searchSpecification() {

      },
      ensureDeleteSpecification() {
        if (this.deleteSpecificationIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.specificationTable.toggleRowSelection(row)
      },
      handleSelectionChange(val) {
        this.deleteSpecificationIds = val.map(item => item.id)
      },
      sureDeleteSpecifications() {
        this.$axios({
          url: '/9999/specification/delete',
          method: 'post',
          data: this.deleteSpecificationIds
        }).then(({data}) => {
          console.log(data)
          if (data.code === 200) {
            this.$message({
              message: '删除所选规格成功',
              type: 'success'
            })
            this.deleteDialog = false
            this.findAllSpecification()
          }
        })
      },
      editSpecification(e, row) {
        e.stopPropagation()
        this.dialogVisible = true
        this.editSpecificationData = {
          id: row.id,
          optionList: row.specificationOptionList,
          specName: row.specName
        }
      },
      newSpecificationOption() {
        this.editSpecificationData = {
          id: null,
          optionList: [],
          specName: ''
        }
        this.dialogVisible = true
      }
    },
    mounted() {
      this.findAllSpecification()
    }
  }
</script>

<style scoped>

</style>
