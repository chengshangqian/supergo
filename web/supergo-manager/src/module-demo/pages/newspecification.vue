<template>
  <el-dialog
    title="规格编辑"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="specificationForm"
      ref="specificationForm"
      :rules="specificationFormRules"
      label-width="110px"
    >
      <el-form-item
        label="规格名称"
        prop="specificationName"
      >
        <el-input v-model="specificationForm.specificationName" placeholder="规格名称"></el-input>
      </el-form-item>
    </el-form>
    <el-button
      type="primary"
      @click="addSpecificationItem"
      style="margin-bottom: 15px;"
    >
      新增规格选项
    </el-button>
    <el-table :data="specificationList" style="margin-bottom: 20px;">
      <el-table-column label="规格选项">
        <template slot-scope="scope">
          <el-input v-model="scope.row.optionName"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="排序">
        <template slot-scope="scope">
          <el-input v-model="scope.row.orders"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            type="text"
            @click="deleteSpecificationItem(scope)"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
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
  export default {
    name: "new-specification",
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      },
      findAllSpecification: {
        type: Function
      },
      editSpecificationData: {
        type: Object
      }
    },
    data() {
      return {
        specificationForm: {
          specificationName: ''
        },
        specificationList: [],
        specificationFormRules: {
          specificationName: [
            {
              required: true,
              message: '请填写规格名称！',
              trigger: 'blur'
            }
          ]
        },
        editId: null
      }
    },
    computed: {
      visible() {
        return this.dialogVisible
      }
    },
    methods: {
      cancel() {
        this.$refs.specificationForm.clearValidate()
        this.$emit('update:dialogVisible', false)
      },
      onSubmit() {
        let data = this.editId
          ? {
            id: this.editId,
            specName: this.specificationForm.specificationName,
            specificationOptionList: [
              ...this.specificationList
            ]
          }
          : {
            specName: this.specificationForm.specificationName,
            specificationOptionList: [
              ...this.specificationList
            ]
          }
        this.$refs.specificationForm.validate((valid) => {
          if (valid) {
            this.$axios({
              url: `/9999/specification/${this.editId ? 'update' : 'add'}`,
              method: 'post',
              data
            }).then(({data}) => {
              if (data.code === 200) {
                this.specificationList = []
                this.specificationForm.specificationName = ''
                this.$message({
                  message: this.editId ? '修改规格成功！' : '新增规格成功！',
                  type: 'success'
                })
                this.findAllSpecification()
                this.cancel()
              }
            })
          } else {
            return false
          }
        })
      },
      addSpecificationItem() {
        this.specificationList = [
          ...this.specificationList,
          {
            optionName: '',
            orders: '',
            specId: 0
          }
        ]
      },
      deleteSpecificationItem(scope) {
        this.specificationList = this.specificationList.filter((item, index) => index !== scope.$index)
      }
    },
    mounted() {
      this.editId = this.editSpecificationData.id
      this.specificationList = this.editSpecificationData.optionList
      this.specificationForm.specificationName = this.editSpecificationData.specName
    },
    watch: {
      editSpecificationData() {
        this.editId = this.editSpecificationData.id
        this.specificationList = this.editSpecificationData.optionList
        this.specificationForm.specificationName = this.editSpecificationData.specName
      }
    }
  }
</script>

<style scoped>

</style>
