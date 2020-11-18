package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SBoardDAOImpl implements SBoardDAO {

	private static SBoardDAOImpl instance = new SBoardDAOImpl();

	public static SBoardDAOImpl getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context encCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) encCtx.lookup("jdbc/member");
		return ds.getConnection();
	}

	@Override // 추가
	public void boardInsert(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into sc_board (num,writer,subject,email,content,ip,ref,re_step,re_level,password)");
			sb.append(" values(scboard_seq.nextval,?,?,?,?,?,scboard_seq.nextval,0,0,?)");

			ps = con.prepareStatement(sb.toString());
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.setString(5, board.getIp());
			ps.setString(6, board.getPassword());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
	}

	@Override // 전체보기
	public ArrayList<BoardDTO> findAll(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> board = new ArrayList<>();

		try {
			con = getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from (select rownum rn, aa.* from (select * from sc_board order by ref desc, re_step asc) aa ");
			sb.append("where rownum<=?) where rn>=?");
			
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setEmail(rs.getString("email"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setWriter(rs.getString("writer"));
				board.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, rs);
		}
		return board;
	}

	@Override // 수정
	public void boardUpdate(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			String sql = "update sc_board set subject=?, email=?, content=?, password=?, reg_date=sysdate where num=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, board.getSubject());
			ps.setString(2, board.getEmail());
			ps.setString(3, board.getContent());
			ps.setString(4, board.getPassword());
			ps.setInt(5, board.getNum());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
	}

	@Override // 삭제
	public void boardDelete(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "delete from sc_board where num=" + num;
			st = con.createStatement();
			rs = st.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
	}

	@Override // 상세보기
	public BoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO board = null;
		String sql = "";

		try {
			con = getConnection();
			st = con.createStatement();
			sql = "update sc_board set readcount=readcount+1 where num=" + num;
			st.executeUpdate(sql);
			sql = "select * from sc_board where num=" + num;
			rs = st.executeQuery(sql);

			while (rs.next()) {
				board = new BoardDTO();
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setIp(rs.getString("ip"));
				board.setNum(rs.getInt("num"));
				board.setPassword(rs.getString("password"));
				board.setRe_level(rs.getInt("re_level"));
				board.setRe_step(rs.getInt("re_step"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRef(rs.getInt("ref"));
				board.setReg_date(rs.getString("reg_date"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return board;
	}

	@Override // 게시글 수
	public int getBoardCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = getConnection();
			String sql = "select count(*) from sc_board";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}

	@Override // 검색
	public ArrayList<BoardDTO> findAll(String field, String word) {
//		Connection con = null;
//		Statement st = null;
//		ResultSet rs = null;
//		ArrayList<BoardDTO> arr = new ArrayList<>();
//		
//		try {
//			con = getConnection();
//			String sql = "select * from board where "+field+" = '%"+word+"%'";
//			st = con.createStatement();
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()) {
//				BoardDTO board = new BoardDTO();
//				board.
//				
//				arr.add(board);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override // 검색 게시글 수
	public int getBoardCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = getConnection();
			String sql = "select count(*) from sc_board where " + field + " = '%" + word + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}

	@Override // 댓글 리스트
	public ArrayList<CommentDTO> cmList(int bnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<CommentDTO> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			String sql = "select * from sc_commentboard where bnum="+bnum;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setBnum(rs.getInt("bnum"));
				comment.setCnum(rs.getInt("cnum"));
				comment.setUserid(rs.getString("userid"));
				comment.setRegdate(rs.getString("regdate"));
				comment.setMsg(rs.getString("msg"));
				arr.add(comment);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

	@Override // 댓글추가
	public void boardReplyInsert(BoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "update sc_board set re_step=re_step+1 where ref=? and re_step>?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, board.getRef());
			ps.setInt(2, board.getRe_level());
			ps.executeUpdate();

			int re_step = board.getRe_step() + 1;
			int re_level = board.getRe_level() + 1;

			StringBuilder sb = new StringBuilder();
			sb.append("insert into sc_board (num,writer,subject,email,content,ip,ref,re_step,re_level,password)");
			sb.append(" values(scboard_seq.nextval,?,?,?,?,?,?,?,?,?)");

			ps = con.prepareStatement(sb.toString());
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.setString(5, board.getIp());
			ps.setInt(6, board.getRef());
			ps.setInt(7, re_step);
			ps.setInt(8, re_level);
			ps.setString(9, board.getPassword());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, rs);
		}
	}

	@Override
	public void commentInsert(CommentDTO comment) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into sc_commentboard values(scboard_seq.nextval,?,?,sysdate,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, comment.getUserid());
			ps.setNString(2, comment.getMsg());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		
	}

	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (st != null) st.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
