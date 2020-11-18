package com.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;

/**
 * Servlet implementation class BoardUpdateAction
 */
@WebServlet("/board/update")
public class BoardUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		BoardDTO board = dao.findByNum(num);
		
		request.setAttribute("toUpdate", board);
		
		RequestDispatcher rd = request.getRequestDispatcher("boardUpdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		BoardDTO board = new BoardDTO();
		board.setSubject(request.getParameter("subject"));
		board.setEmail(request.getParameter("email"));
		board.setContent(request.getParameter("content"));
		board.setPassword(request.getParameter("password"));
		board.setNum(Integer.parseInt(request.getParameter("num")));
		
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		dao.boardUpdate(board);
		
//		String ip = request.getRemoteAddr();
//		board.setIp(ip);
//		
		response.sendRedirect("list");
		
//		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
//		rd.forward(request, response);
	}

}
