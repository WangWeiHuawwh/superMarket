
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
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
public class NewJFrame_goods_query extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	protected static final String TableModel = null;
	private JLabel jLabel_note;
	private JTextField jTextField_time2;
	private JLabel jLabel_time2;
	private JTextField jTextField_time1;
	private JLabel jLabel_time1;
	private JRadioButton jRadioButton_time;
	private JTextField jTextField_goodsName;
	private JLabel jLabel_goodsName;
	private boolean isSelected_goodsName = false;
	private boolean isSelected_barcode = false;
	private boolean isSelected_time = false;
	
	static int index_goodsName = 0;
	static int index_barcode = 0;
	static int index_time = 0;
	
	private JTextField jTextField_barcode;
	private JLabel jLabel_barcode;
	private JRadioButton jRadioButton_barcode;
	private JRadioButton jRadioButton_goodsName;
	private JButton jButton_sale_query;
	private JTable jTable_goods_query;
	private JScrollPane jScrollPane_goods_query;
	private JButton jButton_in_goods_query;
	private JButton jButton_storage_query;
	private JButton jButton_ok;
	
	private Query q;
	
	public NewJFrame_goods_query() {
		
		setVisible(true);
		setTitle("货物信息查询系统");
		initGUI();
		
		q = new Query();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setLocation(new java.awt.Point(240, 100));
			AnchorLayout thisLayout = new AnchorLayout();
			this.getContentPane().setLayout(thisLayout);
			this.getContentPane().setBackground(new java.awt.Color(249,140,240));
			{
				jLabel_note = new JLabel();
				this.getContentPane().add(
					jLabel_note,
					new AnchorConstraint(
						233,
						804,
						286,
						705,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_note.setText("(yyyy-mm-dd)");
				jLabel_note.setPreferredSize(new java.awt.Dimension(79, 30));
			}
			{
				jTextField_time2 = new JTextField();
				this.getContentPane().add(
					jTextField_time2,
					new AnchorConstraint(
						237,
						701,
						289,
						591,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_time2.setPreferredSize(new java.awt.Dimension(87, 30));
			}
			{
				jLabel_time2 = new JLabel();
				this.getContentPane().add(
					jLabel_time2,
					new AnchorConstraint(
						240,
						595,
						293,
						518,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_time2.setText("\u7ec8\u6b62\u65f6\u95f4");
				jLabel_time2.setPreferredSize(new java.awt.Dimension(61, 30));
			}
			{
				jTextField_time1 = new JTextField();
				this.getContentPane().add(
					jTextField_time1,
					new AnchorConstraint(
						237,
						510,
						289,
						397,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_time1.setPreferredSize(new java.awt.Dimension(90, 30));
			}
			{
				jLabel_time1 = new JLabel();
				this.getContentPane().add(
					jLabel_time1,
					new AnchorConstraint(
						237,
						368,
						289,
						285,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_time1.setText("\u8d77\u59cb\u65f6\u95f4");
				jLabel_time1.setPreferredSize(new java.awt.Dimension(65, 30));
			}
			{
				jRadioButton_time = new JRadioButton();
				this.getContentPane().add(
					jRadioButton_time,
					new AnchorConstraint(
						228,
						211,
						281,
						65,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jRadioButton_time.setText("\u6309\u65f6\u95f4\u67e5\u8be2");
				jRadioButton_time.setPreferredSize(new java.awt.Dimension(116, 30));
				jRadioButton_time.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						index_time ++;
						if(index_time%2 != 0){
							isSelected_time = true;
							
							jTextField_goodsName.setText("");
							jTextField_barcode.setText("");	
						}
						else
							isSelected_time = false;
					}
				});
			}
			{
				jTextField_barcode = new JTextField();
				this.getContentPane().add(
					jTextField_barcode,
					new AnchorConstraint(
						181,
						701,
						233,
						398,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_barcode.setPreferredSize(new java.awt.Dimension(240, 30));
			}
			{
				jLabel_barcode = new JLabel();
				this.getContentPane().add(
					jLabel_barcode,
					new AnchorConstraint(
						181,
						385,
						233,
						284,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_barcode.setText("\u8f93\u5165\u6761\u5f62\u7801\uff1a");
				jLabel_barcode.setPreferredSize(new java.awt.Dimension(80, 30));
			}
			{
				jRadioButton_barcode = new JRadioButton();
				this.getContentPane().add(
					jRadioButton_barcode,
					new AnchorConstraint(
						176,
						211,
						228,
						65,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jRadioButton_barcode.setText("\u6309\u6761\u5f62\u7801\u67e5\u8be2");
				jRadioButton_barcode.setPreferredSize(new java.awt.Dimension(116, 30));
				jRadioButton_barcode.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						index_barcode ++;
						if(index_barcode%2 != 0){
							isSelected_barcode = true;
							jTextField_goodsName.setText("");
							jTextField_time1.setText("");
							jTextField_time2.setText("");
						}
						else
							isSelected_barcode = false;
					}
					
				});
			}
			{
				jTextField_goodsName = new JTextField();
				this.getContentPane().add(
					jTextField_goodsName,
					new AnchorConstraint(
						123,
						701,
						177,
						398,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jTextField_goodsName.setPreferredSize(new java.awt.Dimension(240, 31));
			}
			{
				jLabel_goodsName = new JLabel();
				this.getContentPane().add(
					jLabel_goodsName,
					new AnchorConstraint(
						123,
						373,
						176,
						285,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jLabel_goodsName.setText("\u8f93\u5165\u5546\u54c1\u540d:");
				jLabel_goodsName.setPreferredSize(new java.awt.Dimension(69, 30));
			}
			{
				jRadioButton_goodsName = new JRadioButton();
				this.getContentPane().add(
					jRadioButton_goodsName,
					new AnchorConstraint(
						123,
						211,
						176,
						65,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jRadioButton_goodsName.setText("\u6309\u5546\u54c1\u540d\u79f0\u67e5\u8be2");
				jRadioButton_goodsName.setPreferredSize(new java.awt.Dimension(116, 30));
				jRadioButton_goodsName.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						index_goodsName ++;
						if(index_goodsName%2 != 0){
							isSelected_goodsName = true;
							
							jTextField_barcode.setText("");
							jTextField_time1.setText("");
							jTextField_time2.setText("");
						}
						else
							isSelected_goodsName = false;
					}
				});
			}
			{
				jScrollPane_goods_query = new JScrollPane();
				this.getContentPane().add(
					jScrollPane_goods_query,
					new AnchorConstraint(
						307,
						990,
						993,
						8,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jScrollPane_goods_query.setPreferredSize(new java.awt.Dimension(778, 392));
				jScrollPane_goods_query.setEnabled(false);
				{
					Object rowdata[][]={{null,null,null,null,null,null,null,null,null,null,null}};
					String names[]={"顺序码","条形码","商品名称","数量","商品规格","进价","售价","总价值","生产厂商","售货/采购员编号","日期"};

					TableModel jTable_goods_queryModel = new DefaultTableModel(new String[][] {{"顺序码","条形码","商品名称","数量",
						"商品规格","进价","售价","总价值","生产厂商","售货/采购员编号","日期"}},new String[]{"","","","","","","","","","",""});
					jTable_goods_query = new JTable(rowdata,names);

					jScrollPane_goods_query.setViewportView(jTable_goods_query);
					jTable_goods_query.setModel(jTable_goods_queryModel);
					jTable_goods_query.getTableHeader().setEnabled(false);
					jTable_goods_query.getPreferredSize();
				}
			}
			{
				jButton_in_goods_query = new JButton();
				this.getContentPane().add(
					jButton_in_goods_query,
					new AnchorConstraint(
						44,
						702,
						97,
						553,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_in_goods_query.setText("\u8fdb\u8d27\u67e5\u8be2");
				jButton_in_goods_query.setPreferredSize(new java.awt.Dimension(118, 30));
				jButton_in_goods_query.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						
						//清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_goods_query.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
						
						if(isSelected_goodsName == true){//按商品名查询
							String goodsName = jTextField_goodsName.getText();
							if(goodsName.equals(""))
								JOptionPane.showMessageDialog(null,"请输入商品名！");
							else
								q.in_goodsQuery(tableModel, "select i.*,st.gname,st.commodity,st.producer from storage st,in_goods i where st.s_barcode = i.i_barcode and gname='"+goodsName+"' order by buydate");
						}else if(isSelected_barcode == true){//按条形码查询
							
							String barcode = jTextField_barcode.getText();
							if(barcode.equals(""))
								JOptionPane.showMessageDialog(null,"请输入条形码！");
							else
								q.in_goodsQuery(tableModel, "select i.*,st.gname,st.commodity,st.producer from storage st,in_goods i where st.s_barcode = i.i_barcode and i_barcode="+Integer.parseInt(barcode)+" order by buydate");
						}else if(isSelected_time == true){
							String time1 = jTextField_time1.getText();
							String time2 = jTextField_time2.getText();
							if(time1.equals("") || time2.equals(""))
								JOptionPane.showMessageDialog(null, "请输入完整时间！");
							else{
								q.in_goodsQuery(tableModel, "select i.*,st.gname,st.commodity,st.producer from storage st,in_goods i where st.s_barcode = i.i_barcode and buydate between '"+time1+"' and '"+time2+"' order by buydate");
							}
						}else
							q.in_goodsQuery(tableModel, "select i.*,st.gname,st.commodity,st.producer from storage st,in_goods i where st.s_barcode = i.i_barcode order by buydate");
						q.in_goodsQuery(tableModel, "select * from in_goods");
					}
				});
			}
			{
				jButton_storage_query = new JButton();
				this.getContentPane().add(
					jButton_storage_query,
					new AnchorConstraint(
						48,
						447,
						97,
						304,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_storage_query.setText("\u5e93\u5b58\u67e5\u8be2");
				jButton_storage_query.setPreferredSize(new java.awt.Dimension(113, 28));
				jButton_storage_query.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						
						//清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_goods_query.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
						if(isSelected_goodsName == true){//按商品名查询
							String goodsName = jTextField_goodsName.getText();
							if(goodsName.equals(""))
								JOptionPane.showMessageDialog(null,"请输入商品名！");
							else
								q.storageQuery(tableModel, "select * from storage where gname='"+goodsName+"' order by s_barcode");
						}else if(isSelected_barcode == true){//按条形码查询
							String barcode = jTextField_barcode.getText();
							if(barcode.equals(""))
								JOptionPane.showMessageDialog(null,"请输入条形码！");
							else
								q.storageQuery(tableModel, "select * from storage where i_barcode="+Integer.parseInt(barcode)+" order by s_barcode");
						}else
							q.storageQuery(tableModel, "select * from storage");
					}
				});
			}
			{
				jButton_sale_query = new JButton();
				this.getContentPane().add(
					jButton_sale_query,
					new AnchorConstraint(
						48,
						196,
						98,
						62,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_sale_query.setText("\u9500\u552e\u67e5\u8be2");
				jButton_sale_query.setPreferredSize(new java.awt.Dimension(106, 29));
				jButton_sale_query.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						
						//清除table内的所有数据
						DefaultTableModel tableModel = (DefaultTableModel) jTable_goods_query.getModel();
						tableModel.setRowCount(1);// 清除原有行(除列名外)
						//---------------连接数据库，提交交易信息---------------------------------------
						
						if(isSelected_goodsName == true){//按商品名查询
							String goodsName = jTextField_goodsName.getText();
							if(goodsName.equals(""))
								JOptionPane.showMessageDialog(null,"请输入商品名！");
							else
								q.saleQuery(tableModel, "select s.*,st.gname,st.commodity,i.in_price,st.producer from sale s,storage st,in_goods i where s.sale_barcode=st.s_barcode and i.i_barcode=s.sale_barcode and gname='"+goodsName+"' order by saledate");
						}else if(isSelected_barcode == true){//按条形码查询
							
							String barcode = jTextField_barcode.getText();
							if(barcode.equals(""))
								JOptionPane.showMessageDialog(null,"请输入条形码！");
							else
								q.saleQuery(tableModel, "select s.*,st.gname,st.commodity,i.in_price,st.producer from sale s,storage st,in_goods i where s.sale_barcode=st.s_barcode and i.i_barcode=s.sale_barcode and i_barcode="+Integer.parseInt(barcode)+" order by saledate");
						}else if(isSelected_time == true){
							String time1 = jTextField_time1.getText();
							String time2 = jTextField_time2.getText();
							if(time1.equals("") || time2.equals(""))
								JOptionPane.showMessageDialog(null, "请输入完整时间！");
							else{
								q.saleQuery(tableModel, "select s.*,st.gname,st.commodity,i.in_price,st.producer from sale s,storage st,in_goods i where s.sale_barcode=st.s_barcode and i.i_barcode=s.sale_barcode and saledate between '"+time1+"' and '"+time2+"' order by saledate");
							}
						}else
							q.saleQuery(tableModel, "select s.*,st.gname,st.commodity,i.in_price,st.producer from sale s,storage st,in_goods i where s.sale_barcode=st.s_barcode and i.i_barcode=s.sale_barcode order by sale_id");
					}			
				});
			}
			{
				jButton_ok = new JButton();
				this.getContentPane().add(
					jButton_ok,
					new AnchorConstraint(
						86,
						933,
						207,
						807,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL,
						AnchorConstraint.ANCHOR_REL));
				jButton_ok.setText("\u5173\u95ed");
				jButton_ok.setPreferredSize(new java.awt.Dimension(100, 69));
				jButton_ok.setFont(new java.awt.Font("Dialog",1,16));
				jButton_ok.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						dispose();//关闭本窗口
						System.gc();
					}
				});
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void addRow_saleQuery(DefaultTableModel tableModel , ResultSet rs)
	{
		//处理ResultSet
		try {
			while(rs.next())
			{
				tableModel.addRow(new Object[]{rs.getInt("sale_id"),rs.getInt("sale_barcode"),rs.getString("gname"),rs.getInt("sale_num"),rs.getString("commodity"),rs.getFloat("in_price"),rs.getFloat("price"),
						rs.getFloat("every_due_money"),rs.getString("producer"),rs.getString("eid"),rs.getString("saledate")});
			}
		} catch (SQLException e) {
			System.out.println("addRow_saleQuery向table中添加数据异常！");
		}
	}
	
	static void addRow_in_goodsQuery(DefaultTableModel tableModel , ResultSet rs)
	{
		//处理ResultSet
		try {
			while(rs.next())
			{
				tableModel.addRow(new Object[]{rs.getInt("i_order"),rs.getInt("i_barcode"),rs.getString("gname"),rs.getInt("buy_num"),rs.getString("commodity"),rs.getFloat("in_price"),
					null,rs.getFloat("sum_money"),rs.getString("producer"),rs.getString("eid"),rs.getString("buydate")});
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("addRow_in_goodsQuery向table中添加数据异常！");
		}
	}
	
	static void addRow_storageQuery(DefaultTableModel tableModel , ResultSet rs)
	{
		//处理ResultSet
		try {
			while(rs.next())
			{
				tableModel.addRow(new Object[]{null,rs.getInt("s_barcode"),rs.getString("gname"),rs.getInt("s_num"),
					rs.getString("commodity"),null,rs.getFloat("sale_price"),null,rs.getString("producer"),null,null});
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("addRow_storageQuery向table中添加数据异常！");
		}
	}
	
	/**
	* Auto-generated method for setting the popup menu for a component
	*/
	private void setComponentPopupMenu(final java.awt.Component parent, final javax.swing.JPopupMenu menu) {
parent.addMouseListener(new java.awt.event.MouseAdapter() {
public void mousePressed(java.awt.event.MouseEvent e) {
if(e.isPopupTrigger())
menu.show(parent, e.getX(), e.getY());
}
public void mouseReleased(java.awt.event.MouseEvent e) {
if(e.isPopupTrigger())
menu.show(parent, e.getX(), e.getY());
}
});
	}
}
