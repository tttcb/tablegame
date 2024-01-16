package com.guiguohui.system.service;

import com.guiguohui.system.domain.dto.Commodity;

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
    List<Commodity> search(String commodityName, Integer commodityType, Integer commodityMaxPrice, Integer commodityMinPrice, Integer commoditySeason);

    List<Commodity> queryAll();
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
}
