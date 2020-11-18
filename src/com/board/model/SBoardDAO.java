package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
	//추가
	public void boardInsert(BoardDTO board);
	//전체보기
	public ArrayList<BoardDTO> findAll(int startRow, int endRow);
	//수정
	public void boardUpdate(BoardDTO board);
	//삭제
	public void boardDelete(int num);
	//상세보기
	public BoardDTO findByNum(int num);
	//게시글 수
	public int getBoardCount();
	//검색
	public ArrayList<BoardDTO> findAll(String field, String word);
	//검색 게시글 수
	public int getBoardCount(String field, String word);
	//댓글추가
	public void  boardReplyInsert(BoardDTO board);
	//댓글 리스트
	public ArrayList<CommentDTO> cmList(int num);
	//댓글 리스트
	public void commentInsert(CommentDTO comment);
}
