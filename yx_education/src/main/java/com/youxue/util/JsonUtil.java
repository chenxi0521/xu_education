package com.youxue.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youxue.entity.User;

import java.io.IOException;

/**
 * @author chenxi
 * @date 2021/9/7 14:44
 * @description
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj){

        String json = "";

        try {
           json =  mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static <T> T jsonToEntity(String data, Class<T> t){
        T obj = null;
        try {
           obj =  mapper.readValue(data,t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }


}
