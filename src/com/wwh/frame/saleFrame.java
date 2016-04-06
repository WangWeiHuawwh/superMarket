package com.wwh.frame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.bean.ConfigBean;
import com.wwh.bean.ConfigImpl;
import com.wwh.bean.SalesBean;
import com.wwh.bean.SalesImpl;
import com.wwh.bean.StoreHouseBean;
import com.wwh.bean.StoreHouseImpl;
import com.wwh.bean.VipBean;
import com.wwh.bean.VipImpl;
import com.wwh.utils.Application;
import com.wwh.utils.DbManager;
import com.wwh.utils.SQLiteCRUD;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Robot;

import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class saleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable jTable_data;
	private boolean isVip = false;
	private JButton btnAdd;
	private JButton button;
	private JLabel vip_score_label;
	private JLabel once_price_label;
	private JSpinner spinner;
	private JLabel sum_money;
	private JTextField get_money;
	private JLabel pay_back_label;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel name_label;
	private JButton btnNewButton;
	private String vipPhone;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// ���Է�����޸����ڸ�ʽ
	private SalesImpl salesImpl;
	private int score = 0;
	final JCheckBox checkBox;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JButton push_button;
	JPanel grid_layout;
	ConfigImpl configImpl = new ConfigImpl();
	private final int MAX_W = 4;
	private final int MAX_H = 6;
	private final int MAX_NUMBER = MAX_W * MAX_H;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleFrame frame = new saleFrame();
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
	public saleFrame() {
		setTitle("\u9500\u552E");

		salesImpl = new SalesImpl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1073, 768);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		checkBox = new JCheckBox("\u4F1A\u5458");

		checkBox.setBounds(21, 31, 67, 23);
		contentPane.add(checkBox);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setBounds(21, 86, 726, 605);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("*\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 61, 72, 15);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(82, 58, 114, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("\u8D2D\u4E70\u6570\u91CF\uFF1A");
		label.setBounds(10, 142, 72, 19);
		panel.add(label);

		JScrollPane scrollPane_data = new JScrollPane();
		scrollPane_data.setPreferredSize(new Dimension(737, 251));
		scrollPane_data.setBounds(226, 43, 462, 235);
		panel.add(scrollPane_data);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(144, 253, 72, 23);
		panel.add(btnAdd);

		once_price_label = new JLabel("\u5546\u54C1\u5355\u4EF7");
		once_price_label.setBounds(109, 207, 87, 15);
		panel.add(once_price_label);
		scrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "���", "����", "����", "ŷԪ", "��Ա", "����" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "���", "����", "����", "ŷԪ", "��Ա", "����" } }, new String[] { "", "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			scrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		spinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
		spinner.setBounds(82, 141, 54, 22);
		panel.add(spinner);

		label_4 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_4.setBounds(10, 103, 72, 21);
		panel.add(label_4);

		name_label = new JLabel("\u5546\u54C1\u540D\u79F0");
		name_label.setBounds(82, 104, 114, 21);
		panel.add(name_label);

		JButton clear_button = new JButton("clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
			}
		});
		clear_button.setBounds(653, 10, 63, 23);
		panel.add(clear_button);

		JButton btnNewButton_2 = new JButton("\u2193\u2193");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreHouseImpl storehouseImpl = new StoreHouseImpl();
				StoreHouseBean storeHouseBean = storehouseImpl.findOne(textField_1.getText().trim());
				if (storeHouseBean != null && storeHouseBean.getP_barcode().equals(textField_1.getText().trim())) {
					ConfigBean configbean = configImpl.get();
					String uproduce = configbean.getUproduce();
					String[] uid = uproduce.split("\\|");
					if (uid.length > MAX_NUMBER) {
						JOptionPane.showMessageDialog(null, "���ó�������!");
						return;
					}
					for (int i = 0; i < uid.length; i++) {
						if (uid[i].trim().equals(textField_1.getText().trim())) {
							JOptionPane.showMessageDialog(null, "�Ѿ����ڸ���Ʒ");
							return;
						}
					}
					configbean.setUproduce(configbean.getUproduce() + "|" + textField_1.getText().trim());
					configImpl.update(configbean);
					updateGrid();
				} else {
					JOptionPane.showMessageDialog(null, "û�и���Ʒ��Ϣ");
				}

			}
		});
		btnNewButton_2.setBounds(10, 253, 63, 23);
		panel.add(btnNewButton_2);

		grid_layout = new JPanel();
		grid_layout.setBounds(10, 288, 678, 306);
		panel.add(grid_layout);
		grid_layout.setLayout(new GridLayout(4, 6, 0, 0));

		JButton btnNewButton_3 = new JButton("\u2191\u2191");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StoreHouseImpl storehouseImpl = new StoreHouseImpl();
				StoreHouseBean storeHouseBean = storehouseImpl.findOne(textField_1.getText().trim());
				if (storeHouseBean != null && storeHouseBean.getP_barcode().equals(textField_1.getText().trim())) {
					ConfigBean configbean = configImpl.get();
					String uproduce = configbean.getUproduce();
					String[] uid = uproduce.split("\\|");
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < uid.length; i++) {
						if (uid[i].trim().equals(textField_1.getText().trim())) {
							// JOptionPane.showMessageDialog(null, "�Ѿ����ڸ���Ʒ");
						} else {
							sb.append(uid[i].trim() + "|");
						}
					}
					String sbb = sb.toString();
					if (sb.toString().endsWith("|")) {
						sbb = sb.toString().substring(0, sb.length() - 1);
					}
					configbean.setUproduce(sbb);
					configImpl.update(configbean);
					updateGrid();
				} else {
					JOptionPane.showMessageDialog(null, "û�и���Ʒ��Ϣ");
				}
			}
		});
		btnNewButton_3.setBounds(73, 253, 72, 23);
		panel.add(btnNewButton_3);

		final JPanel panel_vip = new JPanel();
		panel_vip.setBorder(new LineBorder(Color.RED));
		panel_vip.setBounds(94, 10, 653, 66);
		contentPane.add(panel_vip);
		panel_vip.setLayout(null);
		panel_vip.setVisible(false);
		textField = new JTextField();
		textField.setBounds(127, 20, 171, 21);
		panel_vip.add(textField);
		textField.setColumns(10);
		button = new JButton("\u6821\u9A8C\u4F1A\u5458");

		button.setBounds(340, 19, 93, 23);
		panel_vip.add(button);

		JLabel lblId = new JLabel("*phone\uFF1A");
		lblId.setBounds(33, 23, 69, 15);
		panel_vip.add(lblId);

		vip_score_label = new JLabel("\u79EF\u5206\uFF1A0");
		vip_score_label.setBounds(479, 23, 93, 15);
		panel_vip.add(vip_score_label);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(757, 382, 272, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (get_money.getText().length() > 0) {
					get_money.setText(get_money.getText().substring(0, get_money.getText().length() - 1));
				}
			}
		});
		btnNewButton_1.setBounds(0, 0, 65, 54);
		panel_1.add(btnNewButton_1);

		JButton button_2 = new JButton("%");
		button_2.setBounds(68, 0, 65, 54);
		panel_1.add(button_2);

		JButton button_3 = new JButton("*");
		button_3.setBounds(137, 0, 65, 54);
		panel_1.add(button_3);

		JButton button_4 = new JButton("-");
		button_4.setBounds(204, 0, 65, 54);
		panel_1.add(button_4);

		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "7");
			}
		});
		button_5.setBounds(0, 60, 65, 54);
		panel_1.add(button_5);

		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "8");
			}
		});
		button_6.setBounds(68, 60, 65, 54);
		panel_1.add(button_6);

		JButton button_7 = new JButton("9");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "9");
			}
		});
		button_7.setBounds(137, 60, 65, 54);
		panel_1.add(button_7);

		JButton button_8 = new JButton("+");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_8.setBounds(204, 60, 65, 112);
		panel_1.add(button_8);

		JButton button_9 = new JButton("4");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "4");
			}
		});
		button_9.setBounds(0, 118, 65, 54);
		panel_1.add(button_9);

		JButton button_10 = new JButton("5");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "5");
			}
		});
		button_10.setBounds(68, 118, 65, 54);
		panel_1.add(button_10);

		JButton button_11 = new JButton("6");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "6");
			}
		});
		button_11.setBounds(137, 118, 65, 54);
		panel_1.add(button_11);

		JButton button_12 = new JButton("=");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (get_money.getText().length() > 0) {
					Double backMoney = Double.parseDouble(get_money.getText())
							- Double.parseDouble(sum_money.getText());
					pay_back_label.setText(backMoney + "");
				}
			}
		});
		button_12.setBounds(204, 175, 65, 118);
		panel_1.add(button_12);

		JButton button_13 = new JButton("1");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "1");
			}
		});
		button_13.setBounds(0, 175, 65, 54);
		panel_1.add(button_13);

		JButton button_14 = new JButton("2");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "2");
			}
		});
		button_14.setBounds(68, 175, 65, 54);
		panel_1.add(button_14);

		JButton button_15 = new JButton("3");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "3");
			}
		});
		button_15.setBounds(137, 175, 65, 54);
		panel_1.add(button_15);

		JButton button_16 = new JButton(".");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + ".");
			}
		});
		button_16.setBounds(137, 239, 65, 54);
		panel_1.add(button_16);

		JButton button_17 = new JButton("0");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_money.setText(get_money.getText() + "0");
			}
		});
		button_17.setBounds(0, 239, 133, 54);
		panel_1.add(button_17);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(757, 86, 287, 265);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		push_button = new JButton("\u8BA1\u7B97");
		push_button.setBounds(10, 10, 81, 23);
		panel_2.add(push_button);

		label_2 = new JLabel("\u603B\u8BA1\uFF1A");
		label_2.setBounds(22, 77, 54, 15);
		panel_2.add(label_2);

		sum_money = new JLabel("\u603B\u8BA1");
		sum_money.setBounds(86, 64, 112, 37);
		panel_2.add(sum_money);
		sum_money.setFont(new Font("����", Font.PLAIN, 20));
		sum_money.setForeground(Color.RED);

		JLabel label_1 = new JLabel("*\u6536\u6B3E\uFF1A");
		label_1.setBounds(22, 136, 49, 15);
		panel_2.add(label_1);

		get_money = new JTextField();
		get_money.setBounds(90, 133, 96, 21);
		panel_2.add(get_money);
		get_money.setColumns(10);

		label_3 = new JLabel("\u627E\u96F6\uFF1A");
		label_3.setBounds(22, 188, 54, 15);
		panel_2.add(label_3);

		pay_back_label = new JLabel("\u627E\u96F6");
		pay_back_label.setBounds(99, 175, 112, 37);
		panel_2.add(pay_back_label);
		pay_back_label.setFont(new Font("����", Font.PLAIN, 20));
		pay_back_label.setForeground(Color.MAGENTA);

		btnNewButton = new JButton("\u4ED8\u6B3E");
		btnNewButton.setBounds(144, 232, 93, 23);
		panel_2.add(btnNewButton);

		rdbtnNewRadioButton = new JRadioButton("\u514B\u6717");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(109, 10, 86, 23);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == rdbtnNewRadioButton) {
					rdbtnNewRadioButton.setSelected(true);
					rdbtnNewRadioButton_1.setSelected(false);
					push_button.doClick();
				}
			}
		});
		panel_2.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton_1 = new JRadioButton("\u6B27\u5143");
		rdbtnNewRadioButton_1.setBounds(109, 35, 77, 23);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == rdbtnNewRadioButton_1) {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnNewRadioButton_1.setSelected(true);
					push_button.doClick();
				}
			}
		});
		panel_2.add(rdbtnNewRadioButton_1);
		push_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				Double sumMoney = 0d;
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					//
					if (isVip) {
						sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 4).toString())
								* Double.parseDouble(tableModel.getValueAt(i, 5).toString());
					} else {
						sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 2).toString())
								* Double.parseDouble(tableModel.getValueAt(i, 5).toString());
					}
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					sumMoney = sumMoney * Application.getbili();
				}
				sum_money.setText(sumMoney + "");
			}
		});
		checkBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (checkBox.isSelected()) {
					panel_vip.setVisible(true);
					isVip = true;
				} else {
					panel_vip.setVisible(false);
					isVip = false;
				}
			}
		});
		init();
	}

	public void init() {
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (textField.getText().length() > 0) {
						VipImpl vipImpl = new VipImpl();
						VipBean vipBean = vipImpl.findOne(textField.getText().trim());
						if (vipBean != null && vipBean.getPhone().equals(textField.getText().trim())) {
							vipPhone = textField.getText().trim();
							vip_score_label.setText("����:" + vipBean.getScore());
							score = vipBean.getScore();
							isVip = true;
						} else {
							vip_score_label.setText("�ǻ�Ա");
							isVip = false;
							score = 0;
						}

					}

				}
			}

		});
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (isFull()) {
						StoreHouseImpl storehouseImpl = new StoreHouseImpl();
						StoreHouseBean storeHouseBean = storehouseImpl.findOne(textField_1.getText().trim());
						if (storeHouseBean != null
								&& storeHouseBean.getP_barcode().equals(textField_1.getText().trim())) {

							once_price_label.setText("����:" + storeHouseBean.getSale_price());
							name_label.setText(storeHouseBean.getP_name());
						} else {
							JOptionPane.showMessageDialog(null, "û�и���Ʒ��Ϣ");
						}
					} else {
						JOptionPane.showMessageDialog(null, "��Ϣ��д����ȫ");
					}
				}
			}

		});
		get_money.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (get_money.getText().length() > 0) {
						Double backMoney = Double.parseDouble(get_money.getText())
								- Double.parseDouble(sum_money.getText());
						pay_back_label.setText(backMoney + "");
					}
				}
			}

		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isFull()) {
					StoreHouseImpl storehouseImpl = new StoreHouseImpl();
					StoreHouseBean storeHouseBean = storehouseImpl.findOne(textField_1.getText().trim());
					if (storeHouseBean != null && storeHouseBean.getP_barcode().equals(textField_1.getText().trim())) {
						if (storeHouseBean.getP_number() - Integer.parseInt(spinner.getValue().toString()) < 0) {
							JOptionPane.showMessageDialog(null, "��治��!");
							return;
						}
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						// �����һ��
						tableModel.addRow(new Object[] { textField_1.getText(), storeHouseBean.getP_name(),
								storeHouseBean.getSale_price(), storeHouseBean.getSale_price() * Application.getbili(),
								storeHouseBean.getVip_price(), Integer.parseInt(spinner.getValue().toString()), });
						// ���ı����е�������գ��Ա���һ������
						textField_1.setText("");
						spinner.setValue(1);

					} else {
						JOptionPane.showMessageDialog(null, "û�и���Ʒ��Ϣ");
					}
				} else {
					JOptionPane.showMessageDialog(null, "��Ϣ��д����ȫ");
				}

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VipImpl vipImpl = new VipImpl();
				VipBean vipBean = vipImpl.findOne(textField.getText().trim());
				if (vipBean != null && vipBean.getPhone().equals(textField.getText().trim())) {
					vipPhone = textField.getText().trim();
					vip_score_label.setText("����:" + vipBean.getScore());
					score = vipBean.getScore();
					isVip = true;
				} else {
					vip_score_label.setText("�ǻ�Ա");
					isVip = false;
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date datetime = new Date();
				String xiaopiao = "СƱ\n-------------------------------------------------\n"
						+ dateFormat.format(datetime) + "\n-------------------------------------------------\n";
				xiaopiao = xiaopiao + "��� ---����---ԭ��---����--- �ۼ�\n";
				ArrayList<SalesBean> xiaopiaoList = new ArrayList<SalesBean>();
				if (get_money.getText().length() > 0) {

					double sumMoney = 0d;
					DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
					for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
						StoreHouseImpl storeHouseimpl = new StoreHouseImpl();
						StoreHouseBean storeHouseBean = storeHouseimpl.findOne(tableModel.getValueAt(i, 0).toString());
						// ���¿����
						if (storeHouseBean.getP_number()
								- Integer.parseInt(tableModel.getValueAt(i, 5).toString()) < 0) {
							JOptionPane.showMessageDialog(null, "���:" + tableModel.getValueAt(i, 0) + "����������");
							return;
						} else {
							storeHouseBean.setP_number(storeHouseBean.getP_number()
									- Integer.parseInt(tableModel.getValueAt(i, 5).toString()));
							storeHouseimpl.update(storeHouseBean);
						}
						Double moeny = 0d;
						SalesBean salesBean = new SalesBean();
						//
						if (isVip) {
							// �����ܼ�
							sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 4).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 5).toString());
							// �����ۻ���
							Date date = new Date(System.currentTimeMillis());
							moeny = Double.parseDouble(tableModel.getValueAt(i, 4).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 5).toString());
							salesBean.setBarcode(tableModel.getValueAt(i, 0).toString());
							salesBean.setPrice(Double.parseDouble(tableModel.getValueAt(i, 2).toString()));
							salesBean.setDate(dateFormat.format(date));
							salesBean.setVip(vipPhone);
							salesBean.setReal_price(Double.parseDouble(tableModel.getValueAt(i, 4).toString()));
							salesBean.setNumber(Integer.parseInt(tableModel.getValueAt(i, 5).toString()));
							salesBean.setSummoney(moeny);
							salesBean.setUser(Application.getEid());
							salesImpl.insert(salesBean);
							xiaopiao = xiaopiao + "" + tableModel.getValueAt(i, 0).toString() + "---"
									+ tableModel.getValueAt(i, 1).toString() + "---"
									+ Double.parseDouble(tableModel.getValueAt(i, 2).toString()) + "---"
									+ Integer.parseInt(tableModel.getValueAt(i, 5).toString()) + "---"
									+ Double.parseDouble(tableModel.getValueAt(i, 4).toString()) + "\n";

						} else {
							sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 2).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 5).toString());
							Date date = new Date(System.currentTimeMillis());
							moeny = Double.parseDouble(tableModel.getValueAt(i, 2).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 5).toString());
							salesBean.setBarcode(tableModel.getValueAt(i, 0).toString());
							salesBean.setPrice(Double.parseDouble(tableModel.getValueAt(i, 2).toString()));
							salesBean.setDate(dateFormat.format(date));
							salesBean.setVip("null");
							salesBean.setReal_price(Double.parseDouble(tableModel.getValueAt(i, 2).toString()));
							salesBean.setNumber(Integer.parseInt(tableModel.getValueAt(i, 5).toString()));
							salesBean.setSummoney(moeny);
							salesBean.setUser(Application.getEid());
							salesImpl.insert(salesBean);
							xiaopiao = xiaopiao + "" + tableModel.getValueAt(i, 0).toString() + "---"
									+ tableModel.getValueAt(i, 1).toString() + "---"
									+ Double.parseDouble(tableModel.getValueAt(i, 2).toString()) + "---"
									+ Integer.parseInt(tableModel.getValueAt(i, 5).toString()) + "---"
									+ Double.parseDouble(tableModel.getValueAt(i, 2).toString()) + "\n";
						}
						xiaopiaoList.add(salesBean);

					}
					xiaopiao = xiaopiao + "-------------------------------------------------\n";
					String backMoneyString;
					// ����ŷԪ
					if (rdbtnNewRadioButton_1.isSelected()) {
						sumMoney = sumMoney * Application.getbili();
						Double backMoney = Double.parseDouble(get_money.getText()) - sumMoney;
						if (isVip) {
							VipImpl vipimpl = new VipImpl();
							VipBean vipBean = new VipBean();
							vipBean.setScore(score + (int) sumMoney);
							vipBean.setPhone(vipPhone);
							vipimpl.update(vipBean);
						}
						backMoneyString = xiaopiao + "����:" + backMoney + "ŷԪ";
						JOptionPane.showMessageDialog(null, xiaopiao + "����:" + backMoney + "ŷԪ");
					} else {
						Double backMoney = Double.parseDouble(get_money.getText()) - sumMoney;
						if (isVip) {
							VipImpl vipimpl = new VipImpl();
							VipBean vipBean = new VipBean();
							vipBean.setScore(score + (int) sumMoney);
							vipBean.setPhone(vipPhone);
							vipimpl.update(vipBean);
						}
						backMoneyString = xiaopiao + "����:" + backMoney + "����";
						JOptionPane.showMessageDialog(null, xiaopiao + "����:" + backMoney + "����");

					}
					PrintWarranty print = new PrintWarranty(xiaopiaoList, backMoneyString);
					print.startPrint();
					clearAll();
				} else {
					JOptionPane.showMessageDialog(null, "��д�տ�");
				}
			}
		});
		ConfigBean configbean = configImpl.get();
		Application.bili = configbean.getBili();
		updateGrid();
	}

	private void updateGrid() {
		// TODO Auto-generated method stub
		grid_layout.removeAll();
		ConfigBean configbean = configImpl.get();
		String uproduce = configbean.getUproduce();
		String[] uid = uproduce.split("\\|");
		int wd = grid_layout.getWidth() / MAX_H;
		int hi = grid_layout.getHeight() / MAX_W;
		for (int i = 0; i < uid.length; i++) {
			StoreHouseImpl storehouseImpl = new StoreHouseImpl();
			final StoreHouseBean storeHouseBean = storehouseImpl.findOne(uid[i]);
			JButton button = new JButton(storeHouseBean.getP_name());
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (storeHouseBean != null) {
						textField_1.setText(storeHouseBean.getP_barcode());
						name_label.setText(storeHouseBean.getP_name());
						once_price_label.setText("����:" + storeHouseBean.getSale_price());
						spinner.setValue(1);
					} else {
						JOptionPane.showMessageDialog(null, "û�и���Ʒ��Ϣ");
					}

				}
			});
			grid_layout.add(button);
			try {
				String path = storeHouseBean.getImage().replace("\\\\", "\\\\\\\\");
				if (path.length() > 0) {

					ImageIcon icon = new ImageIcon(path);
					Image temp = icon.getImage().getScaledInstance(wd, hi, icon.getImage().SCALE_DEFAULT);
					icon = new ImageIcon(temp);
					button.setIcon(icon);
				}
			} catch (Exception e) {
				// JOptionPane.showMessageDialog(null, "��ͼƬ"+e.getMessage());
				System.out.println(e.getMessage());

			}
		}

		for (int i = uid.length; i < MAX_NUMBER; i++) {
			JButton button = new JButton("null");
			grid_layout.add(button);
		}
		grid_layout.updateUI();
		grid_layout.repaint();
		grid_layout.revalidate();
		grid_layout.validate();

	}

	protected void clearAll() {
		// TODO Auto-generated method stub
		DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
		for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
			tableModel.removeRow(i);
		}
		sum_money.setText(0 + "");
		pay_back_label.setText(0 + "");
		get_money.setText("");
		checkBox.setSelected(false);
		name_label.setText("");
		once_price_label.setText("");
	}

	protected boolean isFull() {
		// TODO Auto-generated method stub
		if (textField_1.getText().length() > 0 && spinner.getValue().toString().length() > 0) {
			return true;
		}
		return false;
	}

	public class PrintWarranty implements Printable {
		ArrayList<SalesBean> xiaopiaoList;
		String backmoneyString;

		public PrintWarranty(ArrayList<SalesBean> xiaopiaoList, String s) {
			this.xiaopiaoList = xiaopiaoList;
			backmoneyString = s;
		}

		@Override
		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
			// TODO Auto-generated method stub
			if (pageIndex > 0) {
				return NO_SUCH_PAGE;
			}

			Graphics2D g2d = (Graphics2D) graphics;
			g2d.setFont(new Font("Default", Font.PLAIN, 10));
			g2d.drawString("СƱ", 50, 10);
			Date datetime = new Date();
			g2d.drawString("ʱ�䣺" + dateFormat.format(datetime), 7, 20);
			g2d.drawString("-------------------------------------", 7, 20);
			g2d.drawString("��� ---����---ԭ��---����--- �ۼ�", 7, 20);
			for (SalesBean sales : xiaopiaoList) {
				g2d.drawString(sales.getBarcode() + " " + sales.getReal_price() + " " + sales.getNumber() + " "
						+ sales.getReal_price(), 7, 35);
			}
			g2d.drawString(backmoneyString, 7, 20);
			// g2d.drawString("�ֻ����룺11111111111", 7, 35);
			// g2d.drawString("������ڣ�" + "11111", 7, 65);
			// g2d.drawString("-------------------------------------", 7, 80);
			// g2d.setFont(new Font("Default", Font.PLAIN, 25));
			// g2d.drawString("С��", 7, 105);
			// g2d.setFont(new Font("Default", Font.PLAIN, 14));
			// g2d.drawString("��֮ǰ����" + 5 + "�������ڵȴ�", 7, 130);
			// g2d.drawString("-------------------------------------", 7, 145);
			// g2d.drawString("*��ӡʱ��:" + "1111" + "*", 7, 160);
			// g2d.drawString("������11", 7, 175);

			return PAGE_EXISTS;
		}

		public void startPrint() {
			int height = 175 + 3 * 15 + 20;
			// ͨ���������顢�ĵ�
			Book book = new Book();
			// ��ӡ��ʽ
			PageFormat pf = new PageFormat();
			pf.setOrientation(PageFormat.PORTRAIT);
			// ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
			Paper p = new Paper();
			p.setSize(230, height);
			p.setImageableArea(5, -20, 230, height + 20);
			pf.setPaper(p);
			// �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
			book.append(this, pf);
			// ��ȡ��ӡ�������
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPageable(book);
			try {
				job.print();
			} catch (PrinterException e1) {
				System.out.println("================��ӡ�����쳣");
			}
		}

	}

}
