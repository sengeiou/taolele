package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.ItemCat;
import com.cjw.taolele.service.ItemCatService;
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
@RequestMapping("/itemCat")
public class ItemCatController {
    @Resource
    private ItemCatService itemCatService;

    @RequestMapping("/save")
    public Result save(@RequestBody ItemCat itemCat) {
        itemCatService.save(itemCat);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody ItemCat itemCat) {
        itemCatService.save(itemCat);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        itemCatService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        itemCatService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ItemCat itemCat) {
        itemCatService.update(itemCat);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        ItemCat itemCat = itemCatService.findById(id);
        return ResultGenerator.genSuccessResult(itemCat);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<ItemCat> itemCats = itemCatService.findByIds(ids);
        return ResultGenerator.genSuccessResult(itemCats);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<ItemCat> itemCats = itemCatService.findAll();
        return ResultGenerator.genSuccessResult(itemCats);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = itemCatService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
