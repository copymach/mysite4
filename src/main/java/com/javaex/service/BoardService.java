package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getBoardList () {
		System.out.println("BoardService.getBoardList 실행");
		
		return boardDao.getBoardList();
	} // getBoardList
	
	public Map<String, Object> getBoardList2 (int crtPage) {
		System.out.println("BoardService.getBoardList2 실행");
		
//		#리스트 가져오기
		
//		페이지 당 글 갯수 10개
		int listCnt = 10;
		
//		현재페이지 처리 if문 방식
		if (crtPage <= 0) { // 마이너스 페이지 입력이 들어오면 그냥 1페이지로 간다
			crtPage = 1;
		}
		
//		현재페이지 처리 삼항연산자 방식 간단한if문 (위와 같은 동작)
//		crtPage = 조건(crtPage>0) ? 참crtPage : 거짓(crtPage=1);  
		
//		시작글 번호 
		int startRnum = (crtPage-1) * listCnt + 1 ; // 1페이지라면1 6페이지라면51 
				
//		끝글 번호
		int endRnum = (startRnum + listCnt) - 1 ; // 1이면 11-1 = 10
		
		List<BoardVo> boardList = boardDao.getBoardList2(startRnum, endRnum);
		
//		#페이징 버튼
		int totalCnt = boardDao.selectTotal();
//		System.out.println("BoardService.totalCnt 출력 "+totalCnt);
		
//		페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		/*
		마지막 버튼 번호 구하기
		1 1~5 0.2 올림 처리 1
		2 1~5 0.4
		3 1~5 0.6
		4 1~5 1
		5 1~5 1.2
		6 6~10
		10 6~10
		11 11~15
		 */
//		마지막 페이지 버튼 번호
		int endPageBtnNo = (int)( Math.ceil(crtPage/(double)pageBtnCount) )*pageBtnCount; // 나눈값의 올림처리 
		
//		시작 버튼 번호
		int startPageBtnNo = endPageBtnNo - (pageBtnCount-1) ; // 끝번호가5면 --> 5-(5-4)=1 
		
//		다음 화살표 출력 유무
		boolean next = false;
		if( endPageBtnNo * listCnt < totalCnt ) {
			next = true;
		} else { // 다음 화살표가 없으면 마지막 버튼값을 다시 계산한다 없는 페이지 출력안함
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt); // 정수와 double실수형 계산해서 나오는 소숫점을 올림처리  
		};
		
//		이전 화살표 출력 유무
		boolean prev = false;
		if ( startPageBtnNo != 1) {
			prev = true;
		};
		
//		지금까지 코드로 14 15 번 페이지 제외하고 5개씩 정상 출력
		
//		#포장
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("prev", prev);
		pMap.put("next", next);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("pageBtnCount", pageBtnCount);
		pMap.put("boardList", boardList);
		
//		System.out.println("BS.pMap 출력 "+pMap);
		
		return pMap;
	} // getBoardList2
	
	
	public BoardVo read (int bno) {
		System.out.println("BoardService.read 실행");
		
		return boardDao.read(bno);
	} // read
	
	public void hit (int bno) {
		System.out.println("BoardService.read 실행");
		boardDao.hit(bno);
	} // hit
	
	public void modify (BoardVo boardVo) {
		System.out.println("BoardService.modify 실행");
		boardDao.modify(boardVo);
	} // modify
	
	public void write (BoardVo boardVo) {
		System.out.println("BoardService.modify 실행");
		/*
		//	페이징 데이터 추가 123개
		for (int i=1; i<=123; i++) {
			boardVo.setTitle(i+"번째 제목입니다");
			boardVo.setContent(i+"번째 내용입니다");
			boardVo.setContent(i+"번째 내용입니다");
			boardVo.setHit(0);
			boardVo.setUno(1);
			}
			*/
		boardDao.write(boardVo);
	} // write

	
	
	public void delete (BoardVo boardVo) {
		System.out.println("BoardService.delete 실행");
		boardDao.delete(boardVo);
	} // delete
		
	
} // The end of BoardService 
