package UI;

import data.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): UpdateStudentScore
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 18:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UpdateStudentScore
{
    JDialog jDialog;
    data.Student student;

    public UpdateStudentScore(Student student)
    {
        this.student = student;

        jDialog = new JDialog(MainPanel.jFrame, "修改学生\"" + student.getName() + "\"的成绩");
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

        JLabel jLabel_subject = new JLabel("请输入科目：");
        JLabel jLabel_score = new JLabel("请输入分数：");
        JTextField JTextField_subject = new JTextField();
        JTextField JTextField_score = new JTextField();
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
        jPanel_no.add(jLabel_subject, BorderLayout.WEST);
        jPanel_no.add(JTextField_subject, BorderLayout.CENTER);
        jPanel_name.add(jLabel_score, BorderLayout.WEST);
        jPanel_name.add(JTextField_score, BorderLayout.CENTER);
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
                UpdateStudentScore.this.update(JTextField_subject, JTextField_score);
            }
        });
    }

    private void update(JTextField JTextField_subject, JTextField JTextField_score)
    {
        String subject;
        float score;
        try
        {
            score = Float.parseFloat(JTextField_score.getText());
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的分数不是float型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        subject = JTextField_subject.getText();
        if (score < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的分数不能为负数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean result = MainPanel.function.updateStudentScore(student.getNo(), subject, score);
        if (!result)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "成绩修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            JTextField_subject.setText("");
            JTextField_score.setText("");
            MainPanel.jTextArea.setText(MainPanel.function.getStudentInformation());
            io.Student.write();
        }
    }
}
