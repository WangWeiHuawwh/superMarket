
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;
import com.cloudgarden.layout.AnchorConstraint;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;


public class logon extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jButton_logon;
	private JButton jButton_quxiao;
	private JLabel jLabel_title;
	private JPasswordField jTextField_password;
	private JTextField jTextField_id;
	
	private Query q;
	/**
	 * @wbp.nonvisual location=67,567
	 */
	private final JRadioButton radioButton = new JRadioButton("\u8FDB\u8D27\u767B\u5F55");
	/**
	 * @wbp.nonvisual location=227,567
	 */
	private final JRadioButton radioButton_1 = new JRadioButton("\u9500\u552E\u767B\u5F55");
	/**
	 * @wbp.nonvisual location=387,567
	 */
	private final JRadioButton radioButton_2 = new JRadioButton("\u7BA1\u7406\u5458\u767B\u5F55");
	
	public logon() {
		initGUI();
		setVisible(true);
		q = new Query();
	}
	
	public void initGUI() {
		try {
			setTitle("超市信息管理系统");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setLocation(new java.awt.Point(240, 200));
			AnchorLayout thisLayout = new AnchorLayout();
			this.getContentPane().setLayout(thisLayout);
			this.getContentPane().setBackground(new java.awt.Color(255,128,255));
			{
				jLabel_title = new JLabel();
				this.getContentPane().add(
					jLabel_title,
					new AnchorConstraint(
						66,
						696,
						203,
						288,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_title.setText("\u8d85\u5e02\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
				jLabel_title.setPreferredSize(new java.awt.Dimension(242, 50));
				jLabel_title.setFont(new java.awt.Font("楷体_GB2312",1,28));
				jLabel_title.setForeground(new java.awt.Color(0,0,255));
			}
			{
				jButton_quxiao = new JButton();
				this.getContentPane().add(
					jButton_quxiao,
					new AnchorConstraint(
						780,
						690,
						889,
						559,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_quxiao.setText("\u53d6\u6d88");
				jButton_quxiao.setPreferredSize(new java.awt.Dimension(77, 40));
				jButton_quxiao.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						dispose();//关闭本窗口程序
						//nf.setVisible(true);
						System.gc();//建议垃圾回收机制回收垃圾
						System.exit(0);
					}
				});
			}
			{
				//------------------界面程序代码------------------------------
				jButton_logon = new JButton();
				this.getContentPane().add(
					jButton_logon,
					new AnchorConstraint(
						780,
						409,
						892,
						274,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_logon.setText("\u767b\u9646");
				jButton_logon.setPreferredSize(new java.awt.Dimension(80, 41));
				//--------------程序功能代码-------------------------------------
				jButton_logon.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						boolean flag = true;//控制“编号或密码错误”通知
						String pwd = new String(jTextField_password.getPassword());//密码框为字符数组型的，将其转化为字符串
						//如果没有输入编号和密码，则提示输入编号和密码
						if(jTextField_id.getText().equals(""))
							JOptionPane.showMessageDialog(null, "请输入编号！");
						else if(pwd.equals(""))
							JOptionPane.showMessageDialog(null, "请输入密码！");
						else
						{
							//----------------------数据库连接-------------------------------
							
							//1.加载驱动
							try {
								q.initSQLLink(null, null, null);
								//4.执行sql
								q.setRs(q.getStmt().executeQuery("select * from employee"));
								//处理ResultSet
								while(q.getRs().next())
								{
									if(jTextField_id.getText().equals(q.getRs().getString("eid"))&& pwd.equals(q.getRs().getString("pwd")))
									{
										setVisible(false);
										if(q.getRs().getString("job").equals("saler"))
										{//=====================跳转到jFrame_saler窗口=======================
											JFrame_saler jf_s = new JFrame_saler();
											jf_s.setLog_eid(jTextField_id.getText());	
										}
										else if(q.getRs().getString("job").equals("buyer"))
										{//=====================跳转到NewJFrame_buyer窗口=======================
											NewJFrame_buyer njb = new NewJFrame_buyer();
											njb.setLog_eid(jTextField_id.getText());
										}
										else if(q.getRs().getString("job").equals("administrator"))
										{//=====================未完成jFrame_buyer()=======================
											NewJFrame_adm nja = new NewJFrame_adm();
											nja.setLog_eid(jTextField_id.getText());
										}
										dispose();//关闭本窗口
										System.gc();//建议垃圾回收机制回收本窗口
										flag = false;
									}
								}
								if(flag)
								{
									JOptionPane.showMessageDialog(null, "您输入的编号与密码有误，请您重新输入！");
									jTextField_id.setText("");
									jTextField_password.setText("");
									flag = true;
								}
							} catch (SQLException e1) {
								System.out.println("SQL语句错误！");
								//e1.printStackTrace();
							}
						}
					}
				});
			}
			{
//				------------------密码TextField------------------------
				jTextField_password = new JPasswordField();
				jTextField_password.setEchoChar('*');
				this.getContentPane().add(
					jTextField_password,
					new AnchorConstraint(
						534,
						879,
						646,
						401,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_password.setPreferredSize(new java.awt.Dimension(283, 41));
			}
			{
				//------------------编号TextField------------------------
				jTextField_id = new JTextField();
				this.getContentPane().add(
					jTextField_id,
					new AnchorConstraint(
						345,
						877,
						460,
						401,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_id.setPreferredSize(new java.awt.Dimension(282, 42));
			}
			{
				//------------------密码Label------------------------
				jLabel2 = new JLabel();
				this.getContentPane().add(
					jLabel2,
					new AnchorConstraint(
						517,
						342,
						668,
						58,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("\u8bf7\u8f93\u5165\u60a8\u7684\u5bc6\u7801\uff1a");
				jLabel2.setPreferredSize(new java.awt.Dimension(168, 55));
				jLabel2.setFont(new java.awt.Font("Dialog",1,20));
			}
			{
				//------------------编号Label-----------------------
				jLabel1 = new JLabel();
				this.getContentPane().add(
					jLabel1,
					new AnchorConstraint(
						356,
						347,
						446,
						58,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel1.setPreferredSize(new java.awt.Dimension(171, 33));
				jLabel1.setText("\u8bf7\u8f93\u5165\u60a8\u7684\u7f16\u53f7\uff1a");
				jLabel1.setFont(new java.awt.Font("Dialog",1,20));
			}
			pack();
			this.setSize(467, 788);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}