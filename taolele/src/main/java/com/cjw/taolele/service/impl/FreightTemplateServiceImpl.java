package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.FreightTemplateMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.FreightTemplate;
import com.cjw.taolele.service.FreightTemplateService;
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
public class FreightTemplateServiceImpl extends AbstractService<FreightTemplate> implements FreightTemplateService {
    @Resource
    private FreightTemplateMapper freightTemplateMapper;

    @Override
    public PageResult findPage(FreightTemplate freightTemplate, int pageNum, int pageSize) {
        PageResult<FreightTemplate> result = new PageResult<FreightTemplate>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(FreightTemplate.class);
        Example.Criteria criteria = example.createCriteria();

        if(freightTemplate!=null){
            //如果字段不为空
                if (freightTemplate.getSellerId()!=null && freightTemplate.getSellerId().length()>0) {
                    criteria.andLike("seller_id", "%" + freightTemplate.getSellerId() + "%");
                }
                if (freightTemplate.getIsDefault()!=null && freightTemplate.getIsDefault().length()>0) {
                    criteria.andLike("is_default", "%" + freightTemplate.getIsDefault() + "%");
                }
                if (freightTemplate.getName()!=null && freightTemplate.getName().length()>0) {
                    criteria.andLike("name", "%" + freightTemplate.getName() + "%");
                }
                if (freightTemplate.getSendTimeType()!=null && freightTemplate.getSendTimeType().length()>0) {
                    criteria.andLike("send_time_type", "%" + freightTemplate.getSendTimeType() + "%");
                }
        }

        //查询数据
        List<FreightTemplate> list = freightTemplateMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<FreightTemplate> info = new PageInfo<FreightTemplate>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
