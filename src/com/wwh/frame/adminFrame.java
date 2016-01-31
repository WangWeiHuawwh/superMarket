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
		setBounds(100, 100, 450, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u8FDB\u8D27\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buyFrame.main(null);
				frame.dispose();// 关闭本窗口
			}
		});
		button.setBounds(33, 38, 93, 23);
		contentPane.add(button);

		JButton btnNewButton = new JButton("\u9500\u552E\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleFrame.main(null);
				frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton.setBounds(148, 38, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u5458\u5DE5\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.main(null);
				frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_1.setBounds(264, 38, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("\u4F1A\u5458\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vipFrame.main(null);
				frame.dispose();// 关闭本窗口
			}
		});
		button_1.setBounds(33, 90, 93, 23);
		contentPane.add(button_1);

		JButton btnNewButton_2 = new JButton("\u9000\u8D27\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnFrame.main(null);
				frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_2.setBounds(148, 90, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeFrame.main(null);
				frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_3.setBounds(264, 90, 93, 23);
		contentPane.add(btnNewButton_3);
	}

}
