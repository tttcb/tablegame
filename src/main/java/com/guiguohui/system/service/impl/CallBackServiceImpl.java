package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.domain.dto.Callback;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.mapper.CallBackMapper;
import com.guiguohui.system.mapper.CommodityMapper;
import com.guiguohui.system.service.CallBackService;
import com.guiguohui.system.service.CommodityService;
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
public class CallBackServiceImpl implements CallBackService {

    @Autowired
    private CallBackMapper callBackMapper;


    @Override
    public List<Callback> queryAll() {
        QueryWrapper<Callback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        return callBackMapper.selectList(queryWrapper);
    }


    @Override
    public String insert(Callback callback) {
        Integer result = callBackMapper.insert(callback);
        if (result.equals(1)) {
            return "新增反馈成功";
        } else {
            return "新增反馈失败";
        }
    }

    @Override
    public String update(Callback callback) {
        QueryWrapper<Callback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", callback.getId());
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = callBackMapper.update(callback, queryWrapper);
        if (result.equals(1)) {
            return "更新反馈成功";
        } else {
            return "更新反馈失败";
        }
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Callback> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "反馈ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (callBackMapper.selectById(id) == null) {
            return "反馈不存在";
        }
        if (Objects.equals(callBackMapper.selectById(id).getStatus(), COMMODITY_DELETE)) {
            return "反馈已经被删除";
        }
        callBackMapper.update(Callback.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除反馈成功";
    }

}
