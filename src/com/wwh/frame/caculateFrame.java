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
		setBounds(100, 100, 768, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final DateChooser dc = new DateChooser(this, true);

		lblNewLabel = new JLabel("2016.02.01");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(168, 10, 150, 52);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("select day");
		btnNewButton.setBounds(36, 26, 93, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("\u6309\u5E74\u5BFC\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uploadYear();
			}
		});
		btnNewButton_1.setBounds(649, 83, 93, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane_data = new JScrollPane();
		scrollPane_data.setPreferredSize(new Dimension(737, 251));
		scrollPane_data.setBounds(36, 83, 603, 456);
		contentPane.add(scrollPane_data);
		scrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "���", "����", "����", "��������", "�ܽ���", "�����۶�", "ӯ��" };

			TableModel jTable_dataModel = new DefaultTableModel(
					new String[][] { { "���", "����", "����", "��������", "�ܽ���", "�����۶�", "ӯ��" } },
					new String[] { "", "", "", "", "", "", "" });
			jTable_data = new JTable(rowdata, names);

			scrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		JButton btnNewButton_2 = new JButton("\u6309\u6708\u5BFC\u51FA");
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
				// ����������
				WritableWorkbook workbook;
				try {
					workbook = Workbook.createWorkbook(new File(time[0] + "year" + time[1] + "month.xls"));
					// �����µ�һҳ
					WritableSheet sheet = workbook.createSheet("ͳ��", 0);
					// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
					Label head0 = new Label(0, 0, "���");
					sheet.addCell(head0);
					Label head1 = new Label(1, 0, "����");
					sheet.addCell(head1);
					Label head2 = new Label(2, 0, "����");
					sheet.addCell(head2);
					Label head3 = new Label(3, 0, "��������");
					sheet.addCell(head3);
					Label head4 = new Label(4, 0, "�ܽ���");
					sheet.addCell(head4);
					Label head5 = new Label(5, 0, "�����۶�");
					sheet.addCell(head5);
					Label head6 = new Label(6, 0, "ӯ��");
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
					// �Ѵ���������д�뵽������У����ر������
					workbook.write();
					workbook.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_2.setBounds(649, 131, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u6309\u65E5\u5BFC\u51FA");
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
				// ����������
				WritableWorkbook workbook;
				try {
					workbook = Workbook
							.createWorkbook(new File(time[0] + "year" + time[1] + "month" + time[2] + "day.xls"));
					// �����µ�һҳ
					WritableSheet sheet = workbook.createSheet("ͳ��", 0);
					// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
					Label head0 = new Label(0, 0, "���");
					sheet.addCell(head0);
					Label head1 = new Label(1, 0, "����");
					sheet.addCell(head1);
					Label head2 = new Label(2, 0, "����");
					sheet.addCell(head2);
					Label head3 = new Label(3, 0, "��������");
					sheet.addCell(head3);
					Label head4 = new Label(4, 0, "�ܽ���");
					sheet.addCell(head4);
					Label head5 = new Label(5, 0, "�����۶�");
					sheet.addCell(head5);
					Label head6 = new Label(6, 0, "ӯ��");
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
					// �Ѵ���������д�뵽������У����ر������
					workbook.write();
					workbook.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(649, 184, 93, 23);
		contentPane.add(btnNewButton_3);

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
		// ����������
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(new File(time[0] + "year.xls"));
			// �����µ�һҳ
			WritableSheet sheet = workbook.createSheet("ͳ��", 0);
			// ����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
			Label head0 = new Label(0, 0, "���");
			sheet.addCell(head0);
			Label head1 = new Label(1, 0, "����");
			sheet.addCell(head1);
			Label head2 = new Label(2, 0, "����");
			sheet.addCell(head2);
			Label head3 = new Label(3, 0, "��������");
			sheet.addCell(head3);
			Label head4 = new Label(4, 0, "�ܽ���");
			sheet.addCell(head4);
			Label head5 = new Label(5, 0, "�����۶�");
			sheet.addCell(head5);
			Label head6 = new Label(6, 0, "ӯ��");
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
			// �Ѵ���������д�뵽������У����ر������
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
