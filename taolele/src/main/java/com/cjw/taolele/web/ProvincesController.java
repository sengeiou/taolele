package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Provinces;
import com.cjw.taolele.service.ProvincesService;
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
@RequestMapping("/provinces")
public class ProvincesController {
    @Resource
    private ProvincesService provincesService;

    @RequestMapping("/save")
    public Result save(@RequestBody Provinces provinces) {
        provincesService.save(provinces);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody Provinces provinces) {
        provincesService.save(provinces);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        provincesService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        provincesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Provinces provinces) {
        provincesService.update(provinces);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        Provinces provinces = provincesService.findById(id);
        return ResultGenerator.genSuccessResult(provinces);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<Provinces> provincess = provincesService.findByIds(ids);
        return ResultGenerator.genSuccessResult(provincess);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<Provinces> provincess = provincesService.findAll();
        return ResultGenerator.genSuccessResult(provincess);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = provincesService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
