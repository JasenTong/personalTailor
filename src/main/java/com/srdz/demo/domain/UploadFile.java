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
 * 文件上传表
 * </p>
 *
 * @author walt1012
 * @since 2020-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 上传文件的ID
     */
    @TableId(value = "upload_file_id", type = IdType.AUTO)
    private Integer uploadFileId;

    /**
     * 设计师id
     */
    private Integer designerId;

    /**
     * 文件标题
     */
    private String fileTitle;

    /**
     * 文件个数
     */
    private Integer fileCount;

    /**
     * 文件路径
     */
    private String fileDest;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


}
