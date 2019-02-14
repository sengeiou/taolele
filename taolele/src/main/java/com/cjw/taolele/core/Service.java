package com.cjw.taolele.core;


import com.cjw.taolele.entity.PageResult;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    void save(T model);//持久化
    void saveList(List<T> models);//批量持久化
    void deleteById(Long id);//通过主鍵刪除
    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”
    void update(T model);//更新
    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”
    T findById(Long id);        //主键查询
    PageResult findPage(int pageNum, int pageSize);
    List<T> findAll();          //获取所有
    PageResult findPage(T brand, int pageNum, int pageSize);
}
