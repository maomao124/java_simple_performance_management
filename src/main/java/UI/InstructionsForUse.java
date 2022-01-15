package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Project name(项目名称)：java实现简单的成绩管理
 * Package(包名): UI
 * Class(类名): InstructionsForUse
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/15
 * Time(创建时间)： 19:55
 * Version(版本): 1.0
 * Description(描述)： 使用说明
 */

public class InstructionsForUse extends JFrame
{
    public InstructionsForUse()
    {
        this.setTitle("使用说明");
        this.setSize(950, 550);
        JPanel jPanel = new JPanel();
        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        // TODO: 2022/1/15 完成使用说明
        String str = """
                使用说明：
                
                """;

        Font font = new Font("宋体", Font.BOLD, 18);
        jTextArea.setFont(font);
        jTextArea.setForeground(Color.PINK);
        //jTextArea.setBackground(new Color(0,244,125));
        jTextArea.setText(str);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        this.add(jPanel);
    }
}
