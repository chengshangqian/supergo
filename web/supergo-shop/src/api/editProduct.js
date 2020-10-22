import request from '@/utils/request'

export function getList(id) {
  return request({
    url: 'shop/goods/getById/'+id,
    method: 'get',
  })
}

export function getList2(params) {
  return request({
    url: 'shop/itemCat/parent/'+params,
    method: 'get',
    params
  })
}


export function getProName(params) {
  return request({
    url: 'manager/brand/findAll',
    method: 'get',
    params
  })
}


export function saveEdit(params){
  return request({
    url:'shop/goods/update',
    method:'post',
    data:params
  })
}
