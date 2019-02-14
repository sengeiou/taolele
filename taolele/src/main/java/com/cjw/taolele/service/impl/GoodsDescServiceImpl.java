package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.GoodsDescMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.GoodsDesc;
import com.cjw.taolele.service.GoodsDescService;
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
public class GoodsDescServiceImpl extends AbstractService<GoodsDesc> implements GoodsDescService {
    @Resource
    private GoodsDescMapper goodsDescMapper;

    @Override
    public PageResult findPage(GoodsDesc goodsDesc, int pageNum, int pageSize) {
        PageResult<GoodsDesc> result = new PageResult<GoodsDesc>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(GoodsDesc.class);
        Example.Criteria criteria = example.createCriteria();

        if(goodsDesc!=null){
            //如果字段不为空
                if (goodsDesc.getIntroduction()!=null && goodsDesc.getIntroduction().length()>0) {
                    criteria.andLike("introduction", "%" + goodsDesc.getIntroduction() + "%");
                }
                if (goodsDesc.getSpecificationItems()!=null && goodsDesc.getSpecificationItems().length()>0) {
                    criteria.andLike("specification_items", "%" + goodsDesc.getSpecificationItems() + "%");
                }
                if (goodsDesc.getCustomAttributeItems()!=null && goodsDesc.getCustomAttributeItems().length()>0) {
                    criteria.andLike("custom_attribute_items", "%" + goodsDesc.getCustomAttributeItems() + "%");
                }
                if (goodsDesc.getItemImages()!=null && goodsDesc.getItemImages().length()>0) {
                    criteria.andLike("item_images", "%" + goodsDesc.getItemImages() + "%");
                }
                if (goodsDesc.getPackageList()!=null && goodsDesc.getPackageList().length()>0) {
                    criteria.andLike("package_list", "%" + goodsDesc.getPackageList() + "%");
                }
                if (goodsDesc.getSaleService()!=null && goodsDesc.getSaleService().length()>0) {
                    criteria.andLike("sale_service", "%" + goodsDesc.getSaleService() + "%");
                }
        }

        //查询数据
        List<GoodsDesc> list = goodsDescMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<GoodsDesc> info = new PageInfo<GoodsDesc>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
