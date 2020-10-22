<template>
  <el-dialog
    title="店铺详情"
    :visible="visible"
    @close="cancel"
  >

  </el-dialog>
</template>

<script>
  export default {
    name: "all-store",
    props: {
      showAllStore: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {

      }
    },
    computed: {
      visible() {
        return this.showAllStore
      }
    },
    methods: {
      cancel() {
        this.$emit('update:showAllStore', false)
      }
    }
  }
</script>

<style scoped>

</style>
