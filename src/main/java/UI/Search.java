package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): Search
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 17:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Search
{
    private static int start = 0;                                            // 查找开始位置
    private static int end = 0;                                              // 查找结束位置

    public Search()
    {
        // 查找对话框
        JDialog jDialog_search = new JDialog(MainPanel.jFrame, "全局查找");
        jDialog_search.setSize(500, 150);
        int x = MainPanel.jFrame.getX();
        int y = MainPanel.jFrame.getY();
        //System.out.println(x+"  "+y);
        int width = MainPanel.jFrame.getWidth();
        int height = MainPanel.jFrame.getHeight();
        int search_x = x + width / 2 - 500 / 2;
        int search_y = y + height / 2 - 150 / 2;
        jDialog_search.setLocation(search_x, search_y);
        JLabel label_search = new JLabel("查找的内容");
        label_search.setFont(new Font("宋体", Font.BOLD, 15));
        final JTextField textField_search = new JTextField(10);
        JButton buttonFind = new JButton("查找下一个");
        buttonFind.setBackground(Color.cyan);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(label_search);
        panel2.add(buttonFind);
        panel1.add(panel, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(textField_search, BorderLayout.CENTER);
        jDialog_search.add(panel1);
        jDialog_search.setVisible(true);

        // 查找下一个按钮监听器
        buttonFind.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String findText = textField_search.getText();       // 查找的字符串
                String textArea = MainPanel.jTextArea.getText();              // 当前文本框的内容
                start = textArea.indexOf(findText, end);
                end = start + findText.length();
                // 没有找到
                if (start == -1)
                {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null,
                            "已经到达文档尾部", "提示", JOptionPane.WARNING_MESSAGE);
                    MainPanel.jTextArea.select(start, end);
                    start = 0;
                    end = 0;
                }
                else                                                //找到了
                {
                    MainPanel.jTextArea.requestFocus();     //请求此Component获取输入焦点
                    MainPanel.jTextArea.select(start, end);
                }
            }
        });
    }
}
