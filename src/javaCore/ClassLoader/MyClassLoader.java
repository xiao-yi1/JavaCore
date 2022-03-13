package javaCore.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name == null || "".equals(name)) {
            throw new ClassNotFoundException();
        }
        InputStream is = null;
        try {
            String className = "/" + name.replace('.', '/') + ".class";
            System.out.println(className);
            // 在classpath路径下加载java/lang/Object.class文件
            is = getClass().getResourceAsStream(className);
            System.out.println(is);
            if (is == null) {
                throw new ClassNotFoundException();
            }
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            // 调用父类classLoader的defineClass方法
            // 将字节数组转换为Class实例
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<?> clazz = Class.forName("java.lang.Object", true, myClassLoader);
            System.out.println("自定义类加载器：" + clazz.newInstance().getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
