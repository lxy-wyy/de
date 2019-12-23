package com.buba.de.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.buba.de.pojo.ApiOSSInfoDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OSSUtils {
    //上传图片到oss
    public static boolean putUpload(List<File> files) throws IOException {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(OssConstant.OSS_PARAMETER_ENDOPINT, OssConstant.OSS_PARAMETER_ACCESSKEYID, OssConstant.OSS_PARAMETER_ACCESSKEYSECRET, "");
        try {
            for (File file : files) {
                PutObjectRequest putObjectRequest = new PutObjectRequest(OssConstant.OSS_PARAMETER_BUCKETNAME, OssConstant.OSS_PARAMETER_DEMO_DIR  + file.getName(),
                        file);
                ossClient.putObject(putObjectRequest);
            }
            ossClient.shutdown();
        } catch (Exception e) {
            return false;
        } finally {
            // 关闭client
            ossClient.shutdown();
        }
        return true;
    }

    //删除存储的图片
    public static boolean deleteImage(String imageName, ApiOSSInfoDTO info) throws IOException {
        // EndPoint以为例
        OSSClient client = new OSSClient(OssConstant.OSS_PARAMETER_ENDOPINT, OssConstant.OSS_PARAMETER_ACCESSKEYID, OssConstant.OSS_PARAMETER_ACCESSKEYSECRET);
        try {
            client.deleteObject(OssConstant.OSS_PARAMETER_BUCKETNAME, info.getDir() + imageName);
            client.shutdown();
        } catch (Exception e) {
            return false;
        } finally {
            // 关闭client
            client.shutdown();
        }
        return true;
    }
}
