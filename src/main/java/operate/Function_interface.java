package operate;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): operate
 * Interface(接口名): Function_interface
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 22:17
 * Version(版本): 1.0
 * Description(描述)： 函数的接口
 * 参数说明：
 * long no：学号
 * String name：姓名
 * long old_no：老的学号
 * String subject：科目
 * float score：分数
 * String asc_or_desc：排序方式，asc为升序，desc为降序，此参数只能存入这两个值
 */

public interface Function_interface
{
    //添加一名学生，不包含成绩
    public boolean addStudent(long no, String name);

    //删除一名学生，这会清除学生对应的成绩
    public boolean deleteStudent(long no);

    //修改一名学生的信息，不包括成绩
    public boolean updateStudent(long no, String name, long old_no);

    //查看学生的所有信息
    public void display();

    //添加一名学生的成绩信息，如果键已经存在，则更新成绩
    public boolean addStudentScore(long no, String subject, float score);


    //修改一名学生的成绩信息
    public boolean updateStudentScore(long no, String subject, float score);

    //删除一名学生的一门科目的成绩
    public boolean removeStudentScore(long no, String subject);

    //删除一名学生的所有成绩
    public boolean removeAllStudentScore(long no);

    //查看一名学生的平均分
    public void AverageScore(long no);

    //查看某门科目的成绩，并且按升序或者降序排列
    public void subject_score(String subject, String asc_or_desc);
}
