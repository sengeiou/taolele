package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.AddressMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Address;
import com.cjw.taolele.service.AddressService;
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
public class AddressServiceImpl extends AbstractService<Address> implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public PageResult findPage(Address address, int pageNum, int pageSize) {
        PageResult<Address> result = new PageResult<Address>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();

        if(address!=null){
            //如果字段不为空
                if (address.getUserId()!=null && address.getUserId().length()>0) {
                    criteria.andLike("user_id", "%" + address.getUserId() + "%");
                }
                if (address.getProvinceId()!=null && address.getProvinceId().length()>0) {
                    criteria.andLike("province_id", "%" + address.getProvinceId() + "%");
                }
                if (address.getCityId()!=null && address.getCityId().length()>0) {
                    criteria.andLike("city_id", "%" + address.getCityId() + "%");
                }
                if (address.getTownId()!=null && address.getTownId().length()>0) {
                    criteria.andLike("town_id", "%" + address.getTownId() + "%");
                }
                if (address.getMobile()!=null && address.getMobile().length()>0) {
                    criteria.andLike("mobile", "%" + address.getMobile() + "%");
                }
                if (address.getAddress()!=null && address.getAddress().length()>0) {
                    criteria.andLike("address", "%" + address.getAddress() + "%");
                }
                if (address.getContact()!=null && address.getContact().length()>0) {
                    criteria.andLike("contact", "%" + address.getContact() + "%");
                }
                if (address.getIsDefault()!=null && address.getIsDefault().length()>0) {
                    criteria.andLike("is_default", "%" + address.getIsDefault() + "%");
                }
                if (address.getNotes()!=null && address.getNotes().length()>0) {
                    criteria.andLike("notes", "%" + address.getNotes() + "%");
                }
                if (address.getAlias()!=null && address.getAlias().length()>0) {
                    criteria.andLike("alias", "%" + address.getAlias() + "%");
                }
        }

        //查询数据
        List<Address> list = addressMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Address> info = new PageInfo<Address>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
