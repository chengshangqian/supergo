import request from '@/utils/request'

export function getList(params) {
  return request({
    url: 'manager/goods/query/'+params.page+'/10',
    method: 'post',
    data:{
      // 必传
      auditStatus:params.status,
      goodsName:params.name
    }
  })
}


export function getcategoryName() {
  return request({
    url: 'shop/itemCat/all',
    method: 'get',
  })
}


export function sendDelete(arr){
  return request({
    url:'shop/goods/delete',
    method:'post',
    data:arr,
  })
}


export function sendStatus(arr){
  return request({
    url:'shop/goods/updateStatus?status=2',
    method:'post',
    data:arr,
  })
}


export function chooseTemplate(id){
  return request({
    url:'shop/goods/querySpecificationOption/'+id,
    method:'get',
  });
} 


export function savePost(data){
  return request({
    url:'manager/item/add',
    method:'post',
    data:{
      goodsId:data.goodsId
    }
  })
}
