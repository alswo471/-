package dto;

import java.time.LocalDateTime;

import constants.Status;

public class LibaryProgramDto {
	private int id;
	private Status status; 
	private String workNm;
	private LocalDateTime regDt; // 작업 등록일
	private LocalDateTime modDt; // 작업 수정일
	
public LibaryProgramDto() {} //기본 생성사 만든 이유 : 
	
	public LibaryProgramDto(int id, Status status, String workNm, LocalDateTime regDt, LocalDateTime modDt) {
		
		this.id = id;
		this.status=status;
		this.workNm=workNm;
		this.regDt=regDt;
		this.modDt=modDt;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getWorkNm() {
		return workNm;
	}

	public void setWorkNm(String workNm) {
		this.workNm = workNm;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public LocalDateTime getModDt() {
		return modDt;
	}

	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "LibaryProgram [id=" + id + ", status=" + status + ", workNm=" + workNm + ", regDt=" + regDt + ", modDt="
				+ modDt + "]";
	}
	
}

 