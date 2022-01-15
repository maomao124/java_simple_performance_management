package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): Subject_score
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 19:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Subject_score
{
    JDialog jDialog;

    public Subject_score()
    {
        jDialog = new JDialog(MainPanel.jFrame, "查询某科目成绩");
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

        JLabel jLabel_subject = new JLabel("请输入科目信息：");
        JLabel jLabel_asc_or_desc = new JLabel("请输入排序方式：");
        JTextField JTextField_subject = new JTextField();
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("升序");
        jComboBox.addItem("降序");
        JButton jButton = new JButton("确定");
        jButton.setBackground(Color.cyan);

        JPanel jPanel = new JPanel();
        JPanel jPanel_subject = new JPanel();
        JPanel jPanel_asc_or_desc = new JPanel();
        JPanel jPanel1 = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        //jPanel_no.setLayout(new GridLayout(1, 2));
        //jPanel_name.setLayout(new GridLayout(1, 2));
        jPanel_subject.setLayout(new BorderLayout());
        jPanel_asc_or_desc.setLayout(new BorderLayout());

        /*
        jPanel_no.add(jLabel_no);
        jPanel_no.add(JTextField_no);
        jPanel_name.add(jLabel_name);
        jPanel_name.add(JTextField_name);
         */
        jPanel1.add(jComboBox);
        jPanel_subject.add(jLabel_subject, BorderLayout.WEST);
        jPanel_subject.add(JTextField_subject, BorderLayout.CENTER);
        jPanel_asc_or_desc.add(jLabel_asc_or_desc, BorderLayout.WEST);
        jPanel_asc_or_desc.add(jPanel1, BorderLayout.CENTER);
        jPanel.add(jPanel_subject);
        jPanel.add(jPanel_asc_or_desc);
        jPanel.add(jButton);
        jDialog.add(jPanel);

        jDialog.setVisible(true);
        //jDialog.dispose();

        jButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Subject_score.this.display(JTextField_subject, jComboBox);
            }
        });
    }

    private void display(JTextField JTextField_subject, JComboBox<String> jComboBox)
    {
        //System.out.println(JTextField_subject.getText());
        //System.out.println(jComboBox.getSelectedItem());
        if (JTextField_subject.getText() == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的科目信息不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (JTextField_subject.getText().equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的科目信息不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Objects.equals(jComboBox.getSelectedItem(), ""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "异常！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String asc_or_desc;
        if (Objects.equals(jComboBox.getSelectedItem(), "升序"))
        {
            asc_or_desc = "asc";
        }
        else if (Objects.equals(jComboBox.getSelectedItem(), "降序"))
        {
            asc_or_desc = "desc";
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "异常！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //System.out.println(asc_or_desc);
        MainPanel.jTextArea.setText(MainPanel.function.getSubject_score(JTextField_subject.getText(), asc_or_desc));
        jDialog.dispose();
    }
}
