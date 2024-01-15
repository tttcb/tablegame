package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Notice;
import com.guiguohui.system.domain.dto.Shop;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author tu.cb
 */
public interface CommodityService {

    /**
     * 查询列表
     *
     * @param id
     * @return
     */
    List<Commodity> query(Integer id, String commodityName, Integer commodityType,Integer commodityMaxPrice, Integer commodityMinPrice,Integer commoditySeason);

    List<Commodity> query();
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

}
