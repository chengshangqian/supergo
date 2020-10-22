import request from '@/utils/request'

export function getList(params) {
  return request({
    url: 'manager/item/getAll?pageNum='+params.page,
    method: 'post',
    data:{
      // 必传
      // status:params.status,
      // title:params.name,
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
    url:'manager/item/delete',
    method:'post',
    data:arr,
  })
}


export function goUp(arr){
  return request({
    url:'manager/item/updateStatus/1',
    method:'post',
    data:arr,
  })
}

export function goDown(arr){
  return request({
    url:'manager/item/updateStatus/2',
    method:'post',
    data:arr,
  })
}