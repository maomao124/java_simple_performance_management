package io;


import operate.Function;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): io
 * Class(类名): u_test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 22:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class u_test1
{
    public static void main(String[] args)
    {
        data.student_arraylist.setList(io.Student.read());
        System.out.println(data.student_arraylist.getList().size());
        for (data.Student student : data.student_arraylist.getList())
        {
            System.out.println(student);
        }
        Function function=new Function();
        function.subject_score("语文","desc");
    }
}
