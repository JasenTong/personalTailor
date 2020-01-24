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
     *
     * @param designerId 设计师id
     * @return 消费者列表
     */
    public List<NeedContent>queryNeedContentByDesignerId(Integer designerId);

}
