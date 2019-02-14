package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Areas;
import com.cjw.taolele.service.AreasService;
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
@RequestMapping("/areas")
public class AreasController {
    @Resource
    private AreasService areasService;

    @RequestMapping("/save")
    public Result save(@RequestBody Areas areas) {
        areasService.save(areas);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody Areas areas) {
        areasService.save(areas);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        areasService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        areasService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Areas areas) {
        areasService.update(areas);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        Areas areas = areasService.findById(id);
        return ResultGenerator.genSuccessResult(areas);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<Areas> areass = areasService.findByIds(ids);
        return ResultGenerator.genSuccessResult(areass);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<Areas> areass = areasService.findAll();
        return ResultGenerator.genSuccessResult(areass);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = areasService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
