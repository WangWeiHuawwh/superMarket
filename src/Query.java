import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


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
public class Query {
	Connection conn = null; 
	Statement stmt = null;
	ResultSet rs = null;
	
	protected void initSQLLink(Connection c , Statement s , ResultSet r){
		conn = c;
		stmt = s;
		rs = r;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "123456");		
			//3.获取Statement对象
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("没有找到类异常！");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Query类：initSQLLink方法中SQL语句错误！");
		}
	}
	
	//销售查询
	protected void saleQuery(DefaultTableModel tableModel , String str){
//			---------------连接数据库，提交交易信息---------------------------------------
		try {
			initSQLLink(null , null , null);
			//4.执行sql
			rs = stmt.executeQuery(str+"");
			//处理ResultSet
			NewJFrame_goods_query.addRow_saleQuery(tableModel, rs);
		}catch (SQLException e1) {
			System.out.println("Query类：saleQuery方法中SQL语句错误！");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//关闭连接
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e1)
			{
				System.out.println("关闭连接异常！");
			}
		}
	}
	//库存查询
	protected void storageQuery(DefaultTableModel tableModel , String str){
//	---------------连接数据库，提交交易信息---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.执行sql
		rs = stmt.executeQuery(str+"");
		//处理ResultSet
		NewJFrame_goods_query.addRow_storageQuery(tableModel, rs);
	}catch (SQLException e1) {
			System.out.println("Query类：storageQuery方法中SQL语句错误！");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//关闭连接
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e1)
			{
				//e1.printStackTrace();
				System.out.println("关闭连接异常！");
			}
		}
	}
	
	//采购员的库存查询
	protected void buyer_storageQuery(DefaultTableModel tableModel , String str){
//	---------------连接数据库，提交交易信息---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.执行sql
		rs = stmt.executeQuery(str+"");
		//处理ResultSet
		NewJFrame_buyer. addRow_allQuery(tableModel , rs);
	}catch (SQLException e1) {
			System.out.println("Query类：storageQuery方法中SQL语句错误！");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//关闭连接
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e1)
			{
				//e1.printStackTrace();
				System.out.println("关闭连接异常！");
			}
		}
	}
	//进货查询
	protected void in_goodsQuery(DefaultTableModel tableModel , String str){
//	---------------连接数据库，提交交易信息---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.执行sql
		rs = stmt.executeQuery(str+"");
		//处理ResultSet
		NewJFrame_goods_query.addRow_in_goodsQuery(tableModel, rs);
	}catch (SQLException e1) {
			System.out.println("Query类：in_goodsQuery方法中SQL语句错误！");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//关闭连接
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e1)
			{
				//e1.printStackTrace();
				System.out.println("关闭连接异常！");
			}
		}
	}
	
	//员工查询
	protected void employeeQuery(DefaultTableModel tableModel , String str){
//	---------------连接数据库，提交交易信息---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.执行sql
		rs = stmt.executeQuery(str+"");
		//处理ResultSet
		NewJFrame_adm.addRow_empQuery(tableModel, rs);
	}catch (SQLException e1) {
			System.out.println("Query类：employeeQuery方法中SQL语句错误！");
		}finally
		{
			try
			{
				//关闭连接
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e1)
			{
				//e1.printStackTrace();
				System.out.println("关闭连接异常！");
			}
		}
	}
	public Statement getStmt() {
		return stmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}
