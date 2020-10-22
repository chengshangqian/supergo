<template>
      <div class="body userSafe">

        <el-tabs v-model="activeName" type="border-card" @tab-click="handleClick">
    <el-tab-pane label="密码设置" name="first">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" size="mini">
        <el-form-item label="用户名" prop="name">
    <el-input v-model="ruleForm.name"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item label="重复密码" prop="checkPass">
    <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
</el-form>
      </el-tab-pane>
    <el-tab-pane label="绑定手机" name="second">
        <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
  <el-step title="第一步 验证身份"></el-step>
  <el-step title="第二步 绑定新手机号"></el-step>
  <el-step title="第三步 完成"></el-step>
</el-steps>
      </el-tab-pane>
  </el-tabs>
                
                    </div>
</template>

<script>
export default {
  name: "setting-safe",
  data() {
    var checkName = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('用户名不能为空'));
        }
        // setTimeout(() => {
        //   if (!Number.isInteger(value)) {
        //     callback(new Error('请输入数字值'));
        //   } else {
        //     if (value < 18) {
        //       callback(new Error('必须年满18岁'));
        //     } else {
        //       callback();
        //     }
        //   }
        // }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
    return {
      activeName: 'first',
      ruleForm: {
          name: '',
          pass: '',
          checkPass: ''
        },
        rules: {
          name: [
            { validator: checkName, trigger: 'blur' }
          ],
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass, trigger: 'blur' }
          ] 
        }
    };
  },
  components: {},
  mounted() {},
  methods: {
    
submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }


  }
};
</script>

<style scoped>
.el-input {
   width: 200px;
}
</style>
