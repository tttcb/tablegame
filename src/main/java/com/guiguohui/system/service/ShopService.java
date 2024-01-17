package com.guiguohui.system.service;

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
    List<Shop> search(String shopName);

    /**
     * 插入
     * @param
     * @return
     */
    String insert(Shop shop);


    List<Shop> queryAll();

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

}
