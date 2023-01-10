package com.coding5.el.emp.comm.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding5.el.emp.comm.dao.EmpCommDao;
import com.coding5.el.emp.comm.vo.EmpCommVo;
import com.coding5.el.emp.comm.vo.LikeVo;
import com.coding5.el.emp.service.EmpService;
import com.coding5.el.notice.vo.PageVo;



@Service
public class EmpCommServiceImpl implements EmpCommService{
	
	@Autowired private SqlSessionTemplate sst;
	@Autowired private EmpCommDao empCommDao;
	
	
	@Override	//글쓰기
	public int write(EmpCommVo vo) throws Exception {
		return empCommDao.insertWrite(sst, vo);
	}


	@Override	//글 갯수
	public int getEmpCommCnt() throws Exception {
		return empCommDao.getEmpCommCnt(sst);
	}


	@Override	//커뮤 리스트
	public List<EmpCommVo> getEmpCommList(PageVo pageVo) throws Exception {
		return empCommDao.getEmpCommList(sst, pageVo);
	}


	@Override	//조회수 +
	public int increaseHit(String no) throws Exception {
		return empCommDao.increaseHit(sst, no);
	}


	@Override	//상세조회
	public EmpCommVo selectDetail(String no) throws Exception {
		return empCommDao.selectDetail(sst, no);
	}


	@Override	//글 수정하기
	public int editEmpComm(EmpCommVo vo) throws Exception {
		return empCommDao.editEmpComm(sst, vo);
	}


	@Override	//글 삭제하기
	public int deleteEmpComm(String no) throws Exception {
		return empCommDao.deleteEmpComm(sst, no);
	}


	@Override	//해당 글에 해당 멤버가 좋아요를 했는지? Map으로 한번에 합쳐주기
	public LikeVo findHeart(String no, String memberNo) throws Exception {
		Map<String, String> number = new HashMap<String, String>();
		number.put("no", no);
		number.put("memberNo", memberNo);
		return empCommDao.findHeart(sst, number);
	}



	

}
