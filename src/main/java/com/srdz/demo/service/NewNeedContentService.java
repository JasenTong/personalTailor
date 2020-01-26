package com.srdz.demo.service;

import com.srdz.demo.domain.NeedContent;

import java.util.List;

public interface NewNeedContentService {

    /**
     * @param needContent insert need content
     */
    public void insertNeedContent(NeedContent needContent);

    /**
     * @param needContent insert plan content
     */
    public void insertPlanContentByContnetId(NeedContent needContent);

    /**
     * @param customerId 消费者id
     * @return 消费者列表
     */
    public List<NeedContent> queryNeedContentByCustomerId(Integer customerId);

    /**
     * @param designerId 设计师id
     * @return 消费者列表
     */
    public List<NeedContent> queryNeedContentByDesignerId(Integer designerId);

    /**
     * 更新状态
     *
     * @param needContentId 需求表id
     * @param status        状态值
     */
    public void updateStatus(Integer needContentId, Integer status);

}
