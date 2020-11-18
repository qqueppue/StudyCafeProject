package com.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO{
	
	private static UserDAOImpl instance = new UserDAOImpl();
	
	public static UserDAOImpl getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context encCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) encCtx.lookup("jdbc/member");
		return ds.getConnection();
	}
	
	public void tempJoin(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into sc_user values(?,?,?,?,?,?,user_seq.nextval,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getPwd());
			ps.setString(3, "");
			ps.setString(4, "");
			ps.setString(5, "");
			ps.setInt(6, user.getAdmin());
			ps.setString(7, "");			//time
			ps.setString(8, "");			//time
			ps.setInt(9, 0);				//seat
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override	// ȸ������ & ��ȸ������ �α���
	public void memberJoin(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into sc_user values(?,?,?,?,?,?,user_seq.nextval,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getName());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getAdmin());
			ps.setString(7, "");			//time
			ps.setString(8, "");			//time
			ps.setInt(9, 0);				//seat
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
	}

	@Override	// ȸ��/��ȸ�� ����Ʈ
	public ArrayList<UserDTO> getMember() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<UserDTO> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			String sql = "select * from sc_user";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				UserDTO user = new UserDTO();
				user.setAdmin(rs.getInt("admin"));
				user.setName(rs.getString("name"));
				user.setNickname(rs.getString("nickname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				arr.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override	//ȸ������
	public int memberUpdate(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag = 0;
		
		try {
			con = getConnection();
			String sql = "update sc_user set name=?, pwd=?, email=?, nickname=?, admin=? where phone=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setInt(5, user.getAdmin());
			ps.setString(6, user.getPhone());
			flag = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		return flag;
	}

	@Override	//�󼼺���
	public UserDTO findById(String phone) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		UserDTO user = new UserDTO();
		
		try {
			con = getConnection();
			String sql = "select * from sc_user where phone = '"+phone+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				user.setAdmin(rs.getInt("admin"));
				user.setName(rs.getString("name"));
				user.setNickname(rs.getString("nickname"));
				user.setPwd(rs.getString("pwd"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return user;
	}

	@Override	//����
	public void memberDelete(int usernum) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			String sql = "delete from sc_user where userid = "+usernum;
			st = con.createStatement();
			st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
	}

	@Override	//ȸ����
	public int memberCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from sc_user where admin= 0";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, null, rs);
		}
		return count;
	}

	@Override	//�г��� �ߺ�Ȯ��
	public String membernickCheck(String nickname) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes";
		
		try {
			con = getConnection();
			String sql = "select * from sc_user where nickname = '"+nickname+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				flag = "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override	//�α��� Ȯ��
	public UserDTO memberLoginCheck(String phone, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//int flag = -1;
		UserDTO user = new UserDTO();
		user.setAdmin(-1);
		
		try {
			con = getConnection();
			String sql = "select * from sc_user where phone = '"+phone+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {	//phone����(user)
				user = new UserDTO();
				if(rs.getString("pwd").equals(pwd)) {
					user.setAdmin(rs.getInt("admin"));
					user.setName(rs.getString("name"));
					user.setNickname(rs.getString("nickname"));
					user.setPwd(rs.getString("pwd"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
				}else {	//�������
					user.setAdmin(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return user;
	}

	@Override	//�ð��߰�	(�Ϸ�)
	public int od_timeInsert(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag = 0;
		
		try {
			con = getConnection();
			String sql = "update sc_user set od_time=? where phone=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		return flag;
	}
	
	@Override	//�ð��߰�	(��)
	public int sd_timeInsert(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag = 0;
		
		try {
			con = getConnection();
			String sql = "update sc_user set sd_time=? where phone=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		return flag;
	}

	@Override	//�ڸ��߰�
	public int seatInsert(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag = 0;
		
		try {
			con = getConnection();
//			String sql2 = "insert into sc_seat values(?,?,?)";
//			ps = con.prepareStatement(sql2);
			String sql = "update sc_user set seat=? where phone=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getSeat());
			ps.setString(2, user.getPhone( ));
			
//			ps.setInt(1, seat.getSeat());
//			ps.setInt(2, seat.getUsernum());
//			ps.setString(3, "");
			flag = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		return flag;
	}

	@Override	//�ڸ�����(����X)
	public int seatDeleteInsert(UserDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		int flag = 0;
		
		try {
			con = getConnection();
			String sql = "update sc_user set name=?, pwd=?, email=?, nickname=?, admin=? where phone=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setInt(5, user.getAdmin());
			ps.setString(6, user.getPhone());
			flag = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		return flag;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if (con != null)con.close();
			if (ps != null)	ps.close();
			if (st != null)	st.close();
			if (rs != null)	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
