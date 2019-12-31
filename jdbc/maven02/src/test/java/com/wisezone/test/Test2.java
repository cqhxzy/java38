package com.wisezone.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test2 {

    //日志Logger在哪个类中获取，getLogger时，参数就写哪个类的class。默认为ROOT
    private Logger logger = LoggerFactory.getLogger(Test2.class);

    //使用自定义Logger
    //private Logger logger = LoggerFactory.getLogger("myLogger");

    @Test
    public void test1(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
