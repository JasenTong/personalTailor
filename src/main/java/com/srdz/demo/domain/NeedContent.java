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

    private String planContent;

    /**
     * 消费者ID
     */
    private Integer customerId;

    /**
     * 设计师ID
     */
    private Integer designerId;

    /**
     * 需求表的状态
     * 1 提交需求 2 给出方案 3 确认定制 4 放弃 6 生成订单
     */
    private Integer status;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNeedContentId() {
        return needContentId;
    }

    public void setNeedContentId(Integer needContentId) {
        this.needContentId = needContentId;
    }
}
