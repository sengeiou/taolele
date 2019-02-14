package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.AreasMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Areas;
import com.cjw.taolele.service.AreasService;
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
public class AreasServiceImpl extends AbstractService<Areas> implements AreasService {
    @Resource
    private AreasMapper areasMapper;

    @Override
    public PageResult findPage(Areas areas, int pageNum, int pageSize) {
        PageResult<Areas> result = new PageResult<Areas>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Areas.class);
        Example.Criteria criteria = example.createCriteria();

        if(areas!=null){
            //如果字段不为空
                if (areas.getAreaid()!=null && areas.getAreaid().length()>0) {
                    criteria.andLike("areaid", "%" + areas.getAreaid() + "%");
                }
                if (areas.getArea()!=null && areas.getArea().length()>0) {
                    criteria.andLike("area", "%" + areas.getArea() + "%");
                }
                if (areas.getCityid()!=null && areas.getCityid().length()>0) {
                    criteria.andLike("cityid", "%" + areas.getCityid() + "%");
                }
        }

        //查询数据
        List<Areas> list = areasMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Areas> info = new PageInfo<Areas>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
