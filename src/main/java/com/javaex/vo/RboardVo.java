package com.javaex.vo;

public class RboardVo {
	
//	필드
	private int bno; // 게시물 식별 번호
	private String title; // 게시판 제목
	private String content; // 게시판 내용
	private int hit; // 조회수 카운터
	private String reg_date; // 등록일자
	private int uno; // 작성자번호 (로그인 연계)
	private String id; // 아이디
	private String password; // 패스워드
	private String user_name; // 작성자이름
	private int group_no; // 그룹번호 (bno와 동일)
	private int order_no; // 그룹 순서 (초기값 1)
	private int depth; // 깊이 (초기값 0)
	
	
//	생성자 컨스트럭터
	public RboardVo() {
	}
	
	public RboardVo(int bno, String title, String content, int hit, String reg_date, int uno, String id,
			String password, String user_name, int group_no, int order_no, int depth) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
		this.uno = uno;
		this.id = id;
		this.password = password;
		this.user_name = user_name;
		this.group_no = group_no;
		this.order_no = order_no;
		this.depth = depth;
	}
	
	
//	메서드 gs
	public int getBno() {
		return bno;
	}
	
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
//	메서드 일반
	@Override
	public String toString() {
		return "RboardVo [bno=" + bno + ", title=" + title + ", content=" + content + ", hit=" + hit + ", reg_date="
				+ reg_date + ", uno=" + uno + ", id=" + id + ", password=" + password + ", user_name=" + user_name
				+ ", group_no=" + group_no + ", order_no=" + order_no + ", depth=" + depth + "]";
	}
	
	
	
} // The end of RboardVo
