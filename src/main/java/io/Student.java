package io;

import data.student_arraylist;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): io
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/14
 * Time(创建时间)： 21:34
 * Version(版本): 1.0
 * Description(描述)： 学生的输入输出类
 */

public class Student
{
    private static final String path = "Student.dat";       //用于存放数据的文件路径

    /**
     * 把所有学生的信息写入到硬盘里
     *
     * @return boolean
     */
    public static boolean write()
    {
        boolean result = false;
        FileOutputStream fileOutputStream = null;         //文件字节流,输出
        //文件输出流是用于将数据写入File或FileDescriptor的输出流。 文件是否可用或可以创建取决于底层平台。
        // 特别是某些平台，一次只允许一个FileOutputStream （或其他文件写入对象）打开一个文件进行写入。
        ObjectOutputStream objectOutputStream = null;     //对象流，输出
        //ObjectOutputStream 将 Java 对象的原始数据类型和图形写入 OutputStream。
        // 可以使用 ObjectInputStream 读取（重构）对象。 对象的持久存储可以通过使用流的文件来实现。 如果流是网络套接字流，则可以在另一个主机或另一个进程中重构对象。
        //只有支持 java.io.Serializable 接口的对象才能写入流。 每个可序列化对象的类都经过编码，
        // 包括类的类名和签名、对象的字段和数组的值，以及从初始对象引用的任何其他对象的闭包。
        //writeObject 方法用于将对象写入流。 任何对象，包括字符串和数组，都是用 writeObject 编写的。
        // 可以将多个对象或原语写入流。 对象必须从相应的 ObjectInputstream 以与写入时相同的类型和相同的顺序读回。
        //原始数据类型也可以使用 DataOutput 中的适当方法写入流。 也可以使用 writeUTF 方法写入字符串。

        try                                  //文件流打开，文件读写
        {
            fileOutputStream = new FileOutputStream(path);              //创建管道
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //写入文件
            for (int i = 0; i < student_arraylist.getList().size(); i++)
            {
                data.Student student;
                student = student_arraylist.getList().get(i);
                objectOutputStream.writeObject(student);
            }
            result = true;
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭流
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null)
                {
                    objectOutputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 读取
     *
     * @return ArrayList<data.Student>对象
     */
    public static ArrayList<data.Student> read()
    {
        ArrayList<data.Student> list = new ArrayList<>();
        FileInputStream fileInputStream = null;
        //FileInputStream从文件系统中的文件中获取输入字节。 哪些文件可用取决于主机环境。
        ObjectInputStream objectInputStream = null;
        //ObjectInputStream 反序列化之前使用 ObjectOutputStream 编写的原始数据和对象。
        try                                  //文件流打开，文件读写
        {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            data.Student student;
            Object obj = null;
            while ((obj = objectInputStream.readObject()) != null)
            {
                student = (data.Student) obj;
                list.add(student);
            }
        }
        catch (EOFException e)          //到达末尾
        {
            return list;
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭流
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (objectInputStream != null)
                {
                    objectInputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
        return list;
    }

    //第二种方法，直接读写集合
    //// TODO: 2022/1/14
}
