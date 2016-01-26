package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.utils.DbManager;
import com.wwh.utils.SQLiteCRUD;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
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

public class saleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable jTable_data;
	private boolean isVip = false;
	private SQLiteCRUD sqlLite;

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
		sqlLite = new SQLiteCRUD(new DbManager().getConnect());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 502);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JCheckBox checkBox = new JCheckBox("\u4F1A\u5458");

		checkBox.setBounds(21, 31, 67, 23);
		contentPane.add(checkBox);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setBounds(21, 86, 649, 368);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 26, 72, 15);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(79, 23, 114, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("\u8D2D\u4E70\u6570\u91CF\uFF1A");
		label.setBounds(10, 74, 72, 15);
		panel.add(label);

		textField_2 = new JTextField();
		textField_2.setText("1");
		textField_2.setBounds(79, 71, 114, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JScrollPane scrollPane_data = new JScrollPane();
		scrollPane_data.setPreferredSize(new Dimension(737, 251));
		scrollPane_data.setBounds(226, 26, 378, 245);
		panel.add(scrollPane_data);

		JButton button_1 = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		button_1.setBounds(109, 170, 93, 23);
		panel.add(button_1);

		JLabel label_1 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		label_1.setBounds(139, 124, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u603B\u8BA1\uFF1A");
		label_2.setBounds(422, 294, 54, 15);
		panel.add(label_2);
		scrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "名称", "价格", "数量" };

			TableModel jTable_dataModel = new DefaultTableModel(new String[][] { { "编号", "名称", "价格", "数量" } },
					new String[] { "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			scrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		final JPanel panel_vip = new JPanel();
		panel_vip.setBorder(new LineBorder(Color.GREEN));
		panel_vip.setBounds(94, 10, 391, 66);
		contentPane.add(panel_vip);
		panel_vip.setLayout(null);
		panel_vip.setVisible(false);
		textField = new JTextField();
		textField.setBounds(39, 20, 72, 21);
		panel_vip.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u6821\u9A8C\u4F1A\u5458");
		button.setBounds(134, 19, 93, 23);
		panel_vip.add(button);

		JLabel lblId = new JLabel("Id\uFF1A");
		lblId.setBounds(10, 23, 32, 15);
		panel_vip.add(lblId);
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
						// 1.加载驱动
						Object[][] produce = sqlLite.selectObject("vip", "id", textField.getText().trim());
						if (produce != null && produce.length > 0) {
							JOptionPane.showMessageDialog(null, "是会员!");// 提示消息对话框

						} else {
							JOptionPane.showMessageDialog(null, "不是会员!");// 提示消息对话框
						}

					}

				}
			}

		});
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (textField_1.getText().length() > 0) {
						// 1.加载驱动
						Object[][] produce = sqlLite.selectObject("storehouse", "p_barcode",
								textField.getText().trim());
						if (produce != null && produce.length > 0) {

						} else {
							JOptionPane.showMessageDialog(null, "没有这个商品");// 提示消息对话框
						}

					}

				}
			}

		});
	}
}
