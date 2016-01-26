
import javax.swing.JLabel;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.cloudgarden.layout.AnchorConstraint;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
* *************************************
*/
public class NewJFrame_adm extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	private String log_eid;
	private JLabel jLabel_eid;
	private JLabel jLabel_pwd;
	private JLabel jLabel1;
	private JButton jButton_storage_query;
	private JLabel jLabel_sal;
	private JTextField jTextField_sal;
	private JTable jTable_data;
	private JScrollPane jScrollPane_data;
	private JButton jButton_del_emp;
	private JButton jButton_add_emp;
	private JButton jButton_emp_query;
	private JButton jButton_exit;
	private JButton jButton_back;
	private JTextField jTextField_job;
	private JLabel jLabel_job;
	private JTextField jTextField_pwd;
	private JTextField jTextField_ename;
	private JLabel jLabel_ename;
	private JTextField jTextField_eid;
	
	private Query q;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public NewJFrame_adm() {
		setTitle("管理员系统");
		initGUI();
		q = new Query();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setLocation(new java.awt.Point(240, 100));
			AnchorLayout thisLayout = new AnchorLayout();
			this.getContentPane().setLayout(thisLayout);
			this.getContentPane().setBackground(new java.awt.Color(250,156,242));
			
			setVisible(true);
			{
				jScrollPane_data = new JScrollPane();
				this.getContentPane().add(
					jScrollPane_data,
					new AnchorConstraint(
						573,
						969,
						970,
						27,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jScrollPane_data.setPreferredSize(new java.awt.Dimension(746, 225));
				jScrollPane_data.setAutoscrolls(true);
				jScrollPane_data.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				{
					Object rowdata[][]={{null,null,null,null,null}};
					String names[]={"工作编号","姓名","密码","职位","工资"};

					TableModel jTable_dataModel = new DefaultTableModel(new String[][] {{"工作编号","姓名","密码","职位","工资"}},
							new String[]{"","","","",""});

					jTable_data = new JTable(rowdata,names);
					jTable_data.setColumnSelectionAllowed(true); 
					jScrollPane_data.setViewportView(jTable_data);
					jTable_data.setModel(jTable_dataModel);
					jTable_data.getPreferredSize();
					
					jTable_data.getTableHeader().setBounds(2, -17, 741, 250);
					jTable_data.setEnabled(false);
				}
			}
			{
				jLabel1 = new JLabel();
				this.getContentPane().add(
					jLabel1,
					new AnchorConstraint(
						158,
						864,
						209,
						653,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("(administrator/buyer/saler)");
				jLabel1.setPreferredSize(new java.awt.Dimension(167, 29));
			}
			{
				jButton_del_emp = new JButton();
				this.getContentPane().add(
					jButton_del_emp,
					new AnchorConstraint(
						283,
						671,
						336,
						546,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_del_emp.setText("\u5220\u9664\u96c7\u5458");
				jButton_del_emp.setPreferredSize(new java.awt.Dimension(99, 30));
				jButton_del_emp.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						boolean flag = true;//控制“编号不存在”通知
						//如果没有输入编号和密码，则提示输入编号和密码
						if(jTextField_eid.getText().equals(""))
							JOptionPane.showMessageDialog(null, "请输入编号！");
						else
						{
							//----------------------数据库连接-------------------------------
							//1.加载驱动
							try {
								q.initSQLLink(null , null , null);
								//4.执行sql
								q.setRs(q.getStmt().executeQuery("select * from employee"));
								//处理ResultSet
								while(q.getRs().next())
								{
									if(jTextField_eid.getText().equals(q.getRs().getString("eid")))
									{
										q.getStmt().executeUpdate("delete from employee where eid = '"+jTextField_eid.getText()+"'");
										q.getStmt().executeUpdate("commit");
										JOptionPane.showMessageDialog(null,"删除成功！");
										clearTextField();
										flag = false;
										break;
									}
								}
								if(flag)
								{
									JOptionPane.showMessageDialog(null, "您输入的雇员编号不存在，请重新输入您要删除的雇员编号！");
									jTextField_eid.setText("");
									flag = true;
								}
							} catch (SQLException e1) {
								System.out.println("jButton_del_emp+SQL语句错误！");
								//e1.printStackTrace();
							}
						}
					}
				});
			}
			{
				jButton_add_emp = new JButton();
				this.getContentPane().add(
					jButton_add_emp,
					new AnchorConstraint(
						285,
						450,
						338,
						325,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_add_emp.setText("\u6dfb\u52a0\u96c7\u5458");
				jButton_add_emp.setPreferredSize(new java.awt.Dimension(99, 30));
				jButton_add_emp.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
						if(jTextField_eid.getText().equals("")&&jTextField_ename.getText().equals("")&&jTextField_pwd.getText().equals("")
								&&jTextField_job.getText().equals("")&&jTextField_sal.getText().equals(""))
							JOptionPane.showMessageDialog(null, "不能添加空值！");//提示消息对话框
						else
						{
							//----------------------数据库连接-------------------------------
							boolean flag = true;
							//1.加载驱动
							try {
								q.initSQLLink(null , null , null);
								//4.执行sql
								q.setRs(q.getStmt().executeQuery("select * from employee"));
								//处理ResultSet
								
								//====================添加Button的功能实现（向table中插入和向数据库中插入）=================================================
								//-------------------将雇员信息插入到employee表中--------------------------------------------------
								while(q.getRs().next())
								{
									String eid = q.getRs().getString("eid");
									//如果雇员编号已存在于employee表中
									if(jTextField_eid.getText().equals(eid))
									{
										JOptionPane.showMessageDialog(null,"您输入的雇员编号已存在，请重新输入！");
										jTextField_eid.setText("");
										flag = false;
										break;
									}
								}
								//如果雇员编号不存在
								if(flag)
								{
									if(jTextField_job.getText().equals("saler")||jTextField_job.getText().equals("buyer")
											||jTextField_job.getText().equals("administrator"))
									{
										q.getStmt().executeUpdate("insert into employee values('"+jTextField_eid.getText()+"','"+jTextField_ename.getText()+"','"
												+jTextField_job.getText()+"',"+jTextField_sal.getText()+",'"+jTextField_pwd.getText()+"')");
										q.getStmt().executeUpdate("commit");
										JOptionPane.showMessageDialog(null,"添加成功！");
										//添加下一行
										tableModel.addRow(new Object[]{jTextField_eid.getText(), jTextField_ename.getText(),jTextField_pwd.getText(),
												jTextField_job.getText(),jTextField_sal.getText()});
										//将文本框中的内容清空，以便下一次输入
										clearTextField();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "职位请输入administrator、saler或buyer!");
										jTextField_job.setText("");
									}
								}
								
								//==================================================================================================
							} catch (SQLException e1) {
								System.out.println("jButton_buy + SQL语句错误！"+e1.getMessage());
								//e1.printStackTrace();
							}
						}
					}
				});
			}
			{
				jButton_emp_query = new JButton();
				this.getContentPane().add(
					jButton_emp_query,
					new AnchorConstraint(
						382,
						450,
						435,
						325,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_emp_query.setText("\u96c7\u5458\u67e5\u8be2");
				jButton_emp_query.setPreferredSize(new java.awt.Dimension(99, 30));
				jButton_emp_query.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
//						清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_data.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
//						---------------连接数据库，提交交易信息---------------------------------------
						q.employeeQuery(tableModel, "select * from employee order by job,eid");
					}
				});
			}
			{
				jButton_exit = new JButton();
				this.getContentPane().add(
					jButton_exit,
					new AnchorConstraint(
						476,
						655,
						545,
						530,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_exit.setText("\u9000\u51fa");
				jButton_exit.setPreferredSize(new java.awt.Dimension(99, 39));
				jButton_exit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						dispose();//关闭本窗口
						System.exit(0);//退出系统
						System.gc();//建议垃圾回收机制回收垃圾
					}
				});
			}
			{
				jButton_back = new JButton();
				this.getContentPane().add(
					jButton_back,
					new AnchorConstraint(
						476,
						471,
						543,
						346,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_back.setText("\u8fd4\u56de");
				jButton_back.setPreferredSize(new java.awt.Dimension(99, 38));
				jButton_back.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						dispose();//关闭本窗口
						logon Log = new logon();
						Log.setVisible(true);
						System.gc();
					}
					
				});
			}
			{
				jButton_storage_query = new JButton();
				this.getContentPane().add(
					jButton_storage_query,
					new AnchorConstraint(
						380,
						672,
						433,
						547,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_storage_query.setText("货物查询");
				jButton_storage_query.setPreferredSize(new java.awt.Dimension(99, 30));
				jButton_storage_query.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						new NewJFrame_goods_query();
					}
				});
			}
			
			{
				jTextField_sal = new JTextField();
				this.getContentPane().add(
					jTextField_sal,
					new AnchorConstraint(
						60,
						913,
						112,
						745,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_sal.setPreferredSize(new java.awt.Dimension(133, 29));
			}
			{
				jLabel_sal = new JLabel();
				this.getContentPane().add(
					jLabel_sal,
					new AnchorConstraint(
						60,
						735,
						112,
						677,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_sal.setText("\u5de5\u8d44");
				jLabel_sal.setPreferredSize(new java.awt.Dimension(46, 29));
				jLabel_sal.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_job = new JTextField();
				this.getContentPane().add(
					jTextField_job,
					new AnchorConstraint(
						158,
						645,
						207,
						476,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_job.setPreferredSize(new java.awt.Dimension(134, 28));
			}
			{
				jLabel_job = new JLabel();
				this.getContentPane().add(
					jLabel_job,
					new AnchorConstraint(
						156,
						485,
						209,
						409,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_job.setText("\u804c\u4f4d");
				jLabel_job.setPreferredSize(new java.awt.Dimension(60, 30));
				jLabel_job.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_pwd = new JTextField();
				this.getContentPane().add(
					jTextField_pwd,
					new AnchorConstraint(
						149,
						346,
						200,
						182,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_pwd.setPreferredSize(new java.awt.Dimension(130, 29));
			}
			{
				jLabel_pwd = new JLabel();
				this.getContentPane().add(
					jLabel_pwd,
					new AnchorConstraint(
						151,
						142,
						202,
						65,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_pwd.setText("\u5bc6\u7801");
				jLabel_pwd.setPreferredSize(new java.awt.Dimension(61, 29));
				jLabel_pwd.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_ename = new JTextField();
				this.getContentPane().add(
					jTextField_ename,
					new AnchorConstraint(
						59,
						643,
						112,
						474,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_ename.setPreferredSize(new java.awt.Dimension(134, 30));
			}
			{
				jLabel_ename = new JLabel();
				this.getContentPane().add(
					jLabel_ename,
					new AnchorConstraint(
						62,
						458,
						112,
						409,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_ename.setText("\u59d3\u540d");
				jLabel_ename.setPreferredSize(new java.awt.Dimension(39, 28));
				jLabel_ename.setFont(new java.awt.Font("Dialog",1,16));
			}
			{
				jTextField_eid = new JTextField();
				this.getContentPane().add(
					jTextField_eid,
					new AnchorConstraint(
						62,
						346,
						112,
						181,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_eid.setPreferredSize(new java.awt.Dimension(131, 28));
			}
			{
				jLabel_eid = new JLabel();
				this.getContentPane().add(
					jLabel_eid,
					new AnchorConstraint(
						62,
						155,
						112,
						65,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_eid.setText("\u5de5\u4f5c\u7f16\u53f7");
				jLabel_eid.setPreferredSize(new java.awt.Dimension(72, 28));
				jLabel_eid.setFont(new java.awt.Font("Dialog",1,16));
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void addRow_empQuery(DefaultTableModel tableModel , ResultSet rs)
	{
		//处理ResultSet
		try {
			while(rs.next())
			{
				tableModel.addRow(new Object[]{rs.getString("eid"),rs.getString("ename"),rs.getInt("pwd"),
					rs.getString("job"),rs.getString("sal")});
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("向table中添加数据异常！");
		}
	}
	
	void clearTextField()
	{
		jTextField_eid.setText("");
		jTextField_ename.setText("");
		jTextField_job.setText("");
		jTextField_sal.setText("");
		jTextField_pwd.setText("");
	}

	public String getLog_eid() {
		return log_eid;
	}

	public void setLog_eid(String log_eid) {
		this.log_eid = log_eid;
	}
}
