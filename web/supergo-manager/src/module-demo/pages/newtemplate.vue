<template>
  <el-dialog
    title="商品类型模板编辑"
    :visible="dialogVisible"
    @close="cancel"
  >
    <el-form :model="templateForm" label-width="110px" :rules="templateRules" ref="templateForm">
      <el-form-item label="模板所属分类" prop="templateType">
        <el-cascader :options="templateTypeList" v-model="templateForm.templateType">
        </el-cascader>
      </el-form-item>
      <el-form-item label="模板名称" prop="templateName">
        <el-input v-model="templateForm.templateName">
        </el-input>
      </el-form-item>
      <el-form-item label="关联品牌" prop="templateBrand">
        <el-select :multiple="true" v-model="templateForm.brandIds">
          <el-option v-for="brandItem in brandList" :label="brandItem.name" :value="brandItem.name" :key="brandItem.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="关联规格" prop="templateSize">
        <el-select :multiple="true" v-model="templateForm.specificationIds">
          <el-option v-for="specificationItem in specificationList" :label="specificationItem.text" :value="specificationItem.text" :key="specificationItem.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="扩展属性" prop="templateExtend">
        <el-select :multiple="true" v-model="templateForm.templateExtend">
          <el-option v-for="extendStatusItem in extendStatusList" :label="extendStatusItem.attributeName" :value="extendStatusItem.attributeName" :key="extendStatusItem.attributeId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          @click="onSubmit"
        >
          保存
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
  export default {
    name: 'new-template',
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        templateTypeList: [],
        templateForm: {
          templateType: [],
          templateName: '',
          brandIds: [],
          specificationIds: [],
          templateSize: [],
          templateExtend: []
        },
        templateRules: {
          templateType: [
            {
              required: true,
              message: '请选择模板所属分类！',
              trigger: 'change'
            }
          ],
          templateName: [
            {
              required: true,
              message: '请填写模板名称！',
              trigger: 'blur'
            }
          ]
        },
        brandList: [],
        specificationList: []
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
      onSubmit() {
        this.$refs.templateForm.validate((valid) => {
          if (!valid) return false
          console.log(this.templateForm)
          this.$axios({
            url: '/9999/api/manager/template/add',
            method: 'post',
            data: {
              brandIds: this.templateForm.brandIds.join(',')
            }
          }).then(({data}) => {
            console.log(data)
          })
        })
      }
    },
    mounted() {
      let array1 = ['1', '2']
      let array2 = ['a', 'b']
      let array3 = ['@', '*']
      // 作为二维数组来运算
      let array4 = [array1, array2, array3]
      // last为上次运算的结果，current为数组中的当前元素
      let result = array4.reduce((last, current) => {
        const array = []
        last.forEach(par1 => {
          current.forEach(par2 => {
            array.push(par1 + ',' + par2)
          })
        })
        return array
      })
      this.$axios({
        url: '/9999/brand/findAll',
        method: 'get'
      }).then(({data}) => {
        this.brandList = data.data
      })
      this.$axios({
        url: '/9999/specification/specificationList',
        method: 'get'
      }).then(({data}) => {
        this.specificationList = data.data
      })
      this.$axios({
        url: '/local9999/template/getAllAttrNotPage',
        method: 'get'
      }).then(({data}) => {
        console.log(data)
        this.extendStatusList = data.data
      })
    }
  }
</script>

<style scoped>

</style>
