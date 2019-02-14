package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.ContentCategoryMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.ContentCategory;
import com.cjw.taolele.service.ContentCategoryService;
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
public class ContentCategoryServiceImpl extends AbstractService<ContentCategory> implements ContentCategoryService {
    @Resource
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public PageResult findPage(ContentCategory contentCategory, int pageNum, int pageSize) {
        PageResult<ContentCategory> result = new PageResult<ContentCategory>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(ContentCategory.class);
        Example.Criteria criteria = example.createCriteria();

        if(contentCategory!=null){
            //如果字段不为空
                if (contentCategory.getName()!=null && contentCategory.getName().length()>0) {
                    criteria.andLike("name", "%" + contentCategory.getName() + "%");
                }
        }

        //查询数据
        List<ContentCategory> list = contentCategoryMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<ContentCategory> info = new PageInfo<ContentCategory>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
