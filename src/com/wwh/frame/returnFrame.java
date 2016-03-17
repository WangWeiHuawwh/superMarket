package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wwh.bean.ReturnBean;
import com.wwh.bean.ReturnImpl;
import com.wwh.bean.StoreHouseBean;
import com.wwh.bean.StoreHouseImpl;
import com.wwh.utils.Application;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class returnFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_2;
	private JButton btnNewButton;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnFrame frame = new returnFrame();
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
	public returnFrame() {
		setTitle("\u9000\u8D27");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 474, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("*\u7F16\u53F7\uFF1A");
		label.setBounds(112, 47, 58, 15);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(209, 44, 99, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u6570\u91CF\uFF1A");
		label_1.setBounds(112, 133, 54, 15);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(209, 130, 99, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		label_2 = new JLabel("\u4EF7\u683C\uFF1A");
		label_2.setBounds(112, 173, 54, 15);
		contentPane.add(label_2);

		btnNewButton = new JButton("\u9000\u8D27");

		btnNewButton.setBounds(244, 266, 93, 23);
		contentPane.add(btnNewButton);

		textField_2 = new JTextField();
		textField_2.setBounds(209, 170, 99, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		label_3 = new JLabel("\u540D\u79F0\uFF1A");
		label_3.setBounds(112, 93, 54, 15);
		contentPane.add(label_3);

		textField_3 = new JTextField();
		textField_3.setBounds(209, 90, 99, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		init();
	}

	public void init() {
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (textField.getText().length() > 0) {
						StoreHouseImpl storeHouseImpl = new StoreHouseImpl();
						StoreHouseBean storeBean = storeHouseImpl.findOne(textField.getText().trim());
						if (storeBean != null && storeBean.getP_barcode().equals(textField.getText().trim())) {
							textField_2.setText(storeBean.getSale_price() + "");
							textField_3.setText(storeBean.getP_name());
						} else {
							JOptionPane.showMessageDialog(null, "没有该商品");
						}

					} else {
						JOptionPane.showMessageDialog(null, "输入正确的编号");
					}
				}
			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isFull()) {
					StoreHouseImpl storeHouseImpl = new StoreHouseImpl();
					StoreHouseBean storeBean = storeHouseImpl.findOne(textField.getText().trim());
					if (storeBean != null && storeBean.getP_barcode().equals(textField.getText().trim())) {
						Date date = new Date(System.currentTimeMillis());
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 可以方便地修改日期格式
						ReturnImpl returnImpl = new ReturnImpl();
						ReturnBean returnBean = new ReturnBean();
						returnBean.setBarcode(textField.getText().trim());
						returnBean.setEid(Application.getEid());
						returnBean.setName(textField_3.getText());
						returnBean.setNumber(Integer.parseInt(textField_1.getText()));
						returnBean.setPrice(Double.parseDouble(textField_2.getText()));
						returnBean.setReturn_date(dateFormat.format(date));
						returnImpl.insert(returnBean);
						storeBean.setP_number(storeBean.getP_number() + Integer.parseInt(textField_1.getText()));
						storeHouseImpl.update(storeBean);
						JOptionPane.showMessageDialog(null, "退货成功");
						clear();
					} else {
						JOptionPane.showMessageDialog(null, "没有该商品信息");
					}
				} else {
					JOptionPane.showMessageDialog(null, "输入完整信息");

				}

			}
		});
	}

	protected void clear() {
		// TODO Auto-generated method stub
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField.setText("");

	}

	public boolean isFull() {
		if (textField.getText().length() > 0 && textField_1.getText().length() > 0 && textField_2.getText().length() > 0
				&& textField_3.getText().length() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
