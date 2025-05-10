package com.agric.myagric.service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@Service

public class FaceService {
    public void faceRecognition() throws IOException{
        //前面一半是本地环境下的python的启动文件地址，后面一半是要执行的python脚本地址
        //arguments第一个参数是执行的python文件，从第二个开始才是要传的参数
        int y=1;
        String[] arguments = new String[] {"D:\\Program Files\\anaconda3\\envs\\py3_pcse\\python.exe", "D:\\mycode\\pcseProject\\testspringboot.py","20"};
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(arguments);// 执行py文件
            //用输入输出流来截取结果
            String charset = "UTF-8";//两边的编码要统一
        FileInputStream errorStream = (FileInputStream)proc.getErrorStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"UTF-8"));

        String line = in.readLine();
//        InputStreamReader isr = new InputStreamReader(errorStream,"gbk");//读取
//        System.out.println(isr.getEncoding());
//        BufferedReader in = new BufferedReader(isr);//缓冲
//        String line = in.readLine();
            System.out.println(line);
//        while ((line = in.readLine()) != null) {
//            System.out.println("111"+line);
//        }
        in.close();
        //waitFor是用来显示脚本是否运行成功，1表示失败，0表示成功，还有其他的表示其他错误
        int re = proc.waitFor();
        System.out.println(re);
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



