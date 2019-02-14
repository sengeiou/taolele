package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.ContentCategory;
import com.cjw.taolele.service.ContentCategoryService;
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
@RequestMapping("/contentCategory")
public class ContentCategoryController {
    @Resource
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/save")
    public Result save(@RequestBody ContentCategory contentCategory) {
        contentCategoryService.save(contentCategory);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody ContentCategory contentCategory) {
        contentCategoryService.save(contentCategory);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        contentCategoryService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        contentCategoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ContentCategory contentCategory) {
        contentCategoryService.update(contentCategory);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        ContentCategory contentCategory = contentCategoryService.findById(id);
        return ResultGenerator.genSuccessResult(contentCategory);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<ContentCategory> contentCategorys = contentCategoryService.findByIds(ids);
        return ResultGenerator.genSuccessResult(contentCategorys);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<ContentCategory> contentCategorys = contentCategoryService.findAll();
        return ResultGenerator.genSuccessResult(contentCategorys);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = contentCategoryService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
