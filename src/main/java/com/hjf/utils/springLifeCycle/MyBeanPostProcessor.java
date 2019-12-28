package com.hjf.utils.springLifeCycle;

import org.springframework.beans.BeansException;  
import org.springframework.beans.factory.config.BeanPostProcessor;  
  
public class MyBeanPostProcessor implements BeanPostProcessor {  
  
    public MyBeanPostProcessor() {  
       super();  
       System.out.println("3,这是BeanPostProcessor实现类构造器！！");           
   }  
 
    @Override  
    public Object postProcessBeforeInitialization(Object arg, String str)  
            throws BeansException {  
        System.out.println("11,BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");  
        return arg;  
    }  
    
   @Override  
   public Object postProcessAfterInitialization(Object arg, String str)  
           throws BeansException {  
       System.out.println("14,BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");  
       return arg;  
   }  
 
}  