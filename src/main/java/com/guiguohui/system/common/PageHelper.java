package com.guiguohui.system.common;

import cn.hutool.core.util.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageHelper<a> {
    int totalPages;
    int pageSize;
    int pageIndex;
    List<a> data;

    public void init() {
        this.totalPages = PageUtil.totalPage(data.size(), pageSize);
        int[] index = PageUtil.transToStartEnd(pageIndex-1, pageSize);
        if (index[1] > data.size()) {
            index[1]=data.size();
        }
        this.data = data.subList(index[0], index[1]);
    }
}
