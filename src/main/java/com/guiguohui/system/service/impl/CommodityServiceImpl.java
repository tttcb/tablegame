package com.guiguohui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.mapper.CommodityMapper;
import com.guiguohui.system.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import static com.guiguohui.system.common.Parameter.COMMODITY_ACTIVE;
import static com.guiguohui.system.common.Parameter.COMMODITY_DELETE;

/**
 * @author tu.cb
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;


    public PageHelper<Commodity> search(String commodityName, String commodityType, Integer commodityMaxPrice, Integer commodityMinPrice, Integer commoditySeason, Integer pageIndex, Integer pageSize) {
        if (commodityName != null) {
            commodityName = "%" + commodityName + "%";
        }
        if (commodityMinPrice == null) {
            commodityMaxPrice = null;
        }
        List<Commodity> data = commodityMapper.search(commodityName, commodityType, commodityMaxPrice, commodityMinPrice, commoditySeason);
        PageHelper<Commodity> result = new PageHelper<>(0, pageSize, pageIndex, data);
        result.init();
        return result;
    }

    @Override
    public PageHelper<Commodity> queryAll() {
        return search(null, null, null, null, null, 1, 100);
    }


    @Override
    public String insert(Commodity commodity) {
        commodity.setStatus(COMMODITY_ACTIVE);
        Integer result = commodityMapper.insert(commodity);
        if (result.equals(1)) {
            return "新增商品成功";
        } else {
            return "新增商品失败";
        }
    }

    @Override
    public String update(Commodity commodity) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", commodity.getId());
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = commodityMapper.update(commodity, queryWrapper);
        if (result.equals(1)) {
            return "更新商品成功";
        } else {
            return "更新商品失败";
        }
    }

    @Override
    public String delete(Integer id) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        if (id == null) {
            return "商品ID不能为空";
        }
        queryWrapper.eq("Id", id);
        if (commodityMapper.selectById(id) == null) {
            return "商品不存在";
        }
        if (Objects.equals(commodityMapper.selectById(id).getStatus(), COMMODITY_DELETE)) {
            return "商品已经被删除";
        }
        commodityMapper.update(Commodity.builder()
                .status(COMMODITY_DELETE)
                .build(), queryWrapper);
        return "删除商品成功";
    }

    @Override
    public Commodity queryById(Integer commodityId) {
        if (commodityId != null) {
            return commodityMapper.selectById(commodityId);
        } else {
            throw new IllegalArgumentException("id不能为空");
        }
    }

    @Override
    public String changeStock(Integer count, Integer id) {
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.eq("status", COMMODITY_ACTIVE);
        Integer result = commodityMapper.update(Commodity.builder().stock(count).build(), queryWrapper);
        if (result.equals(1)) {
            return "更新库存成功";
        } else {
            return "更新库存失败";
        }
    }

    @Override
    public String upLoadImage(MultipartFile file, Integer id) throws IOException {
        return update(Commodity.builder().image(file.getBytes()).id(id).build());
    }

    @Override
    public String loadImage(Integer commodityId, HttpServletResponse httpServletResponse) {
        byte[] bytes = null;
        Commodity commodity = queryById(commodityId);
        if (commodity != null) {
            bytes = commodity.getImage();
        }
        if (bytes == null) {
            return "暂无图片";
        }
        InputStream is = new ByteArrayInputStream(bytes);
        httpServletResponse.setContentType("image/*");
        try {
            ServletOutputStream sout = httpServletResponse.getOutputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf, 0, 1024)) != -1) {
                sout.write(buf, 0, len);
            }
            sout.flush();
            sout.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "读取成功";
    }


}
