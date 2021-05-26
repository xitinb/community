package com.leyou.upload.test;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FastDFSTest {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        // 要上传的文件
        File file = new File("C:\\Users\\lenovo\\Downloads\\灯\\2.jpg");
        // 上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpeg", null);
        // 带分组的路径
        System.out.println("http://8.129.53.82/" + storePath.getFullPath());
        // 不带分组的路径
        System.out.println("http://8.129.53.82/" + storePath.getPath());
    }

    @Test
    public void testten() throws FileNotFoundException {
        for (int i = 0; i < 10; i++) {
            testUploadAndCreateThumb();
        }
    }

    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File("C:\\Users\\lenovo\\Downloads\\灯\\3.jpg");
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println("http://8.129.53.82/" + storePath.getFullPath());
        // 不带分组的路径
        System.out.println("http://8.129.53.82/" + storePath.getPath());
        // 获取缩略图路径
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println("http://8.129.53.82/" + path);
    }
}
