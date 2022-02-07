import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/medicinalBuyRecord/list',
    method: 'post',
    data: params,
  })
}

export function create(params) {
  return request({
    url: '/medicinalBuyRecord/create',
    method: 'post',
    data: params,
  })
}
