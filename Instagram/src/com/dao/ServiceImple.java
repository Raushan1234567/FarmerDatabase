package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.dto.Instagram;
import com.exception.NOrecordFound;
import com.exception.SomeThingWentWrong;

public class ServiceImple implements Inter{

	@Override
	public void AdddPrompt(Instagram a) throws SomeThingWentWrong {
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String q="create table if not exists Instagram (id int auto_increment primary key,follower int ,following int,name varchar(10),joindate date)";
			
			PreparedStatement p=c.prepareStatement(q);
			p.executeUpdate();
			
String qw="insert into instagram values(?,?,?,?,?)";


			
			PreparedStatement ps=c.prepareStatement(qw);
			ps.setInt(1, 0);
			ps.setInt(2, a.getFllowers());
			ps.setInt(3, a.getFollowing());
			ps.setString(4, a.getUserid());
			ps.setDate(5, Date.valueOf(a.getJoindate()));
			
			
			
			int d=ps.executeUpdate();
			if(d==0) {
				throw new SomeThingWentWrong("Something went wrong");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdatePrompt(int id, String name) throws SomeThingWentWrong {
Connection c=null;
		
		try {
			c=Connect.getco();
			
			
			
String qw="update instagram set name=? where id=?";



			
			PreparedStatement ps=c.prepareStatement(qw);
			ps.setInt(2, id);
			ps.setString(1,name);
			
			
			
			
			int d=ps.executeUpdate();
			if(d==0) {
				throw new SomeThingWentWrong("Something went wrong");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void DeletePrompt(int id) throws SomeThingWentWrong {
Connection c=null;
		
		try {
			c=Connect.getco();
			
			
			
String qw="delete from instagram where id=?";



			
			PreparedStatement ps=c.prepareStatement(qw);
			ps.setInt(1, id);
			
			
			
			
			
			int d=ps.executeUpdate();
			if(d==0) {
				throw new SomeThingWentWrong("Something went wrong");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Instagram FindPrompt(int id) throws SomeThingWentWrong, NOrecordFound {
Connection c=null;
Instagram io=null;
		
		try {
			c=Connect.getco();
			
			
			
String qw="select * from Instagram where id=?";



			
			PreparedStatement ps=c.prepareStatement(qw);
			ps.setInt(1, id);
			
			
			
			
			
		ResultSet rs=ps.executeQuery();
			if(isEmpty(rs)) {
				throw new NOrecordFound("List is empty");
			}
			else {
				rs.next();
				io=new Instagram(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5).toLocalDate());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomeThingWentWrong("Something went wrong");
		}
		return io;
	}

	private boolean isEmpty(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return (!rs.isBeforeFirst() && rs.getRow()==0);
	}

	@Override
	public List<Instagram> PrintPrompt() throws SomeThingWentWrong, NOrecordFound {
		Connection c=null;
		List<Instagram> io=new ArrayList<>();
				
				try {
					c=Connect.getco();
					
					
					
		String qw="select * from Instagram";



					
					PreparedStatement ps=c.prepareStatement(qw);
					
					
					
					
					
					
				ResultSet rs=ps.executeQuery();
					if(isEmpty(rs)) {
						throw new NOrecordFound("List is empty");
					}
					else {
						while(rs.next()) {
						io.add(new Instagram(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDate(5).toLocalDate()));
						}
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new SomeThingWentWrong("Something went wrong");
				}
				return io;
	}
	

}
