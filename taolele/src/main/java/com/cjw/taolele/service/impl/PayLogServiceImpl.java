package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.PayLogMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.PayLog;
import com.cjw.taolele.service.PayLogService;
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
public class PayLogServiceImpl extends AbstractService<PayLog> implements PayLogService {
    @Resource
    private PayLogMapper payLogMapper;

    @Override
    public PageResult findPage(PayLog payLog, int pageNum, int pageSize) {
        PageResult<PayLog> result = new PageResult<PayLog>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(PayLog.class);
        Example.Criteria criteria = example.createCriteria();

        if(payLog!=null){
            //如果字段不为空
                if (payLog.getOutTradeNo()!=null && payLog.getOutTradeNo().length()>0) {
                    criteria.andLike("out_trade_no", "%" + payLog.getOutTradeNo() + "%");
                }
                if (payLog.getUserId()!=null && payLog.getUserId().length()>0) {
                    criteria.andLike("user_id", "%" + payLog.getUserId() + "%");
                }
                if (payLog.getTransactionId()!=null && payLog.getTransactionId().length()>0) {
                    criteria.andLike("transaction_id", "%" + payLog.getTransactionId() + "%");
                }
                if (payLog.getTradeState()!=null && payLog.getTradeState().length()>0) {
                    criteria.andLike("trade_state", "%" + payLog.getTradeState() + "%");
                }
                if (payLog.getOrderList()!=null && payLog.getOrderList().length()>0) {
                    criteria.andLike("order_list", "%" + payLog.getOrderList() + "%");
                }
                if (payLog.getPayType()!=null && payLog.getPayType().length()>0) {
                    criteria.andLike("pay_type", "%" + payLog.getPayType() + "%");
                }
        }

        //查询数据
        List<PayLog> list = payLogMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<PayLog> info = new PageInfo<PayLog>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
