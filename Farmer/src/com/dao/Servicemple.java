package com.dao;

import java.sql.*;
import java.util.*;

import com.dto.Farmer;
import com.exception.NorecorsFounf;
import com.exception.SomethingWentWrong;

public class Servicemple implements Inter{

	@Override
	public void AddUi(Farmer a) throws SomethingWentWrong {
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String q="create table if not exists farmer (id int auto_increment primary key,name varchar(10),address varchar(40),debt double(8,2),sanction_date date )";
			
			PreparedStatement p=c.prepareStatement(q);
			
			p.executeUpdate();
			
			
String qw="insert into farmer values(?,?,?,?,?)";
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(1, 0);
			ps.setString(2, a.getName());
			ps.setString(3, a.getAddress());
			ps.setDouble(4, a.getDebtAmount());
			ps.setDate(5, java.sql.Date.valueOf(a.getSanctiondate()));
			
			
			
			
			
			int d=ps.executeUpdate();
if(d==0) {			
	throw new SomethingWentWrong("soe thing went wrong");
}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void UpdateUi(Farmer a) throws SomethingWentWrong {
		
Connection c=null;
		
		try {
			c=Connect.getco();
			
			
String qw="update farmer set name=?,address=?,debt=?,sanction_date=? where id=?";
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(5, a.getId());
			ps.setString(1, a.getName());
			ps.setString(2, a.getAddress());
			ps.setDouble(3, a.getDebtAmount());
			ps.setDate(4, java.sql.Date.valueOf(a.getSanctiondate()));
			
			
			
			
			
			int d=ps.executeUpdate();
if(d==0) {			
	throw new SomethingWentWrong("some  thing went wrong");
}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void DeleteUi(int id) throws SomethingWentWrong {
Connection c=null;
		
		try {
			c=Connect.getco();
			
			
String qw="delete from farmer where id=?";
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(1, id);
			
			
			
			
			
			
			int d=ps.executeUpdate();
if(d==0) {			
	throw new SomethingWentWrong("some  thing went wrong");
}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Farmer FindUi(int id) throws NorecorsFounf, SomethingWentWrong {
		
Connection c=null;
Farmer fo=null;
		
		try {
			c=Connect.getco();
			
			
String qw="select * from  farmer where id=?";
			
			PreparedStatement ps=c.prepareStatement(qw);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
if(isEmpty(rs)) {			
	throw new NorecorsFounf("List is empty");
}
else {
	rs.next();
	fo=new Farmer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5).toLocalDate());
}
			
			
		} catch (SQLException e) {
			throw new SomethingWentWrong("Something went wrong");
			
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fo;
	}

	private boolean isEmpty(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return (!rs.isBeforeFirst() && rs.getRow()==0);
	}

	@Override
	public List<Farmer> PrintUi() throws NorecorsFounf, SomethingWentWrong {
		Connection c=null;
		List<Farmer> list =new ArrayList<>();
				
				try {
					c=Connect.getco();
					
					
		String qw="select * from  farmer";
					
					PreparedStatement ps=c.prepareStatement(qw);
					
				
					
					ResultSet rs=ps.executeQuery();
		if(isEmpty(rs)) {			
			throw new NorecorsFounf("List is empty");
		}
		else {
			while(rs.next()) {
		list.add(new Farmer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));}
		}
					
					
				} catch (SQLException e) {
					throw new SomethingWentWrong("Something went wrong");
					
				}finally {
					try {
						Connect.closeco(c);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				return list;
	}

}
