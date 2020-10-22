<template>
  <div class="app-container">
    <h3>测试页面</h3>
    <el-cascader
      :options="options"
      @active-item-change="handleItemChange"
      :props="props"
></el-cascader>
  </div>
</template>

<script>
export default {
    data() {
      return {
        options: [{
          label: '江苏',
          cities: []
        }, {
          label: '浙江',
          cities: []
        }],
        props: {
          value: 'label',
          children: 'cities'
        }
      };
    },

    methods: {
      handleItemChange(val) {
        console.log('active item:', val);
        setTimeout(_ => {
          if (val.indexOf('江苏') > -1 && !this.options[0].cities.length) {
            this.options[0].cities = [{
              label: '南京'
            }];
          } else if (val.indexOf('浙江') > -1 && !this.options[1].cities.length) {
            this.options[1].cities = [{
              label: '杭州'
            }];
          }
        }, 300);
      }
    }
  };
</script>
<style lang="scss">
   .grid-content{
     height: 60px;
     border: 1px solid #CCC;
     line-height: 60px;
   }
   .grid-tit{
     background: #EEE;
     text-align: center;
   }
</style>

