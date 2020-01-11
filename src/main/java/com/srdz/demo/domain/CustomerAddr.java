package com.srdz.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author walt1012
 * @since 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomerAddr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    @TableId(value = "customer_addr_id", type = IdType.AUTO)
    private Integer customerAddrId;

    /**
     * customer_login表的自增ID
     */
    private Integer customerId;

    /**
     * 邮编
     */
    private Integer zip;

    /**
     * 地区表中省份的ID
     */
    private Integer province;

    /**
     * 地区表中城市的ID
     */
    private Integer city;

    /**
     * 地区表中的区ID
     */
    private Integer district;

    /**
     * 具体的地址门牌号
     */
    private String address;

    /**
     * 是否默认
     */
    private Integer isDefault;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


}
