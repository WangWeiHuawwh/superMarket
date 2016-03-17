package com.wwh.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.wwh.bean.UserBean;
import com.wwh.bean.UserImpl;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class userFrame extends JFrame {

	private JPanel contentPane;
	private JTable jTable_data;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private UserImpl userimpl;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userFrame frame = new userFrame();
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
	public userFrame() {
		userimpl = new UserImpl();
		setTitle("\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane jScrollPane_data = new JScrollPane();
		jScrollPane_data.setPreferredSize(new Dimension(737, 251));
		jScrollPane_data.setBounds(182, 49, 430, 445);
		contentPane.add(jScrollPane_data);
		jScrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
		{
			Object rowdata[][] = { { null, null, null, null, null, null, null } };
			String names[] = { "编号", "姓名", "职位", "密码", "电话" };

			TableModel jTable_dataModel = new DefaultTableModel(new String[][] { { "编号", "姓名", "职位", "密码", "电话" } },
					new String[] { "", "", "", "", "", });
			jTable_data = new JTable(rowdata, names);

			jScrollPane_data.setViewportView(jTable_data);
			jTable_data.setModel(jTable_dataModel);
		}

		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		label.setBounds(10, 61, 54, 15);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(61, 58, 82, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(10, 111, 54, 15);
		contentPane.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(61, 108, 82, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u804C\u4F4D\uFF1A");
		label_2.setBounds(10, 164, 54, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u5BC6\u7801\uFF1A");
		label_3.setBounds(10, 215, 54, 15);
		contentPane.add(label_3);

		textField_3 = new JTextField();
		textField_3.setBounds(63, 212, 80, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setBounds(10, 267, 54, 15);
		contentPane.add(label_4);

		textField_4 = new JTextField();
		textField_4.setBounds(61, 264, 82, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isFull()) {
					UserBean userBean = new UserBean();
					userBean.setEid(textField.getText().trim());
					userBean.setEname(textField_1.getText().trim());
					switch (comboBox.getSelectedIndex()) {
					case 0:
						userBean.setJob("saler");
						break;
					case 1:
						userBean.setJob("buyer");
						break;
					case 3:
						userBean.setJob("admin");
						break;

					}
					userBean.setPwd(textField_3.getText().trim());
					userBean.setPhone(textField_4.getText().trim());
					userimpl.save(userBean);
					JOptionPane.showMessageDialog(null, "添加成功");
					initData();
				}
			}
		});
		button.setBounds(76, 352, 93, 23);
		contentPane.add(button);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u552E\u8D27\u5458", "\u8FDB\u8D27\u5458", "\u7BA1\u7406\u5458" }));
		comboBox.setBounds(61, 161, 86, 21);
		contentPane.add(comboBox);
		initData();
	}

	protected boolean isFull() {
		// TODO Auto-generated method stub
		if (textField.getText().length() > 0 && textField_1.getText().length() > 0 && textField_3.getText().length() > 0
				&& textField_4.getText().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void initData() {
		textField.setText("");
		textField_1.setText("");
		textField_3.setText("");
		textField_4.setText("");
		DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
		for (int i = tableModel.getRowCount() - 1; i > 0; i--) {
			tableModel.removeRow(i);
		}
		List<UserBean> storeList = userimpl.getAll();
		for (UserBean storehouse : storeList) {
			tableModel.addRow(new Object[] { storehouse.getEid(), storehouse.getEname(), storehouse.getJob(),
					storehouse.getPwd(), storehouse.getPhone() });
		}
	}
}
