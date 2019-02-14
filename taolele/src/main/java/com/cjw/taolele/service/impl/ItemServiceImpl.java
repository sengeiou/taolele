package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.ItemMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Item;
import com.cjw.taolele.service.ItemService;
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
public class ItemServiceImpl extends AbstractService<Item> implements ItemService {
    @Resource
    private ItemMapper itemMapper;

    @Override
    public PageResult findPage(Item item, int pageNum, int pageSize) {
        PageResult<Item> result = new PageResult<Item>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Item.class);
        Example.Criteria criteria = example.createCriteria();

        if(item!=null){
            //如果字段不为空
                if (item.getTitle()!=null && item.getTitle().length()>0) {
                    criteria.andLike("title", "%" + item.getTitle() + "%");
                }
                if (item.getSellPoint()!=null && item.getSellPoint().length()>0) {
                    criteria.andLike("sell_point", "%" + item.getSellPoint() + "%");
                }
                if (item.getBarcode()!=null && item.getBarcode().length()>0) {
                    criteria.andLike("barcode", "%" + item.getBarcode() + "%");
                }
                if (item.getImage()!=null && item.getImage().length()>0) {
                    criteria.andLike("image", "%" + item.getImage() + "%");
                }
                if (item.getStatus()!=null && item.getStatus().length()>0) {
                    criteria.andLike("status", "%" + item.getStatus() + "%");
                }
                if (item.getItemSn()!=null && item.getItemSn().length()>0) {
                    criteria.andLike("item_sn", "%" + item.getItemSn() + "%");
                }
                if (item.getIsDefault()!=null && item.getIsDefault().length()>0) {
                    criteria.andLike("is_default", "%" + item.getIsDefault() + "%");
                }
                if (item.getSellerId()!=null && item.getSellerId().length()>0) {
                    criteria.andLike("seller_id", "%" + item.getSellerId() + "%");
                }
                if (item.getCartThumbnail()!=null && item.getCartThumbnail().length()>0) {
                    criteria.andLike("cart_thumbnail", "%" + item.getCartThumbnail() + "%");
                }
                if (item.getCategory()!=null && item.getCategory().length()>0) {
                    criteria.andLike("category", "%" + item.getCategory() + "%");
                }
                if (item.getBrand()!=null && item.getBrand().length()>0) {
                    criteria.andLike("brand", "%" + item.getBrand() + "%");
                }
                if (item.getSpec()!=null && item.getSpec().length()>0) {
                    criteria.andLike("spec", "%" + item.getSpec() + "%");
                }
                if (item.getSeller()!=null && item.getSeller().length()>0) {
                    criteria.andLike("seller", "%" + item.getSeller() + "%");
                }
        }

        //查询数据
        List<Item> list = itemMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Item> info = new PageInfo<Item>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
