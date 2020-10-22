<template>
  <el-dialog
    title="商品分类编辑"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="categoryForm"
      ref="categoryForm"
      :rules="categoryFormRules"
      label-width="110px"
    >
      <el-form-item
        label="商品分类名称"
        prop="categoryName"
      >
        <el-input v-model="categoryForm.categoryName" placeholder="商品分类名称"></el-input>
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
  export default {
    name: "new-category",
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      },
      editCategoryData: {
        type: Object
      },
      parentId: {
        type: Number
      },
      findAllCategory: {
        type: Function
      }
    },
    data() {
      return {
        categoryForm: {
          categoryName: ''
        },
        categoryFormRules: {
          categoryName: [
            {
              required: true,
              message: '请填写商品分类名称！',
              trigger: 'blur'
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
        this.$refs.categoryForm.clearValidate()
        this.$emit('update:dialogVisible', false)
      },
      onSubmit() {
        this.$refs.categoryForm.validate(valid => {
          if (!valid) return false
          this.$axios({
            url: this.editCategoryData.id ? '/9999/itemCat/update' : '/9999/itemCat/add',
            method: 'post',
            data: this.editCategoryData.id
              ? {
                id: this.editCategoryData.id,
                name: this.categoryForm.categoryName
              }
              : {
                parentId: this.parentId,
                name: this.categoryForm.categoryName,
                typeid: 35
              }
          }).then(({data}) => {
            if (data.code === 200) {
              this.findAllCategory()
              this.$message({
                message: this.editCategoryData.id ? '修改分类成功！' : '新增分类成功！',
                type: 'success'
              })
              this.cancel()
            }
          })
        })
      }
    },
    mounted() {
      this.categoryForm.categoryName = this.editCategoryData.name
    },
    watch: {
      editCategoryData() {
        this.categoryForm.categoryName = this.editCategoryData.name
      }
    }
  }
</script>

<style scoped>

</style>
