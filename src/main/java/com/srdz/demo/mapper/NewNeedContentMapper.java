package com.srdz.demo.mapper;

import com.srdz.demo.domain.NeedContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewNeedContentMapper {

    public void insertNeedConttent(NeedContent needContent);

    public void insertPlanContentByContnetId(NeedContent needContent);

    public void updateStatus(Integer needContentId,Integer status);

    public List<NeedContent> queryNeedContentByCustomerId(Integer customerId);

    public List<NeedContent> queryNeedContentByDesignerId(Integer designerId);

}
