<template>
  <el-dialog
    title="新增用户"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="userEditForm"
      :rules="userFormRules"
      label-width="100px"
      ref="userEditForm"
    >
      <el-form-item label="中文名称" prop="name">
        <el-input v-model="userEditForm.name"></el-input>
      </el-form-item>
      <el-form-item label="用户名称" prop="username">
        <el-input v-model="userEditForm.username"></el-input>
      </el-form-item>
      <el-form-item label="头像上传" prop="icon">
        <el-upload
          class="avatar-uploader"
          action="/9999/upload/pic"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
        >
          <img v-if="userEditForm.headPic" :src="userEditForm.headPic" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="用户密码" prop="password">
        <el-input type="password" v-model="userEditForm.password"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmPassword">
        <el-input type="password" v-model="userEditForm.confirmPassword"></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="userEditForm.phone"></el-input>
      </el-form-item>
    </el-form>
    <el-button
      type="primary"
      @click="onSubmit"
    >
      保存
    </el-button>
    <el-button
      @click="cancel"
    >
      取消
    </el-button>
  </el-dialog>
</template>

<script>
  import moment from "moment"
  export default {
    name: "new-user",
    props: {
      dialogVisible: {
        user: Boolean,
        default: false
      },
      findAllUser: {
        type: Function
      }
    },
    data() {
      let validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.userEditForm.password) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }
      return {
        userEditForm: {
          name: '',
          username: '',
          password: '',
          headPic: '',
          confirmPassword: '',
          phone: ''
        },
        userFormRules: {
          name: [
            {
              required: true,
              message: '请填写中文名称！',
              trigger: 'blur'
            }
          ],
          username: [
            {
              required: true,
              message: '请填写用户名称！',
              trigger: 'blur'
            }
          ],
          password: [
            {
              required: true,
              message: '请输入您的密码！'
            }
          ],
          confirmPassword: [
            {
              required: true,
              message: '请再次输入密码'
            },
            {
              validator: validatePass2,
              trigger: 'blur'
            }
          ],
          phone: [
            {
              required: true,
              message: '请填写手机号！',
              trigger: 'blur'
            },
            {
              pattern: /^1[3456789]\d{9}$/,
              message: '请输入正确的手机号码！'
            }
          ]
        }
      }
    },
    computed: {
      visible() {
        return this.dialogVisible
      }
    },
    methods: {
      cancel() {
        this.$refs.userEditForm.clearValidate()
        this.$refs.userEditForm.resetFields()
        this.$emit('update:dialogVisible', false)
      },
      handleUpload() {

      },
      onSubmit() {
        this.$refs.userEditForm.validate(valid => {
          if (valid) {
            let {confirmPassword, ...data} = this.userEditForm
            this.$axios({
              url: '/9999/user/add',
              method: 'post',
              data: {
                ...data,
                created: moment().format(),
                updated: moment().format()
              }
            }).then(({data}) => {
              if (data.code === 200) {
                this.$message({
                  message: '新增用户成功！',
                  type: 'success'
                })
                this.findAllUser()
                this.cancel()
              }
            })
          } else {
            return false
          }
        })
      },
      beforeAvatarUpload(file) {
        const isJPG = (file.type === 'image/jpeg' || file.type === 'image/png' || file.type === 'image/gif' || file.type === 'image/sg' || file.type === 'image/jpg')

        if (!isJPG) {
          this.$message.error('请上传图片格式文件!')
        }
        return isJPG
      },
      handleAvatarSuccess(res, file) {
        if (res.code === 200) {
          this.userEditForm.headPic = res.msg
        } else {
          this.$message.error('上传图片失败！请重新上传！')
        }
      }
    },
    mounted() {
    }
  }
</script>

<style scoped>

</style>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar-uploader .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
