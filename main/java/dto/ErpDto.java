package dto;

import java.time.LocalDateTime;

import constants.Sports;

public class ErpDto {
	private int id; // 등록번호
	private Sports sports;
	private String sportNm;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	public ErpDto() {}
	
	public ErpDto(int id, Sports sports, String sportNm, LocalDateTime regDt, LocalDateTime modDt) {
	
		this.id = id;
		this.sports = sports;
		this.sportNm = sportNm;
		this.regDt = regDt;
		this.modDt = modDt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public String getSportNm() {
		return sportNm;
	}

	public void setSportNm(String sportNm) {
		this.sportNm = sportNm;
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
		return "ErpDto [id=" + id + ", sports=" + sports + ", sportNm=" + sportNm + ", regDt=" + regDt + ", modDt="
				+ modDt + ", getId()=" + getId() + ", getSports()=" + getSports() + ", getSportNm()=" + getSportNm()
				+ ", getRegDt()=" + getRegDt() + ", getModDt()=" + getModDt() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
