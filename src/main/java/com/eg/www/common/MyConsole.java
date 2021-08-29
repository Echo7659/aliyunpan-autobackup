package com.eg.www.common;

import javax.swing.*;
import java.awt.*;

/**
 * Description: 模拟控制台类
 * Author: Eg
 * Date: 2021/08/29
 */
public class MyConsole extends JTextArea {
    public MyConsole() {
        this.setForeground(Color.white);
        this.setBackground(Color.BLACK);
        //启动自动换行
        this.setLineWrap(true);
        //换行不断字
        this.setWrapStyleWord(true);
        this.setVisible(true);
    }
}
