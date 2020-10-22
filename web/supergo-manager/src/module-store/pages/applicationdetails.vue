<template>
  <el-dialog
    title="商家详情"
    :visible="visible"
    @close="cancel"
  >
    <el-tabs :value="activityDetails" @tab-click="tabClick">
      <el-tab-pane v-for="(tabItem, tabIndex) in tabList" :label="$t('tabs.'+ tabItem)" :name="tabItem" :key="tabIndex">
        <template v-for="(numItem, numIndex) in numList">
          <el-form class="detailsForm" :model="formList[numItem + 'Form']" v-if="tabIndex === numIndex" label-width="calc(50%)" label-position="left" :key="numIndex">
            <el-form-item v-for="(formValue, formKey) in formList[numItem + 'Form']" :label="$t('form.' + formKey)" :key="formKey">
            <span>
              {{formValue}}
            </span>
            </el-form-item>
          </el-form>
        </template>
      </el-tab-pane>
    </el-tabs>
    <el-button-group>
      <el-button
        type="success"
        @click="changeSellerStatus(1)"
        v-if="application"
      >
        审核通过
      </el-button>
      <el-button
        type="danger"
        @click="changeSellerStatus(2)"
        v-if="application"
      >
        审核未通过
      </el-button>
      <el-button
        type="danger"
        @click="changeSellerStatus(3)"
        v-if="!application"
      >
        关闭商家
      </el-button>
      <el-button
        @click="cancel"
      >
        关闭
      </el-button>
    </el-button-group>
  </el-dialog>
</template>

<script>
  export default {
    name: 'application-details',
    data() {
      return {
        tabList: [
          'basicInfo',
          'contacts',
          'passport',
          'representative',
          'bank'
        ],
        activityDetail: '',
        numList: [
          'first',
          'second',
          'third',
          'forth',
          'fifth'
        ]
      }
    },
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      },
      application: {
        type: Boolean,
        default: false
      },
      selectSeller: {
        type: Object
      }
    },
    computed: {
      visible() {
        return this.dialogVisible
      },
      activityDetails() {
        return this.activityDetail || this.tabList[0]
      },
      firstForm() {
        let data = {}
        if (this.selectSeller && Object.keys(this.selectSeller).length > 0) {
          let {name, mobile, telephone, address} = this.selectSeller
          data = {
            name,
            mobile,
            telephone,
            address
          }
        }
        return data
      },
      secondForm() {
        let data = {}
        if (this.selectSeller && Object.keys(this.selectSeller).length > 0) {
          let {linkmanName, linkmanQq, linkmanMobile, linkmanEmail} = this.selectSeller
          data = {
            linkmanName,
            linkmanQq,
            linkmanMobile,
            linkmanEmail
          }
        }
        return data
      },
      thirdForm() {
        let data = {}
        if (this.selectSeller && Object.keys(this.selectSeller).length > 0) {
          let {licenseNumber, taxNumber, orgNumber} = this.selectSeller
          data = {
            licenseNumber,
            taxNumber,
            orgNumber
          }
        }
        return data
      },
      forthForm() {
        let data = {}
        if (this.selectSeller && Object.keys(this.selectSeller).length > 0) {
          let {legalPerson, legalPersonCardId} = this.selectSeller
          data = {
            legalPerson,
            legalPersonCardId
          }
        }
        return data
      },
      fifthForm() {
        let data = {}
        if (this.selectSeller && Object.keys(this.selectSeller).length > 0) {
          let {bankName, backUser} = this.selectSeller
          data = {
            bankName,
            backUser
          }
        }
        return data
      },
      formList() {
        let {firstForm,
          secondForm,
          thirdForm,
          forthForm,
          fifthForm} = this
        return {
          firstForm,
          secondForm,
          thirdForm,
          forthForm,
          fifthForm
        }
      }
    },
    methods: {
      turnStatusToName(status) {
        switch (status) {
          case 0:
            return '待审核'
          case 1:
            return '已审核'
          case 2:
            return '审核未通过'
          case 3:
            return '关闭商家'
          default:
            return status
        }
      },
      cancel() {
        this.$emit('update:dialogVisible', false)
      },
      changeSellerStatus(status) {
        this.$axios({
          url: `/9999/seller/status/${this.selectSeller.sellerId}/${status}`
        }).then(({data}) => {
          if (data.code === 200) {
            this.$message({
              message: `${data.msg}结果为${this.turnStatusToName(status)}!`,
              type: 'success'
            })
          } else {
            this.$message.error(data.msg)
          }
        })
      },
      tabClick(tab) {
        this.activityDetail = tab.name
      }
    }
  }
</script>

<style>
  .detailsForm {
    margin-bottom: 20px;
  }
  .detailsForm > div {
    border: 1px solid #f4f4f4;
    margin: 0;
    margin-top: -1px;
    text-indent: 10px;
  }
  .detailsForm > div:nth-child(1) {
    margin: 0;
  }
  .detailsForm > div:nth-child(2n - 1) {
    background: #f9f9f9;
  }
  .detailsForm > div > div {
    border-left: 1px solid #f4f4f4;
  }
  .detailsForm > div span {
    margin-left: 10px;
  }
</style>

<style scoped>

</style>
