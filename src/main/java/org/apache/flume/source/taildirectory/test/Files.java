package org.apache.flume.source.taildirectory.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Files {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str=null;
        byte[] byt=str.getBytes("ISO-8859-1");
        String newStr=new String(byt, "utf-8");
                System.out.println(newStr);
    }
}
