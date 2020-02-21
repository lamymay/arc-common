package com.arc.core.model.domain.system;


import com.arc.core.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 图像记录
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SystemFile extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id; //主键
    private String url; // 文件地址
    private String path; // 文件本地地址
    private String name; //文件名称
    private String suffix; //文件后缀
    private Date createDate;//创建时间
    private Date updateDate;//更新时间


    public SystemFile(String url, String path, String name, String suffix  ) {
        this.url = url;
        this.path = path;
        this.name = name;
        this.suffix = suffix;
    }
/*
    public static SystemFile transferFile(MultipartFile file, String filePath) throws IOException {
        SystemFile convertFile = new SystemFile(filePath);
        if (convertFile.exists()) {
            if (!convertFile.delete()) {
                log.debug("本地文件已存在");
            }
        }
        FileUtil.extractDirAndCreate(filePath);
        try (InputStream inputStream = file.getInputStream()) {
            FileUtil.copy(inputStream, convertFile);
        }
        return convertFile;
    }*/

}
