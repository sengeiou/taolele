package com.cjw.taolele.web;

import com.cjw.taolele.core.Result;
import com.cjw.taolele.core.ResultGenerator;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Seller;
import com.cjw.taolele.service.SellerService;
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
@RequestMapping("/seller")
public class SellerController {
    @Resource
    private SellerService sellerService;

    @RequestMapping("/save")
    public Result save(@RequestBody Seller seller) {
        sellerService.save(seller);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/saveList")
    public Result saveList(@RequestBody Seller seller) {
        sellerService.save(seller);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteByIds")
    public Result deleteByIds(String ids) {
        sellerService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Long id) {
        sellerService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Seller seller) {
        sellerService.update(seller);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/findById")
    public Result findById(Long id) {
        Seller seller = sellerService.findById(id);
        return ResultGenerator.genSuccessResult(seller);
    }

    @RequestMapping("/findByIds")
    public Result findByIds(String ids) {
        List<Seller> sellers = sellerService.findByIds(ids);
        return ResultGenerator.genSuccessResult(sellers);
    }

    @RequestMapping("/findAll")
    public Result findAll() {
    List<Seller> sellers = sellerService.findAll();
        return ResultGenerator.genSuccessResult(sellers);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8")int pageSize) {
        PageResult pageResult = sellerService.findPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageResult);
    }
}
