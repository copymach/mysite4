package com.javaex.vo;

public class GalleryVo {
	
//	필드 db입력 순서대로 기입
	private int bno; // 게시물 식별 번호
	private String content; // 코멘트
	private String filePath; // 파일경로
	private String orgName; // 원본파일명
	private String saveName; // 저장파일명
	private long fileSize; // 파일용량
	private String reg_date; // 등록일자
	private int uno; // user_no 작성자번호
	private String id; // 작성자id
	private String name; // 작성자이름
	
//	생성자 컨스트럭터
	public GalleryVo() {
	}
	public GalleryVo(int bno, String content, String filePath, String orgName, String saveName, long fileSize,
			String reg_date, int uno, String id, String name) {
		this.bno = bno;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.reg_date = reg_date;
		this.uno = uno;
		this.id = id;
		this.name = name;
	}

//	메서드 gs
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	메서드 일반
	@Override
	public String toString() {
		return "GalleryVo [bno=" + bno + ", content=" + content + ", filePath=" + filePath + ", orgName=" + orgName
				+ ", saveName=" + saveName + ", fileSize=" + fileSize + ", reg_date=" + reg_date + ", uno=" + uno
				+ ", id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
} // The End of GalleryVo
