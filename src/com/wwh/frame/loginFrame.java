package com.wwh.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import com.wwh.utils.Application;
import com.wwh.utils.DbManager;
import com.wwh.utils.SQLiteCRUD;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class loginFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private int type = 0;
	private SQLiteCRUD sqlLite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame window = new loginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginFrame() {
		initialize();
		sqlLite = new SQLiteCRUD(new DbManager().getConnect());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(91, 82, 54, 15);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(144, 79, 196, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setBounds(91, 131, 54, 15);
		frame.getContentPane().add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(144, 128, 196, 21);
		frame.getContentPane().add(passwordField);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("\u8FDB\u8D27\u767B\u5F55");

		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(97, 175, 80, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u9500\u552E\u767B\u5F55");
		rdbtnNewRadioButton_1.setBounds(196, 175, 80, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u7BA1\u7406\u5458\u767B\u5F55");
		rdbtnNewRadioButton_2.setBounds(278, 175, 85, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		JButton btnNewButton = new JButton("\u767B\u5F55");

		btnNewButton.setBounds(247, 228, 93, 23);
		frame.getContentPane().add(btnNewButton);
		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					type = 0;
				}
			}
		});
		rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_2.setSelected(false);
					type = 1;
				}
			}
		});
		rdbtnNewRadioButton_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnNewRadioButton_2.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					type = 2;
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText().trim();
				String psw = passwordField.getText().trim();
				if (name.length() < 1 || psw.length() < 1) {
					JOptionPane.showMessageDialog(null, "用户名密码不能为空");
				}
				switch (type) {
				case 0:
					Vector<Vector<Object>> size = sqlLite.selectVector(
							"select * from user where job='buyer' and eid='" + name + "' and pwd='" + psw + "'");
					if (size.size() > 0) {
						Application.setEid(size.get(0).get(0).toString());
						// 登录成功
						buyFrame.main(null);
						frame.dispose();// 关闭本窗口
					} else {
						JOptionPane.showMessageDialog(null, "用户名密码错误");
					}
					break;
				case 1:
					Vector<Vector<Object>> size2 = sqlLite.selectVector(
							"select * from user where job='saler' and eid='" + name + "' and pwd='" + psw + "'");
					if (size2.size() > 0) {
						Application.setEid(size2.get(0).get(0).toString());
						// 登录成功
						frame.dispose();// 关闭本窗口
					} else {
						JOptionPane.showMessageDialog(null, "用户名密码错误");
					}
					break;
				case 2:
					Vector<Vector<Object>> size3 = sqlLite.selectVector(
							"select * from user where job='admin' and eid='" + name + "' and pwd='" + psw + "'");
					if (size3.size() > 0) {
						Application.setEid(size3.get(0).get(0).toString());
						// 登录成功
						frame.dispose();// 关闭本窗口
					} else {
						JOptionPane.showMessageDialog(null, "用户名密码错误");
					}
					break;
				}

			}
		});
	}
}
