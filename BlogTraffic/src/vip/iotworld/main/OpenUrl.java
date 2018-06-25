package vip.iotworld.main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class OpenUrl {
    public static String str="taskkill /F /IM firefox.exe";
    //这里firefox也可以改为iexplore或者chrome等等,也就是指定打开网页的浏览器，后面这些参数就是网址，
    //实际上有文件来代替更好，主要是本人博客不多也懒得折腾了
    public static String str1="cmd /c start firefox "
            + "https://blog.csdn.net/qq_21508727/article/details/80044265 " // 阿里云+github+Hexo部署静态资源博客 
            + "https://blog.csdn.net/qq_21508727/article/details/80044252 " // Tomcat中部署web静态资源 
            + "https://blog.csdn.net/qq_21508727/article/details/78826109 " // linux常用命令小结 
            + "https://blog.csdn.net/qq_21508727/article/details/79592349 " // 阿里云centos7配置JDK1.8+Tomcat7+Mysql5.7 
            + "https://blog.csdn.net/qq_21508727/article/details/79596423 " // 阿里云Centos7安装Redis4.0.8 
            + "https://blog.csdn.net/qq_21508727/article/details/79753693 " // linux 守护进程小结 
            + "https://blog.csdn.net/qq_21508727/article/details/79839195 " // 激光雷达数据解析（Python-lidar-data-analysis_V1.0） 
            + "https://blog.csdn.net/qq_21508727/article/details/79546197 " // Maven安装与配置 
    		+ "https://blog.csdn.net/qq_21508727/article/details/79546586 " // Maven在Eclipse中的配置 
    		+ "https://blog.csdn.net/qq_21508727/article/details/78826064 " // 指针小结 
    		+ "https://blog.csdn.net/qq_21508727/article/details/80071174 "	// 阿里云Centos7安装Nginx服务器实现反向代理											
            + "https://blog.csdn.net/qq_21508727/article/details/79547067 ";// 利用altuim degiser创建标准PCB工程 

    //我这里把要访问的网址分成了两部分，一次性访问大概二十个左右，浏览器不敢一次打开得太多，怕爆炸
    public static String str2="cmd /c start firefox "
            + "https://blog.csdn.net/qq_21508727/article/details/79824455 " // SQL内连接与外连接 
    		+ "https://blog.csdn.net/qq_21508727/article/details/80061314 " // Centos防火墙设置与端口开放的方法
    		+ "https://blog.csdn.net/qq_21508727/article/details/79760192 " // mybatis入门 第一天
    		+ "https://blog.csdn.net/qq_21508727/article/details/80199246 " // windows10 系统安装node.js和webpack
    		+ "https://blog.csdn.net/qq_21508727/article/details/80212183 " // 聊聊Web App、Hybrid App与Native App的设计差异
    		+ "https://blog.csdn.net/qq_21508727/article/details/79540678 " // POST和GET的区别
    		+ "https://blog.csdn.net/qq_21508727/article/details/80430592 " // 正排索引(forward index)与倒排索引(inverted index)
    		+ "https://blog.csdn.net/qq_21508727/article/details/80357580 " // python自动化处理txt文本文件
    		+ "https://blog.csdn.net/qq_21508727/article/details/79707354 ";// 交换机和路由器的区别 
            
             

    public static ArrayList<String> strList=new ArrayList<String>();


    public OpenUrl(){
        strList.add(str1);
        strList.add(str2);
    }

    public static void main(String args[]) {
        // defaultBrowserOpenUrl();
        OpenUrl openUrl=new OpenUrl();
        while(true){
            int i = 0;
            String strUrl = "";
            while (i < 2) {
                strUrl = strList.get(i);
                openFirefoxBrowser(strUrl, str);
                //每关闭一次浏览器，等待大概60s再重启，太过频繁浏览器会爆炸
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                i++;
            }
            //遍历一次睡一个小时，一天可以跑个二十二二十三次左右
            try {
                Thread.sleep(1300000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //使用指定的浏览器打开
    public static void openFirefoxBrowser(String start,String stop) {
        // 启用cmd运行firefox的方式来打开网址。
        try {
            Runtime.getRuntime().exec(start);
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Runtime.getRuntime().exec(stop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用操作系统默认的浏览器打开
        private static void defaultBrowserOpenUrl() {
            // ...
            try {
                Desktop.getDesktop().browse(new URI("https://blog.csdn.net/qq_21508727/article/details/80044265"));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // 网址被屏蔽了，手动加网址试一下。
        }

}
