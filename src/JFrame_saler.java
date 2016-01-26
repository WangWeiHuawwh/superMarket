
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.*;

import com.cloudgarden.layout.AnchorConstraint;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class JFrame_saler extends javax.swing.JFrame {

	private String log_eid;//记录登陆者的ID号
	private float every_due_money = 0;//一次交易中每种商品总共要付的钱
	private Float due_money = new Float(0);//应付的金额
	private Float back_money = new Float(0);//应找的钱
	private static final long serialVersionUID = 1L;
	private JLabel jLabel_title;
	private JLabel jLabel_in_money;
	private JButton jButton_back;
	private JButton jButton_cancel;
	private JButton jButton_commit;
	private JButton jButton_add;
	private JTable jTable_data;
	private JScrollPane jScrollPane_data;
	private JButton jButton1;
	private JTextField jTextField_all_price;
	private JLabel jLabel2_all_price;
	private JLabel jLabel1;
	private JTextField jTextField_back_money;
	private JLabel jLabel_back_money;
	private JTextField jTextField_in_money;
	private JLabel jLabel_barcode;
	private JLabel jLabel_num;
	private JTextField jTextField_num;
	private JTextField jTextField_commodity;
	private JTextField jTextField_price;
	private JTextField jTextField_name;
	private JTextField jTextField_barcode;
	private JLabel jLabel_price;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel_guige;
	private JLabel jLabel_name;

	private Query q;
	
	public JFrame_saler() {
		setTitle("销售系统");
		initGUI();
		q = new Query();
	}
	
	private void initGUI() {
		try {
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.getContentPane().setBackground(new java.awt.Color(241,156,235));
			AnchorLayout thisLayout = new AnchorLayout();
			this.getContentPane().setLayout(thisLayout);
			this.setLocation(new java.awt.Point(240, 50));
			this.setIgnoreRepaint(true);

			//返回主界面
			{
				jLabel5 = new JLabel();
				this.getContentPane().add(
					jLabel5,
					new AnchorConstraint(
						209,
						885,
						253,
						841,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel5.setText("(\u5143)");
				jLabel5.setPreferredSize(new java.awt.Dimension(35, 29));
				jLabel5.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel4 = new JLabel();
				this.getContentPane().add(
					jLabel4,
					new AnchorConstraint(
						487,
						889,
						532,
						846,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel4.setText("(\u5143)");
				jLabel4.setPreferredSize(new java.awt.Dimension(34, 30));
				jLabel4.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel3 = new JLabel();
				this.getContentPane().add(
					jLabel3,
					new AnchorConstraint(
						398,
						889,
						442,
						844,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("(\u5143)");
				jLabel3.setPreferredSize(new java.awt.Dimension(36, 29));
				jLabel3.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel2 = new JLabel();
				this.getContentPane().add(
					jLabel2,
					new AnchorConstraint(
						304,
						888,
						347,
						841,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("(\u5143)");
				jLabel2.setPreferredSize(new java.awt.Dimension(37, 29));
				jLabel2.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jScrollPane_data = new JScrollPane();
				this.getContentPane().add(
						jScrollPane_data,
						new AnchorConstraint(
							679,
							977,
							991,
							23,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
				jScrollPane_data.setPreferredSize(new java.awt.Dimension(746, 225));
				jScrollPane_data.setAutoscrolls(true);
				jScrollPane_data.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				{
					Object rowdata[][]={{null,null,null,null,null}};
					String names[]={"条形码", "商品名称","零售价","购买数量","商品规格" };

					TableModel jTable_dataModel = new DefaultTableModel(new String[][] {{"条形码","商品名称","零售价",
						"购买数量","商品规格"}},new String[]{"", "","","","" });
					jTable_data = new JTable(rowdata,names);

					jScrollPane_data.setViewportView(jTable_data);
					jTable_data.setColumnSelectionAllowed(true); 
					jTable_data.setModel(jTable_dataModel);
					jTable_data.setEnabled(false);
				}
			}
			{
				jButton1 = new JButton();
				this.getContentPane().add(
					jButton1,
					new AnchorConstraint(
						611,
						711,
						662,
						605,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton1.setText("\u8fd4\u56de");
				jButton1.setPreferredSize(new java.awt.Dimension(84, 34));
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						dispose();//关闭本窗口
						System.gc();
						logon l = new logon();
						l.setVisible(true);
					}
				});
			}
			{
				jTextField_all_price = new JTextField();
				this.getContentPane().add(
					jTextField_all_price,
					new AnchorConstraint(
						395,
						839,
						445,
						639,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_all_price.setPreferredSize(new java.awt.Dimension(158, 33));
				jTextField_all_price.setEditable(false);
			}
			{
				jLabel2_all_price = new JLabel();
				this.getContentPane().add(
					jLabel2_all_price,
					new AnchorConstraint(
						397,
						618,
						443,
						524,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel2_all_price.setText("\u5e94\u6536\u91d1\u989d");
				jLabel2_all_price.setPreferredSize(new java.awt.Dimension(74, 31));
				jLabel2_all_price.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel1 = new JLabel();
				this.getContentPane().add(
					jLabel1,
					new AnchorConstraint(
						209,
						500,
						256,
						452,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("(5\u4f4d)");
				jLabel1.setPreferredSize(new java.awt.Dimension(38, 31));
				jLabel1.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				//退出button
				jButton_back = new JButton();
				this.getContentPane().add(
					jButton_back,
					new AnchorConstraint(
						610,
						860,
						661,
						750,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_back.setText("\u9000\u51fa");
				jButton_back.setPreferredSize(new java.awt.Dimension(87, 34));
				jButton_back.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});
			}
			{
				jButton_cancel = new JButton();
				this.getContentPane().add(
					jButton_cancel,
					new AnchorConstraint(
						610,
						565,
						661,
						456,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_cancel.setText("\u53d6\u6d88\u4ea4\u6613");
				jButton_cancel.setPreferredSize(new java.awt.Dimension(86, 34));
				//事件监听
				jButton_cancel.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
//						----------------------数据库连接-------------------------------
						//1.加载驱动
						try {
							q.initSQLLink(null , null , null);
							q.getStmt().executeUpdate("rollback");
							setLog_eid("");
							clearTextField();
							//处理ResultSet
						}catch (SQLException e1) {
							System.out.println("SQL语句错误！");
						}
					}
				});
			}
			{
				jButton_commit = new JButton();
				this.getContentPane().add(
					jButton_commit,
					new AnchorConstraint(
						610,
						258,
						661,
						147,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_commit.setText("\u5b8c\u6210\u4ea4\u6613");
				jButton_commit.setPreferredSize(new java.awt.Dimension(88, 34));
				jButton_commit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						if(jTextField_in_money.getText().equals(""))
							JOptionPane.showMessageDialog(null,"实收金额不能为零！");//提示消息对话框
						else
						{
							back_money = Float.parseFloat(jTextField_in_money.getText())-due_money;
							if(back_money<0)
							{
								JOptionPane.showMessageDialog(null,"您支付的金额不足，请您重新付款！");
								jButton_commit.setText("");
							}
							else
							{
								jTextField_back_money.setText(back_money.toString());
								jTextField_all_price.setText(due_money.toString());
								//---------------连接数据库，提交交易信息---------------------------------------
								//1.加载驱动
								try {
									q.initSQLLink(null , null , null);
									//4.执行sql
									q.getStmt().executeUpdate("commit");
									setLog_eid(null);
									//处理ResultSet
								}catch (SQLException e1) {
									System.out.println("SQL语句错误！");
								}
							}
						}
					}
				});
			}
			{
				jButton_add = new JButton();
				this.getContentPane().add(
					jButton_add,
					new AnchorConstraint(
						610,
						413,
						661,
						302,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_add.setText("\u6dfb\u52a0");
				jButton_add.setPreferredSize(new java.awt.Dimension(88, 34));
				jButton_add.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						if(jTextField_barcode.getText().equals("")&&jTextField_name.getText().equals("")&&
								jTextField_price.getText().equals("")&&jTextField_num.getText().equals("")&&
								jTextField_commodity.getText().equals(""))
							JOptionPane.showMessageDialog(null, "不能添加空值！");//提示消息对话框
						else
						{//----------------------数据库连接-------------------------------
							try {
								q.initSQLLink(null,null,null);
								//4.执行sql
								q.setRs(q.getStmt().executeQuery("select s_num from storage where s_barcode="+Integer.parseInt(jTextField_barcode.getText())));
								//====================添加Button的功能实现（向table中插入和向数据库中插入）=================================================
								//-------------------将销售信息插入到售货表中--------------------------------------------------
								while(q.getRs().next())
								{
									int num = q.getRs().getInt("s_num");
									if(num<Integer.parseInt(jTextField_num.getText()))
									{
										JOptionPane.showMessageDialog(null,"库存不足,请重新输入！");
										jTextField_num.setText("");
									}
									else
									{
										//将库存中商品的数目减去已出售商品的数目
										q.getStmt().executeUpdate("update storage set s_num = s_num - "+jTextField_num.getText()+" where s_barcode = "+jTextField_barcode.getText());
										//一笔交易中每种商品应付的金额
										every_due_money = Float.parseFloat(jTextField_price.getText())*Integer.parseInt(jTextField_num.getText());
										//计算总共应付的金额
										due_money += every_due_money;
										//将出售商品的信息添加到销售表中
										q.getStmt().executeUpdate("insert into sale(sale_barcode,sale_num,price,eid,every_due_money) values("+jTextField_barcode.getText()+","
												+Float.parseFloat(jTextField_num.getText())+","+Float.parseFloat(jTextField_price.getText())+",'"+log_eid+"',"+every_due_money+")");
										//添加下一行
										tableModel.addRow(new Object[]{jTextField_barcode.getText(), jTextField_name.getText(),
												jTextField_price.getText(),jTextField_num.getText(),jTextField_commodity.getText()});
	//									将文本框中的内容清空，以便下一次输入
										clearTextField();
										break;
									}
								}
							} catch (SQLException e1) {
								System.out.println("jbutton_add + SQL语句错误！"+e1.getMessage());
							}
						}
					}
				});
			}
			{
				jTextField_back_money = new JTextField();
				this.getContentPane().add(
					jTextField_back_money,
					new AnchorConstraint(
						485,
						840,
						535,
						639,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_back_money.setPreferredSize(new java.awt.Dimension(159, 33));
				jTextField_back_money.setEditable(false);
			}
			{
				jLabel_back_money = new JLabel();
				this.getContentPane().add(
					jLabel_back_money,
					new AnchorConstraint(
						487,
						602,
						535,
						527,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_back_money.setText("\u627e\u96f6");
				jLabel_back_money.setPreferredSize(new java.awt.Dimension(60, 32));
				jLabel_back_money.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_in_money = new JTextField();
				this.getContentPane().add(
					jTextField_in_money,
					new AnchorConstraint(
						301,
						836,
						350,
						638,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_in_money.setPreferredSize(new java.awt.Dimension(157, 33));
			}
			{
				jLabel_in_money = new JLabel();
				this.getContentPane().add(
					jLabel_in_money,
					new AnchorConstraint(
						304,
						615,
						353,
						524,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_in_money.setText("\u5b9e\u6536\u91d1\u989d");
				jLabel_in_money.setPreferredSize(new java.awt.Dimension(72, 33));
				jLabel_in_money.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_num = new JTextField();
				this.getContentPane().add(
					jTextField_num,
					new AnchorConstraint(
						394,
						447,
						446,
						250,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_num.setPreferredSize(new java.awt.Dimension(156, 35));
			}
			{
				jTextField_commodity = new JTextField();
				this.getContentPane().add(
					jTextField_commodity,
					new AnchorConstraint(
						488,
						450,
						538,
						250,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_commodity.setPreferredSize(new java.awt.Dimension(158, 33));
				jTextField_commodity.setEditable(false);
			}
			{
				jTextField_price = new JTextField();
				this.getContentPane().add(
					jTextField_price,
					new AnchorConstraint(
						204,
						835,
						256,
						638,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_price.setPreferredSize(new java.awt.Dimension(156, 34));
				jTextField_price.setEditable(false);
			}
			{
				jTextField_name = new JTextField();
				this.getContentPane().add(
					jTextField_name,
					new AnchorConstraint(
						305,
						446,
						356,
						250,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_name.setPreferredSize(new java.awt.Dimension(155, 34));
				jTextField_name.setEditable(false);
			}
			{
				jTextField_barcode = new JTextField();
				this.getContentPane().add(
					jTextField_barcode,
					new AnchorConstraint(
						207,
						447,
						260,
						251,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_barcode.setPreferredSize(new java.awt.Dimension(155, 35));
				jTextField_barcode.addKeyListener(new KeyAdapter()
				{
					public void keyTyped(KeyEvent e) {
//						----------------------数据库连接-------------------------------
						boolean flag1=true;
						if(jTextField_barcode.getText().length()==5)
						{
							//1.加载驱动
							try {
								q.initSQLLink(null, null, null);
								//4.执行sql
								q.setRs(q.getStmt().executeQuery("select * from storage"));
								//====================向barcode文本框输入条形码，同时在其它文本框中显示相应信息=================================================
								//处理ResultSet
								while(q.getRs().next())
								{
									if(jTextField_barcode.getText().equals(q.getRs().getString("s_barcode")))
									{
										//------------------输入条形码，将相应信息自动显示到其它文本框中-----------------------------
										jTextField_name.setText(q.getRs().getString("gname"));
										jTextField_price.setText(q.getRs().getString("sale_price"));
										jTextField_commodity.setText(q.getRs().getString("commodity"));
										flag1 = false;
										break;
									}
								}
								if(flag1)
								{
									JOptionPane.showMessageDialog(null, "没有此商品,请重新输入！");//提示消息对话框
									jTextField_barcode.setText("");
								}
								//==================================================================================================
							} catch (SQLException e1) {
								System.out.println("SQL语句错误！");
							}
						}
					}
				});
			}
			{
				jLabel_price = new JLabel();
				this.getContentPane().add(
					jLabel_price,
					new AnchorConstraint(
						206,
						599,
						260,
						523,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_price.setText("\u96f6\u552e\u4ef7");
				jLabel_price.setPreferredSize(new java.awt.Dimension(60, 36));
				jLabel_price.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel_num = new JLabel();
				this.getContentPane().add(
					jLabel_num,
					new AnchorConstraint(
						398,
						205,
						446,
						118,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_num.setText("\u8d2d\u4e70\u6570\u91cf");
				jLabel_num.setPreferredSize(new java.awt.Dimension(69, 32));
				jLabel_num.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel_guige = new JLabel();
				this.getContentPane().add(
					jLabel_guige,
					new AnchorConstraint(
						478,
						205,
						529,
						118,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_guige.setText("\u5546\u54c1\u89c4\u683c");
				jLabel_guige.setPreferredSize(new java.awt.Dimension(69, 34));
				jLabel_guige.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel_name = new JLabel();
				this.getContentPane().add(
					jLabel_name,
					new AnchorConstraint(
						305,
						206,
						355,
						118,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_name.setText("\u5546\u54c1\u540d\u79f0");
				jLabel_name.setPreferredSize(new java.awt.Dimension(70, 33));
				jLabel_name.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel_barcode = new JLabel();
				this.getContentPane().add(
					jLabel_barcode,
					new AnchorConstraint(
						207,
						200,
						260,
						124,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_barcode.setText("\u6761\u5f62\u7801");
				jLabel_barcode.setPreferredSize(new java.awt.Dimension(60, 35));
				jLabel_barcode.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel_title = new JLabel();
				this.getContentPane().add(
					jLabel_title,
					new AnchorConstraint(
						52,
						711,
						117,
						275,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_title.setText("\u6b22\u8fce\u60a8\u8fdb\u5165\u9500\u552e\u7cfb\u7edf");
				jLabel_title.setPreferredSize(new java.awt.Dimension(345, 37));
				jLabel_title.setFont(new java.awt.Font("楷体_GB2312",1,36));
				jLabel_title.setForeground(new java.awt.Color(0,0,255));
			}
			pack();
			this.setSize(800, 700);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void clearTextField()
	{
		jTextField_barcode.setText("");
		jTextField_name.setText("");
		jTextField_in_money.setText("");
		jTextField_price.setText("");
		jTextField_commodity.setText("");
		jTextField_num.setText("");
		jTextField_back_money.setText("");
		jTextField_all_price.setText("");
	}

	public String getLog_eid() {
		return log_eid;
	}

	public void setLog_eid(String log_eid) {
		this.log_eid = log_eid;
	}
}
