package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.ProvincesMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Provinces;
import com.cjw.taolele.service.ProvincesService;
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
public class ProvincesServiceImpl extends AbstractService<Provinces> implements ProvincesService {
    @Resource
    private ProvincesMapper provincesMapper;

    @Override
    public PageResult findPage(Provinces provinces, int pageNum, int pageSize) {
        PageResult<Provinces> result = new PageResult<Provinces>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Provinces.class);
        Example.Criteria criteria = example.createCriteria();

        if(provinces!=null){
            //如果字段不为空
                if (provinces.getProvinceid()!=null && provinces.getProvinceid().length()>0) {
                    criteria.andLike("provinceid", "%" + provinces.getProvinceid() + "%");
                }
                if (provinces.getProvince()!=null && provinces.getProvince().length()>0) {
                    criteria.andLike("province", "%" + provinces.getProvince() + "%");
                }
        }

        //查询数据
        List<Provinces> list = provincesMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Provinces> info = new PageInfo<Provinces>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
