package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.SpecificationMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Specification;
import com.cjw.taolele.service.SpecificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jing wen on 2019/02/14.
 */
@Service
@Transactional
public class SpecificationServiceImpl extends AbstractService<Specification> implements SpecificationService {
    @Resource
    private SpecificationMapper specificationMapper;

    @Override
    public PageResult findPage(Specification specification, int pageNum, int pageSize) {
        PageResult<Specification> result = new PageResult<Specification>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Specification.class);
        Example.Criteria criteria = example.createCriteria();

        if(specification!=null){
            //如果字段不为空
                if (specification.getSpecName()!=null && specification.getSpecName().length()>0) {
                    criteria.andLike("spec_name", "%" + specification.getSpecName() + "%");
                }
        }

        //查询数据
        List<Specification> list = specificationMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Specification> info = new PageInfo<Specification>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
