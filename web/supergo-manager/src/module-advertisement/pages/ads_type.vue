<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="adsTypeSearchForm">
          <el-form-item label="名称">
            <el-input v-model="adsTypeSearchForm.orderNumber"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="searchAdsType"
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
            新建
          </el-button>
          <el-button
            type="success"
            @click="ensureDeleteAdsType"
          >
            删除
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteAdsType"
          >
            开启
          </el-button>
          <el-button
            type="success"
            @click="ensureDeleteAdsType"
          >
            屏蔽
          </el-button>
        </el-button-group>
        <el-table
          :data="adsTypeData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionAdsType"
          ref="adsTypeTable"
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
            prop="adsTypeName"
          >
          </el-table-column>
          <el-table-column
            label="分组"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="KEY"
            prop="adsTypeName"
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
            @size-adsType="handleSizeAdsType"
            @current-adsType="handleCurrentAdsType"
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
          @click="sureDeleteAdsTypes"
        >
          确定
        </el-button>
        <el-button
          @click="deleteDialog = false"
        >
          取消
        </el-button>
      </el-dialog>
      <new-ads-type :dialogVisible.sync="dialogVisible"/>
    </div>
  </div>
</template>

<script>
  import NewAdsType from "./newadstype";
  export default {
    name: 'adsType',
    components: {NewAdsType},
    data() {
      return {
        currentPage: 1,
        adsTypeData: [
          {
            id: 1,
            adsTypeName: '图书',
            sort: 1,
            pid: 0
          },
          {
            id: 2,
            adsTypeName: '家用电器',
            sort: 2,
            pid: 0
          },
          {
            id: 11,
            adsTypeName: '小说',
            sort: 3,
            pid: 1
          }
        ],
        dialogVisible: false,
        deleteDialog: false,
        deleteAdsTypeIds: [],
        adsTypeSearchForm: {
          adsTypeStatus: '',
          orderNumber: '',
          consignee: '',
          updateTime: ''
        }
      }
    },
    methods: {
      onSubmit() {

      },
      handleSizeAdsType() {

      },
      handleCurrentAdsType() {

      },
      searchAdsType() {

      },
      showEditDialog(e) {
        e.stopPropagation();
        this.dialogVisible = true
      },
      ensureDeleteAdsType() {
        if (this.deleteAdsTypeIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.adsTypeTable.toggleRowSelection(row)
      },
      handleSelectionAdsType(val) {
        this.deleteAdsTypeIds = val.map(item => item.id)
      },
      sureDeleteAdsTypes() {
        this.deleteDialog = false
      }
    }
  }
</script>

<style scoped>

</style>
