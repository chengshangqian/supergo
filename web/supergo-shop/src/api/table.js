import request from '@/utils/request'

export function getList(params) {
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
    params,
    // data:{
    //   status:0,
    //   goodsName:'张'
    // }
    // data:{
    //   goodsName:
    // }
  })
}
