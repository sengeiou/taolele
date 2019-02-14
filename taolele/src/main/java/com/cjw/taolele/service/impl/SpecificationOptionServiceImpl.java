package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.SpecificationOptionMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.SpecificationOption;
import com.cjw.taolele.service.SpecificationOptionService;
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
public class SpecificationOptionServiceImpl extends AbstractService<SpecificationOption> implements SpecificationOptionService {
    @Resource
    private SpecificationOptionMapper specificationOptionMapper;

    @Override
    public PageResult findPage(SpecificationOption specificationOption, int pageNum, int pageSize) {
        PageResult<SpecificationOption> result = new PageResult<SpecificationOption>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(SpecificationOption.class);
        Example.Criteria criteria = example.createCriteria();

        if(specificationOption!=null){
            //如果字段不为空
                if (specificationOption.getOptionName()!=null && specificationOption.getOptionName().length()>0) {
                    criteria.andLike("option_name", "%" + specificationOption.getOptionName() + "%");
                }
        }

        //查询数据
        List<SpecificationOption> list = specificationOptionMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<SpecificationOption> info = new PageInfo<SpecificationOption>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
