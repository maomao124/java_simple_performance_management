package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): MainPatch
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 13:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MainPanel
{
    JFrame jFrame;
    private JTextArea jTextArea;                //文本域
    private JButton addStudent;
    private JButton deleteStudent;
    private JButton updateStudent;
    private JButton display;
    private JButton findByNo;
    private JButton findByName;
    private JButton addStudentScore;
    private JButton updateStudentScore;
    private JButton removeStudentScore;
    private JButton removeAllStudentScore;
    private JButton AverageScore;
    private JButton subject_score;


    public MainPanel()
    {
        jFrame = new JFrame("成绩管理");                //初始化顶层面板
        jFrame.setSize(1280, 720);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;       //获取屏幕宽度
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;     //获取屏幕高度
        jFrame.setLocation(screenWidth / 2 - jFrame.getWidth() / 2, screenHeight / 2 - jFrame.getHeight() / 2);  //位于屏幕中央
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        JPanel jPanel_main = new JPanel();
        JPanel jPanel_up = new JPanel();
        JPanel jPanel_down = new JPanel();
        jPanel_main.setLayout(new BorderLayout());          //构造一个新的边框布局，组件之间没有间隙

        Font font = new Font("宋体", Font.BOLD, 20);
        jTextArea = new JTextArea();
        jTextArea.setFont(font);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);       //加入滚动面板

        jPanel_main.add(jScrollPane, BorderLayout.CENTER);
        jPanel_main.add(jPanel_up, BorderLayout.NORTH);
        jPanel_main.add(jPanel_down, BorderLayout.SOUTH);
        jFrame.add(jPanel_main);

        this.initListener();                            //初始化监听器

        jFrame.setVisible(true);

    }

    /**
     * 初始化监听器
     */
    private void initListener()
    {
        jFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(1);
            }
        });
    }
}
