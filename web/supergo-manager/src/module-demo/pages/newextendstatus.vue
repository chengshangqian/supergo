<template>
  <el-dialog
    :title="`${extendStatusTitle}扩展属性`"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="extendStatusForm"
      ref="extendStatusForm"
      :rules="extendStatusFormRules"
      label-width="110px"
    >
      <el-form-item
        label="属性名称"
        prop="attributeName"
      >
        <el-input v-model="extendStatusForm.attributeName" placeholder="属性名称"></el-input>
      </el-form-item>
      <el-form-item
        label="属性key"
        prop="attributeKey"
      >
        <el-input v-model="extendStatusForm.attributeKey" placeholder="属性key"></el-input>
      </el-form-item>
      <div style="margin-bottom: 20px;">
        <el-button-group>
          <el-button @click="newExtendStatus">
            新建扩展属性
          </el-button>
        </el-button-group>
      </div>
      <el-table
        :data="attributeOptions"
      >
        <el-table-column
          label="属性选项"
          prop="statusName"
        >
          <template slot-scope="scope">
            <el-input v-model="scope.row.optionName"></el-input>
          </template>
        </el-table-column>
        <el-table-column
          label="排序"
          prop="statusValue"
        >
          <template slot-scope="scope">
            <el-input v-model="scope.row.sort"></el-input>
          </template>
        </el-table-column>
        <el-table-column
          label="操作"
        >
          <template slot-scope="scope">
            <el-button @click="handleDelete(scope)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-form-item label-width="0" style="margin-top: 20px">
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
  import moment from "moment"

  export default {
    name: "new-extend-status",
    props: {
      extendStatusTitle: {
        type: String
      },
      edit: {
        type: Boolean
      },
      dialogVisible: {
        type: Boolean
      },
      attributeData: {
        type: Object
      },
      findAllExtendStatus: {
        type: Function
      }
    },
    data() {
      return {
        extendStatusForm: {
          attributeName: '',
          attributeKey: ''
        },
        extendStatusFormRules: {
          attributeName: [
            {
              required: true,
              message: '请填写扩展属性名！',
              trigger: 'blur'
            }
          ],
          attributeKey: [
            {
              required: true,
              message: '请填写扩展属性Key！',
              trigger: 'blur'
            }
          ]
        },
        secondForm: {},
        attributeOptions: [],
        attributeId: null
      }
    },
    methods: {
      onSubmit() {
        let data = this.edit
          ? {
            attributeId: this.attributeId,
            ...this.extendStatusForm,
            attributeOptions: JSON.stringify(this.attributeOptions),
            updateTime: moment().format()
          }
          : {
            ...this.extendStatusForm,
            attributeOptions: JSON.stringify(this.attributeOptions),
            createTime: moment().format(),
            updateTime: moment().format()

          }
        this.$axios({
          url: `/local9999/attr/${this.edit ? 'update' : 'add'}`,
          method: 'post',
          data
        }).then(({data}) => {
          if (data.code === 200) {
            this.findAllExtendStatus()
            this.cancel()
            this.$message({
              message: `${this.extendStatusTitle}扩展属性成功！`,
              type: 'success'
            })
          }
        })
      },
      cancel() {
        this.$refs.extendStatusForm.clearValidate()
        this.$emit('update:dialogVisible', false)
      },
      newExtendStatus() {
        this.attributeOptions = [
          ...this.attributeOptions,
          {
            optionName: '',
            sort: ''
          }
        ]
      },
      handleDelete(scope) {
        this.attributeOptions = this.attributeOptions.filter((item, index) => index !== scope.$index)
      }
    },
    computed: {
      visible() {
        return this.dialogVisible
      }
    },
    watch: {
      attributeData() {
        let {attributeId, attributeKey, attributeName, attributeOptions} = this.attributeData
        this.extendStatusForm = {
          attributeKey,
          attributeName
        }
        this.attributeId = attributeId
        this.attributeOptions = JSON.parse(attributeOptions)
      }
    }
  }
</script>

<style scoped>

</style>
