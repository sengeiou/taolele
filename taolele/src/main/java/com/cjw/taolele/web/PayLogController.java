package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.PayLog;
import com.cjw.taolele.service.PayLogService;
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
@RequestMapping("/payLog")
public class PayLogController {
    @Resource
    private PayLogService payLogService;

    @RequestMapping("/save")
    public Result save(@RequestBody PayLog payLog) {
        payLogService.save(payLog);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody PayLog payLog) {
        payLogService.save(payLog);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        payLogService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        payLogService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody PayLog payLog) {
        payLogService.update(payLog);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        PayLog payLog = payLogService.findById(id);
        return ResultGenerator.genSuccessResult(payLog);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<PayLog> payLogs = payLogService.findByIds(ids);
        return ResultGenerator.genSuccessResult(payLogs);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<PayLog> payLogs = payLogService.findAll();
        return ResultGenerator.genSuccessResult(payLogs);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = payLogService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
