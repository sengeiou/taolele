package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Specification;
import com.cjw.taolele.service.SpecificationService;
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
@RequestMapping("/specification")
public class SpecificationController {
    @Resource
    private SpecificationService specificationService;

    @RequestMapping("/save")
    public Result save(@RequestBody Specification specification) {
        specificationService.save(specification);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody Specification specification) {
        specificationService.save(specification);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        specificationService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        specificationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification) {
        specificationService.update(specification);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        Specification specification = specificationService.findById(id);
        return ResultGenerator.genSuccessResult(specification);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<Specification> specifications = specificationService.findByIds(ids);
        return ResultGenerator.genSuccessResult(specifications);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<Specification> specifications = specificationService.findAll();
        return ResultGenerator.genSuccessResult(specifications);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = specificationService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
