package data;

import java.util.ArrayList;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): data
 * Class(类名): student_arraylist
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 21:31
 * Version(版本): 1.0
 * Description(描述)： 此类存放学生数组
 */

public class student_arraylist
{
    private static ArrayList<Student> list = new ArrayList<>(); //确保不为空指针异常
    //List接口的可调整大小的数组实现。 实现所有可选的列表操作，并允许所有元素，包括null 。

    public static ArrayList<Student> getList()
    {
        return list;
    }

    public static void setList(ArrayList<Student> list)
    {
        student_arraylist.list = list;
    }
}
