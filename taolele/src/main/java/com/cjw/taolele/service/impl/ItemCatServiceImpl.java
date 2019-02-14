package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.ItemCatMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.ItemCat;
import com.cjw.taolele.service.ItemCatService;
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
public class ItemCatServiceImpl extends AbstractService<ItemCat> implements ItemCatService {
    @Resource
    private ItemCatMapper itemCatMapper;

    @Override
    public PageResult findPage(ItemCat itemCat, int pageNum, int pageSize) {
        PageResult<ItemCat> result = new PageResult<ItemCat>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(ItemCat.class);
        Example.Criteria criteria = example.createCriteria();

        if(itemCat!=null){
            //如果字段不为空
                if (itemCat.getName()!=null && itemCat.getName().length()>0) {
                    criteria.andLike("name", "%" + itemCat.getName() + "%");
                }
        }

        //查询数据
        List<ItemCat> list = itemCatMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<ItemCat> info = new PageInfo<ItemCat>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
