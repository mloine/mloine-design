package com.mloine.classLoad;

import com.sun.nio.zipfs.ZipPath;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * @author mloine
 * @title: ClassLoaderTest
 * @projectName mloine-design
 * @description: TODO
 * @date 2019/7/2322:54
 */
public class ClassLoaderTest extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //1.bootStrapClassloader  非java语言实现的类加载器
        System.out.println("顶级类的加载器："+HashMap.class.getClassLoader());

        //2.sun.misc.Launcher$ExtClassLoader@6d6f6e28  扩展类的加载器
        System.out.println("扩展的类加载器："+ ZipPath.class.getClassLoader());

        //3.自定义应用类的类加载器
        System.out.println("应用类的类加载器："+ClassLoaderTest.class.getClassLoader());


        //4.项目中可以自定义类加载器
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();

        Object o = classLoaderTest.loadClass("com.mloine.classLoad.ClassLoaderTest").newInstance();
        System.out.println("自定义类加载器："+o.getClass().getClassLoader());
        //没有打破双亲委派是相同类  打破双亲委派需要重写loadClass()
        System.out.println("类型是否相同："+(o instanceof  ClassLoaderTest));


        echo();
    }

    //打破双亲委派必须重写loadClass
    @Override
    public final Class<?>loadClass(String name)throws ClassNotFoundException{
        try{
            //获取编译后的class
            String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
            //从class中读取字节数组
            InputStream is=getClass().getResourceAsStream(fileName);
            if(is==null){
                return super.loadClass(name);
            }
            byte[]b=new byte[is.available()];
            is.read(b);
            //使用父类的方法将字节数组转换为class
            return defineClass(name,b,0,b.length);
        }catch(IOException e){
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * 打印类加载目录 和信息
     */
    public static void echo(){
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("加载目录-顶级类加载器bootStrapClassloader:"+Launcher.getLauncher().getClassLoader());
        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        URL[] urLs = bootstrapClassPath.getURLs();
        for (URL u :urLs){
            System.out.println(u.toString());
        }

        URLClassLoader extClassLoader = (URLClassLoader) ZipPath.class.getClassLoader();
        System.out.println("加载目录-扩展类加载器extClassLoader" + extClassLoader);
        URL[] urLs1 = extClassLoader.getURLs();
        for (URL u :urLs1){
            System.out.println(u.toString());
        }

        URLClassLoader appClassLoader = (URLClassLoader) ClassLoaderTest.class.getClassLoader();
        System.out.println("加载目录-应用类加载器extClassLoader" + appClassLoader);
        URL[] urLs2 = appClassLoader.getURLs();
        for (URL u :urLs2){
            System.out.println(u.toString());
        }


    }

}
