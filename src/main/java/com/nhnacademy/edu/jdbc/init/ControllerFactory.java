package com.nhnacademy.edu.jdbc.init;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 05/04/2023
 */

@Slf4j
public class ControllerFactory  {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c){
        //repository 초기화
        for (Class<?> clazz : c) {
            try {
                log.error("controller:{}",clazz.getSimpleName());
                Annotation[] annotations = clazz.getAnnotations();
                if(annotations.length>0) {
                    String annotation = annotations[0].toString();
                    log.error("annotation:{}", annotation);
                    if (isController(annotation)) {
                        //@Controller
                        String method = getMethod(annotation);
                        String path = getPath(annotation);
                        String key = keyGen(method,path);
                        log.error("method:{}",method);
                        log.error("path:{}",path);
                        log.error("key:{}",key);

                        //생성
                        Object command = clazz.getDeclaredConstructor().newInstance();
                        Constructor[] constructors = clazz.getDeclaredConstructors();

                        beanMap.put(key, command);
                    }
                }
            }catch (Exception e){
                log.error("Command creation error:{}",e);
            }
        }//end for

    }

    public Object getBean(String method, String path){
        String key = keyGen(method,path);
        if(!beanMap.containsKey(key)){
            throw new RuntimeException("url not found");
        }
        Object bean = beanMap.get(key);
        return bean;
    }

    private String keyGen(String method, String path){
        return method + "-" + path;
    }

    private boolean isController(String s){
        return s.contains("RequestMapping");
    }
    private String getMethod(String s){
        s.indexOf("method=");
        return s.substring(s.indexOf("method=")+7, s.indexOf(","));
    }

    private String getPath(String s){
        return s.substring(s.indexOf("value=")+7, s.length()-2);
    }

    //파라미터 개수가 가장 많은 생성자를 결정
    private Constructor resolveConstructor(Constructor[] constructors){
        Constructor result = null;
        for(Constructor constructor : constructors){
           if(Objects.isNull(result)){
               result = constructor;
           }else{
               if(result.getParameters().length < constructor.getParameters().length){
                   result = constructor;
               }
           }
        }
        return result;
    }
}
