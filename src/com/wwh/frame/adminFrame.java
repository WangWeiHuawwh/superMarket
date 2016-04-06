package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class adminFrame extends JFrame implements Printable {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static adminFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new adminFrame();
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
	public adminFrame() {
		setTitle("\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u8FDB\u8D27\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buyFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		button.setBounds(33, 38, 93, 23);
		contentPane.add(button);

		JButton btnNewButton = new JButton("\u9500\u552E\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton.setBounds(210, 38, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u5458\u5DE5\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_1.setBounds(403, 38, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton button_1 = new JButton("\u4F1A\u5458\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vipFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		button_1.setBounds(33, 133, 93, 23);
		contentPane.add(button_1);

		JButton btnNewButton_2 = new JButton("\u9000\u8D27\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_2.setBounds(210, 133, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		btnNewButton_3.setBounds(403, 133, 93, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u62A5\u8868\u7EDF\u8BA1");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caculateFrame.main(null);
			}
		});
		btnNewButton_4.setBounds(403, 215, 93, 23);
		contentPane.add(btnNewButton_4);

		JButton button_2 = new JButton("\u9500\u552E\u8BB0\u5F55");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saleRecordFrame.main(null);
				// frame.dispose();// 关闭本窗口
			}
		});
		button_2.setBounds(33, 215, 93, 23);
		contentPane.add(button_2);

		JButton btnNewButton_5 = new JButton("\u6C47\u7387\u8BBE\u7F6E");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingFrame.main(null);
			}
		});
		btnNewButton_5.setBounds(210, 215, 93, 23);
		contentPane.add(btnNewButton_5);

		JButton button_3 = new JButton("\u6253\u5370");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int height = 175 + 3 * 15 + 20;
				// 通俗理解就是书、文档
				Book book = new Book();
				// 打印格式
				PageFormat pf = new PageFormat();
				pf.setOrientation(PageFormat.PORTRAIT);
				// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
				Paper p = new Paper();
				p.setSize(230, height);
				p.setImageableArea(5, -20, 230, height + 20);
				pf.setPaper(p);
				// 把 PageFormat 和 Printable 添加到书中，组成一个页面
				book.append(new adminFrame(), pf);
				// 获取打印服务对象
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPageable(book);
				try {
					job.print();
				} catch (PrinterException e) {
					System.out.println("================打印出现异常");
				}
			}
		});
		button_3.setBounds(33, 277, 93, 23);
		contentPane.add(button_3);
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		if (page > 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("Default", Font.PLAIN, 14));
		g2d.drawString("等位排单号", 50, 10);
		g2d.drawString("-------------------------------------", 7, 20);
		g2d.drawString("手机号码：11111111111", 7, 35);
		g2d.drawString("领号日期：" + "11111", 7, 65);
		g2d.drawString("-------------------------------------", 7, 80);
		g2d.setFont(new Font("Default", Font.PLAIN, 25));
		g2d.drawString("小号", 7, 105);
		g2d.setFont(new Font("Default", Font.PLAIN, 14));
		g2d.drawString("您之前还有" + 5 + "桌客人在等待", 7, 130);
		g2d.drawString("-------------------------------------", 7, 145);
		g2d.drawString("*打印时间:" + "1111" + "*", 7, 160);
		g2d.drawString("店名：11", 7, 175);

		return PAGE_EXISTS;
	}

}
