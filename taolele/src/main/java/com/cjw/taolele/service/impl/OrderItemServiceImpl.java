package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.OrderItemMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.OrderItem;
import com.cjw.taolele.service.OrderItemService;
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
public class OrderItemServiceImpl extends AbstractService<OrderItem> implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public PageResult findPage(OrderItem orderItem, int pageNum, int pageSize) {
        PageResult<OrderItem> result = new PageResult<OrderItem>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();

        if(orderItem!=null){
            //如果字段不为空
                if (orderItem.getTitle()!=null && orderItem.getTitle().length()>0) {
                    criteria.andLike("title", "%" + orderItem.getTitle() + "%");
                }
                if (orderItem.getPicPath()!=null && orderItem.getPicPath().length()>0) {
                    criteria.andLike("pic_path", "%" + orderItem.getPicPath() + "%");
                }
                if (orderItem.getSellerId()!=null && orderItem.getSellerId().length()>0) {
                    criteria.andLike("seller_id", "%" + orderItem.getSellerId() + "%");
                }
        }

        //查询数据
        List<OrderItem> list = orderItemMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<OrderItem> info = new PageInfo<OrderItem>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
