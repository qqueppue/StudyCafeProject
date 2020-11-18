package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
	//�߰�
	public void boardInsert(BoardDTO board);
	//��ü����
	public ArrayList<BoardDTO> findAll(int startRow, int endRow);
	//����
	public void boardUpdate(BoardDTO board);
	//����
	public void boardDelete(int num);
	//�󼼺���
	public BoardDTO findByNum(int num);
	//�Խñ� ��
	public int getBoardCount();
	//�˻�
	public ArrayList<BoardDTO> findAll(String field, String word);
	//�˻� �Խñ� ��
	public int getBoardCount(String field, String word);
	//����߰�
	public void  boardReplyInsert(BoardDTO board);
	//��� ����Ʈ
	public ArrayList<CommentDTO> cmList(int num);
	//��� ����Ʈ
	public void commentInsert(CommentDTO comment);
}
