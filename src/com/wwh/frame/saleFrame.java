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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Font;

public class saleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable jTable_data;
	private boolean isVip = false;
	private JButton button_1;
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
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 可以方便地修改日期格式
	private SalesImpl salesImpl;
	private int score = 0;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 717);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JCheckBox checkBox = new JCheckBox("\u4F1A\u5458");

		checkBox.setBounds(21, 31, 67, 23);
		contentPane.add(checkBox);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setBounds(21, 86, 726, 563);
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
		scrollPane_data.setBounds(226, 26, 444, 382);
		panel.add(scrollPane_data);

		button_1 = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		button_1.setBounds(93, 266, 123, 23);
		panel.add(button_1);

		once_price_label = new JLabel("\u5546\u54C1\u4EF7\u683C");
		once_price_label.setBounds(93, 213, 94, 15);
		panel.add(once_price_label);

		sum_money = new JLabel("\u603B\u8BA1");
		sum_money.setFont(new Font("宋体", Font.PLAIN, 20));
		sum_money.setForeground(Color.RED);
		sum_money.setBounds(406, 426, 112, 37);
		panel.add(sum_money);
		scrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "名称", "价格", "会员", "数量" };

			TableModel jTable_dataModel = new DefaultTableModel(new String[][] { { "编号", "名称", "价格", "会员", "数量" } },
					new String[] { "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			scrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		spinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
		spinner.setBounds(82, 141, 54, 22);
		panel.add(spinner);

		JButton push_button = new JButton("\u8BA1\u7B97");
		push_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				Double sumMoney = 0d;
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					//
					if (isVip) {
						sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 3).toString())
								* Double.parseDouble(tableModel.getValueAt(i, 4).toString());
					} else {
						sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 2).toString())
								* Double.parseDouble(tableModel.getValueAt(i, 4).toString());
					}
				}
				sum_money.setText(sumMoney + "");
			}
		});
		push_button.setBounds(226, 435, 93, 23);
		panel.add(push_button);

		JLabel label_1 = new JLabel("*\u6536\u6B3E\uFF1A");
		label_1.setBounds(515, 439, 49, 15);
		panel.add(label_1);

		get_money = new JTextField();
		get_money.setBounds(574, 436, 96, 21);
		panel.add(get_money);
		get_money.setColumns(10);

		pay_back_label = new JLabel("\u627E\u96F6");
		pay_back_label.setFont(new Font("宋体", Font.PLAIN, 20));
		pay_back_label.setForeground(Color.MAGENTA);
		pay_back_label.setBounds(406, 480, 112, 37);
		panel.add(pay_back_label);

		btnNewButton = new JButton("\u4ED8\u6B3E");

		btnNewButton.setBounds(577, 530, 93, 23);
		panel.add(btnNewButton);

		label_2 = new JLabel("\u603B\u8BA1\uFF1A");
		label_2.setBounds(342, 439, 54, 15);
		panel.add(label_2);

		label_3 = new JLabel("\u627E\u96F6\uFF1A");
		label_3.setBounds(342, 490, 54, 15);
		panel.add(label_3);

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
		clear_button.setBounds(663, 0, 63, 23);
		panel.add(clear_button);

		final JPanel panel_vip = new JPanel();
		panel_vip.setBorder(new LineBorder(Color.GREEN));
		panel_vip.setBounds(94, 10, 391, 66);
		contentPane.add(panel_vip);
		panel_vip.setLayout(null);
		panel_vip.setVisible(false);
		textField = new JTextField();
		textField.setBounds(89, 20, 102, 21);
		panel_vip.add(textField);
		textField.setColumns(10);
		button = new JButton("\u6821\u9A8C\u4F1A\u5458");

		button.setBounds(210, 19, 93, 23);
		panel_vip.add(button);

		JLabel lblId = new JLabel("*phone\uFF1A");
		lblId.setBounds(10, 23, 69, 15);
		panel_vip.add(lblId);

		vip_score_label = new JLabel("\u79EF\u5206\uFF1A0");
		vip_score_label.setBounds(327, 23, 54, 15);
		panel_vip.add(vip_score_label);
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
							vip_score_label.setText("积分:" + vipBean.getScore());
							score = vipBean.getScore();
							isVip = true;
						} else {
							vip_score_label.setText("非会员");
							isVip = false;
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

							once_price_label.setText("单价:" + storeHouseBean.getSale_price());
							name_label.setText(storeHouseBean.getP_name());
						} else {
							JOptionPane.showMessageDialog(null, "没有该商品信息");
						}
					} else {
						JOptionPane.showMessageDialog(null, "信息填写不完全");
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
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isFull()) {
					StoreHouseImpl storehouseImpl = new StoreHouseImpl();
					StoreHouseBean storeHouseBean = storehouseImpl.findOne(textField_1.getText().trim());
					if (storeHouseBean != null && storeHouseBean.getP_barcode().equals(textField_1.getText().trim())) {
						if (storeHouseBean.getP_number() - Integer.parseInt(spinner.getValue().toString()) < 0) {
							JOptionPane.showMessageDialog(null, "库存不足!");
							return;
						}
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						// 添加下一行
						tableModel.addRow(new Object[] { textField_1.getText(), storeHouseBean.getP_name(),
								storeHouseBean.getSale_price(), storeHouseBean.getVip_price(),
								Integer.parseInt(spinner.getValue().toString()), });
						// 将文本框中的内容清空，以便下一次输入
						textField_1.setText("");
						spinner.setValue(1);

					} else {
						JOptionPane.showMessageDialog(null, "没有该商品信息");
					}
				} else {
					JOptionPane.showMessageDialog(null, "信息填写不完全");
				}

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VipImpl vipImpl = new VipImpl();
				VipBean vipBean = vipImpl.findOne(textField.getText().trim());
				if (vipBean != null && vipBean.getPhone().equals(textField.getText().trim())) {
					vipPhone = textField.getText().trim();
					vip_score_label.setText("积分:" + vipBean.getScore());
					score = vipBean.getScore();
					isVip = true;
				} else {
					vip_score_label.setText("非会员");
					isVip = false;
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (get_money.getText().length() > 0) {

					double sumMoney = 0d;
					DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
					for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
						StoreHouseImpl storeHouseimpl = new StoreHouseImpl();
						StoreHouseBean storeHouseBean = storeHouseimpl.findOne(tableModel.getValueAt(i, 0).toString());
						// 更新库存量
						if (storeHouseBean.getP_number()
								- Integer.parseInt(tableModel.getValueAt(i, 4).toString()) < 0) {
							// JOptionPane.showMessageDialog(null,
							// "这个货余量不足");
							continue;
						} else {
							storeHouseBean.setP_number(storeHouseBean.getP_number()
									- Integer.parseInt(tableModel.getValueAt(i, 4).toString()));
							storeHouseimpl.update(storeHouseBean);
						}
						Double moeny = 0d;
						SalesBean salesBean = new SalesBean();
						//
						if (isVip) {
							// 计算总价
							sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 3).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 4).toString());
							// 更新售货表
							Date date = new Date(System.currentTimeMillis());
							moeny = Double.parseDouble(tableModel.getValueAt(i, 3).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 4).toString());
							salesBean.setBarcode(tableModel.getValueAt(i, 0).toString());
							salesBean.setPrice(Double.parseDouble(tableModel.getValueAt(i, 2).toString()));
							salesBean.setDate(dateFormat.format(date));
							salesBean.setVip(vipPhone);
							salesBean.setReal_price(Double.parseDouble(tableModel.getValueAt(i, 3).toString()));
							salesBean.setNumber(Integer.parseInt(tableModel.getValueAt(i, 4).toString()));
							salesBean.setSummoney(moeny);
							salesBean.setUser(Application.getEid());
							salesImpl.insert(salesBean);

						} else {
							sumMoney = sumMoney + Double.parseDouble(tableModel.getValueAt(i, 2).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 4).toString());
							Date date = new Date(System.currentTimeMillis());
							moeny = Double.parseDouble(tableModel.getValueAt(i, 2).toString())
									* Double.parseDouble(tableModel.getValueAt(i, 4).toString());
							salesBean.setBarcode(tableModel.getValueAt(i, 0).toString());
							salesBean.setPrice(Double.parseDouble(tableModel.getValueAt(i, 2).toString()));
							salesBean.setDate(dateFormat.format(date));
							salesBean.setVip("null");
							salesBean.setReal_price(Double.parseDouble(tableModel.getValueAt(i, 2).toString()));
							salesBean.setNumber(Integer.parseInt(tableModel.getValueAt(i, 4).toString()));
							salesBean.setSummoney(moeny);
							salesBean.setUser(Application.getEid());
							salesImpl.insert(salesBean);
						}

					}
					Double backMoney = Double.parseDouble(get_money.getText()) - sumMoney;
					if (isVip) {
						VipImpl vipimpl = new VipImpl();
						VipBean vipBean = new VipBean();
						vipBean.setScore(score + (int) sumMoney);
						vipBean.setPhone(vipPhone);
						vipimpl.update(vipBean);
					}

					JOptionPane.showMessageDialog(null, "成功!找零:" + backMoney);
					clearAll();
				} else {
					JOptionPane.showMessageDialog(null, "填写收款");
				}
			}
		});
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
	}

	protected boolean isFull() {
		// TODO Auto-generated method stub
		if (textField_1.getText().length() > 0 && spinner.getValue().toString().length() > 0) {
			return true;
		}
		return false;
	}
}
