package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.TypeTemplateMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.TypeTemplate;
import com.cjw.taolele.service.TypeTemplateService;
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
public class TypeTemplateServiceImpl extends AbstractService<TypeTemplate> implements TypeTemplateService {
    @Resource
    private TypeTemplateMapper typeTemplateMapper;

    @Override
    public PageResult findPage(TypeTemplate typeTemplate, int pageNum, int pageSize) {
        PageResult<TypeTemplate> result = new PageResult<TypeTemplate>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(TypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        if(typeTemplate!=null){
            //如果字段不为空
                if (typeTemplate.getName()!=null && typeTemplate.getName().length()>0) {
                    criteria.andLike("name", "%" + typeTemplate.getName() + "%");
                }
                if (typeTemplate.getSpecIds()!=null && typeTemplate.getSpecIds().length()>0) {
                    criteria.andLike("spec_ids", "%" + typeTemplate.getSpecIds() + "%");
                }
                if (typeTemplate.getBrandIds()!=null && typeTemplate.getBrandIds().length()>0) {
                    criteria.andLike("brand_ids", "%" + typeTemplate.getBrandIds() + "%");
                }
                if (typeTemplate.getCustomAttributeItems()!=null && typeTemplate.getCustomAttributeItems().length()>0) {
                    criteria.andLike("custom_attribute_items", "%" + typeTemplate.getCustomAttributeItems() + "%");
                }
        }

        //查询数据
        List<TypeTemplate> list = typeTemplateMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<TypeTemplate> info = new PageInfo<TypeTemplate>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
