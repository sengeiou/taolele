package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.OrderMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Order;
import com.cjw.taolele.service.OrderService;
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
public class OrderServiceImpl extends AbstractService<Order> implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public PageResult findPage(Order order, int pageNum, int pageSize) {
        PageResult<Order> result = new PageResult<Order>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();

        if(order!=null){
            //如果字段不为空
                if (order.getPaymentType()!=null && order.getPaymentType().length()>0) {
                    criteria.andLike("payment_type", "%" + order.getPaymentType() + "%");
                }
                if (order.getPostFee()!=null && order.getPostFee().length()>0) {
                    criteria.andLike("post_fee", "%" + order.getPostFee() + "%");
                }
                if (order.getStatus()!=null && order.getStatus().length()>0) {
                    criteria.andLike("status", "%" + order.getStatus() + "%");
                }
                if (order.getShippingName()!=null && order.getShippingName().length()>0) {
                    criteria.andLike("shipping_name", "%" + order.getShippingName() + "%");
                }
                if (order.getShippingCode()!=null && order.getShippingCode().length()>0) {
                    criteria.andLike("shipping_code", "%" + order.getShippingCode() + "%");
                }
                if (order.getUserId()!=null && order.getUserId().length()>0) {
                    criteria.andLike("user_id", "%" + order.getUserId() + "%");
                }
                if (order.getBuyerMessage()!=null && order.getBuyerMessage().length()>0) {
                    criteria.andLike("buyer_message", "%" + order.getBuyerMessage() + "%");
                }
                if (order.getBuyerNick()!=null && order.getBuyerNick().length()>0) {
                    criteria.andLike("buyer_nick", "%" + order.getBuyerNick() + "%");
                }
                if (order.getBuyerRate()!=null && order.getBuyerRate().length()>0) {
                    criteria.andLike("buyer_rate", "%" + order.getBuyerRate() + "%");
                }
                if (order.getReceiverAreaName()!=null && order.getReceiverAreaName().length()>0) {
                    criteria.andLike("receiver_area_name", "%" + order.getReceiverAreaName() + "%");
                }
                if (order.getReceiverMobile()!=null && order.getReceiverMobile().length()>0) {
                    criteria.andLike("receiver_mobile", "%" + order.getReceiverMobile() + "%");
                }
                if (order.getReceiverZipCode()!=null && order.getReceiverZipCode().length()>0) {
                    criteria.andLike("receiver_zip_code", "%" + order.getReceiverZipCode() + "%");
                }
                if (order.getReceiver()!=null && order.getReceiver().length()>0) {
                    criteria.andLike("receiver", "%" + order.getReceiver() + "%");
                }
                if (order.getInvoiceType()!=null && order.getInvoiceType().length()>0) {
                    criteria.andLike("invoice_type", "%" + order.getInvoiceType() + "%");
                }
                if (order.getSourceType()!=null && order.getSourceType().length()>0) {
                    criteria.andLike("source_type", "%" + order.getSourceType() + "%");
                }
                if (order.getSellerId()!=null && order.getSellerId().length()>0) {
                    criteria.andLike("seller_id", "%" + order.getSellerId() + "%");
                }
        }

        //查询数据
        List<Order> list = orderMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Order> info = new PageInfo<Order>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
