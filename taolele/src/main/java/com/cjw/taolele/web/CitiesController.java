package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Cities;
import com.cjw.taolele.service.CitiesService;
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
@RequestMapping("/cities")
public class CitiesController {
    @Resource
    private CitiesService citiesService;

    @RequestMapping("/save")
    public Result save(@RequestBody Cities cities) {
        citiesService.save(cities);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody Cities cities) {
        citiesService.save(cities);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        citiesService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        citiesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Cities cities) {
        citiesService.update(cities);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        Cities cities = citiesService.findById(id);
        return ResultGenerator.genSuccessResult(cities);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<Cities> citiess = citiesService.findByIds(ids);
        return ResultGenerator.genSuccessResult(citiess);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<Cities> citiess = citiesService.findAll();
        return ResultGenerator.genSuccessResult(citiess);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = citiesService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
