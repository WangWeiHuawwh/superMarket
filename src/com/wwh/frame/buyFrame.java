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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.bean.PurchaseBean;
import com.wwh.bean.StoreHouseBean;
import com.wwh.bean.StoreHouseImpl;
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
import javax.swing.JFileChooser;

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
	private JButton button_1;
	private JLabel label_4;
	private JTextField textField_7;
	StoreHouseImpl storeHouseimpl;
	JFileChooser chooser;
	JLabel path_label;
	private JLabel label_5;

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
		setTitle("\u8FDB\u8D27");
		storeHouseimpl = new StoreHouseImpl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("*\u4EA7\u54C1\u7F16\u53F7\uFF1A");
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
		jScrollPane_data.setBounds(236, 40, 716, 578);
		contentPane.add(jScrollPane_data);
		jScrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "名称", "厂商", "进货价", "销售价", "vip", "数量", "备注", "图片路径" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "编号", "名称", "厂商", "进货价", "销售价", "vip", "数量", "备注", "图片路径" } },
					new String[] { "", "", "", "", "", "", "", "", "" });
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

		button.setBounds(124, 490, 93, 23);
		contentPane.add(button);

		button_1 = new JButton("\u786E\u8BA4\u8FDB\u8D27");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = 1; i < tableModel.getRowCount(); i++) {
					StoreHouseBean storehouseBean = storeHouseimpl
							.findOne(tableModel.getValueAt(i, 0).toString().trim());
					String[] value = new String[tableModel.getColumnCount()];
					for (int j = 0; j < tableModel.getColumnCount(); j++) {
						value[j] = tableModel.getValueAt(i, j).toString();
					}
					StoreHouseBean newStoreHouseBean = new StoreHouseBean();
					newStoreHouseBean.setP_barcode(value[0]);
					newStoreHouseBean.setP_name(value[1]);
					newStoreHouseBean.setP_producer(value[2]);
					newStoreHouseBean.setSale_price(Double.parseDouble(value[4]));
					newStoreHouseBean.setP_number(Integer.parseInt(value[6]));
					newStoreHouseBean.setP_text(value[7]);
					newStoreHouseBean.setVip_price(Double.parseDouble(value[5]));
					newStoreHouseBean.setIn_price(Double.parseDouble(value[3]));
					newStoreHouseBean.setImage(value[8]);
					if (storehouseBean != null
							&& storehouseBean.p_barcode.equals(tableModel.getValueAt(i, 0).toString().trim())) {
						newStoreHouseBean.setP_number(newStoreHouseBean.getP_number() + storehouseBean.getP_number());
						storeHouseimpl.update(newStoreHouseBean);
					} else {
						storeHouseimpl.save(newStoreHouseBean);
					}
					Date date = new Date(System.currentTimeMillis());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 可以方便地修改日期格式
					PurchaseBean purchaseBean = new PurchaseBean();
					purchaseBean.setBarcode(value[0]);
					purchaseBean.setIn_price(Double.parseDouble(value[3]));
					purchaseBean.setBuy_number(Integer.parseInt(value[6]));
					purchaseBean.setBuy_date(dateFormat.format(date));
					purchaseBean.setBuy_user(Application.getEid());
					System.out.println(purchaseBean.toString());
					// 插入进货记录
					// sqlLite.executeSql(
					// "insert into
					// purchase(barcode,in_price,buy_number,buy_date,produce_time,buy_user,save_day)
					// values('"
					// + value[0] + "' ,'" + value[3] + "','" + value[6] + "','"
					// + dateFormat.format(date)
					// + "',0,'" + Application.getEid() + "','0');");
					storeHouseimpl.savePurchase(purchaseBean);

				}
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				JOptionPane.showMessageDialog(null, "进货成功");

			}
		});
		button_1.setBounds(846, 667, 93, 23);
		contentPane.add(button_1);

		label_4 = new JLabel("\u9500\u552E\u4EF7\u683C\uFF1A");
		label_4.setBounds(47, 216, 80, 15);
		contentPane.add(label_4);

		textField_7 = new JTextField();
		textField_7.setBounds(110, 213, 90, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		path_label = new JLabel("");
		path_label.setBounds(110, 391, 104, 21);
		contentPane.add(path_label);

		JButton btnNewButton = new JButton("\u56FE\u7247");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(chooser);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					path_label.setText(chooser.getSelectedFile().getAbsolutePath());

				}
			}
		});
		btnNewButton.setBounds(47, 403, 69, 23);
		contentPane.add(btnNewButton);
		
		label_5 = new JLabel("\u6CE8\uFF1A\u56FE\u7247\uFF08\u53EF\u9009\uFF09\u5B58\u653E\u5728\u6307\u5B9A\u6587\u4EF6\u5939\u4E0D\u8981\u79FB\u52A8");
		label_5.setBounds(34, 643, 364, 21);
		contentPane.add(label_5);
		init();
	}

	public void init() {
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_ENTER) {
					if (textField.getText().length() > 0) {
						// 1.加载驱动
						// Object[][] produce =
						// sqlLite.selectObject("storehouse", "p_barcode",
						// textField.getText().trim());
						StoreHouseBean storehouseBean = storeHouseimpl.findOne(textField.getText().trim());
						if (storehouseBean != null
								&& storehouseBean.getP_barcode().equals(textField.getText().trim())) {
							textField_1.setText(storehouseBean.getP_name());
							textField_2.setText(storehouseBean.getP_producer());
							textField_3.setText(storehouseBean.getIn_price().toString());
							textField_4.setText(storehouseBean.getVip_price().toString());
							textField_5.setText(storehouseBean.getP_number() + "");
							textField_6.setText(storehouseBean.getP_text());
							textField_7.setText(storehouseBean.getSale_price().toString());
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
							textField_6.getText(), path_label.getText() });
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
		path_label.setText("");
	}
}
