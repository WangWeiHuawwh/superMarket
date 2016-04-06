package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.bean.CaculateBean;
import com.wwh.bean.CaculateImpl;

import hysun.util.DateChooser;
import hysun.util.MonthlyCalendar;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.Color;

public class caculateFrame extends JFrame {

	private JPanel contentPane;
	CaculateImpl caculateImpl = new CaculateImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					caculateFrame frame = new caculateFrame();
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
	JLabel lblNewLabel;
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy.MM.dd");
	private JButton btnNewButton_1;
	private JTable jTable_data;

	public caculateFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final DateChooser dc = new DateChooser(this, true);

		lblNewLabel = new JLabel("2016.02.01");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(168, 10, 150, 52);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("select day");
		btnNewButton.setBounds(36, 26, 93, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("\u6309\u5E74\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uploadYear();
			}
		});
		btnNewButton_1.setBounds(873, 91, 93, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane_data = new JScrollPane();
		scrollPane_data.setPreferredSize(new Dimension(737, 251));
		scrollPane_data.setBounds(36, 83, 749, 563);
		contentPane.add(scrollPane_data);
		scrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "名称", "厂商", "销售数量", "总进价", "总销售额", "盈利" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "编号", "名称", "厂商", "销售数量", "总进价", "总销售额", "盈利" } },
					new String[] { "", "", "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			scrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		JButton btnNewButton_2 = new JButton("\u6309\u6708\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] time = lblNewLabel.getText().trim().split("[.]");
				if (time.length != 3)
					return;
				List<CaculateBean> caculateList = caculateImpl.getmoth(time[0], time[1]);
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				for (CaculateBean c : caculateList) {
					tableModel.addRow(new Object[] { c.getBarcode(), c.getP_name(), c.getP_producer(),
							c.getSum_number(), c.getAll_in(), c.getSum_money(), c.getGet_money() });
				}
				

			}
		});
		btnNewButton_2.setBounds(873, 142, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u6309\u65E5\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] time = lblNewLabel.getText().trim().split("[.]");
				if (time.length != 3)
					return;
				List<CaculateBean> caculateList = caculateImpl.getday(time[0], time[1], time[2]);
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				for (CaculateBean c : caculateList) {
					tableModel.addRow(new Object[] { c.getBarcode(), c.getP_name(), c.getP_producer(),
							c.getSum_number(), c.getAll_in(), c.getSum_money(), c.getGet_money() });
				}
				
			}
		});
		btnNewButton_3.setBounds(873, 195, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("\u6309\u5E74\u5BFC\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] time = lblNewLabel.getText().trim().split("[.]");
				if (time.length != 3)
					return;
				List<CaculateBean> caculateList = caculateImpl.getyear(time[0]);
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				for (CaculateBean c : caculateList) {
					tableModel.addRow(new Object[] { c.getBarcode(), c.getP_name(), c.getP_producer(), c.getSum_number(),
							c.getAll_in(), c.getSum_money(), c.getGet_money() });
				}
				// 创建工作薄
				WritableWorkbook workbook;
				try {
					workbook = Workbook.createWorkbook(new File(time[0] + "year.xls"));
					// 创建新的一页
					WritableSheet sheet = workbook.createSheet("统计", 0);
					// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
					Label head0 = new Label(0, 0, "编号");
					sheet.addCell(head0);
					Label head1 = new Label(1, 0, "名称");
					sheet.addCell(head1);
					Label head2 = new Label(2, 0, "厂商");
					sheet.addCell(head2);
					Label head3 = new Label(3, 0, "销售数量");
					sheet.addCell(head3);
					Label head4 = new Label(4, 0, "总进价");
					sheet.addCell(head4);
					Label head5 = new Label(5, 0, "总销售额");
					sheet.addCell(head5);
					Label head6 = new Label(6, 0, "盈利");
					sheet.addCell(head6);
					int i = 1;
					for (CaculateBean c : caculateList) {
						Label headnew = new Label(0, i, c.getBarcode());
						sheet.addCell(headnew);
						Label headnew2 = new Label(1, i, c.getP_name());
						sheet.addCell(headnew2);
						Label headnew3 = new Label(2, i, c.getP_producer());
						sheet.addCell(headnew3);
						Label headnew4 = new Label(3, i, c.getSum_number() + "");
						sheet.addCell(headnew4);
						Label headnew5 = new Label(4, i, c.getAll_in() + "");
						sheet.addCell(headnew5);
						Label headnew6 = new Label(5, i, c.getSum_money() + "");
						sheet.addCell(headnew6);
						Label headnew7 = new Label(6, i, c.getGet_money() + "");
						sheet.addCell(headnew7);
						i++;
					}
					// 把创建的内容写入到输出流中，并关闭输出流
					workbook.write();
					workbook.close();
					JOptionPane.showMessageDialog(null, "导出成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(873, 494, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u6309\u6708\u5BFC\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] time = lblNewLabel.getText().trim().split("[.]");
				if (time.length != 3)
					return;
				List<CaculateBean> caculateList = caculateImpl.getmoth(time[0], time[1]);
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				for (CaculateBean c : caculateList) {
					tableModel.addRow(new Object[] { c.getBarcode(), c.getP_name(), c.getP_producer(),
							c.getSum_number(), c.getAll_in(), c.getSum_money(), c.getGet_money() });
				}
				// 创建工作薄
				WritableWorkbook workbook;
				try {
					workbook = Workbook.createWorkbook(new File(time[0] + "year" + time[1] + "month.xls"));
					// 创建新的一页
					WritableSheet sheet = workbook.createSheet("统计", 0);
					// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
					Label head0 = new Label(0, 0, "编号");
					sheet.addCell(head0);
					Label head1 = new Label(1, 0, "名称");
					sheet.addCell(head1);
					Label head2 = new Label(2, 0, "厂商");
					sheet.addCell(head2);
					Label head3 = new Label(3, 0, "销售数量");
					sheet.addCell(head3);
					Label head4 = new Label(4, 0, "总进价");
					sheet.addCell(head4);
					Label head5 = new Label(5, 0, "总销售额");
					sheet.addCell(head5);
					Label head6 = new Label(6, 0, "盈利");
					sheet.addCell(head6);
					int i = 1;
					for (CaculateBean c : caculateList) {
						Label headnew = new Label(0, i, c.getBarcode());
						sheet.addCell(headnew);
						Label headnew2 = new Label(1, i, c.getP_name());
						sheet.addCell(headnew2);
						Label headnew3 = new Label(2, i, c.getP_producer());
						sheet.addCell(headnew3);
						Label headnew4 = new Label(3, i, c.getSum_number() + "");
						sheet.addCell(headnew4);
						Label headnew5 = new Label(4, i, c.getAll_in() + "");
						sheet.addCell(headnew5);
						Label headnew6 = new Label(5, i, c.getSum_money() + "");
						sheet.addCell(headnew6);
						Label headnew7 = new Label(6, i, c.getGet_money() + "");
						sheet.addCell(headnew7);
						i++;
					}
					// 把创建的内容写入到输出流中，并关闭输出流
					workbook.write();
					workbook.close();
					JOptionPane.showMessageDialog(null, "导出成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_1.setBounds(873, 563, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6309\u65E5\u5BFC\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] time = lblNewLabel.getText().trim().split("[.]");
				if (time.length != 3)
					return;
				List<CaculateBean> caculateList = caculateImpl.getday(time[0], time[1], time[2]);
				DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
				for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
					tableModel.removeRow(i);
				}
				for (CaculateBean c : caculateList) {
					tableModel.addRow(new Object[] { c.getBarcode(), c.getP_name(), c.getP_producer(),
							c.getSum_number(), c.getAll_in(), c.getSum_money(), c.getGet_money() });
				}
				// 创建工作薄
				WritableWorkbook workbook;
				try {
					workbook = Workbook
							.createWorkbook(new File(time[0] + "year" + time[1] + "month" + time[2] + "day.xls"));
					// 创建新的一页
					WritableSheet sheet = workbook.createSheet("统计", 0);
					// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
					Label head0 = new Label(0, 0, "编号");
					sheet.addCell(head0);
					Label head1 = new Label(1, 0, "名称");
					sheet.addCell(head1);
					Label head2 = new Label(2, 0, "厂商");
					sheet.addCell(head2);
					Label head3 = new Label(3, 0, "销售数量");
					sheet.addCell(head3);
					Label head4 = new Label(4, 0, "总进价");
					sheet.addCell(head4);
					Label head5 = new Label(5, 0, "总销售额");
					sheet.addCell(head5);
					Label head6 = new Label(6, 0, "盈利");
					sheet.addCell(head6);
					int i = 1;
					for (CaculateBean c : caculateList) {
						Label headnew = new Label(0, i, c.getBarcode());
						sheet.addCell(headnew);
						Label headnew2 = new Label(1, i, c.getP_name());
						sheet.addCell(headnew2);
						Label headnew3 = new Label(2, i, c.getP_producer());
						sheet.addCell(headnew3);
						Label headnew4 = new Label(3, i, c.getSum_number() + "");
						sheet.addCell(headnew4);
						Label headnew5 = new Label(4, i, c.getAll_in() + "");
						sheet.addCell(headnew5);
						Label headnew6 = new Label(5, i, c.getSum_money() + "");
						sheet.addCell(headnew6);
						Label headnew7 = new Label(6, i, c.getGet_money() + "");
						sheet.addCell(headnew7);
						i++;
					}
					// 把创建的内容写入到输出流中，并关闭输出流
					workbook.write();
					workbook.close();
					JOptionPane.showMessageDialog(null, "导出成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(873, 623, 93, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("\u6CE8\uFF1A\u5BFC\u51FA\u76EE\u5F55\u751F\u6210\u5728\u76EE\u5F55\u4E0B");
		label.setBounds(36, 682, 394, 15);
		contentPane.add(label);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dc.setLocationRelativeTo(lblNewLabel);
				dc.setVisible(true);
				java.util.Calendar cal = dc.getSelectedDate();
				if (cal != null) {
					lblNewLabel.setText(FORMATTER.format(cal.getTime()));
				}

			}
		});
	}

	protected void uploadYear() {
		// TODO Auto-generated method stub
		String[] time = lblNewLabel.getText().trim().split("[.]");
		if (time.length != 3)
			return;
		List<CaculateBean> caculateList = caculateImpl.getyear(time[0]);
		DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
		for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
			tableModel.removeRow(i);
		}
		for (CaculateBean c : caculateList) {
			tableModel.addRow(new Object[] { c.getBarcode(), c.getP_name(), c.getP_producer(), c.getSum_number(),
					c.getAll_in(), c.getSum_money(), c.getGet_money() });
		}
		

	}
}
