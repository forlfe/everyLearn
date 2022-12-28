package com.coding5.el.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding5.el.member.dao.MemberDao;
import com.coding5.el.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	@Autowired
	private MemberDao memberDao;
	
	//회원가입
	@Override
	public int join(MemberVo vo) {
		
		//암호화
		String pwd = vo.getMemberPwd();
		String newPwd = enc.encode(pwd);
		vo.setMemberPwd(newPwd);
		
		return memberDao.insertMember(sst, vo);
	}

	//로그인
	@Override
	public MemberVo login(MemberVo vo) {
		
		MemberVo loginMember = memberDao.selectMemberOne(sst, vo);
		//암호화
		String memberPwd = vo.getMemberPwd();
		String encMemberPwd = loginMember.getMemberPwd();
		boolean isMatch = enc.matches(memberPwd, encMemberPwd);
		
		if(isMatch) {
			return loginMember;
		}else {
			
			return null;
		}
		
	}

	//아이디 중복
	@Override
	public String idDup(String memberId) {
		String IdDup = memberDao.selectIdDup(sst, memberId);
		if(IdDup != "") {
			return IdDup;
		}else {
			return "null";
		}
		
	}

	//닉네임  중복
	@Override
	public String nickDup(String memberNick) {
		String nickDup = memberDao.selectNickDup(sst, memberNick);
		return nickDup;
	}


	@Override
	public String idFind(MemberVo findVo) {
		return memberDao.idFindAjax(sst, findVo);
	}

	@Override
	public MemberVo updateMember(MemberVo vo) {
		
		//암호화
		String pwd = vo.getMemberPwd();
		String newPwd = enc.encode(pwd);
		vo.setMemberPwd(newPwd);
		
		int result = memberDao.updateMember(sst, vo);
		
		if(result != 1) {
			return null;
		}
		
		
		return memberDao.selectMemberOne(sst, vo);
	}


	
	
}
