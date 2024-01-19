package com.guiguohui.system.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @ApiParam("响应结果，无需填写")
    public OrderCommodity orderCommodity;
    @ApiParam("新增时需要将商品ID和数量写一个list")
    public Integer commodityId;
    @ApiParam("数量")
    public Integer count;

}
