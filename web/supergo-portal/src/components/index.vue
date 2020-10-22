<template>
    <div>
		<Header />
		 <homePage />
		<Footer />
    </div>
</template>

<script>
import Header from './public/header'
import homePage from './homePage/homePage'
import Footer from './public/footer'

export default {
    name:"index",
    data () {
        return {
           
        }
    },
    components: {
    Header,
    homePage,
	Footer
    },
    mounted(){

    }
}
</script>

<style scoped>
.top,
.sort,
.show,
.like,
.fun,
.floor,
.brand,
.footer {
	height: auto
}
  .top{
      background-color: #EAEAEA;
	  line-height: 30px
  }

   
</style>


