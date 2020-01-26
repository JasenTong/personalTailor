package com.srdz.demo.service.impl;

import com.srdz.demo.domain.NeedContent;
import com.srdz.demo.mapper.NewNeedContentMapper;
import com.srdz.demo.service.NewNeedContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewNeedContnetServiceImpl implements NewNeedContentService {
    @Autowired
    private NewNeedContentMapper newNeedContentMapper;

    public void insertNeedContent(NeedContent needContent) {
        this.newNeedContentMapper.insertNeedConttent(needContent);
    }

    public void insertPlanContentByContnetId(NeedContent needContent) {
        this.newNeedContentMapper.insertPlanContentByContnetId(needContent);
    }

    public List<NeedContent> queryNeedContentByCustomerId(Integer customerId) {
        List<NeedContent> list = new ArrayList<>();
        list = this.newNeedContentMapper.queryNeedContentByCustomerId(customerId);
        return list;
    }

    public List<NeedContent> queryNeedContentByDesignerId(Integer designerId) {
        List<NeedContent> list = new ArrayList<>();
        list = this.newNeedContentMapper.queryNeedContentByDesignerId(designerId);
        return list;
    }

    public void updateStatus(Integer needContentId, Integer status) {
        this.newNeedContentMapper.updateStatus(needContentId, status);
    }
}
