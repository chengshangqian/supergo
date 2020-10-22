<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-radio-group v-model="applicationStatus" @change="changeStatus">
          <el-radio-button label="全部">
          </el-radio-button>
          <el-radio-button v-for="statusItem in statusList" :label="statusItem" :key="statusItem">
          </el-radio-button>
        </el-radio-group>
      </el-card>
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
              <el-button
                type="text"
                @click="showAllStore = true"
              >
                查看所有店铺
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
      <application-details :dialogVisible.sync="dialogVisible" :selectSeller="selectSeller"/>
      <all-store :show-all-store.sync="showAllStore"/>
    </div>
  </div>
</template>

<script>

  import ApplicationDetails from "./applicationdetails"
  import AllStore from "./allstore"

  export default {
    name: 'brand',
    components: {AllStore, ApplicationDetails},
    data() {
      return {
        searchForm: {
          name: '',
          nickName: ''
        },
        applicationStatus: '全部',
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        applicationData: [],
        dialogVisible: false,
        showAllStore: false,
        selectSeller: null,
        statusList: [
          '待审核',
          '已审核',
          '审核未通过',
          '关闭'
        ]
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
        let data = this.turnNameToStatus(this.applicationStatus) === 'all'
          ? {
            ...searchData
          }
          : {
          status: this.turnNameToStatus(this.applicationStatus),
            ...searchData
          }
        this.$axios({
          url: `/9999/seller/query/${this.currentPage}/${this.currentSize}`,
          method: 'post',
          data
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
      turnNameToStatus(status) {
        switch (status) {
          case '全部':
            return 'all'
          case '待审核':
            return '0'
          case '已审核':
            return '1'
          case '审核未通过':
            return '2'
          case '商家关闭':
            return '3'
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
      },
      changeStatus(val) {
        let status = this.turnNameToStatus(val)
        if (status === 'all') {
          this.findAllSeller()
        } else {
          this.$axios({
            url: `/9999/seller/query/${this.currentPage}/${this.currentSize}`,
            method: 'post',
            data: {
              status: status
            }
          }).then(({data}) => {
            this.applicationData = data.data.rows
            this.currentTotal = data.data.total
          })
        }
      }
    },
    mounted() {
      this.findAllSeller()
    }
  }
</script>

<style scoped>

</style>
