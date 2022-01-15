package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): RemoveStudentScore
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 18:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class RemoveStudentScore
{
    JDialog jDialog;

    public RemoveStudentScore()
    {
        jDialog = new JDialog(MainPanel.jFrame, "删除学生成绩");
        int w = 350;
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

        JLabel jLabel_no = new JLabel("------------请输入学生学号：");
        JLabel jLabel_subject = new JLabel("请输入要删除的学生成绩：");
        JTextField JTextField_no = new JTextField();
        JTextField JTextField_subject = new JTextField();
        JButton jButton = new JButton("确定");
        jButton.setBackground(Color.cyan);

        JPanel jPanel = new JPanel();
        JPanel jPanel_no = new JPanel();
        JPanel jPanel_subject = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        //jPanel_no.setLayout(new GridLayout(1, 2));
        //jPanel_name.setLayout(new GridLayout(1, 2));
        jPanel_no.setLayout(new BorderLayout());
        jPanel_subject.setLayout(new BorderLayout());

        /*
        jPanel_no.add(jLabel_no);
        jPanel_no.add(JTextField_no);
        jPanel_name.add(jLabel_name);
        jPanel_name.add(JTextField_name);
         */
        jPanel_no.add(jLabel_no, BorderLayout.WEST);
        jPanel_no.add(JTextField_no, BorderLayout.CENTER);
        jPanel_subject.add(jLabel_subject, BorderLayout.WEST);
        jPanel_subject.add(JTextField_subject, BorderLayout.CENTER);
        jPanel.add(jPanel_no);
        jPanel.add(jPanel_subject);
        jPanel.add(jButton);
        jDialog.add(jPanel);

        jDialog.setVisible(true);
        //jDialog.dispose();

        jButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RemoveStudentScore.this.remove(JTextField_no, JTextField_subject);
            }
        });
    }

    private void remove(JTextField JTextField_no, JTextField JTextField_subject)
    {
        long no = -1;
        String subject;
        if (JTextField_no.getText().equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
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
        subject = JTextField_subject.getText();

        if (no == -1)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号为-1！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no<0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不能为负数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (subject == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "科目信息为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (subject.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "科目信息为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
