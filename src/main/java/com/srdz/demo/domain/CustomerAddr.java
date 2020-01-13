package com.srdz.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author walt1012
 * @since 2020-01-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Date modifiedTime;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

}
