package org.apache.flume.source.taildirectory.test;

import java.io.File;

/**
 * Created by Administrator on 2018/4/9.
 */
public class FileTest {
    public static void main(String[] args) {
        File file=new File("F:\\house_price_input\\train.csv");
        System.out.println(file.getPath());
        System.out.println(file.getParentFile().getName());
    }
}
