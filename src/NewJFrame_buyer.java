import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.cloudgarden.layout.AnchorLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.cloudgarden.layout.AnchorConstraint;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


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
 * @param <logon>
* *************************************
*/
public class NewJFrame_buyer extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String log_eid;//记录登陆者的ID号
	Float sum = new Float(0);
	private JTable jTable_data;
	private JScrollPane jScrollPane_data;
	private JLabel jLabel_title;
	private JLabel jLabel_in_price;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JButton jButton_back;
	private JButton jButton_all_query;
	private JButton jButton_over_query;
	private JButton jButton_buy;
	private JTextField jTextField_gname;
	private JLabel jLabel1_gname;
	private JTextField jTextField_producer;
	private JLabel jLabel_producer;
	private JTextField jTextField_commodity;
	private JLabel jLabel_commodity;
	private JTextField jTextField_buy_num;
	private JLabel jLabel_buy_num;
	private JTextField jTextField_in_price;
	private JTextField jTextField_i_barcode;
	private JLabel jLabel_i_barcode;

	private Query q;
	
	public NewJFrame_buyer() {
		
		setTitle("采购员系统");
		initGUI();
		q = new Query();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setLocation(new java.awt.Point(240, 100));
			AnchorLayout thisLayout = new AnchorLayout();
			this.getContentPane().setLayout(thisLayout);
			this.getContentPane().setBackground(new java.awt.Color(255,128,255));
			setVisible(true);
			{
				jLabel1 = new JLabel();
				this.getContentPane().add(
					jLabel1,
					new AnchorConstraint(
						447,
						490,
						499,
						455,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("(< 5)");
				jLabel1.setPreferredSize(new java.awt.Dimension(28, 29));
			}
			{
				jScrollPane_data = new JScrollPane();
				this.getContentPane().add(
					jScrollPane_data,
					new AnchorConstraint(
						534,
						964,
						977,
						33,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jScrollPane_data.setPreferredSize(new java.awt.Dimension(737, 251));
				{
					Object rowdata[][]={{null,null,null,null,null,null,null}};
					String names[]={"条形码","商品名称","数量","商品规格","进价","总价值","生产厂商"};

					TableModel jTable_dataModel = new DefaultTableModel(new String[][] {{"条形码","商品名称","数量",
						"商品规格","进价","总价值","生产厂商"}},new String[]{"","","","","","",""});
					jTable_data = new JTable(rowdata,names);

					jScrollPane_data.setViewportView(jTable_data);
					jTable_data.setModel(jTable_dataModel);
				}
			}
			{
				jLabel = new JLabel();
				this.getContentPane().add(
					jLabel,
					new AnchorConstraint(
						154,
						517,
						207,
						442,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel.setText("(5\u4f4d)");
				jLabel.setPreferredSize(new java.awt.Dimension(59, 30));
				jLabel.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jButton_back = new JButton();
				this.getContentPane().add(
					jButton_back,
					new AnchorConstraint(
						446,
						822,
						497,
						711,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_back.setText("\u8fd4\u56de");
				jButton_back.setPreferredSize(new java.awt.Dimension(88, 29));
				jButton_back.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e) {
						dispose();//关闭本窗口程序
						System.gc();//建议垃圾回收机制回收垃圾
						logon Logon = new logon();
						Logon.setVisible(true);
					}
				});
			}
			{
				jButton_all_query = new JButton();
				this.getContentPane().add(
					jButton_all_query,
					new AnchorConstraint(
						446,
						640,
						497,
						529,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_all_query.setText("\u5e93\u5b58\u67e5\u8be2");
				jButton_all_query.setPreferredSize(new java.awt.Dimension(88, 29));
				jButton_all_query.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e) {
						//清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)

						q.buyer_storageQuery(tableModel, "select * from storage");
					}
				});
			}
			{
				jButton_over_query = new JButton();
				this.getContentPane().add(
					jButton_over_query,
					new AnchorConstraint(
						444,
						451,
						497,
						335,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_over_query.setText("\u7f3a\u8d27\u67e5\u8be2");
				jButton_over_query.setPreferredSize(new java.awt.Dimension(92, 30));
				jButton_over_query.addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent e) {
//						清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
							
						q.buyer_storageQuery(tableModel, "select * from storage where s_num <= 5");
					}
				});
			}
			{
				jButton_buy = new JButton();
				this.getContentPane().add(
					jButton_buy,
					new AnchorConstraint(
						444,
						263,
						495,
						153,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_buy.setText("\u91c7\u8d2d\u8d27\u7269");
				jButton_buy.setPreferredSize(new java.awt.Dimension(87, 29));
				jButton_buy.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
						if(jTextField_i_barcode.getText().length() != 5)
						{
							clearTextField();
							JOptionPane.showMessageDialog(null, "请输入5位条形码！");
						}
						else if(jTextField_i_barcode.getText().equals("")&&jTextField_gname.getText().equals("")&&
								jTextField_commodity.getText().equals("")&&jTextField_buy_num.getText().equals("")&&
								jTextField_in_price.getText().equals("")&&jTextField_producer.getText().equals(""))
							JOptionPane.showMessageDialog(null, "不能添加空值！");//提示消息对话框
						else
						{
							//----------------------数据库连接-------------------------------
							boolean flag = true;
							//1.加载驱动
							try {
								q.initSQLLink(null , null , null);
								//4.执行sql
								q.setRs(q.getStmt().executeQuery("select * from storage where s_barcode="+jTextField_i_barcode.getText()));
								//处理ResultSet
								
								//====================添加Button的功能实现（向table中插入和向数据库中插入）=================================================
								//-------------------将销售信息插入到售表中--------------------------------------------------
								while(q.getRs().next())
								{
									int barcode = q.getRs().getInt("s_barcode");
									//如果货物已存在于库存中
									if(barcode==Integer.parseInt(jTextField_i_barcode.getText()))
									{
										sum = Integer.parseInt(jTextField_buy_num.getText())*Float.parseFloat(jTextField_in_price.getText());
										q.getStmt().executeUpdate("insert into in_goods(i_barcode,buy_num,in_price,eid,sum_money) values("+barcode+","+jTextField_buy_num.getText()+","
												+jTextField_in_price.getText()+","+log_eid+","+sum.toString()+")");
										
										q.getStmt().executeUpdate("update storage set s_num = s_num + "+jTextField_buy_num.getText()+",sale_price="+(Float.parseFloat(jTextField_in_price.getText())*1.5)+" where s_barcode = "+barcode);
										flag = false;
										break;
									}
								}
								//如果货物不存在于库存中
								if(flag)
								{
									sum = Integer.parseInt(jTextField_buy_num.getText())*Float.parseFloat(jTextField_in_price.getText());
									q.getStmt().executeUpdate("insert into in_goods(i_barcode,buy_num,in_price,eid,sum_money) values("+jTextField_i_barcode.getText()+","+jTextField_buy_num.getText()+","
											+jTextField_in_price.getText()+","+log_eid+","+sum.toString()+")");
									//默认sale_price = in_price*2
									q.getStmt().executeUpdate("insert into storage(s_barcode,gname,s_num,producer,commodity,sale_price) values("+jTextField_i_barcode.getText()
											+",'"+jTextField_gname.getText()+"','"+jTextField_buy_num.getText()+"','"+jTextField_producer.getText()+"','"+
											jTextField_commodity.getText()+"',"+(Float.parseFloat(jTextField_in_price.getText())*1.5)+")");
//									将商品名称、商品规格、生产厂商的文本框设为不可修改
									jTextField_gname.setEditable(false);
									jTextField_commodity.setEditable(false);
									jTextField_producer.setEditable(false);
								}
								q.getStmt().executeUpdate("commit");
								//添加下一行
								tableModel.addRow(new Object[]{jTextField_i_barcode.getText(), jTextField_gname.getText(),jTextField_buy_num.getText(),
										jTextField_commodity.getText(),jTextField_in_price.getText(),sum,jTextField_producer.getText()});
								//将文本框中的内容清空，以便下一次输入
								clearTextField();
								//==================================================================================================
							} catch (SQLException e1) {
								clearTextField();
								JOptionPane.showMessageDialog(null, "请输入数字！");
							}
						}
					}
				});
			}
			{
				jTextField_gname = new JTextField();
				this.getContentPane().add(
					jTextField_gname,
					new AnchorConstraint(
						237,
						438,
						287,
						291,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_gname.setPreferredSize(new java.awt.Dimension(117, 28));
				jTextField_gname.setEditable(false);
			}
			{
				jLabel1_gname = new JLabel();
				this.getContentPane().add(
					jLabel1_gname,
					new AnchorConstraint(
						239,
						272,
						285,
						174,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel1_gname.setText("\u5546\u54c1\u540d\u79f0");
				jLabel1_gname.setPreferredSize(new java.awt.Dimension(77, 26));
				jLabel1_gname.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_producer = new JTextField();
				this.getContentPane().add(
					jTextField_producer,
					new AnchorConstraint(
						315,
						804,
						366,
						644,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_producer.setPreferredSize(new java.awt.Dimension(127, 29));
				jTextField_producer.setEditable(false);
			}
			{
				jLabel_producer = new JLabel();
				this.getContentPane().add(
					jLabel_producer,
					new AnchorConstraint(
						317,
						620,
						368,
						530,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_producer.setText("\u751f\u4ea7\u5382\u5546");
				jLabel_producer.setPreferredSize(new java.awt.Dimension(71, 29));
				jLabel_producer.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_commodity = new JTextField();
				this.getContentPane().add(
					jTextField_commodity,
					new AnchorConstraint(
						317,
						440,
						368,
						292,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_commodity.setPreferredSize(new java.awt.Dimension(117, 29));
				jTextField_commodity.setEditable(false);
			}
			{
				jLabel_commodity = new JLabel();
				this.getContentPane().add(
					jLabel_commodity,
					new AnchorConstraint(
						317,
						269,
						368,
						173,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_commodity.setText("\u5546\u54c1\u89c4\u683c");
				jLabel_commodity.setPreferredSize(new java.awt.Dimension(76, 29));
				jLabel_commodity.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_buy_num = new JTextField();
				this.getContentPane().add(
					jTextField_buy_num,
					new AnchorConstraint(
						152,
						802,
						205,
						643,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_buy_num.setPreferredSize(new java.awt.Dimension(126, 30));
			}
			{
				jLabel_buy_num = new JLabel();
				this.getContentPane().add(
					jLabel_buy_num,
					new AnchorConstraint(
						152,
						616,
						204,
						529,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_buy_num.setText("\u91c7\u8d2d\u6570\u91cf");
				jLabel_buy_num.setPreferredSize(new java.awt.Dimension(69, 29));
				jLabel_buy_num.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_in_price = new JTextField();
				this.getContentPane().add(
					jTextField_in_price,
					new AnchorConstraint(
						234,
						803,
						285,
						643,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_in_price.setPreferredSize(new java.awt.Dimension(127, 29));
			}
			{
				jLabel_in_price = new JLabel();
				this.getContentPane().add(
					jLabel_in_price,
					new AnchorConstraint(
						234,
						607,
						283,
						530,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_in_price.setText("\u8fdb\u4ef7");
				jLabel_in_price.setPreferredSize(new java.awt.Dimension(61, 28));
				jLabel_in_price.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_i_barcode = new JTextField();
				this.getContentPane().add(
					jTextField_i_barcode,
					new AnchorConstraint(
						156,
						438,
						209,
						291,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_i_barcode.setPreferredSize(new java.awt.Dimension(117, 30));
				jTextField_i_barcode.addKeyListener(new KeyAdapter()
				{
					public void keyTyped(KeyEvent e) {
						boolean flag1=true;
						
						if(jTextField_i_barcode.getText().length()>=5)
						{
							if(jTextField_i_barcode.getText().length() > 5)
								JOptionPane.showMessageDialog(null, "您至多只能输入5位,请重新输入！");
							else{
								//1.加载驱动
								try {
									q.initSQLLink(null , null , null);
									//4.执行sql
									q.setRs(q.getStmt().executeQuery("select s_barcode,gname,commodity,producer from storage"));
									//处理ResultSet
									
									//====================向barcode文本框输入条形码，同时在其它文本框中显示相应信息=================================================
									while(q.getRs().next())
									{
										if(jTextField_i_barcode.getText().equals(q.getRs().getString("s_barcode")))
										{
											//------------------输入条形码，将相应信息自动显示到其它文本框中-----------------------------
											jTextField_gname.setText(q.getRs().getString("gname"));
											jTextField_commodity.setText(q.getRs().getString("commodity"));
											jTextField_producer.setText(q.getRs().getString("producer"));
											flag1 = false;
											break;
										}
									}
									if(flag1)
									{
										JOptionPane.showMessageDialog(null, "库存中没有此商品,请输入其详细信息！");//提示消息对话框
										jTextField_gname.setEditable(true);
										jTextField_commodity.setEditable(true);
										jTextField_producer.setEditable(true);
									}
									//==================================================================================================
								} catch (SQLException e1) {
									System.out.println("SQL语句错误！");
								}
							}
						}
					}
				});
			}
			{
				jLabel_i_barcode = new JLabel();
				this.getContentPane().add(
					jLabel_i_barcode,
					new AnchorConstraint(
						156,
						245,
						205,
						174,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_i_barcode.setText("\u6761\u5f62\u7801");
				jLabel_i_barcode.setPreferredSize(new java.awt.Dimension(56, 28));
				jLabel_i_barcode.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jLabel_title = new JLabel();
				this.getContentPane().add(
					jLabel_title,
					new AnchorConstraint(
						53,
						652,
						117,
						340,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_title.setText("\u6b22\u8fce\u8fdb\u5165\u91c7\u8d2d\u5458\u7cfb\u7edf");
				jLabel_title.setPreferredSize(new java.awt.Dimension(247, 36));
				jLabel_title.setFont(new java.awt.Font("楷体_GB2312",1,26));
				jLabel_title.setForeground(new java.awt.Color(0,0,255));
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//缺货查询
	static void addRow_overQuery(DefaultTableModel tableModel , ResultSet rs)
	{
		//处理ResultSet
		try {
			while(rs.next())
			{
				tableModel.addRow(new Object[]{rs.getInt("s_barcode"),rs.getString("gname"),rs.getInt("s_num"),
						rs.getString("commodity"),null,null,rs.getString("producer")});
			}
		} catch (SQLException e) {
			System.out.println("向table中添加数据异常！");
		}
	}
	//库存查询
	static void addRow_allQuery(DefaultTableModel tableModel , ResultSet rs)
	{
		//处理ResultSet
		try {
			while(rs.next())
			{
				tableModel.addRow(new Object[]{rs.getInt("s_barcode"),rs.getString("gname"),rs.getInt("s_num"),
						rs.getString("commodity"),null,null,rs.getString("producer")});
			}
		} catch (SQLException e) {
			System.out.println("向table中添加数据异常！");
		}
	}
	
	void clearTextField()
	{
		jTextField_i_barcode.setText("");
		jTextField_gname.setText("");
		jTextField_commodity.setText("");
		jTextField_buy_num.setText("");
		jTextField_in_price.setText("");
		jTextField_producer.setText("");
	}

	public String getLog_eid() {
		return log_eid;
	}

	public void setLog_eid(String log_eid) {
		this.log_eid = log_eid;
	}
}
