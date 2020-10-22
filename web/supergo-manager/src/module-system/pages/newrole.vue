<template>
  <el-dialog
    :title="roleDialogTitle + '角色'"
    :visible="visible"
    @close="cancel"
  >
    <el-form
      :model="roleEditForm"
      :rules="roleFormRules"
      label-width="100px"
      ref="roleEditForm"
    >
      <el-form-item label="角色名称" prop="roleName">
        <el-input v-model="roleEditForm.roleName"></el-input>
      </el-form-item>
      <el-form-item label="上级角色" prop="higherRole">
        <el-popover
          ref="higherRolePopOver"
          placement="bottom-start"
          trigger="click"
        >
          <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
        </el-popover>
        <el-input :value="higherRoleName" v-popover:higherRolePopOver>
          <el-button slot="append">选择</el-button>
        </el-input>
      </el-form-item>
      <el-form-item label="角色备注" prop="remarks">
        <el-input type="textarea" v-model="roleEditForm.remarks"></el-input>
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
  export default {
    name: "new-role",
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      },
      roleDialogTitle: {
        type: String
      }
    },
    data() {
      return {
        higherRoleDialog: false,
        higherRoleName: '',
        roleEditForm: {
          roleName: '',
          higherRole: '',
          remarks: ''
        },
        roleFormRules: {
          roleName: [
            {
              required: true,
              message: '请填写角色名称！',
              trigger: 'blur'
            }
          ],
          higherRole: [
            {
              required: true,
              message: '请选择上级角色！',
              trigger: 'change'
            }
          ]
        },
        data: [{
          label: '一级 1',
          children: [{
            label: '二级 1-1',
            children: [{
              label: '三级 1-1-1'
            }]
          }]
        }, {
          label: '一级 2',
          children: [{
            label: '二级 2-1',
            children: [{
              label: '三级 2-1-1'
            }]
          }, {
            label: '二级 2-2',
            children: [{
              label: '三级 2-2-1'
            }]
          }]
        }, {
          label: '一级 3',
          children: [{
            label: '二级 3-1',
            children: [{
              label: '三级 3-1-1'
            }]
          }, {
            label: '二级 3-2',
            children: [{
              label: '三级 3-2-1'
            }]
          }]
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
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
        this.$refs.roleEditForm.validate(valid => {
          if (valid) {
            console.log('校验成功')
          } else {
            return false
          }
        })
      },
      chooseHigherRole() {

      },
      handleNodeClick(data) {
        this.higherRoleName = data.label
        this.roleEditForm.higherRole = data.label
      }
    }
  }
</script>

<style scoped>

</style>
