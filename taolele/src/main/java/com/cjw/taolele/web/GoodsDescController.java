package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.GoodsDesc;
import com.cjw.taolele.service.GoodsDescService;
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
@RequestMapping("/goodsDesc")
public class GoodsDescController {
    @Resource
    private GoodsDescService goodsDescService;

    @RequestMapping("/save")
    public Result save(@RequestBody GoodsDesc goodsDesc) {
        goodsDescService.save(goodsDesc);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody GoodsDesc goodsDesc) {
        goodsDescService.save(goodsDesc);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        goodsDescService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        goodsDescService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody GoodsDesc goodsDesc) {
        goodsDescService.update(goodsDesc);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        GoodsDesc goodsDesc = goodsDescService.findById(id);
        return ResultGenerator.genSuccessResult(goodsDesc);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<GoodsDesc> goodsDescs = goodsDescService.findByIds(ids);
        return ResultGenerator.genSuccessResult(goodsDescs);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<GoodsDesc> goodsDescs = goodsDescService.findAll();
        return ResultGenerator.genSuccessResult(goodsDescs);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = goodsDescService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
