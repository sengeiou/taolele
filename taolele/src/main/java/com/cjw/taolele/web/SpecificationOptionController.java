package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.SpecificationOption;
import com.cjw.taolele.service.SpecificationOptionService;
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
@RequestMapping("/specificationOption")
public class SpecificationOptionController {
    @Resource
    private SpecificationOptionService specificationOptionService;

    @RequestMapping("/save")
    public Result save(@RequestBody SpecificationOption specificationOption) {
        specificationOptionService.save(specificationOption);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody SpecificationOption specificationOption) {
        specificationOptionService.save(specificationOption);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        specificationOptionService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        specificationOptionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody SpecificationOption specificationOption) {
        specificationOptionService.update(specificationOption);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        SpecificationOption specificationOption = specificationOptionService.findById(id);
        return ResultGenerator.genSuccessResult(specificationOption);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<SpecificationOption> specificationOptions = specificationOptionService.findByIds(ids);
        return ResultGenerator.genSuccessResult(specificationOptions);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<SpecificationOption> specificationOptions = specificationOptionService.findAll();
        return ResultGenerator.genSuccessResult(specificationOptions);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = specificationOptionService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
