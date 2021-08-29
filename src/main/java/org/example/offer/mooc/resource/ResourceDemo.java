package org.example.offer.mooc.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

public class ResourceDemo {
    public static void main(String[] args) throws IOException {
        //在不启动spring容器的情况下就能使用spring的功能
        FileSystemResource fileSystemResource = new FileSystemResource("D:\\project\\spring-study\\src\\main\\java\\org\\example\\offer\\mooc\\resource\\test.txt");
        File file = fileSystemResource.getFile();
        System.out.println(file.length());
        OutputStream outputStream = fileSystemResource.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,这是一个替换操作");
        bufferedWriter.flush();   //将缓存中的数据flush到文件
        outputStream.close();
        bufferedWriter.close();
    }
}
