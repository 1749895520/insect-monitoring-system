import request from "@/utils/request";

export const serverIp = 'localhost'

// 查询防治措施
export function methodList() {
  return request({
    url: 'method/page',
    method: 'get',
  })
}

export function methodUpdate(method) {
  return request({
    url: 'method/update',
    method: 'post',
    data: method
  })
}

export function methodInsert(method) {
  return request({
    url: 'method/insert',
    method: 'post',
    data: method
  })
}

export function methodDelete(id) {
  return request({
    url: 'method/delete/' + id,
    method: 'post'
  })
}

export function methodDeletes(ids) {
  return request({
    url: 'method/delete/batch',
    method: 'post',
    data: ids
  })
}

export function imgUpload(ids) {
  return request({
    url: 'method/delete/batch',
    method: 'post',
    data: ids
  })
}

export function imgList() {
  return request({
    url: 'file/page',
    method: 'get',
  })
}

export function run() {
  return request({
    url: 'file/run',
    method: 'get',
  })
}
