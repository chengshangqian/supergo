<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card>
        <el-form :inline="true" :model="searchForm">
          <el-form-item label="公司名称">
            <el-input v-model="searchForm.name" placeholder="公司名称"></el-input>
          </el-form-item>
          <el-form-item label="店铺名称">
            <el-input v-model="searchForm.nickName" placeholder="店铺名称"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
          </el-form-item>
        </el-form>
        <el-table
          :data="applicationData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
        >
          <el-table-column
            label="商家ID"
            prop="sellerId"
          >
          </el-table-column>
          <el-table-column
            label="公司名称"
            prop="name"
          >
          </el-table-column>
          <el-table-column
            label="默认店铺名称"
            prop="nickName"
          >
          </el-table-column>
          <el-table-column
            label="联系人姓名"
            prop="linkmanName"
          >
          </el-table-column>
          <el-table-column
            label="公司电话"
            prop="telephone"
          >
          </el-table-column>
          <el-table-column
            label="商家状态"
            prop="status"
          >
            <template slot-scope="scope">
              {{turnStatusToName(scope.row.status)}}
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="openSellerDetails(scope.row)"
              >
                详情
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
      <application-details :dialogVisible.sync="dialogVisible" :selectSeller="selectSeller" :application="true"/>
    </div>
  </div>
</template>

<script>
  import ApplicationDetails from './applicationdetails'
  export default {
    name: 'application',
    components: {ApplicationDetails},
    data() {
      return {
        searchForm: {
          name: '',
          nickName: ''
        },
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        applicationData: [],
        dialogVisible: false,
        selectSeller: null
      }
    },
    methods: {
      onSubmit() {
        let searchData = {}
        for (let searchFormKey in this.searchForm) {
          if (this.searchForm[searchFormKey]) {
            searchData[searchFormKey] = this.searchForm[searchFormKey]
          }
        }
        this.$axios({
          url: `/9999/seller/query/${this.currentPage}/${this.currentSize}`,
          method: 'post',
          data: {
            ...searchData
          }
        }).then(({data}) => {
          this.applicationData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      turnStatusToName(status) {
        switch (status) {
          case '0':
            return '待审核'
          case '1':
            return '已审核'
          case '2':
            return '审核未通过'
          case '3':
            return '商家关闭'
          default:
            return status
        }
      },
      openSellerDetails(row) {
        this.selectSeller = row
        this.dialogVisible = true
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllSeller()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllSeller()
      },
      findAllSeller() {
        this.$axios({
          url: `/9999/seller/query/${this.currentPage}/${this.currentSize}`,
          method: 'post',
          data: {}
        }).then(({data}) => {
          this.applicationData = data.data.rows
          this.currentTotal = data.data.total
        })
      }
    },
    mounted() {
      this.findAllSeller()
    }
  }
</script>

<style scoped>

</style>
