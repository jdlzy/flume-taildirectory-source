package org.apache.flume.source.taildirectory.test;

import java.io.*;

/**
 * Created by Administrator on 2018/4/9.
 */
public class FileTest {
    public static void main(String[] args) {
        File file=new File("G:\\资源网接口文件整理\\资源网接口文件整理\\工参\\csv\\GC5_4g_site.csv");
        System.out.println(file.getPath());
        System.out.println(file.getParentFile().getName());
        System.out.println("中国");
        InputStreamReader read = null;//考虑到编码格式
        try {
            read = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                System.out.println(lineTxt);
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
