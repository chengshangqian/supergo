<template>
  <el-dialog
    title="新增权限"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="userEditForm"
      :rules="userFormRules"
      label-width="100px"
      ref="userEditForm"
    >
      <el-form-item label="中文名称" prop="userCHNName">
        <el-input v-model="userEditForm.userCHNName"></el-input>
      </el-form-item>
      <el-form-item label="用户名称" prop="userName">
        <el-input v-model="userEditForm.userName"></el-input>
      </el-form-item>
      <el-form-item label="头像上传" prop="icon">
        <el-upload action="1" v-model="userEditForm.icon">
          <el-button
            type="primary"
            @click="handleUpload"
          >
            点击上传
          </el-button>
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
    <el-button>
      取消
    </el-button>
  </el-dialog>
</template>

<script>
  export default {
    name: "new-authority",
    props: {
      dialogVisible: {
        user: Boolean,
        default: false
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
          userCHNName: '',
          userName: '',
          icon: '',
          password: '',
          confirmPassword: '',
          phone: ''
        },
        userFormRules: {
          userCHNName: [
            {
              required: true,
              message: '请填写中文名称！',
              trigger: 'blur'
            }
          ],
          userName: [
            {
              required: true,
              message: ''
            }
          ],
          icon: [
            {
              required: true,
              message: ''
            }
          ],
          password: [
            {
              required: true,
              message: ''
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
              message: ''
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
        this.$emit('update:dialogVisible', false)
      },
      handleUpload() {

      },
      onSubmit() {
        this.$refs.userEditForm.validate(valid => {
          if (valid) {
            console.log('校验成功')
          } else {
            return false
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
