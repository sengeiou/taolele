package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Content;
import com.cjw.taolele.service.ContentService;
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
@RequestMapping("/content")
public class ContentController {
    @Resource
    private ContentService contentService;

    @RequestMapping("/save")
    public Result save(@RequestBody Content content) {
        contentService.save(content);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody Content content) {
        contentService.save(content);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        contentService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        contentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Content content) {
        contentService.update(content);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        Content content = contentService.findById(id);
        return ResultGenerator.genSuccessResult(content);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<Content> contents = contentService.findByIds(ids);
        return ResultGenerator.genSuccessResult(contents);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<Content> contents = contentService.findAll();
        return ResultGenerator.genSuccessResult(contents);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = contentService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
