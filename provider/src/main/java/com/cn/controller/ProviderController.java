package com.cn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenZZ
 * @Date 2021/12/14 11:30
 */
@RestController
@RequestMapping("provider")
public class ProviderController {

    @GetMapping("{message}")
    @SentinelResource(value = "provider", blockHandler = "blockHandlerHello")
    public String hello(@PathVariable String message) {
        System.out.println(message);
        String ce = String.format("hello %s" ,message);
        return ce;
    }

//    @SentinelResource(value = "helloWorld2", blockHandler = "blockHandlerForHelloWorld2")

    private static int c = 0;

    @GetMapping("hello")
    @SentinelResource(value = "hello", blockHandler = "blockHandlerHello")
    public String hello1(){
        System.out.println("run  hello1~");
        return "😍";
    }

    /**
     * 原方法调用被限流/降级/系统保护的时候调用
     * @param ex
     * @return
     */
    public String blockHandlerHello(BlockException ex){
        ex.printStackTrace();
        return "系统繁忙，请稍后！";
    }

    public static void main(String[] args) {
        String a = "<p><img alt=\"\" src=\"http://localhost:8028/cms/imgupload/lesson/20211215095018.jpg\" style=\"width: 512px; height: 512px;\" /></p>\n";
        int c = a.lastIndexOf("cms")+"cms".length();
        String b = a.substring(c,a.indexOf("style"));
        System.out.println(a);
        System.out.println(b);
        String album = "<p>/imgupload/lesson/20211215100555.jpg</p>";
        String coverNew = album.replaceAll("<[^>]*>","");
        System.out.println(coverNew);
    }
}
