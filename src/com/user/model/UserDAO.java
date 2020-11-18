package com.user.model;

import java.util.ArrayList;

public interface UserDAO {
	//회원가입
	public void memberJoin(UserDTO user); 
	//비회원으로 로그인
	public void tempJoin(UserDTO user);
	// 회원/비회원 리스트
	public ArrayList<UserDTO> getMember();
	//수정
	public int memberUpdate(UserDTO user);
	//상세보기
	public UserDTO findById(String phone);
	//삭제
	public void memberDelete(int usernum);
	//회원수
	public int memberCount();
	//아이디 중복확인
	public String membernickCheck(String usernum);
	//로그인 확인
	public UserDTO memberLoginCheck(String phone, String pwd);
	
	//시간추가(하루)
	public int od_timeInsert(UserDTO user);
	//시간추가(날)
	public int sd_timeInsert(UserDTO user);
	
	//자리추가
	public int seatInsert(UserDTO user);
//	//자리추가
//	public int seatInsert(seatDTO seat);
	//자리삭제
	public int seatDeleteInsert(UserDTO user);
	
}
