<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card style="margin-bottom: 20px;">
        <el-form :inline="true" v-model="userSearchForm">
          <el-form-item label="名称">
            <el-input v-model="userSearchForm.orderNumber"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="searchUser"
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
            @click="newUserInfo"
            type="primary"
          >
            新建
          </el-button>
          <el-button
            type="danger"
            @click="ensureDeleteUser"
          >
            删除
          </el-button>
          <!--<el-button-->
          <!--type="danger"-->
          <!--@click="ensureDeleteUser"-->
          <!--&gt;-->
          <!--重置密码-->
          <!--</el-button>-->
        </el-button-group>
        <el-table
          :data="userData"
          :cell-style="() => 'text-align:center'"
          :header-cell-style="() => 'text-align:center'"
          style="margin-bottom: 15px;"
          @row-click="rowClick"
          @selection-change="handleSelectionUser"
          ref="userTable"
        >
          <el-table-column
            type="selection"
          >
          </el-table-column>
          <el-table-column
            label="用户ID"
            prop="id"
          >
          </el-table-column>
          <el-table-column
            label="用户名称"
            prop="username"
          >
          </el-table-column>
          <el-table-column
            label="用户入职时间"
            prop="created"
          >
            <template slot-scope="scope">
              {{momentTime(scope.row.created, 'YYYY-MM-DD HH:mm:ss')}}
            </template>
          </el-table-column>
          <el-table-column
            label="更改时间"
            prop="updated"
          >
            <template slot-scope="scope">
              {{momentTime(scope.row.updated, 'YYYY-MM-DD HH:mm:ss')}}
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="editUserInfo($event, scope.row)"
              >
                修改
              </el-button>
              <!--<el-button-->
              <!--type="text"-->
              <!--@click="showEditDialog"-->
              <!--&gt;-->
              <!--授权-->
              <!--</el-button>-->
            </template>
          </el-table-column>
          <!--<el-table-column-->
          <!--label="职务"-->
          <!--&gt;-->
          <!--<el-button-->
          <!--type="text"-->
          <!--@click="showEditDialog"-->
          <!--&gt;-->
          <!--查看-->
          <!--</el-button>-->
          <!--</el-table-column>-->
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
          @click="sureDeleteUsers"
        >
          确定
        </el-button>
        <el-button
          @click="deleteDialog = false"
        >
          取消
        </el-button>
      </el-dialog>
      <new-user :dialogVisible.sync="dialogVisible" :find-all-user="findAllUser"/>
      <edit-user :dialogVisible.sync="editVisible" :find-all-user="findAllUser" :edit-user-data="editUserData"/>
    </div>
  </div>
</template>

<script>
  import NewUser from "./newuser"
  import moment from 'moment'
  import EditUser from "./edituser"
  export default {
    name: 'user',
    components: {EditUser, NewUser},
    data() {
      return {
        currentPage: 1,
        currentSize: 10,
        currentTotal: 0,
        userData: [],
        dialogVisible: false,
        editVisible: false,
        deleteDialog: false,
        deleteUserIds: [],
        userSearchForm: {
          userStatus: '',
          orderNumber: '',
          consignee: '',
          updateTime: ''
        },
        editUserData: {
          id: null,
          username: '',
          name: '',
          phone: '',
          headPic: ''
        }
      }
    },
    methods: {
      onSubmit() {

      },
      findAllUser() {
        this.$axios({
          url: '/9999/user/getAll',
          method: 'post',
          params: {
            pageNum: this.currentPage,
            size: this.currentSize
          },
          data: {}
        }).then(({data}) => {
          this.userData = data.data.rows
          this.currentTotal = data.data.total
        })
      },
      handleSizeChange(size) {
        this.currentSize = size
        this.findAllUser()
      },
      handleCurrentChange(page) {
        this.currentPage = page
        this.findAllUser()
      },
      searchUser() {

      },
      newUserInfo() {
        this.dialogVisible = true
      },
      editUserInfo(e, row) {
        e.stopPropagation()
        this.editUserData = {
          id: row.id,
          username: row.username,
          name: row.name,
          phone: row.phone,
          headPic: row.headPic
        }
        this.editVisible = true
      },
      ensureDeleteUser() {
        if (this.deleteUserIds.length > 0) {
          this.deleteDialog = true
        } else {
          this.$message({
            message: '当前未选中任何规格！请选择规格后再进行操作！',
            type: 'warning'
          })
        }
      },
      rowClick(row) {
        this.$refs.userTable.toggleRowSelection(row)
      },
      handleSelectionUser(val) {
        this.deleteUserIds = val.map(item => item.id)
      },
      sureDeleteUsers() {
        this.$axios({
          url: '/9999/user/delete',
          method: 'post',
          data: this.deleteUserIds
        }).then(({data}) => {
          if (data.code === 200) {
            this.findAllUser()
            this.deleteDialog = false
            this.$message({
              message: '所选用户删除成功!',
              type: 'success'
            })
          }
        })
      },
      momentTime(time, style) {
        return moment(time).format(style)
      }
    },
    mounted() {
      this.findAllUser()
    }
  }
</script>

<style scoped>

</style>
