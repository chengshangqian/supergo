<template>
    <div class="body userAddress">
                        <div class="address-title">
                            <span class="title">地址管理</span>
                            <a data-toggle="modal" data-target=".edit" data-keyboard="false"   class="sui-btn  btn-info add-new">添加新地址</a>
                            <span class="clearfix"></span>
                        </div>
                        <div class="address-detail">
                            <table class="sui-table table-bordered">
                                <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>地址</th>
                                        <th>联系电话</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>刘田田</td>
                                        <td>北京 北京市 海淀区 上地街道东北旺西路8号中关村软件园9号楼</td>
                                        <td>1774***********4</td>
                                        <td>
                                            <a href="#">编辑</a>
                                            <a href="#">删除</a>
                                            默认地址
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>沈沉</td>
                                        <td>北京 北京市 海淀区 上地街道东北旺西路8号中关村软件园9号楼</td>
                                        <td>1774***********4</td>
                                        <td>
                                            <a href="#">编辑</a>
                                            <a href="#">删除</a>
                                            <a href="#">设为默认</a>
                                        </td>
                                    </tr>
                                    
                                </tbody>
                            </table>                          
                        </div>
    </div>
</template>

<script>
export default {
  name: "setting-address",
  data() {
    return {
     
    };
  },
  components: {},
  mounted() {},
  methods: {
    



  }
};
</script>

<style scoped>

</style>
