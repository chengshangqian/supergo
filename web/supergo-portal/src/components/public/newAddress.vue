<template>
    <div>
      <el-dialog title="添加收货地址" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
                <el-form :model="form">
    <el-form-item label="收货人:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="详细地址:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="联系电话:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="邮箱:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="地址别名:" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
      <p>建议填写常用地址:<el-button>家里</el-button><el-button>父母家</el-button><el-button>公司</el-button></p>
    </el-form-item>
  </el-form>
  
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>
    </div>
</template>

<script>
export default {
  name: "newAddress",
  props:["title"],
  data() {
    return {
     dialogFormVisible: false,//新增收货地址dialog
     form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
		formLabelWidth: '120px',
     
    };
  },
  components: {

  },
  created(){
    // console.log("this.title",this.title)
    //  if(this.title){
    //    this.dialogFormVisible=true;
    //    console.log("this.title",this.title)
    //  }
  },
  mounted() {

  },
  methods: {
    



  }
};
</script>

<style scoped>

</style>
