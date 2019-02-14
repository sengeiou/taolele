package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.UserMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.User;
import com.cjw.taolele.service.UserService;
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
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public PageResult findPage(User user, int pageNum, int pageSize) {
        PageResult<User> result = new PageResult<User>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if(user!=null){
            //如果字段不为空
                if (user.getUsername()!=null && user.getUsername().length()>0) {
                    criteria.andLike("username", "%" + user.getUsername() + "%");
                }
                if (user.getPassword()!=null && user.getPassword().length()>0) {
                    criteria.andLike("password", "%" + user.getPassword() + "%");
                }
                if (user.getPhone()!=null && user.getPhone().length()>0) {
                    criteria.andLike("phone", "%" + user.getPhone() + "%");
                }
                if (user.getEmail()!=null && user.getEmail().length()>0) {
                    criteria.andLike("email", "%" + user.getEmail() + "%");
                }
                if (user.getSourceType()!=null && user.getSourceType().length()>0) {
                    criteria.andLike("source_type", "%" + user.getSourceType() + "%");
                }
                if (user.getNickName()!=null && user.getNickName().length()>0) {
                    criteria.andLike("nick_name", "%" + user.getNickName() + "%");
                }
                if (user.getName()!=null && user.getName().length()>0) {
                    criteria.andLike("name", "%" + user.getName() + "%");
                }
                if (user.getStatus()!=null && user.getStatus().length()>0) {
                    criteria.andLike("status", "%" + user.getStatus() + "%");
                }
                if (user.getHeadPic()!=null && user.getHeadPic().length()>0) {
                    criteria.andLike("head_pic", "%" + user.getHeadPic() + "%");
                }
                if (user.getQq()!=null && user.getQq().length()>0) {
                    criteria.andLike("qq", "%" + user.getQq() + "%");
                }
                if (user.getIsMobileCheck()!=null && user.getIsMobileCheck().length()>0) {
                    criteria.andLike("is_mobile_check", "%" + user.getIsMobileCheck() + "%");
                }
                if (user.getIsEmailCheck()!=null && user.getIsEmailCheck().length()>0) {
                    criteria.andLike("is_email_check", "%" + user.getIsEmailCheck() + "%");
                }
                if (user.getSex()!=null && user.getSex().length()>0) {
                    criteria.andLike("sex", "%" + user.getSex() + "%");
                }
        }

        //查询数据
        List<User> list = userMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<User> info = new PageInfo<User>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
