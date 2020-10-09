package com.ali.edu.stackoverflow;


import org.junit.Test;

/*
 *@Author jiazhiyuan
 *@Date 2020/9/23 9:45
 *@Version 1.0
 */
public class JavaSeDemo {

   private final Integer num = 100;

   public class Inner{
       public void print(){
           System.out.println(num);
       }
   }
    @Test
    public void test(){
        //如果不是静态的内部类加载顺序，应该先加载内部类再去加载内部类，因为每次new一个对象都是在堆上面建立的，我们试着不去new JavaSeDemo
        //直接new内部类报的是不是空指针的错误。
        JavaSeDemo.Inner inner = new Inner();
        inner.print();
    }
}
