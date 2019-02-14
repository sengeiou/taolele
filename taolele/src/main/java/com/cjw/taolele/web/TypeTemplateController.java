package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.TypeTemplate;
import com.cjw.taolele.service.TypeTemplateService;
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
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Resource
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/save")
    public Result save(@RequestBody TypeTemplate typeTemplate) {
        typeTemplateService.save(typeTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody TypeTemplate typeTemplate) {
        typeTemplateService.save(typeTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        typeTemplateService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        typeTemplateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TypeTemplate typeTemplate) {
        typeTemplateService.update(typeTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        TypeTemplate typeTemplate = typeTemplateService.findById(id);
        return ResultGenerator.genSuccessResult(typeTemplate);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<TypeTemplate> typeTemplates = typeTemplateService.findByIds(ids);
        return ResultGenerator.genSuccessResult(typeTemplates);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<TypeTemplate> typeTemplates = typeTemplateService.findAll();
        return ResultGenerator.genSuccessResult(typeTemplates);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = typeTemplateService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
