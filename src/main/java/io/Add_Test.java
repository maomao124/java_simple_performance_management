package io;

import data.Student;

import java.util.Random;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): io
 * Class(类名): Add_Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 20:39
 * Version(版本): 1.0
 * Description(描述)： 数据插入测试
 */

@SuppressWarnings("all")
public class Add_Test
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args)
    {
        //赵钱孙李，周吴郑王。
        //冯陈褚卫，蒋沈韩杨。
        //朱秦尤许，何吕施张。
        //孔曹严华，金魏陶姜。
        //戚谢邹喻，柏水窦章。
        //云苏潘葛，奚范彭郎。
        //鲁韦昌马，苗凤花方。
        //俞任袁柳，酆鲍史唐。
        //费廉岑薛，雷贺倪汤。
        //滕殷罗毕，郝邬安常。
        //乐于时傅，皮卞齐康。
        //伍余元卜，顾孟平黄。
        //和穆萧尹，姚邵湛汪。
        //祁毛禹狄，米贝明臧。
        //计伏成戴，谈宋茅庞。
        //熊纪舒屈，项祝董梁。
        //杜阮蓝闵，席季麻强。
        //贾路娄危，江童颜郭。
        //梅盛林刁，钟徐邱骆。
        //高夏蔡田，樊胡凌霍。
        //虞万支柯，昝管卢莫。
        //经房裘缪，干解应宗。
        //丁宣贲邓，郁单杭洪。

        //包诸左石，崔吉钮龚。
        //程嵇邢滑，裴陆荣翁。
        //荀羊於惠，甄曲家封。
        //芮羿储靳，汲邴糜松。
        //井段富巫，乌焦巴弓。
        //牧隗山谷，车侯宓蓬。
        //全郗班仰，秋仲伊宫。
        //宁仇栾暴，甘钭厉戎。
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        char[] lastName = {'赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯',
                '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张'};
        String name_str = "戚谢邹喻柏水窦章费廉岑薛雷贺倪汤伍余元卜顾孟平黄计伏成戴谈宋茅" +
                "庞杜阮蓝闵席季麻强丁宣贲邓郁单杭洪经房裘缪干解应宗虞万支柯昝管卢莫赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨高夏蔡田樊胡凌霍" +
                "包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠，甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎";

        String[] subject = {"语文", "数学", "英语", "化学", "物理", "生物", "政治", "历史", "地理"};
        System.out.println(lastName.length);
        System.out.println(name_str.length());
        {
            String name = String.valueOf(lastName[getIntRandom(0, lastName.length - 1)]);
            String name1 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            String name2 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            System.out.print(name);
            System.out.print(name1);
            System.out.println(name2);
            String final_name = name + name1 + name2;
            System.out.println(final_name);
        }

        for (long i = 0; i < 1000; i++)
        {
            long no = i + 201813032500L;
            String name = String.valueOf(lastName[getIntRandom(0, lastName.length - 1)]);
            String name1 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            String name2 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            String final_name = name + name1 + name2;
            data.Student student = new Student(no, final_name);
            for (int j = 0; j < subject.length; j++)
            {
                int r = getIntRandom(1, 10);
                if (r >= 4)                            //概率输入成绩 概率：7/10
                {
                    float score = getIntRandom(40, 100);
                    int result = getIntRandom(0, 1);
                    if (result == 1)
                    {
                        score = score + 0.5f;
                        if (score > 100)
                        {
                            score = 100f;
                        }
                    }
                    student.getMap().put(subject[j], score);
                }
            }
            data.student_arraylist.getList().add(student);
        }
        //System.out.println(data.student_arraylist.getList());
        io.Student.write();
        System.out.println();


        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
