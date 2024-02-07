package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.config.SecurityContext;
import com.guiguohui.system.domain.dto.Callback;
import com.guiguohui.system.domain.dto.Criticize;
import com.guiguohui.system.mapper.CriticizeMapper;
import com.guiguohui.system.service.CriticizeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.COMMODITY_ACTIVE;
import static com.guiguohui.system.common.Parameter.COMMODITY_DELETE;

/**
 * @author tu.cb
 */
@Service
public class CriticizeServiceImpl implements CriticizeService {

    @Autowired
    private CriticizeMapper criticizeMapper;


    @Override
    public PageHelper<Criticize> queryAll(Integer orderId, Integer pageIndex, Integer pageSize) {
        QueryWrapper<Criticize> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        queryWrapper.eq("order_id", orderId).orderByAsc("id");
        List<Criticize> data = criticizeMapper.selectList(queryWrapper);
        PageHelper<Criticize> result = new PageHelper<>(0, pageSize, pageIndex, data);
        result.init();
        return result;
    }

    @Override
    public List<Criticize> queryById(Integer criticizeId) {
        QueryWrapper<Criticize> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", criticizeId).or().eq("criticize_id", criticizeId).orderByDesc("id");
        return criticizeMapper.selectList(queryWrapper);
    }


    @Override
    public String insert(String content, Integer orderId) {
        Integer userid = SecurityContext.getUserId();
        if (userid == null) {
            throw new IllegalArgumentException("userid cannot be null");
        }
        Integer result = criticizeMapper.insert(Criticize.builder()
                .content(content)
                .userId(userid)
                .orderId(orderId)
                .status(COMMODITY_ACTIVE)
                .build());
        if (result.equals(1)) {
            return "新增评价成功";
        } else {
            return "新增评价失败";
        }
    }

    @Override
    public String update(String content, Integer criticizeId) {
        QueryWrapper<Criticize> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", criticizeId);
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = criticizeMapper.update(Criticize.builder().content(content).build(), queryWrapper);
        if (result.equals(1)) {
            return "更新评价成功";
        } else {
            return "更新评价失败";
        }
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Criticize> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "评价ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (criticizeMapper.selectById(id) == null) {
            return "评价不存在";
        }
        if (Objects.equals(criticizeMapper.selectById(id).getStatus(), COMMODITY_DELETE)) {
            return "评价已经被删除";
        }
        criticizeMapper.update(Criticize.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除评价成功";
    }

    @Override
    public String reply(String content, Integer criticizeId) {
        Integer userid = SecurityContext.getUserId();
        if (userid == null) {
            throw new IllegalArgumentException("userid cannot be null");
        }
        Integer result = criticizeMapper.insert(Criticize.builder()
                .content(content)
                .orderId(criticizeMapper.selectById(criticizeId).getOrderId())
                .userId(userid)
                .criticizeId(criticizeId)
                .status(COMMODITY_ACTIVE)
                .build());
        if (result.equals(1)) {
            return "新增评价成功";
        } else {
            return "新增评价失败";
        }
    }

}
