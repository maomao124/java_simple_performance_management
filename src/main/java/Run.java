import UI.MainPanel;
import io.ErrorLog;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): PACKAGE_NAME
 * Class(类名): Run
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 13:38
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Run
{
    public static void main(String[] args)
    {
        try
        {
            data.student_arraylist.setList(io.Student.read());  //读
            new MainPanel();
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stackTraceStr = result.toString();
            ErrorLog.write(stackTraceStr);
        }
    }
}
