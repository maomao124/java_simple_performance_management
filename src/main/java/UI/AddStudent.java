package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): AddStudent
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AddStudent
{
    public AddStudent()
    {
        JDialog jDialog = new JDialog(MainPanel.jFrame, "添加学生");
        int w = 300;
        int h = 200;
        int x = MainPanel.jFrame.getX();
        int y = MainPanel.jFrame.getY();
        //System.out.println(x+"  "+y);
        int width = MainPanel.jFrame.getWidth();
        int height = MainPanel.jFrame.getHeight();
        int Location_x = x + width / 2 - w / 2;
        int Location_y = y + height / 2 - h / 2;
        jDialog.setLocation(Location_x, Location_y);
        jDialog.setSize(w, h);

        JLabel jLabel_no = new JLabel("请输入学生学号：");
        JLabel jLabel_name = new JLabel("请输入学生姓名：");
        JTextField JTextField_no = new JTextField();
        JTextField JTextField_name = new JTextField();
        JButton jButton = new JButton("确定");
        jButton.setBackground(Color.cyan);

        JPanel jPanel = new JPanel();
        JPanel jPanel_no = new JPanel();
        JPanel jPanel_name = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        jPanel_no.setLayout(new GridLayout(1, 2));
        jPanel_name.setLayout(new GridLayout(1, 2));

        jPanel_no.add(jLabel_no);
        jPanel_no.add(JTextField_no);
        jPanel_name.add(jLabel_name);
        jPanel_name.add(JTextField_name);


        jDialog.setVisible(true);
        //jDialog.dispose();
    }
}
