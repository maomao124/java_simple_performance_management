package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): About
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 19:56
 * Version(版本): 1.0
 * Description(描述)： 关于面板
 */

public class About extends JFrame
{
    public static ImageIcon createImageIcon(String path)
    {
        URL imgURL = MainPanel.class.getResource(path);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("文件未找到: " + path);
            return null;
        }
    }

    public About()
    {
        this.setSize(335, 480);
        int x = MainPanel.jFrame.getX();
        int y = MainPanel.jFrame.getY();
        int width = MainPanel.jFrame.getWidth();
        int height = MainPanel.jFrame.getHeight();
        int search_x = x + width / 2 - 500 / 2;
        int search_y = y + height / 2 - 150 / 2;
        this.setLocation(search_x, search_y);                       //确保位于主面板的中央
        this.setTitle("关于");
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 5, 10, 5));
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(10, 5, 10, 5));
        panel.setLayout(new GridLayout(7, 1));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 0));
        JLabel label1 = new JLabel("作者：mao");
        label1.setHorizontalAlignment(0);
        JLabel label2 = new JLabel("完成时间：2022-01-15");
        label2.setHorizontalAlignment(0);
        JLabel label5 = new JLabel("最近更新：2022-01-15");
        label5.setHorizontalAlignment(0);
        JLabel label9 = new JLabel("git提交次数：?次");
        label9.setHorizontalAlignment(0);
        JLabel label3 = new JLabel("GitHub：https://github.com/maomao124/");
        JLabel label6 = new JLabel("远程仓库名：");
        JLabel label7 = new JLabel("java_simple_performance_management");
        JLabel label8 = new JLabel("GitHub网址二维码");

        label6.setHorizontalAlignment(0);
        label7.setHorizontalAlignment(0);
        label3.setHorizontalAlignment(0);
        label8.setHorizontalAlignment(0);
        ImageIcon icon = createImageIcon("二维码.png");            //获得图片资源
        JLabel label4 = new JLabel(icon);
        panel.add(label1);
        panel.add(label2);
        panel.add(label5);
        panel.add(label9);
        panel.add(label3);
        panel.add(label6);
        panel.add(label7);
        panel1.add(label4);
        panel1.add(label8);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(panel, BorderLayout.NORTH);
        panel2.add(panel1, BorderLayout.CENTER);
        this.add(panel2);
    }
}
