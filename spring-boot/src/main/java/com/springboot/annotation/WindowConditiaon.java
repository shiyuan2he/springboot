package com.springboot.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author heshiyuan
 * @author shiyuan2he
 * @description <p>继承Condition根据操作系统实例化类</p>
 * @path spring-boot/com.springboot.service.contional.impl
 * @date 2017/4/24 下午12:34
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class WindowConditiaon implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").equals("Windows");
    }
}
