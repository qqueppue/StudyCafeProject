package com.user.model;

import java.util.ArrayList;

public interface UserDAO {
	//ȸ������
	public void memberJoin(UserDTO user); 
	//��ȸ������ �α���
	public void tempJoin(UserDTO user);
	// ȸ��/��ȸ�� ����Ʈ
	public ArrayList<UserDTO> getMember();
	//����
	public int memberUpdate(UserDTO user);
	//�󼼺���
	public UserDTO findById(String phone);
	//����
	public void memberDelete(int usernum);
	//ȸ����
	public int memberCount();
	//���̵� �ߺ�Ȯ��
	public String membernickCheck(String usernum);
	//�α��� Ȯ��
	public UserDTO memberLoginCheck(String phone, String pwd);
	
	//�ð��߰�(�Ϸ�)
	public int od_timeInsert(UserDTO user);
	//�ð��߰�(��)
	public int sd_timeInsert(UserDTO user);
	
	//�ڸ��߰�
	public int seatInsert(UserDTO user);
//	//�ڸ��߰�
//	public int seatInsert(seatDTO seat);
	//�ڸ�����
	public int seatDeleteInsert(UserDTO user);
	
}
