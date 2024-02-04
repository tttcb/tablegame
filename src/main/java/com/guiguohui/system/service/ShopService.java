package com.guiguohui.system.service;

import com.guiguohui.system.common.PageHelper;
import com.guiguohui.system.domain.dto.Commodity;
import com.guiguohui.system.domain.dto.Shop;

import java.util.List;

/**
 * @author tu.cb
 */
public interface ShopService {

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageHelper<Shop> search(String shopName,Integer pageIndex, Integer pageSize);

    /**
     * 插入
     * @param
     * @return
     */
    String insert(Shop shop);


    PageHelper<Shop> queryAll(Integer pageIndex, Integer pageSize);

    /**
     * 更新
     * @param
     * @return
     */
    String update(Shop shop);

    /**
     * 删除
     * @param
     * @return
     */
    String delete(Integer id);

    Shop shopDetail(String userId);
}
