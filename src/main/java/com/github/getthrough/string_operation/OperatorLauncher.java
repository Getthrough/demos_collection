package com.github.getthrough.string_operation;


import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 启动 getLongestSymmetricalString 方法使用的 UI 界面类
 *
 * @author getthrough
 * @date 2020-02-05
 */
public class OperatorLauncher extends JFrame {

    public static void main(String[] args) {
        OperatorLauncher ol = new OperatorLauncher("计算最长对称字符串");
        ol.setVisible(true);
        ol.setSize(500, 500);
        ol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ol.setResizable(false);

        JLabel lb1 = new JLabel("要求：");
        JLabel lb2 = new JLabel("在下面的文本框中输入原始字符串");
        JLabel lb3 = new JLabel("最长对称字符串为");

        JButton btn1 = new JButton("计算");
        JButton btn2 = new JButton("清除");

        JTextArea ta1 = new JTextArea(
                "输入一个字符串s，我们可以删除字符串s中的任意字符，让剩下的字符串形成一个对称字符串，且该字符串为最长对称" +
                        "字符串。如：输入google，则找到最长对称字符串为goog；如输入abcda则能找到3个最长对称字符串为" +
                        "aba/aca/ada。若最长对称字符串存在多个，则输出多个相同长度的最长对称字符串，且字符串中不包含特殊字符。",
                5, 30
        );
        ta1.setLineWrap(true);
        ta1.setEditable(false);
        ta1.setAutoscrolls(true);

        JTextField tf1 = new JTextField(30);
        JTextArea ta2 = new JTextArea(5, 30);
        ta2.setEditable(false);

        GroupLayout layout = new GroupLayout(ol.getContentPane());
        ol.getContentPane().setLayout(layout);

        btn1.addActionListener((event) -> {
            String text = tf1.getText();
            List<String> symmetricalString = StringOperator.getLongestSymmetricalString(text);
            ta2.setText(symmetricalString.toString());
        });

        btn2.addActionListener((event) -> {
            tf1.setText("");
            ta2.setText("");
            tf1.grabFocus();
        });

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup().addComponent(lb1).addComponent(ta1).addComponent(lb2)
                .addComponent(tf1).addComponent(btn1).addComponent(btn2).addComponent(lb3).addComponent(ta2));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(lb1));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(ta1));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(lb2));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(tf1));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(btn1));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(btn2));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(lb3));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(ta2));

        layout.setVerticalGroup(vGroup);

    }

    public OperatorLauncher(String title) throws HeadlessException {
        super(title);
    }
}
