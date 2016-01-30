package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.bean.StoreHouseBean;
import com.wwh.bean.StoreHouseImpl;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class storeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable jTable_data;
	StoreHouseImpl storeHouseImpl;
	private JTextField barcode_textView;
	private JTextField name_textView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					storeFrame frame = new storeFrame();
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
	public storeFrame() {
		setTitle("\u67E5\u8BE2");
		storeHouseImpl = new StoreHouseImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane jScrollPane_data = new JScrollPane();
		jScrollPane_data.setPreferredSize(new Dimension(737, 251));
		jScrollPane_data.setBounds(192, 39, 543, 445);
		contentPane.add(jScrollPane_data);
		jScrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "名称", "厂商", "进货价", "销售价", "vip", "余量", "备注" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "编号", "名称", "厂商", "进货价", "销售价", "vip", "余量", "备注" } },
					new String[] { "", "", "", "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			jScrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED));
		panel.setBounds(10, 47, 172, 129);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u62A5\u8B66\u6570\uFF1A");
		lblNewLabel.setBounds(10, 52, 55, 15);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(77, 49, 84, 21);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(78, 96, 84, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u62A5\u8B66\u9650\u5236\uFF1A");
		lblNewLabel_1.setBounds(10, 10, 78, 15);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.RED));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(10, 209, 172, 145);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		label.setBounds(10, 52, 54, 15);
		panel_1.add(label);

		barcode_textView = new JTextField();
		barcode_textView.setBounds(74, 49, 88, 21);
		panel_1.add(barcode_textView);
		barcode_textView.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u7CBE\u786E\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (barcode_textView.getText().length() > 0) {
					DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
					for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
						tableModel.removeRow(i);
					}
					StoreHouseBean storehouse = storeHouseImpl.findOne(barcode_textView.getText().trim());
					if (storehouse != null) {
						tableModel.addRow(new Object[] { storehouse.getP_barcode(), storehouse.getP_name(),
								storehouse.getP_producer(), storehouse.getIn_price(), storehouse.getSale_price(),
								storehouse.getVip_price(), storehouse.getP_number(), storehouse.getP_text() });
					} else {
						JOptionPane.showMessageDialog(null, "没有该物品");
					}
				} else if (name_textView.getText().length() > 0) {
					DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
					for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
						tableModel.removeRow(i);
					}
					StoreHouseBean storehouse = storeHouseImpl.findByName(name_textView.getText().trim());
					if (storehouse != null) {
						tableModel.addRow(new Object[] { storehouse.getP_barcode(), storehouse.getP_name(),
								storehouse.getP_producer(), storehouse.getIn_price(), storehouse.getSale_price(),
								storehouse.getVip_price(), storehouse.getP_number(), storehouse.getP_text() });
					} else {
						JOptionPane.showMessageDialog(null, "没有该物品");
					}
				}

			}
		});
		btnNewButton_1.setBounds(84, 112, 78, 23);
		panel_1.add(btnNewButton_1);

		JLabel label_1 = new JLabel("\u540D\u79F0\uFF1A");
		label_1.setBounds(10, 83, 54, 15);
		panel_1.add(label_1);

		name_textView = new JTextField();
		name_textView.setBounds(74, 80, 88, 21);
		panel_1.add(name_textView);
		name_textView.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7CBE\u786E\u67E5\u627E\uFF1A");
		label_2.setBounds(10, 10, 76, 15);
		panel_1.add(label_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().length() > 0) {
					DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
					for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
						tableModel.removeRow(i);
					}
					List<StoreHouseBean> storeList = storeHouseImpl.getLeft(Integer.parseInt(textField.getText()));
					for (StoreHouseBean storehouse : storeList) {
						tableModel.addRow(new Object[] { storehouse.getP_barcode(), storehouse.getP_name(),
								storehouse.getP_producer(), storehouse.getIn_price(), storehouse.getSale_price(),
								storehouse.getVip_price(), storehouse.getP_number(), storehouse.getP_text() });
					}
				}
			}
		});
		initData();
	}

	private void initData() {
		// TODO Auto-generated method stub
		DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
		for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
			tableModel.removeRow(i);
		}
		List<StoreHouseBean> storeList = storeHouseImpl.getLeft(100);
		for (StoreHouseBean storehouse : storeList) {
			tableModel.addRow(new Object[] { storehouse.getP_barcode(), storehouse.getP_name(),
					storehouse.getP_producer(), storehouse.getIn_price(), storehouse.getSale_price(),
					storehouse.getVip_price(), storehouse.getP_number(), storehouse.getP_text() });
		}
	}
}
