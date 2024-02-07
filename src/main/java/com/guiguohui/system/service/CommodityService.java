package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Commodity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author tu.cb
 */
public interface CommodityService {

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageHelper<Commodity> search(String commodityName, String commodityType, Integer commodityMaxPrice, Integer commodityMinPrice, Integer commoditySeason,Integer shopId,Integer pageIndex, Integer pageSize);

    PageHelper<Commodity> queryAll();
    /**
     * 插入
     * @param commodity
     * @return
     */
    String insert(Commodity commodity);

    /**
     * 更新
     * @param commodity
     * @return
     */
    String update(Commodity commodity);

    /**
     * 删除
     * @param
     * @return
     */
    String delete(Integer id);

    Commodity queryById(Integer commodityId);

    String changeStock(Integer count,Integer id);

    String upLoadImage(MultipartFile file,Integer id) throws IOException;

    String loadImage(Integer commodityId, HttpServletResponse httpServletResponse);
}
