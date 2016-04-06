package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.bean.SalesBean;
import com.wwh.bean.SalesImpl;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;

public class saleRecordFrame extends JFrame {

	private JPanel contentPane;
	private JTable jTable_data;
	SalesImpl salesImpl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleRecordFrame frame = new saleRecordFrame();
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
	public saleRecordFrame() {
		setTitle("\u9500\u552E\u8BB0\u5F55");
		salesImpl = new SalesImpl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane jScrollPane_data = new JScrollPane();
		jScrollPane_data.setPreferredSize(new Dimension(737, 251));
		jScrollPane_data.setBounds(34, 29, 942, 701);
		contentPane.add(jScrollPane_data);
		jScrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "记录编号", "商品编号", "数量", "原价", "售价", "日期", "销售员", "vip" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "记录编号", "商品编号", "数量", "原价", "售价", "日期", "销售员", "vip" } },
					new String[] { "", "", "", "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			jScrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u9500\u552E\u7F16\u53F7", "\u5546\u54C1\u7F16\u53F7", "\u6570\u91CF", "\u539F\u4EF7", "\u552E\u4EF7", "\u65E5\u671F", "\u9500\u552E\u5458", "vip"
				}
			));
		}
		initData();
	}

	private void initData() {
		// TODO Auto-generated method stub

		DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		List<SalesBean> sales = salesImpl.getSales();
		for (SalesBean salesBean : sales) {
			tableModel.addRow(new Object[] { salesBean.getId(), salesBean.getBarcode(), salesBean.getNumber(),
					salesBean.getPrice(), salesBean.getReal_price(), salesBean.getDate(), salesBean.getUser(),
					salesBean.getVip() });
		}
	}

}
