package com.coding5.el.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.coding5.el.admin.vo.AdminVo;
import com.coding5.el.common.page.PageVo;
import com.coding5.el.common.vo.SearchVo;
import com.coding5.el.member.vo.MemberVo;
import com.coding5.el.member.vo.PointVo;
import com.coding5.el.teacher.vo.TeacherVo;

public interface AdminService {
	
	//로그인 
	public AdminVo login(AdminVo vo);
	
	// 중복 체크
	public String dupCheck(AdminVo vo);
	
	// 관리자등록
	public int join(AdminVo vo);
	
	// 관리자 내 정보 수정
	public AdminVo myInfoModify(AdminVo vo);
	
	// 관리자 총 수 조회
	public int selectAdminCount(Map<String, String> mapSearch);
	
	// 관리자 리스트 조회
	public List<AdminVo> selectAdminList(PageVo pv, Map<String, String> mapSearch);
	
	// 관리자 상세 조회
	public AdminVo adminDetail(String no);
	
	// 마스터 관리자 정보 수정
	public int adminModify(AdminVo vo);
	
	// 학생 멤버 수 조회
	public int selectStudentCount(Map<String, String> mapSearch);
	
	// 학생 회원 리스트 가져오기
	public List<MemberVo> selectStudentList(PageVo pv, Map<String, String> mapSearch);
	
	// 학생 회원 no로 가져오기
	public Map<String, Object> detailStudent(String no);
	
	
	// 포인트 수정
	public int pointEdit(PointVo vo);
	
	// 강사 회원 수 조회
	public int selectTeacherCount(SearchVo svo);
	
	// 강사 회원 리스트 조회
	public List<TeacherVo> selectTeacherList(PageVo pv, SearchVo svo);
	
	// 강사 승인 대기 인원
	public int selectTeacherStatusByN();
	
	// 강사 디테일 조회
	public Map<String, Object> selectTeacherDetail(String no);
	
	// 강사 박탈
	public int teacherDelete(String no);
	
	// 강사 승인
	public int teacherApproval(String no);
	
	// 강의 삭제
	public int classDelete(String cno);
	
}
