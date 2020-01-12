package com.srdz.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author walt1012
 * @since 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详情表ID
     */
    @TableId(value = "order_detail_id", type = IdType.AUTO)
    private Integer orderDetailId;

    /**
     * 订单表ID
     */
    private Integer orderId;

    /**
     * 提交内容ID
     */
    private Integer contentId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 购买商品数量
     */
    private Integer productCnt;

    /**
     * 购买商品单价
     */
    private BigDecimal productPrice;

    /**
     * 平均成本价格
     */
    private BigDecimal averageCost;

    /**
     * 商品重量
     */
    private Float weight;

    /**
     * 优惠分摊金额
     */
    private BigDecimal feeMoney;

    /**
     * 仓库ID
     */
    private Integer wId;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


}
