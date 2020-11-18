package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;

/**
 * Servlet implementation class CommentListAction
 */
@WebServlet("/board/cList")
public class CommentListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bnum = Integer.parseInt(request.getParameter("num"));
		//int bnum=24;
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		
		ArrayList<CommentDTO> comment = dao.cmList(bnum);
		
		JSONArray com = new JSONArray();
		for(CommentDTO dto:comment) {
			JSONObject obj = new JSONObject();
			obj.put("cnum", dto.getCnum() );
			obj.put("bnum", dto.getBnum());
			obj.put("userid", dto.getUserid());
			obj.put("msg", dto.getMsg());
			obj.put("regdate", dto.getRegdate());
			com.add(obj);
		}
		
		JSONObject clist = new JSONObject();
		clist.put("com", com);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(clist.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
