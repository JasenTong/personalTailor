package com.srdz.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.UploadFile;
import com.srdz.demo.mapper.UploadFileMapper;
import com.srdz.demo.service.IUploadFileService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件上传表 服务实现类
 * </p>
 *
 * @author walt1012
 * @since 2020-02-16
 */
@Service
public class UploadFileServiceImpl extends ServiceImpl<UploadFileMapper, UploadFile> implements IUploadFileService {

}
