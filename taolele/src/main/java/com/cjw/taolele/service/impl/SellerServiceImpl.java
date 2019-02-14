package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.SellerMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Seller;
import com.cjw.taolele.service.SellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jing wen on 2019/02/14.
 */
@Service
@Transactional
public class SellerServiceImpl extends AbstractService<Seller> implements SellerService {
    @Resource
    private SellerMapper sellerMapper;

    @Override
    public PageResult findPage(Seller seller, int pageNum, int pageSize) {
        PageResult<Seller> result = new PageResult<Seller>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Seller.class);
        Example.Criteria criteria = example.createCriteria();

        if(seller!=null){
            //如果字段不为空
                if (seller.getSellerId()!=null && seller.getSellerId().length()>0) {
                    criteria.andLike("seller_id", "%" + seller.getSellerId() + "%");
                }
                if (seller.getName()!=null && seller.getName().length()>0) {
                    criteria.andLike("name", "%" + seller.getName() + "%");
                }
                if (seller.getNickName()!=null && seller.getNickName().length()>0) {
                    criteria.andLike("nick_name", "%" + seller.getNickName() + "%");
                }
                if (seller.getPassword()!=null && seller.getPassword().length()>0) {
                    criteria.andLike("password", "%" + seller.getPassword() + "%");
                }
                if (seller.getEmail()!=null && seller.getEmail().length()>0) {
                    criteria.andLike("email", "%" + seller.getEmail() + "%");
                }
                if (seller.getMobile()!=null && seller.getMobile().length()>0) {
                    criteria.andLike("mobile", "%" + seller.getMobile() + "%");
                }
                if (seller.getTelephone()!=null && seller.getTelephone().length()>0) {
                    criteria.andLike("telephone", "%" + seller.getTelephone() + "%");
                }
                if (seller.getStatus()!=null && seller.getStatus().length()>0) {
                    criteria.andLike("status", "%" + seller.getStatus() + "%");
                }
                if (seller.getAddressDetail()!=null && seller.getAddressDetail().length()>0) {
                    criteria.andLike("address_detail", "%" + seller.getAddressDetail() + "%");
                }
                if (seller.getLinkmanName()!=null && seller.getLinkmanName().length()>0) {
                    criteria.andLike("linkman_name", "%" + seller.getLinkmanName() + "%");
                }
                if (seller.getLinkmanQq()!=null && seller.getLinkmanQq().length()>0) {
                    criteria.andLike("linkman_qq", "%" + seller.getLinkmanQq() + "%");
                }
                if (seller.getLinkmanMobile()!=null && seller.getLinkmanMobile().length()>0) {
                    criteria.andLike("linkman_mobile", "%" + seller.getLinkmanMobile() + "%");
                }
                if (seller.getLinkmanEmail()!=null && seller.getLinkmanEmail().length()>0) {
                    criteria.andLike("linkman_email", "%" + seller.getLinkmanEmail() + "%");
                }
                if (seller.getLicenseNumber()!=null && seller.getLicenseNumber().length()>0) {
                    criteria.andLike("license_number", "%" + seller.getLicenseNumber() + "%");
                }
                if (seller.getTaxNumber()!=null && seller.getTaxNumber().length()>0) {
                    criteria.andLike("tax_number", "%" + seller.getTaxNumber() + "%");
                }
                if (seller.getOrgNumber()!=null && seller.getOrgNumber().length()>0) {
                    criteria.andLike("org_number", "%" + seller.getOrgNumber() + "%");
                }
                if (seller.getLogoPic()!=null && seller.getLogoPic().length()>0) {
                    criteria.andLike("logo_pic", "%" + seller.getLogoPic() + "%");
                }
                if (seller.getBrief()!=null && seller.getBrief().length()>0) {
                    criteria.andLike("brief", "%" + seller.getBrief() + "%");
                }
                if (seller.getLegalPerson()!=null && seller.getLegalPerson().length()>0) {
                    criteria.andLike("legal_person", "%" + seller.getLegalPerson() + "%");
                }
                if (seller.getLegalPersonCardId()!=null && seller.getLegalPersonCardId().length()>0) {
                    criteria.andLike("legal_person_card_id", "%" + seller.getLegalPersonCardId() + "%");
                }
                if (seller.getBankUser()!=null && seller.getBankUser().length()>0) {
                    criteria.andLike("bank_user", "%" + seller.getBankUser() + "%");
                }
                if (seller.getBankName()!=null && seller.getBankName().length()>0) {
                    criteria.andLike("bank_name", "%" + seller.getBankName() + "%");
                }
        }

        //查询数据
        List<Seller> list = sellerMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Seller> info = new PageInfo<Seller>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
