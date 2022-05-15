import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/medicinalSellRecord/list',
    method: 'post',
    data: params,
  })
}

export function create(params) {
  return request({
    url: '/medicinalSellRecord/create',
    method: 'post',
    data: params,
  })
}

export function pageSellSummary(params) {
  return request({
    url: '/medicinalSellRecord/summary/list',
    method: 'post',
    data: params,
  })
}
