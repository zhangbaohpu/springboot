package com.zhangbaohpu.springboot.config;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import java.util.Random;

/**
 * @author zhangbaohpu
 * @date 2022/12/6 18:37
 * @desc
 */
public class CustomIdGenerator implements IdentifierGenerator {

    private final char[] arrays = {
            '0','1','2','3','4','5','6','7','8','9'
            ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
            ,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };

    private final Random random = new Random();

    @Override
    public boolean assignId(Object idValue) {
        return IdentifierGenerator.super.assignId(idValue);
    }

    @Override
    public Number nextId(Object entity) {
        long ops =  0L;
        for (int i = 0; i < 18; i++) {
            int tmp = random.nextInt(9)+1;
            ops = ops * 10 + tmp;
        }
        return ops;
    }

    @Override
    public String nextUUID(Object entity) {
//        StringBuffer buffer = new StringBuffer();
//        String name = entity.getClass().getSimpleName().toLowerCase();
//        buffer.append(name).append("-");
//        for (int i = 0; i < 9; i++) {
//            buffer.append(arrays[random.nextInt(52) + 10]);
//            buffer.append(arrays[random.nextInt(10)]);
//        }
//        return buffer.toString();
        return IdUtil.simpleUUID();
    }

    public static void main(String[] args) {
        System.out.println(IdUtil.simpleUUID());
        System.out.println(UUID.fastUUID());
        System.out.println(UUID.randomUUID().toString(true));
        System.out.println(UUID.randomUUID(true));
        System.out.println(UUID.randomUUID(false));
    }

}
