package data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): PACKAGE_NAME
 * Class(类名): data.Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： 学生的数据类
 */

public class Student implements Serializable  //实现序列化接口
{
    private long no;            //学号，主键，不能重复，不能为负数
    private String name;        //名字
    private HashMap<String, Float> map;  //map集合，典型的的一对多关系，一个学生有多个成绩
    //键为具体科目的名称，值为分数，分数不能为负数，最高分未知，这里不加限制
    //Map接口的基于哈希表的实现。 此实现提供了所有可选的映射操作，并允许null值和null键。
    // （ HashMap类大致相当于Hashtable ，除了它是不同步的并且允许空值。）这个类不保证映射的顺序；
    // 特别是，它不保证订单会随着时间的推移保持不变。
    //此实现为基本操作（ get和put ）提供恒定时间性能，假设散列函数在桶中正确分散元素。
    // 迭代集合视图需要的时间与HashMap实例的“容量”（桶的数量）加上它的大小（键值映射的数量）成正比。
    // 因此，如果迭代性能很重要，则不要将初始容量设置得太高（或负载因子太低），这一点非常重要。
    //HashMap的实例有两个影响其性能的参数：初始容量和负载因子。 容量是哈希表中的桶数，初始容量就是哈希表创建时的容量。
    // 负载因子是衡量哈希表在其容量自动增加之前允许达到多满的指标。
    // 当哈希表中的条目数超过负载因子和当前容量的乘积时，重新哈希表（即重建内部数据结构），使哈希表具有大约两倍的桶数。


    //构造函数
    public Student()
    {
        map = new HashMap<>();
    }

    public Student(long no, String name)
    {
        if (no >= 0)
        {
            this.no = no;
        }
        else
        {
            this.no = 0;
        }
        this.name = name;
        map = new HashMap<>();
    }

    //getter和setter方法
    public long getNo()
    {
        return no;
    }

    public void setNo(long no)
    {
        if (no >= 0)
        {
            this.no = no;
        }
        else
        {
            this.no = 0;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public HashMap<String, Float> getMap()
    {
        return map;
    }

    public void setMap(HashMap<String, Float> map)
    {
        this.map = map;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)    //引用同一个对象
        {
            return true;
        }
        if (o == null)    //检测obj是否为null
        {
            return false;
        }
        //if(!(otherObject instanceof ClassName)) //如果所有的子类都拥有统一的语义
        if (this.getClass() != o.getClass())   //比较this与obj是否属于同一个类
        {
            return false;
        }
        //Object类向下转型
        Student student = (Student) o;

        if (no != student.no)
        {
            return false;
        }
        if (!name.equals(student.name))
        {
            return false;
        }
        return map.equals(student.map);
    }

    @Override
    public int hashCode()     //序列化和反序列化的序列码
    {
        int result = (int) (no ^ (no >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + map.hashCode();
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("学号：").append(no).append("      ");
        stringbuilder.append("姓名：").append(name).append('\n');
        stringbuilder.append("分数：").append(map).append('\n');
        return stringbuilder.toString();
    }
}
