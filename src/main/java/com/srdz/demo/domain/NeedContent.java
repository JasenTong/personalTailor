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
 * 提交需求详情
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
public class NeedContent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 需求详情表ID
     */
    @TableId(value = "need_content_id", type = IdType.AUTO)
    private Integer needContentId;

    private String content;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;


}
