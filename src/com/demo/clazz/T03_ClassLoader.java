package com.demo.clazz;

public class T03_ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader c1 = ClassLoader.getSystemClassLoader();

        // 扩展类加载器
        ClassLoader c2 = c1.getParent();

        // 根加载器（C/C++）
        ClassLoader c3 = c2.getParent();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // 测试当前类的加载器
        ClassLoader c4 = Class.forName("java.lang.Object").getClassLoader();
        ClassLoader c5 = T03_ClassLoader.class.getClassLoader();
        System.out.println(c4);
        System.out.println(c5);

        // 获取加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        D:\Programs\Java\jdk1.8.0_281\jre\lib\charsets.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\deploy.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\access-bridge-64.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\cldrdata.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\dnsns.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\jaccess.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\jfxrt.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\localedata.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\nashorn.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\sunec.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\sunjce_provider.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\sunmscapi.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\sunpkcs11.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\ext\zipfs.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\javaws.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\jce.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\jfr.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\jfxswt.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\jsse.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\management-agent.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\plugin.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\resources.jar;
        D:\Programs\Java\jdk1.8.0_281\jre\lib\rt.jar;
        D:\Repos\local\java-demo\java-expert\target\classes;
        D:\Programs\JetBrains\IntelliJ IDEA 2020.3.2\lib\idea_rt.jar
         */
    }
}
