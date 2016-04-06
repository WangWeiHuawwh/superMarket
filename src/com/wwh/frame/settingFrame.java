package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wwh.bean.ConfigBean;
import com.wwh.bean.ConfigImpl;
import com.wwh.utils.Application;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class settingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ConfigImpl configImpl = new ConfigImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settingFrame frame = new settingFrame();
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
	JLabel lblNewLabel_1;

	public settingFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u5F53\u524D\u5151\u6362\u6BD4\u4F8B\uFF08\u514B\u6717:\u6B27\u5143\uFF09\uFF1A");
		lblNewLabel.setBounds(38, 70, 188, 15);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("100000");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(220, 70, 93, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u8BBE\u7F6E\u6BD4\u4F8B\uFF1A");
		lblNewLabel_2.setBounds(133, 160, 78, 15);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(221, 157, 140, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 0) {
					double bili = Double.parseDouble((textField.getText().trim()));
					ConfigBean configbean = configImpl.get();
					configbean.setBili(bili);
					configImpl.update(configbean);
					init();
					textField.setText("");
					Application.bili = bili;
				}
			}
		});
		btnNewButton.setBounds(268, 246, 93, 23);
		contentPane.add(btnNewButton);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		ConfigBean configbean = configImpl.get();
		lblNewLabel_1.setText(configbean.getBili() + "");
	}
}
