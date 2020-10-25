import request from '@/utils/request'

// 获取首页菜单列表
export function leftMenu (){
    return request({
        url:'http://127.0.0.1/api/v1/p/categories',
        method:'get'
    })
}

// 搜索
export function search(data){
    console.log(data);
    return request({
        url:'http://127.0.0.1/api/v1/p/goods/search',
        method:'post',
        data
    })
}

// 搜索联想词
export function searchList(keyword){
    if(!keyword){
      return;
    }
    return request({
        url:`http://127.0.0.1/api/v1/p/goods/search?keyword=${keyword}`,
        method:'get'
    });
}

// 详情页数据
export function getItem (){
    return request({
        url:'http://127.0.0.1/api/v1/item/page/getDynamicPage',
        method:'get',
    })
}
