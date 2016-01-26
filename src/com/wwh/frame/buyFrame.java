package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.utils.Application;
import com.wwh.utils.DbManager;
import com.wwh.utils.SQLiteCRUD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JScrollPane jScrollPane_data;
	private JTable jTable_data;
	private JLabel lblVip;
	private JTextField textField_4;
	private JButton button;
	private SQLiteCRUD sqlLite;
	private JButton button_1;
	private JLabel label_4;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buyFrame frame = new buyFrame();
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
	public buyFrame() {
		sqlLite = new SQLiteCRUD(new DbManager().getConnect());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u4EA7\u54C1\u7F16\u53F7\uFF1A");
		label.setBounds(47, 52, 80, 15);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(110, 49, 90, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u4EA7\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(47, 89, 80, 15);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(110, 86, 90, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u751F\u4EA7\u5382\u5546\uFF1A");
		label_2.setBounds(47, 129, 80, 15);
		contentPane.add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(110, 126, 90, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u8FDB\u8D27\u4EF7\u683C\uFF1A");
		lblNewLabel.setBounds(47, 171, 69, 15);
		contentPane.add(lblNewLabel);

		textField_3 = new JTextField();
		textField_3.setBounds(112, 168, 88, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u8FDB\u8D27\u6570\u91CF\uFF1A");
		lblNewLabel_1.setBounds(47, 295, 69, 15);
		contentPane.add(lblNewLabel_1);

		textField_5 = new JTextField();
		textField_5.setBounds(110, 292, 90, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel label_3 = new JLabel("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		label_3.setBounds(48, 331, 79, 15);
		contentPane.add(label_3);

		textField_6 = new JTextField();
		textField_6.setBounds(110, 328, 90, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		jScrollPane_data = new JScrollPane();
		jScrollPane_data.setPreferredSize(new Dimension(737, 251));
		jScrollPane_data.setBounds(220, 40, 543, 332);
		contentPane.add(jScrollPane_data);
		jScrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "名称", "厂商", "进货价", "销售价", "vip", "数量", "备注" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "编号", "名称", "厂商", "进货价", "销售价", "vip", "数量", "备注" } },
					new String[] { "", "", "", "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			jScrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		lblVip = new JLabel("vip\u4EF7\u683C\uFF1A");
		lblVip.setBounds(49, 255, 67, 15);
		contentPane.add(lblVip);

		textField_4 = new JTextField();
		textField_4.setBounds(111, 252, 89, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		button = new JButton("\u52A0\u5165\u5217\u8868");

		button.setBounds(110, 367, 93, 23);
		contentPane.add(button);

		button_1 = new JButton("\u786E\u8BA4\u8FDB\u8D27");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = 1; i < tableModel.getRowCount(); i++) {
					Object[][] produce = sqlLite.selectObject("storehouse", "p_barcode",
							tableModel.getValueAt(i, 0).toString().trim());
					String[] value = new String[tableModel.getColumnCount()];
					for (int j = 0; j < tableModel.getColumnCount(); j++) {
						value[j] = tableModel.getValueAt(i, j).toString();
					}
					if (produce != null && produce.length > 0) {
						int sum = Integer.parseInt(value[6]) + (int) produce[0][4];
						sqlLite.executeSql(
								"update storehouse set p_number=" + sum + " where p_barcode='" + value[0] + "';");

					} else {
						sqlLite.executeSql("insert into storehouse values('" + value[0] + "','" + value[1] + "','"
								+ value[2] + "','" + value[4] + "','" + value[6] + "','" + value[7] + "','" + value[5]
								+ "','" + value[3] + "');");
					}
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 可以方便地修改日期格式
					// 插入进货记录
//					sqlLite.executeSql(
//							"insert into purchase(barcode,in_price,buy_number,buy_date,produce_time,buy_user,save_day) values('"
//									+ value[0] + "' ,'" + value[3] + "','" + value[6] + "','" + dateFormat.format(date)
//									+ "',0,'" + Application.getEid() + "','0');");
					

				}
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				JOptionPane.showMessageDialog(null, "进货成功");

			}
		});
		button_1.setBounds(632, 407, 93, 23);
		contentPane.add(button_1);

		label_4 = new JLabel("\u9500\u552E\u4EF7\u683C\uFF1A");
		label_4.setBounds(47, 216, 80, 15);
		contentPane.add(label_4);

		textField_7 = new JTextField();
		textField_7.setBounds(110, 213, 90, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		init();
	}

	public void init() {
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (textField.getText().length() > 0) {
						// 1.加载驱动
						Object[][] produce = sqlLite.selectObject("storehouse", "p_barcode",
								textField.getText().trim());
						if (produce != null && produce.length > 0) {
							textField_1.setText(produce[0][1].toString());
							textField_2.setText(produce[0][2].toString());
							textField_3.setText(produce[0][7].toString());
							textField_4.setText(produce[0][6].toString());
							textField_5.setText(produce[0][4].toString());
							textField_6.setText(produce[0][5].toString());
							textField_7.setText(produce[0][3].toString());
						} else {
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
							JOptionPane.showMessageDialog(null, "库存中没有此商品,请输入其详细信息！");// 提示消息对话框
						}
						// ==================================================================================================

					} else {
						JOptionPane.showMessageDialog(null, "输入正确的编号");
					}
				}
			}

		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isFull()) {
					DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
					// 添加下一行
					tableModel.addRow(new Object[] { textField.getText(), textField_1.getText(), textField_2.getText(),
							textField_3.getText(), textField_7.getText(), textField_4.getText(), textField_5.getText(),
							textField_6.getText() });
					// 将文本框中的内容清空，以便下一次输入
					clearTextField();
				} else {
					JOptionPane.showMessageDialog(null, "信息填写不完全");
				}
			}
		});

	}

	public boolean isFull() {
		if (textField.getText().length() > 0 && textField_1.getText().length() > 0 && textField_2.getText().length() > 0
				&& textField_3.getText().length() > 0 && textField_4.getText().length() > 0
				&& textField_5.getText().length() > 0 && textField_7.getText().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void clearTextField() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
	}
}
