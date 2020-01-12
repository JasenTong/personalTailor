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
 * 用户登录表
 * </p>
 *
 * @author walt1012
 * @since 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DesignerLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "designer_id", type = IdType.AUTO)
    private Integer designerId;

    /**
     * warehouse of designer
     */
    private Integer wId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * md5加密的密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer userStatus;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;


}
