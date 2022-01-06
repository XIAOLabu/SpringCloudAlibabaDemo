package com.cn;

import java.util.regex.Pattern;

/**
 * @Author ChenZZ
 * @Date 2022/1/4 16:03
 */
public class test {
    public static void main(String[] args) {
        /**
         * JAVA
         * 【G101-测试啊实打实: C21阿萨德/SS/DDAS、C22杀死/EDS】
         * 【G102-阿诗丹顿EASC: C501-OP是我、CX303-OP阿萨德、埃塞当前为】
         * 【C02-AD/ES/萨德: C36线上代理商/分销商】
         * 转成这个格式
         * G101:C21,C22;G102:C501-OP,CX303-OP;C02:C36;
         * 是不是只能一个个的去进行替换？0.0
         */
        String a =  "【G101-测试啊实打实: C21阿萨德/SS/DDAS、C22杀死/EDS】【G102-阿诗丹顿EASC: C501-OP是我、CX303-OP阿萨德、埃塞当前为】【C02-AD/ES/萨德: C36线上代理商/分销商】";
        String s = a.replaceAll("[\u4e00-\u9fa5]+", "");
        System.out.println(s);
        String replace = s.replace("【", "").replace("】",";");
        System.out.println(replace);
    }
}
