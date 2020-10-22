import request from '@/utils/request'

export function getList(params) {
  return request({
    url: 'manager/order/getAll/?pageNum='+params.page,
    method: 'post',
    data:{
      // 必传
      auditStatus:params.status,
      goodsName:params.name
    }
  })
}