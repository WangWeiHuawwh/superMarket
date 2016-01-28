package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wwh.bean.VipBean;
import com.wwh.bean.VipImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vipFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JTextField text_phone;
	private JTextField text_add;
	private JTextField text_score;
	private VipImpl vipImpl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vipFrame frame = new vipFrame();
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
	public vipFrame() {
		vipImpl = new VipImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel name_label = new JLabel("\u59D3\u540D:");
		name_label.setBounds(29, 138, 54, 15);
		contentPane.add(name_label);

		text_name = new JTextField();
		text_name.setBounds(74, 135, 111, 21);
		contentPane.add(text_name);
		text_name.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel.setBounds(29, 75, 54, 15);
		contentPane.add(lblNewLabel);

		text_phone = new JTextField();
		text_phone.setBounds(74, 72, 109, 21);
		contentPane.add(text_phone);
		text_phone.setColumns(10);

		JLabel label = new JLabel("\u5730\u5740\uFF1A");
		label.setBounds(29, 203, 54, 15);
		contentPane.add(label);

		text_add = new JTextField();
		text_add.setBounds(74, 200, 111, 21);
		contentPane.add(text_add);
		text_add.setColumns(10);

		JLabel label_1 = new JLabel("\u79EF\u5206\uFF1A");
		label_1.setBounds(29, 260, 54, 15);
		contentPane.add(label_1);

		text_score = new JTextField();
		text_score.setBounds(74, 257, 111, 21);
		contentPane.add(text_score);
		text_score.setColumns(10);

		JButton btnNewButton = new JButton("\u65B0\u589E\u4F1A\u5458");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFull()) {
					VipBean vipBean = vipImpl.findOne(text_phone.getText().trim());
					if (vipBean != null) {
						JOptionPane.showMessageDialog(null, "该电话已经注册过");
					} else {
						VipBean vipBeanNew = new VipBean();
						vipBeanNew.setPhone(text_phone.getText().trim());
						vipBeanNew.setAddress(text_add.getText().trim());
						vipBeanNew.setName(text_name.getText().trim());
						vipBeanNew.setScore(Integer.parseInt(text_score.getText().trim()));
						vipImpl.save(vipBeanNew);
						JOptionPane.showMessageDialog(null, "注册成功");

					}
				}

			}
		});
		btnNewButton.setBounds(223, 313, 93, 23);
		contentPane.add(btnNewButton);

		JButton button = new JButton("\u67E5\u8BE2\u4F1A\u5458");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (text_phone.getText().length() > 0) {
					VipBean vipBean = vipImpl.findOne(text_phone.getText().trim());
					if (vipBean != null) {
						text_name.setText(vipBean.getName());
						text_add.setText(vipBean.getAddress());
						text_score.setText(vipBean.getScore() + "");
					} else {
						text_name.setText("");
						text_add.setText("");
						text_score.setText("");
						JOptionPane.showMessageDialog(null, "查无此人");
					}
				}
			}
		});
		button.setBounds(223, 71, 93, 23);
		contentPane.add(button);
	}

	public boolean isFull() {
		if (text_phone.getText().length() > 0 && text_name.getText().length() > 0
				&& text_score.getText().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
