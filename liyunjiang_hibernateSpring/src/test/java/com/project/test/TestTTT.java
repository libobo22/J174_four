package com.project.test;

import com.project.entity.UserEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

public class TestTTT<T> {
    private Class<T> clazz;
    public Class getRealType(){
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        return clazz;
    }
    public static void main(String[] args) {
        TypeVariable[] parameters = TestTTT.class.getTypeParameters();
        for (TypeVariable typeVariable : parameters) {
            System.out.println(typeVariable);
        }
    }
}
