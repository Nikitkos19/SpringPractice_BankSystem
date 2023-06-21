package com.practice.springpractice_banksystem;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.swing.*;

public class BankFrame extends JFrame {
    BankFrame() {
        JFrame frame = new JFrame("BankApplication");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
