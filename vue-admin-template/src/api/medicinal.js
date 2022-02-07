import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/medicinal/list',
    method: 'post',
    data: params,
  })
}

export function create(params) {
  return request({
    url: '/medicinal/create',
    method: 'post',
    data: params,
  })
}

export function update(params) {
  return request({
    url: '/medicinal/update',
    method: 'post',
    data: params,
  })
}

export function deleteMedi(params) {
  return request({
    url: '/medicinal/delete',
    method: 'get',
    params
  })
}

export function getReserveRecordList(params) {
  return request({
    url: '/medicinal/reserveRecord/list',
    method: 'post',
    data: params
  })
}

export function pageMedicinalReserveStas(params) {
  return request({
    url: '/medicinal/reserveRecordStats/list',
    method: 'post',
    data: params
  })
}