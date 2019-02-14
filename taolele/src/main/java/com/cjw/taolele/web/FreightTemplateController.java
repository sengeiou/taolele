package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.FreightTemplate;
import com.cjw.taolele.service.FreightTemplateService;
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
@RequestMapping("/freightTemplate")
public class FreightTemplateController {
    @Resource
    private FreightTemplateService freightTemplateService;

    @RequestMapping("/save")
    public Result save(@RequestBody FreightTemplate freightTemplate) {
        freightTemplateService.save(freightTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody FreightTemplate freightTemplate) {
        freightTemplateService.save(freightTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        freightTemplateService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        freightTemplateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody FreightTemplate freightTemplate) {
        freightTemplateService.update(freightTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        FreightTemplate freightTemplate = freightTemplateService.findById(id);
        return ResultGenerator.genSuccessResult(freightTemplate);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<FreightTemplate> freightTemplates = freightTemplateService.findByIds(ids);
        return ResultGenerator.genSuccessResult(freightTemplates);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<FreightTemplate> freightTemplates = freightTemplateService.findAll();
        return ResultGenerator.genSuccessResult(freightTemplates);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = freightTemplateService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
