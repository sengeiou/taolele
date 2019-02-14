package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.BrandMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Brand;
import com.cjw.taolele.service.BrandService;
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
public class BrandServiceImpl extends AbstractService<Brand> implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    @Override
    public PageResult findPage(Brand brand, int pageNum, int pageSize) {
        PageResult<Brand> result = new PageResult<Brand>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand!=null){
            //如果字段不为空
                if (brand.getName()!=null && brand.getName().length()>0) {
                    criteria.andLike("name", "%" + brand.getName() + "%");
                }
                if (brand.getFirstChar()!=null && brand.getFirstChar().length()>0) {
                    criteria.andLike("first_char", "%" + brand.getFirstChar() + "%");
                }
        }

        //查询数据
        List<Brand> list = brandMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Brand> info = new PageInfo<Brand>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
