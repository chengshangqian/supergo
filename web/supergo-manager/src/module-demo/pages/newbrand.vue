<template>
  <el-dialog
    :title="brandTitle + '品牌'"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="brandForm"
      ref="brandForm"
      :rules="brandFormRules"
      label-width="110px"
    >
      <el-form-item
        label="品牌名称"
        prop="name"
      >
        <el-input v-model="brandForm.name" placeholder="品牌名称"></el-input>
      </el-form-item>
      <el-form-item
        label="首字母"
        prop="firstChar"
      >
        <el-input v-model="brandForm.firstChar" placeholder="首字母"></el-input>
      </el-form-item>
      <el-form-item label-width="0">
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
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
  import moment from "moment";
  export default {
    name: "new-brand",
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      },
      brandTitle: {
        type: String
      },
      editBrandItem: {
        type: Object
      },
      findAllBrand: {
        type: Function
      }
    },
    data() {
      return {
        brandFormRules: {
          name: [
            {
              required: true,
              message: '请填写品牌名称！',
              trigger: 'blur'
            }
          ],
          firstChar: [
            {
              required: true,
              message: '请填写品牌首字母！',
              trigger: 'blur'
            },
            {
              length: 1,
              pattern: /^[A-Z]+$/,
              message: '请填写格式正确的首字母',
              trigger: 'change'
            }
          ]
        }
      }
    },
    computed: {
      visible() {
        return this.dialogVisible
      },
      brandForm() {
        return this.editBrandItem || {
          name: '',
          firstChar: ''
        }
      }
    },
    methods: {
      cancel() {
        this.$refs.brandForm.clearValidate()
        this.$emit('update:dialogVisible', false)
      },
      onSubmit() {
        this.$refs.brandForm.validate(valid => {
          if (!valid) return false
          this.$axios({
            url: '/9999/brand/saveOrUpdate',
            method: 'post',
            data: this.brandForm
          }).then(({data}) => {
            if (data.code === 200) {
              this.findAllBrand()
              this.$message({
                message: 'id' in this.brandForm ? '修改品牌成功！' : '新增品牌成功！',
                type: 'success'
              })
              this.cancel()
            }
          })
        })
      }
    }
  }
</script>

<style scoped>

</style>
