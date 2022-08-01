package dto;

import java.time.LocalDateTime;

import constants.Status;

public class KanbanDto {
	private int id; // 작업 등록번호
	private Status status; // 작업 상태
	private String workNm; // 작업 내용
	private LocalDateTime regDt; // 작업 등록일
	private LocalDateTime modDt; // 작업 수정일
	
	public KanbanDto(){}

	public KanbanDto(int id, Status status, String workNm, LocalDateTime regDt, LocalDateTime modDt) {
		
		this.id = id;
		this.status = status;
		this.workNm = workNm;
		this.regDt = regDt;
		this.modDt = modDt;
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
		return "KanbanDto [id=" + id + ", status=" + status + ", workNm=" + workNm + ", regDt=" + regDt + ", modDt="
				+ modDt + "]";
	}
}
