package com.srdz.demo.service;

import com.srdz.demo.domain.NeedContent;
import com.srdz.demo.domain.OrderMaster;

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
     * @param customerId
     * @return
     */
    public List<NeedContent> queryNeedContentByCustomerId(Integer customerId);

    /**
     * @param designerId
     * @return
     */
    public List<NeedContent> queryNeedContentByDesignerId(Integer designerId);

    /**
     * update status
     *
     * @param needContentId
     * @param status
     */
    public void updateStatus(Integer needContentId, Integer status);

    /**
     * generator order information
     *
     * @param orderMaster
     * @param needContent
     * @return
     */
    public Boolean confirm(OrderMaster orderMaster, NeedContent needContent) throws Exception;

}
