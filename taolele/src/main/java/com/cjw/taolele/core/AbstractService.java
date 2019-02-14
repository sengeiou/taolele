package com.cjw.taolele.core;


import com.cjw.taolele.entity.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model) {
        mapper.insertSelective(model);
    }

    public void saveList(List<T> models) {
        mapper.insertList(models);
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public void deleteById(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageResult<T> result = new PageResult<T>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //查询数据
        List<T> list = mapper.select(null);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<T> info = new PageInfo<T>(list);
        result.setTotal(info.getTotal());
        return result;
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }
}
