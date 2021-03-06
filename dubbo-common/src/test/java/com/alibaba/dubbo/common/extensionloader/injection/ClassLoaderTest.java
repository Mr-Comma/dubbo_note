//package com.alibaba.dubbo.common.extensionloader.injection;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.Arrays;
//
///**
// * 一、ClassLoader加载类的顺序
// *  1.调用 findLoadedClass(String) 来检查是否已经加载类。
// *  2.在父类加载器上调用 loadClass 方法。如果父类加载器为 null，则使用虚拟机的内置类加载器。
// *  3.调用 findClass(String) 方法查找类。
// * 二、实现自己的类加载器
// *  1.获取类的class文件的字节数组
// *  2.将字节数组转换为Class类的实例
// * @author lei 2011-9-1
// */
//public class ClassLoaderTest {
//    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//        //新建一个类加载器
//        MyClassLoader cl = new MyClassLoader("myClassLoader");
//        //加载类，得到Class对象
//        Class<?> clazz = cl.loadClass("classloader.Animal");
//        //得到类的实例
//        Animal animal=(Animal) clazz.newInstance();
//        animal.say();
//    }
//}
//class Animal{
//    public void say(){
//        System.out.println("hello world!");
//    }
//}
//class MyClassLoader extends ClassLoader {
//    //类加载器的名称
//    private String name;
//    //类存放的路径
//    private String path = "E:\\workspace\\Algorithm\\src";
//    MyClassLoader(String name) {
//        this.name = name;
//    }
//    MyClassLoader(ClassLoader parent, String name) {
//        super(parent);
//        this.name = name;
//    }
//    /**
//     * 重写findClass方法
//     */
//    @Override
//    public Class<?> findClass(String name) {
//        byte[] data = loadClassData(name);
//        return this.defineClass(name, data, 0, data.length);
//    }
//    public byte[] loadClassData(String name) {
//        try {
//            name = name.replace(".", "//");
//            FileInputStream is = new FileInputStream(new File(path + name + ".class"));
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            int b = 0;
//            while ((b = is.read()) != -1) {
//                baos.write(b);
//            }
//            return baos.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//}
