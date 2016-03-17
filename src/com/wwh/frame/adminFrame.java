package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static adminFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new adminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminFrame() {
		setTitle("\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u8FDB\u8D27\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buyFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		button.setBounds(33, 38, 93, 23);
		contentPane.add(button);

		JButton btnNewButton = new JButton("\u9500\u552E\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton.setBounds(210, 38, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u5458\u5DE5\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_1.setBounds(403, 38, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("\u4F1A\u5458\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vipFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		button_1.setBounds(33, 133, 93, 23);
		contentPane.add(button_1);

		JButton btnNewButton_2 = new JButton("\u9000\u8D27\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_2.setBounds(210, 133, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_3.setBounds(403, 133, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u62A5\u8868\u7EDF\u8BA1");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caculateFrame.main(null);
			}
		});
		btnNewButton_4.setBounds(403, 215, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JButton button_2 = new JButton("\u9500\u552E\u8BB0\u5F55");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saleRecordFrame.main(null);
				//frame.dispose();// 关闭本窗口
			}
		});
		button_2.setBounds(33, 215, 93, 23);
		contentPane.add(button_2);
		
		JButton btnNewButton_5 = new JButton("\u6C47\u7387\u8BBE\u7F6E");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingFrame.main(null);
			}
		});
		btnNewButton_5.setBounds(210, 215, 93, 23);
		contentPane.add(btnNewButton_5);
	}
}
