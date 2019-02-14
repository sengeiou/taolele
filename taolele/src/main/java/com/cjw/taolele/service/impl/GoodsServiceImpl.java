package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.GoodsMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Goods;
import com.cjw.taolele.service.GoodsService;
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
public class GoodsServiceImpl extends AbstractService<Goods> implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public PageResult findPage(Goods goods, int pageNum, int pageSize) {
        PageResult<Goods> result = new PageResult<Goods>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();

        if(goods!=null){
            //如果字段不为空
                if (goods.getSellerId()!=null && goods.getSellerId().length()>0) {
                    criteria.andLike("seller_id", "%" + goods.getSellerId() + "%");
                }
                if (goods.getGoodsName()!=null && goods.getGoodsName().length()>0) {
                    criteria.andLike("goods_name", "%" + goods.getGoodsName() + "%");
                }
                if (goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0) {
                    criteria.andLike("audit_status", "%" + goods.getAuditStatus() + "%");
                }
                if (goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0) {
                    criteria.andLike("is_marketable", "%" + goods.getIsMarketable() + "%");
                }
                if (goods.getCaption()!=null && goods.getCaption().length()>0) {
                    criteria.andLike("caption", "%" + goods.getCaption() + "%");
                }
                if (goods.getSmallPic()!=null && goods.getSmallPic().length()>0) {
                    criteria.andLike("small_pic", "%" + goods.getSmallPic() + "%");
                }
                if (goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0) {
                    criteria.andLike("is_enable_spec", "%" + goods.getIsEnableSpec() + "%");
                }
                if (goods.getIsDelete()!=null && goods.getIsDelete().length()>0) {
                    criteria.andLike("is_delete", "%" + goods.getIsDelete() + "%");
                }
        }

        //查询数据
        List<Goods> list = goodsMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Goods> info = new PageInfo<Goods>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
