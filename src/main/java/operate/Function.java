package operate;

import data.Student;
import data.student_arraylist;

import java.awt.*;
import java.util.*;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): operate
 * Class(类名): Function
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 22:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Function implements Function_interface
{

    /**
     * 添加一名学生，不包含成绩
     *
     * @param no   学号
     * @param name 姓名
     * @return 是否成功 boolean
     */
    @Override
    public boolean addStudent(long no, String name)
    {
        if (data.student_arraylist.getList().size() == 0)         //为空，直接插入，不用担心学号重复，因为学号为主键
        {
            Student student = new Student(no, name);
            data.student_arraylist.getList().add(student);
            return true;
        }
        //集合不为空
        //遍历集合，传入的学号是否已经存在
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号，插入失败
            {
                Toolkit.getDefaultToolkit().beep();
                return false;
            }
        }
        //没有重复的情况
        Student student = new Student(no, name);
        data.student_arraylist.getList().add(student);
        return true;
    }

    /**
     * 删除一名学生，这会清除学生对应的成绩
     *
     * @param no 学号
     * @return boolean
     */

    @Override
    public boolean deleteStudent(long no)
    {
        //判断传入的学号是否存在
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号，插入失败
            {
                data.student_arraylist.getList().remove(student);
                return true;
            }
        }
        //不存在
        return false;
    }

    /**
     * 修改一名学生的信息，不包括成绩
     *
     * @param no     学号
     * @param name   姓名
     * @param old_no 老学号
     * @return boolean
     */
    @Override
    public boolean updateStudent(long no, String name, long old_no)
    {
        //判断新学号是否和集合中的所有学号的某一个学号相同，因为学号唯一，不能占用别人的学号
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no && student.getNo() != old_no)            //找到相等的学号，不允许修改
            {
                return false;
            }
        }
        //判断老学号是否存在于集合中，如果不存在，则无法进行修改
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == old_no)            //找到相等的学号 可以进行修改
            {
                student.setNo(no);
                student.setName(name);
                return true;
            }
        }
        //没找到，则老学号对应的学生不在集合里，更新失败
        return false;
    }

    /**
     * 查看学生的所有信息
     */

    @Override
    public void display()
    {
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            System.out.println(student);
        }
    }

    /**
     * 获得学生的所有信息，返回字符串，不在控制台上打印
     *
     * @return String
     */
    @Override
    public String getStudentInformation()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            stringBuilder.append(student).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * 查找学生信息，按学号查找
     *
     * @param no 学号
     * @return data.Student对象
     */
    @Override
    public Student findByNo(long no)
    {
        Student student = null;
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student1 = data.student_arraylist.getList().get(i);
            if (student1.getNo() == no)            //找到相等的学号
            {
                student = student1;
                break;
            }
        }
        return student;
    }

    /**
     * 查找学生信息，按姓名查找
     *
     * @param name 学生姓名
     */
    @Override
    public void findByName(String name)
    {
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getName().equals(name))            //找到相等的姓名
            {
                System.out.println(student);
            }
        }
    }

    /**
     * 获得查找学生信息的结果，按姓名查找，返回字符串，不在控制台上打印
     *
     * @param name 学生姓名
     * @return 字符串
     */
    @Override
    public String getFindByName(String name)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getName().equals(name))            //找到相等的姓名
            {
                stringBuilder.append(student).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 添加一名学生的成绩信息，如果键已经存在，则更新成绩
     *
     * @param no      学号
     * @param subject 科目
     * @param score   分数
     * @return boolean
     */
    @Override
    public boolean addStudentScore(long no, String subject, float score)
    {
        //还是得找
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号
            {
                student.getMap().put(subject, score);
                return true;
            }
        }
        //没找到
        return false;
    }

    /**
     * 修改一名学生的成绩信息
     *
     * @param no      学号
     * @param subject 科目
     * @param score   分数
     * @return boolean
     */
    @Override
    public boolean updateStudentScore(long no, String subject, float score)
    {
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号
            {
                if (student.getMap().containsKey(subject))      //集合存在对应的科目，可以修改
                {
                    student.getMap().put(subject, score);
                    return true;
                }
                else            //不存在对应的科目，无法修改
                {
                    return false;
                }
            }
        }
        //没找到该学号
        return false;
    }

    /**
     * 删除一名学生的一门科目的成绩
     *
     * @param no      学号
     * @param subject 科目
     * @return boolean
     */
    @Override
    public boolean removeStudentScore(long no, String subject)
    {
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号
            {
                if (student.getMap().containsKey(subject))      //集合存在对应的科目，可以删除
                {
                    student.getMap().remove(subject);
                    return true;
                }
                else            //不存在对应的科目，无法删除
                {
                    return false;
                }
            }
        }
        //没找到该学号
        return false;
    }

    /**
     * 删除一名学生的所有成绩
     *
     * @param no 学号
     * @return boolean
     */
    @Override
    public boolean removeAllStudentScore(long no)
    {
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号
            {
                student.getMap().clear();       //清空成绩
            }
        }
        //没找到该学号
        return false;
    }

    /**
     * 获得一名学生的平均分
     *
     * @param no 学号
     * @return float类型 值为-1则表示计算失败，原因为传入的学号不存在
     */
    @Override
    public float AverageScore(long no)
    {
        float result = -1.0f;
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getNo() == no)            //找到相等的学号
            {
                float sum = 0.0f;
                for (String subject : student.getMap().keySet())
                {
                    sum = sum + student.getMap().get(subject);
                }
                result = sum / student.getMap().size();
                return result;
            }
        }
        //没找到该学号 返回-1
        return result;
    }

    /**
     * 查看某门科目的成绩，并且按升序或者降序排列，输出有三列，学号，姓名，分数
     *
     * @param subject     科目
     * @param asc_or_desc 升序或者降序
     */
    @Override
    public void subject_score(String subject, String asc_or_desc)
    {
        String str = null;
        ArrayList<Student> list = new ArrayList<>();
        //键为学生对象，值为分数
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getMap().containsKey(subject))      //集合存在对应的科目
            {
                list.add(student);
            }
        }
        if (list.size() == 0)     //空
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("科目" + subject + "无对应的数据");
            return;
        }
        //排序
        if (asc_or_desc.equals("asc") || asc_or_desc.equals("ASC"))       //升序
        {
            str = "升序";
            /*
            list.sort((stu1, stu2) ->
            {
                if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                {
                    return 1;
                }
                else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            });
             */
            list.sort(new Comparator<>()
            {
                @Override
                public int compare(Student stu1, Student stu2)
                {
                    if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                    {
                        return 1;
                    }
                    else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
        }
        else if (asc_or_desc.equals("desc") || asc_or_desc.equals("DESC"))       //降序
        {
            str = "降序";
            list.sort((stu1, stu2) ->
            {
                if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                {
                    return -1;
                }
                else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            });
            /*
            list.sort(new Comparator<Student>()
            {
                @Override
                public int compare(Student stu1, Student stu2)
                {
                    if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                    {
                        return -1;
                    }
                    else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
             */
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("排序方式只能为升序或者降序");
            return;
        }
        //开始遍历
        System.out.println("科目：" + subject + "    排序方式：" + str);
        float sumScore = 0;
        float AverageScore = 0;

        for (Student student : list)
        {
            float number = student.getMap().get(subject);
            System.out.println(student.getNo() + "\t\t" + student.getName() + "\t\t" + number);
            sumScore = sumScore + number;
        }
        AverageScore = sumScore / list.size();
        System.out.println();
        System.out.println("总数：" + list.size() + "    科目平均分：" + AverageScore);
    }

    /**
     * 获得某门科目的成绩，并且按升序或者降序排列，返回字符串,不在控制台上打印
     *
     * @param subject     科目
     * @param asc_or_desc 升序或者降序
     * @return 字符串
     */
    @Override
    public String getSubject_score(String subject, String asc_or_desc)
    {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Student> list = new ArrayList<>();
        //键为学生对象，值为分数
        for (int i = 0; i < student_arraylist.getList().size(); i++)
        {
            data.Student student = data.student_arraylist.getList().get(i);
            if (student.getMap().containsKey(subject))      //集合存在对应的科目
            {
                list.add(student);
            }
        }
        if (list.size() == 0)     //空
        {
            Toolkit.getDefaultToolkit().beep();
            stringBuilder.append("科目").append(subject).append("无对应的数据\n");
            return stringBuilder.toString();
        }
        //排序
        if (asc_or_desc.equals("asc") || asc_or_desc.equals("ASC"))       //升序
        {
            str = "升序";
            /*
            list.sort((stu1, stu2) ->
            {
                if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                {
                    return 1;
                }
                else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            });
             */
            list.sort(new Comparator<>()
            {
                @Override
                public int compare(Student stu1, Student stu2)
                {
                    if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                    {
                        return 1;
                    }
                    else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
        }
        else if (asc_or_desc.equals("desc") || asc_or_desc.equals("DESC"))       //降序
        {
            str = "降序";
            list.sort((stu1, stu2) ->
            {
                if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                {
                    return -1;
                }
                else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            });
            /*
            list.sort(new Comparator<Student>()
            {
                @Override
                public int compare(Student stu1, Student stu2)
                {
                    if (stu1.getMap().get(subject) > stu2.getMap().get(subject))
                    {
                        return -1;
                    }
                    else if (stu1.getMap().get(subject) < stu2.getMap().get(subject))
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
             */
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            stringBuilder.append("排序方式只能为升序或者降序\n");
            return null;
        }
        //开始遍历
        stringBuilder.append("科目：").append(subject).append("    排序方式：").append(str);
        stringBuilder.append("\n");
        float sumScore = 0;
        float AverageScore = 0;

        for (Student student : list)
        {
            float number = student.getMap().get(subject);
            stringBuilder.append(student.getNo()).append("\t\t").append(student.getName()).append("\t\t").append(number);
            stringBuilder.append("\n");
            sumScore = sumScore + number;
        }
        AverageScore = sumScore / list.size();
        stringBuilder.append("\n");
        stringBuilder.append("总数：").append(list.size()).append("    科目平均分：").append(AverageScore);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
