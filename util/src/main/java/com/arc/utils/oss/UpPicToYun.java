package com.arc.utils.oss;


import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UpPicToYun {
    protected static final String BUCKET_NAME = "rong";
    protected static final String YUN_USERNAME = "gongzhen";
    protected static final String YUN_PASSWORD = "rynw87^%43";

    public UpPicToYun() {
    }

    private UpYun getUpYun() {
        return new UpYun(BUCKET_NAME, YUN_USERNAME, YUN_PASSWORD);
    }

    public boolean uploadToYun(String filePath, byte[] datas) throws IOException {
        return getUpYun().writeFile(filePath, datas, true);
    }

    public String readFile(String filePath) throws IOException {
        return getUpYun().readFile(filePath);
    }

    public Map<String, String> getFileInfo(String filePath) {
        return getUpYun().getFileInfo(filePath);
    }

    public boolean deleteFile(String filePath) {
        return getUpYun().deleteFile(filePath);
    }

    public boolean writeFile(String localFilePath, String remoteFilePath) throws IOException {
        return getUpYun().writeFile(remoteFilePath, new File(localFilePath));
    }

    public boolean writeFile(String localFilePath, String remoteFilePath, boolean auto) throws IOException {
        return getUpYun().writeFile(remoteFilePath, new File(localFilePath), auto);
    }

    public boolean uploadPicBySync(String filePath, String picUrl) throws IOException {
        return getUpYun().writeFile(picUrl, new File(filePath), true);
    }

}
