package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.CitiesMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Cities;
import com.cjw.taolele.service.CitiesService;
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
public class CitiesServiceImpl extends AbstractService<Cities> implements CitiesService {
    @Resource
    private CitiesMapper citiesMapper;

    @Override
    public PageResult findPage(Cities cities, int pageNum, int pageSize) {
        PageResult<Cities> result = new PageResult<Cities>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Cities.class);
        Example.Criteria criteria = example.createCriteria();

        if(cities!=null){
            //如果字段不为空
                if (cities.getCityid()!=null && cities.getCityid().length()>0) {
                    criteria.andLike("cityid", "%" + cities.getCityid() + "%");
                }
                if (cities.getCity()!=null && cities.getCity().length()>0) {
                    criteria.andLike("city", "%" + cities.getCity() + "%");
                }
                if (cities.getProvinceid()!=null && cities.getProvinceid().length()>0) {
                    criteria.andLike("provinceid", "%" + cities.getProvinceid() + "%");
                }
        }

        //查询数据
        List<Cities> list = citiesMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Cities> info = new PageInfo<Cities>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
