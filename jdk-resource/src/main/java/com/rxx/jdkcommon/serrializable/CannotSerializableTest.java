package com.rxx.jdkcommon.serrializable;

import org.junit.Test;

import java.io.*;

/**
 * @author :zhangdan
 * @Description: 测试被 transient 或 static 修饰的属性不能被序列化
 * @Company :
 * @date :2018/4/9 17:37
 */

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password;   //被 transient 修饰的变量，不能被序列化
    private static String age;  // 被 static 修饰，不能被序列化

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        User.age = age;
    }
}

public class CannotSerializableTest {



    @Test
    public void transientaAndStaticTest2() throws IOException, ClassNotFoundException {
        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:/user.txt"));
        User userNew = (User) ois.readObject();
        ois.close();

        System.out.println("序列化后：" + userNew.getAge() + "\t" + userNew.getName() + "\t" + userNew.getPassword());
    }
     @Test
    public void transientaAndStaticTest() throws IOException, ClassNotFoundException {
        // 构建对象
        User user = new User();
        user.setAge("22");
        user.setName("小明");
        user.setPassword("admin");
        System.out.println("序列化前：" + user.getAge() + "\t" + user.getName() + "\t" + user.getPassword());

        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/user.txt"));
        oos.writeObject(user);
        oos.flush();
        oos.close();

        //在序列化后在对 static 修饰的变量进行一次赋值操作
        user.setAge("33");


    }

    /* 测试结果
    序列化前：22	小明	admin
    序列化后：33	小明	null
     */
}
