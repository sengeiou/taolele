package com.cjw.taolele.service.impl;

import com.cjw.taolele.core.AbstractService;
import com.cjw.taolele.dao.ContentMapper;
import com.cjw.taolele.entity.PageResult;
import com.cjw.taolele.model.Content;
import com.cjw.taolele.service.ContentService;
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
public class ContentServiceImpl extends AbstractService<Content> implements ContentService {
    @Resource
    private ContentMapper contentMapper;

    @Override
    public PageResult findPage(Content content, int pageNum, int pageSize) {
        PageResult<Content> result = new PageResult<Content>();
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);

        //构建查询条件
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();

        if(content!=null){
            //如果字段不为空
                if (content.getTitle()!=null && content.getTitle().length()>0) {
                    criteria.andLike("title", "%" + content.getTitle() + "%");
                }
                if (content.getUrl()!=null && content.getUrl().length()>0) {
                    criteria.andLike("url", "%" + content.getUrl() + "%");
                }
                if (content.getPic()!=null && content.getPic().length()>0) {
                    criteria.andLike("pic", "%" + content.getPic() + "%");
                }
                if (content.getStatus()!=null && content.getStatus().length()>0) {
                    criteria.andLike("status", "%" + content.getStatus() + "%");
                }
        }

        //查询数据
        List<Content> list = contentMapper.selectByExample(example);
        //保存数据列表
        result.setRows(list);

        //获取总记录数
        PageInfo<Content> info = new PageInfo<Content>(list);
        result.setTotal(info.getTotal());

        return result;
    }
}
