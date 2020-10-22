import Vue from  'vue'
import Vuex from 'vuex'
import { search } from '@/api';

Vue.use(Vuex)

// 创建一个store仓库
export default new Vuex.Store({
    state: {
        num: 0,
        valueList:[]
    },
    getters:{
        getShopNum(state){
            return state.num;
        }
    },
    mutations:{
        addShopNum(state,num){
            state.num+=num;
        },
        changeShopNum(state,num){
           state.num=num;
        },
        SET_GOODS(state,valueList){
            state.valueList = valueList
        } 

    },
    actions:{
        addShopNumByAction({commit},num){
            commit('addShopNum',num)
        },
        changeShopNumByAction({commit},num){
            commit('changeShopNum',num)
        },
        asyncSeachGoods({commit},keywords){
            return search({keywords}).then(({status,data:{data:{valueList}}}) => {
                if(status === 200) {
                    commit("SET_GOODS", valueList);
                }
            }) 
        }
    }
    
});