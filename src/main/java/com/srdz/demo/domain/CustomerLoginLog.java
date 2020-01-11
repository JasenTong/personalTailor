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
 * 用户登陆日志表
 * </p>
 *
 * @author walt1012
 * @since 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomerLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆日志ID
     */
    @TableId(value = "login_id", type = IdType.AUTO)
    private Integer loginId;

    /**
     * 登陆用户ID
     */
    private Integer customerId;

    /**
     * 用户登陆时间
     */
    private LocalDateTime loginTime;

    /**
     * 登陆IP
     */
    private Integer loginIp;

    /**
     * 登陆类型：0未成功，1成功
     */
    private Integer loginType;


}
