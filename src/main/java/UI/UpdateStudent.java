package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): UpdateStudent
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 16:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UpdateStudent
{
    JDialog jDialog;
    data.Student student;

    public UpdateStudent(data.Student student)
    {
        this.student = student;

        jDialog = new JDialog(MainPanel.jFrame, "更新学生信息");
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

        JLabel jLabel_no = new JLabel("请输入新的学生学号：");
        JLabel jLabel_name = new JLabel("请输入新的学生姓名：");
        JTextField JTextField_no = new JTextField();
        JTextField_no.setText(String.valueOf(student.getNo()));
        JTextField JTextField_name = new JTextField();
        JTextField_name.setText(student.getName());
        JButton jButton = new JButton("确定");
        jButton.setBackground(Color.cyan);

        JPanel jPanel = new JPanel();
        JPanel jPanel_no = new JPanel();
        JPanel jPanel_name = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        //jPanel_no.setLayout(new GridLayout(1, 2));
        //jPanel_name.setLayout(new GridLayout(1, 2));
        jPanel_no.setLayout(new BorderLayout());
        jPanel_name.setLayout(new BorderLayout());

        /*
        jPanel_no.add(jLabel_no);
        jPanel_no.add(JTextField_no);
        jPanel_name.add(jLabel_name);
        jPanel_name.add(JTextField_name);
         */
        jPanel_no.add(jLabel_no, BorderLayout.WEST);
        jPanel_no.add(JTextField_no, BorderLayout.CENTER);
        jPanel_name.add(jLabel_name, BorderLayout.WEST);
        jPanel_name.add(JTextField_name, BorderLayout.CENTER);
        jPanel.add(jPanel_no);
        jPanel.add(jPanel_name);
        jPanel.add(jButton);
        jDialog.add(jPanel);

        jDialog.setVisible(true);
        //jDialog.dispose();

        jButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UpdateStudent.this.addStudent(JTextField_no, JTextField_name);
            }
        });
    }

    private void addStudent(JTextField JTextField_no, JTextField JTextField_name)
    {
        long no = -1;
        String name;
        try
        {
            no = Long.parseLong(JTextField_no.getText());
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        name = JTextField_name.getText();

        if (no == -1)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号为-1！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (name == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "姓名为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (name.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "姓名为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean result = MainPanel.function.updateStudent(no, name, student.getNo());
        if (!result)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "更新失败！", "提示", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            MainPanel.jTextArea.setText(MainPanel.function.getStudentInformation());
            io.Student.write();
            jDialog.dispose();
        }
    }
}
