import request from "@/utils/request";

export function detectList() {
  return request({
    url: 'detect/page',
    method: 'get',
  })
}
