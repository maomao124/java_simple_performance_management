package UI;

import operate.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    static Function function = new Function();
    static JFrame jFrame;
    static JTextArea jTextArea;                //文本域
    private JButton addStudent;
    private JButton deleteStudent;
    private JButton updateStudent;
    private JButton display;
    private JButton findByNo;
    private JButton findByName;
    private JButton globalFind;
    private JButton addStudentScore;
    private JButton updateStudentScore;
    private JButton removeStudentScore;
    private JButton removeAllStudentScore;
    private JButton AverageScore;
    private JButton subject_score;

    private FontSetting fontSetting_object = null;
    private Border border_object = null;
    private InstructionsForUse instructionsForUse_object = null;
    private About about_object = null;

    private JMenuBar jMenuBar;   //菜单栏
    private JMenu menu;
    private JMenuItem fontSetting;
    private JMenuItem borderSetting;
    private JMenuItem use;
    private JMenuItem about;


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
        JPanel jPanel_up1 = new JPanel();
        JPanel jPanel_up2 = new JPanel();
        JPanel jPanel_down = new JPanel();
        jPanel_main.setLayout(new BorderLayout());          //构造一个新的边框布局，组件之间没有间隙
        jPanel_up.setLayout(new GridLayout(2, 1));

        Font font = new Font("宋体", Font.BOLD, 20);
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setFont(font);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);       //加入滚动面板

        this.initBottom();                              //初始化按钮
        this.initListener();                            //初始化监听器

        fontSetting_object = new FontSetting(jTextArea);
        border_object = new Border(jTextArea, jScrollPane);
        instructionsForUse_object = new InstructionsForUse();
        about_object = new About();

        jMenuBar = new JMenuBar();
        menu = new JMenu("操作");

        fontSetting = new JMenuItem("字体设置");
        borderSetting = new JMenuItem("边框设置");
        use = new JMenuItem("使用说明");
        about = new JMenuItem("关于");

        fontSetting.setBackground(Color.cyan);
        borderSetting.setBackground(Color.cyan);
        use.setBackground(Color.cyan);
        about.setBackground(Color.cyan);



        jPanel_down.add(display);
        jPanel_up1.add(addStudent);
        jPanel_up1.add(deleteStudent);
        jPanel_up1.add(updateStudent);
        jPanel_up1.add(findByNo);
        jPanel_up1.add(findByName);
        jPanel_up1.add(globalFind);

        jPanel_up2.add(addStudentScore);
        jPanel_up2.add(updateStudentScore);
        jPanel_up2.add(removeStudentScore);
        jPanel_up2.add(removeAllStudentScore);
        jPanel_up2.add(AverageScore);
        jPanel_up2.add(subject_score);

        jPanel_up.add(jPanel_up1);
        jPanel_up.add(jPanel_up2);

        jPanel_main.add(jScrollPane, BorderLayout.CENTER);
        jPanel_main.add(jPanel_up, BorderLayout.NORTH);
        jPanel_main.add(jPanel_down, BorderLayout.SOUTH);
        jFrame.add(jPanel_main);

        jFrame.setVisible(true);

        jTextArea.setText(function.getStudentInformation());
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

        display.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                jTextArea.setText(function.getStudentInformation());
            }
        });

        addStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddStudent();
            }
        });

        deleteStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.delete();
            }
        });

        updateStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.update();
            }
        });

        findByNo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.findByNo();
            }
        });

        findByName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.findByName();
            }
        });

        globalFind.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Search();
            }
        });

        addStudentScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.addStudentScore();
            }
        });

        updateStudentScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.updateStudentScore();
            }
        });

        removeStudentScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RemoveStudentScore();
            }
        });

        removeAllStudentScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.removeAll();
            }
        });

        AverageScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainPanel.this.AverageScore();
            }
        });

        subject_score.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Subject_score();
            }
        });
    }

    /**
     * 初始化按钮
     */
    private void initBottom()
    {
        display = new JButton("刷新");
        addStudent = new JButton("添加");
        deleteStudent = new JButton("删除");
        updateStudent = new JButton("更新");
        findByNo = new JButton("按学号查找");
        findByName = new JButton("按姓名查找");
        globalFind = new JButton("全局查找");
        addStudentScore = new JButton("添加成绩");
        updateStudentScore = new JButton("修改成绩");
        removeStudentScore = new JButton("删除成绩");
        removeAllStudentScore = new JButton("删除全部成绩");
        AverageScore = new JButton("查看平均分");
        subject_score = new JButton("查询某科目成绩");

        display.setBackground(Color.cyan);
        addStudent.setBackground(Color.cyan);
        deleteStudent.setBackground(Color.yellow);
        updateStudent.setBackground(Color.cyan);
        findByNo.setBackground(Color.cyan);
        findByName.setBackground(Color.cyan);
        globalFind.setBackground(Color.cyan);
        addStudentScore.setBackground(Color.cyan);
        updateStudentScore.setBackground(Color.cyan);
        removeStudentScore.setBackground(Color.cyan);
        removeAllStudentScore.setBackground(Color.yellow);
        AverageScore.setBackground(Color.cyan);
        subject_score.setBackground(Color.cyan);
    }

    /**
     * 删除
     */
    private void delete()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入要删除的学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Toolkit.getDefaultToolkit().beep();
        int result = JOptionPane.showConfirmDialog(null,
                "学生信息为：\n" + student + "\n是否删除？", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == 0)
        {
            boolean result1 = function.deleteStudent(no);
            if (!result1)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            MainPanel.jTextArea.setText(MainPanel.function.getStudentInformation());
            io.Student.write();
        }
    }

    /**
     * 更新
     */
    private void update()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入要更新的旧学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new UpdateStudent(student);
    }

    /**
     * 按学号查找
     */
    private void findByNo()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入要查找的学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,
                "学生信息为：\n" + student + "\n", "查找结果", JOptionPane.INFORMATION_MESSAGE);
    }

    private void findByName()
    {
        String name_str = JOptionPane.showInputDialog(null, "请输入要查找的姓名：");
        if (name_str == null)
        {
            return;
        }
        if (name_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "姓名不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = function.getFindByName(name_str);
        if (result == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "查找结果为空!", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (result.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "查找结果为空!", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        jTextArea.setText(function.getFindByName(name_str));
    }

    /**
     * 添加学生成绩信息
     */
    private void addStudentScore()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入要添加学生信息的学生学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new AddStudentScore(student);
    }

    /**
     * 修改成绩
     */
    private void updateStudentScore()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入要修改学生信息的学生学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new UpdateStudentScore(student);
    }

    private void removeAll()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入要删除全部成绩的学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Toolkit.getDefaultToolkit().beep();
        int result = JOptionPane.showConfirmDialog(null,
                "学生信息为：\n" + student + "\n是否删除此学生的全部成绩？", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == 0)
        {
            boolean result1 = function.removeAllStudentScore(no);
            if (!result1)
            {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "成绩删除失败！", "提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            MainPanel.jTextArea.setText(MainPanel.function.getStudentInformation());
            io.Student.write();
        }
    }

    private void AverageScore()
    {
        long no;
        String no_str = JOptionPane.showInputDialog(null, "请输入学号：");
        if (no_str == null)
        {
            return;
        }
        if (no_str.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "学号不能为空!", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            no = Long.parseLong(no_str);
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是long型！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (no < 0)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "输入的学号不是正数！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        data.Student student = function.findByNo(no);
        if (student == null)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "此学生不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float average = function.AverageScore(no);
        JOptionPane.showMessageDialog(null, "学号：" + no + ",姓名："
                + student.getName() + " 的平均分为：" + average, "提示", JOptionPane.INFORMATION_MESSAGE);
    }
}
