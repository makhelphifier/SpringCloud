package com.example.provider.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

/**
 * Created by cheney on 2017/6/15.
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    private String port;

    private BigInteger count =new BigInteger("0");

    private BigInteger one =new BigInteger("1");






    @GetMapping("")
    public JSONObject hello(String name,@Nullable HttpServletRequest request ) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("random11", RandomStringUtils.randomAlphabetic(16));
        if (StringUtils.isNotBlank(name)) {
            jsonObject.put("welcome", "hello, " + name + "!");
        }


        count=count.add(one);

        jsonObject.put("Current Provider Server",request.getHeader("host"));
        jsonObject.put("Your IP ",request.getRemoteAddr());
        jsonObject.put("Used Times",count);
//        logger.info(request.getHeader("host"));
//        logger.info(request.getRemoteAddr());
//        logger.info(request.getRemoteHost());
//        logger.info(request.getRemoteHost());
//        logger.info(request.getLocalAddr());
//        jsonObject.put("welcome1", "1");
//        jsonObject.put("welcome6", "6");
        logger.info("result msg: {}", jsonObject.toJSONString());
        return jsonObject;
    }

}
