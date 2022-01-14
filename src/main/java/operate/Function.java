package operate;

import data.Student;
import data.student_arraylist;

import java.awt.*;

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
     * //删除一名学生，这会清除学生对应的成绩
     * @param no 学号
     * @return boolean
     */

    @Override
    public boolean deleteStudent(long no)
    {
        //判断传入的学号是否存在

    }

    @Override
    public boolean updateStudent(long no, String name, long old_no)
    {
        return false;
    }

    @Override
    public void display()
    {

    }

    @Override
    public boolean addStudentScore(long no, String subject, float score)
    {
        return false;
    }

    @Override
    public boolean updateStudentScore(long no, String subject, float score)
    {
        return false;
    }

    @Override
    public boolean removeStudentScore(long no, String subject)
    {
        return false;
    }

    @Override
    public boolean removeAllStudentScore(long no)
    {
        return false;
    }

    @Override
    public void AverageScore(long no)
    {

    }

    @Override
    public void subject_score(String subject, String asc_or_desc)
    {

    }
}
