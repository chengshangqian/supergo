<template>
  <el-dialog
    title="广告添加"
    :visible="visible"
    @close="cancel"
  >
    <el-form :model="adsTypeEditForm" :rules="adsTypeFormRules" label-width="100px">
      <el-form-item label="广告分类" prop="adsType">
        <el-input v-model="adsTypeEditForm.adsType"></el-input>
      </el-form-item>
      <el-form-item label="标题" prop="title">
        <el-input v-model="adsTypeEditForm.title"></el-input>
      </el-form-item>
      <el-form-item label="KEY" prop="key">
        <el-input v-model="adsTypeEditForm.key"></el-input>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="adsTypeEditForm.status">
          <el-option label="无效" :value="0"></el-option>
          <el-option label="有效" :value="1"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
  export default {
    name: "new-advertisement",
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        adsTypeEditForm: {
          adsType: '',
          title: '',
          key: '',
          status: 1
        },
        adsTypeFormRules: {
          adsType: [
            {
              required: true,
              message: '请填写分类名称!',
              trigger: 'blur'
            }
          ],
          title: [
            {
              required: true,
              message: '请填写分组!',
              trigger: 'blur'
            }
          ],
          key: [
            {
              required: true,
              message: '请填写KEY!',
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
        this.$emit('update:dialogVisible', false)
      }
    }
  }
</script>

<style scoped>

</style>
