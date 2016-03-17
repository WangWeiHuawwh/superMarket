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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

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
		frame.getContentPane().setBackground(Color.PINK);
		frame.setTitle("\u767B\u5F55");
		frame.setBounds(100, 100, 511, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
//        Rectangle bounds = new Rectangle(screenSize);  
//        frame.setBounds(bounds);  

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
		//rdbtnNewRadioButton.setBackground(new Color(0,0,0,Color.TRANSLUCENT));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(97, 175, 80, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u9500\u552E\u767B\u5F55");
		//rdbtnNewRadioButton_1.setBackground(new Color(0,0,0,Color.TRANSLUCENT));
		rdbtnNewRadioButton_1.setBounds(179, 175, 80, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u7BA1\u7406\u5458\u767B\u5F55");
		//rdbtnNewRadioButton_2.setBackground(new Color(0,0,0,Color.TRANSLUCENT));
		rdbtnNewRadioButton_2.setBounds(261, 175, 100, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		JButton btnNewButton = new JButton("\u767B\u5F55");

		btnNewButton.setBounds(247, 228, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblenter = new JLabel("\u6807\u7B7E\u524D\u5E26*\u7684\u90FD\u53EF\u4EE5\u5728\u8F93\u5165\u5B8C\u6210\u540E\u6309enter\u952E");
		lblenter.setForeground(Color.GRAY);
		lblenter.setFont(new Font("����", Font.BOLD, 11));
		lblenter.setBounds(117, 37, 302, 15);
		frame.getContentPane().add(lblenter);
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
					JOptionPane.showMessageDialog(null, "�û������벻��Ϊ��");
				}
				switch (type) {
				case 0:
					Vector<Vector<Object>> size = sqlLite.selectVector(
							"select * from user where job='buyer' and eid='" + name + "' and pwd='" + psw + "'");
					if (size.size() > 0) {
						Application.setEid(size.get(0).get(0).toString());
						// ��¼�ɹ�
						buyFrame.main(null);
						frame.dispose();// �رձ�����
					} else {
						JOptionPane.showMessageDialog(null, "�û����������");
					}
					break;
				case 1:
					Vector<Vector<Object>> size2 = sqlLite.selectVector(
							"select * from user where job='saler' and eid='" + name + "' and pwd='" + psw + "'");
					if (size2.size() > 0) {
						Application.setEid(size2.get(0).get(0).toString());
						// ��¼�ɹ�
						// ��¼�ɹ�
						saleFrame.main(null);
						frame.dispose();// �رձ�����
					} else {
						JOptionPane.showMessageDialog(null, "�û����������");
					}
					break;
				case 2:
					Vector<Vector<Object>> size3 = sqlLite.selectVector(
							"select * from user where job='admin' and eid='" + name + "' and pwd='" + psw + "'");
					if (size3.size() > 0) {
						Application.setEid(size3.get(0).get(0).toString());
						// ��¼�ɹ�
						adminFrame.main(null);
						frame.dispose();// �رձ�����
					} else {
						JOptionPane.showMessageDialog(null, "�û����������");
					}
					break;
				}

			}
		});
	}
}
