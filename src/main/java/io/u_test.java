package io;

import data.Student;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): io
 * Class(类名): u_test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 21:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class u_test
{
    public static void main(String[] args)
    {
        Student student = new Student(12, "张三");
        student.getMap().put("语文", 85.0f);
        student.getMap().put("数学", 76.0f);
        student.getMap().put("英语", 68.5f);
        System.out.println(student);

        Student student1 = new Student(14, "李四");
        student1.getMap().put("语文", 83.0f);
        student1.getMap().put("数学", 79.0f);
        student1.getMap().put("英语", 88.5f);
        System.out.println(student1);

        Student student2 = new Student(18, "王五");
        student2.getMap().put("语文", 78.0f);
        student2.getMap().put("数学", 72.0f);
        student2.getMap().put("英语", 59.5f);
        System.out.println(student2);

        data.student_arraylist.getList().add(student);
        data.student_arraylist.getList().add(student1);
        data.student_arraylist.getList().add(student2);

        System.out.println(data.student_arraylist.getList().size());

        io.Student.write();
    }
}
