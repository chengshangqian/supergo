import {createAPI, createFormAPI} from '@/utils/request'

export const list = data => createAPI('http://localhost:9999/api/manager/brand/findAll', 'get', data)

export const findBrandByPage = data => createAPI('http://localhost:9999/api/manager/brand/findPage', 'post', data)