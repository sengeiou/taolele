package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.OrderItem;
import com.cjw.taolele.service.OrderItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Jing wen on 2019/02/14.
*/
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Resource
    private OrderItemService orderItemService;

    @RequestMapping("/save")
    public Result save(@RequestBody OrderItem orderItem) {
        orderItemService.save(orderItem);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody OrderItem orderItem) {
        orderItemService.save(orderItem);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        orderItemService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        orderItemService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody OrderItem orderItem) {
        orderItemService.update(orderItem);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        OrderItem orderItem = orderItemService.findById(id);
        return ResultGenerator.genSuccessResult(orderItem);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<OrderItem> orderItems = orderItemService.findByIds(ids);
        return ResultGenerator.genSuccessResult(orderItems);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<OrderItem> orderItems = orderItemService.findAll();
        return ResultGenerator.genSuccessResult(orderItems);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = orderItemService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
