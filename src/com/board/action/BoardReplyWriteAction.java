package com.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDTO;
import com.board.model.SBoardDAOImpl;

/**
 * Servlet implementation class CommentInsert
 */
@WebServlet("/board/replyWrite")
public class BoardReplyWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//댓글쓰기 폼으로
		request.setCharacterEncoding("utf-8");
		BoardDTO bean = new BoardDTO();
		bean.setNum(Integer.parseInt(request.getParameter("num")));
		bean.setRef(Integer.parseInt(request.getParameter("ref")));
		bean.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		bean.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		request.setAttribute("bean", bean);
		
		RequestDispatcher rd = request.getRequestDispatcher("boardReplyWrite.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDTO board = new BoardDTO();
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		board.setSubject(request.getParameter("subject"));
		board.setPassword(request.getParameter("password"));
		board.setEmail(request.getParameter("email"));
		board.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		board.setRef(Integer.parseInt(request.getParameter("ref")));
		board.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		board.setIp(request.getRemoteAddr());	//ip주소 구하기
		
		SBoardDAOImpl dao = SBoardDAOImpl.getInstance();
		dao.boardReplyInsert(board);
		response.sendRedirect("list");

	}

}
