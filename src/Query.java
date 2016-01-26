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
			//2.��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "123456");		
			//3.��ȡStatement����
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("û���ҵ����쳣��");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Query�ࣺinitSQLLink������SQL������");
		}
	}
	
	//���۲�ѯ
	protected void saleQuery(DefaultTableModel tableModel , String str){
//			---------------�������ݿ⣬�ύ������Ϣ---------------------------------------
		try {
			initSQLLink(null , null , null);
			//4.ִ��sql
			rs = stmt.executeQuery(str+"");
			//����ResultSet
			NewJFrame_goods_query.addRow_saleQuery(tableModel, rs);
		}catch (SQLException e1) {
			System.out.println("Query�ࣺsaleQuery������SQL������");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//�ر�����
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e1)
			{
				System.out.println("�ر������쳣��");
			}
		}
	}
	//����ѯ
	protected void storageQuery(DefaultTableModel tableModel , String str){
//	---------------�������ݿ⣬�ύ������Ϣ---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.ִ��sql
		rs = stmt.executeQuery(str+"");
		//����ResultSet
		NewJFrame_goods_query.addRow_storageQuery(tableModel, rs);
	}catch (SQLException e1) {
			System.out.println("Query�ࣺstorageQuery������SQL������");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//�ر�����
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
				System.out.println("�ر������쳣��");
			}
		}
	}
	
	//�ɹ�Ա�Ŀ���ѯ
	protected void buyer_storageQuery(DefaultTableModel tableModel , String str){
//	---------------�������ݿ⣬�ύ������Ϣ---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.ִ��sql
		rs = stmt.executeQuery(str+"");
		//����ResultSet
		NewJFrame_buyer. addRow_allQuery(tableModel , rs);
	}catch (SQLException e1) {
			System.out.println("Query�ࣺstorageQuery������SQL������");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//�ر�����
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
				System.out.println("�ر������쳣��");
			}
		}
	}
	//������ѯ
	protected void in_goodsQuery(DefaultTableModel tableModel , String str){
//	---------------�������ݿ⣬�ύ������Ϣ---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.ִ��sql
		rs = stmt.executeQuery(str+"");
		//����ResultSet
		NewJFrame_goods_query.addRow_in_goodsQuery(tableModel, rs);
	}catch (SQLException e1) {
			System.out.println("Query�ࣺin_goodsQuery������SQL������");
			//e1.printStackTrace();
		}finally
		{
			try
			{
				//�ر�����
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
				System.out.println("�ر������쳣��");
			}
		}
	}
	
	//Ա����ѯ
	protected void employeeQuery(DefaultTableModel tableModel , String str){
//	---------------�������ݿ⣬�ύ������Ϣ---------------------------------------
	try {
		initSQLLink(null , null , null);
		//4.ִ��sql
		rs = stmt.executeQuery(str+"");
		//����ResultSet
		NewJFrame_adm.addRow_empQuery(tableModel, rs);
	}catch (SQLException e1) {
			System.out.println("Query�ࣺemployeeQuery������SQL������");
		}finally
		{
			try
			{
				//�ر�����
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
				System.out.println("�ر������쳣��");
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
