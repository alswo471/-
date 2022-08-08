package dto;

import java.time.LocalDateTime;

import constants.Sports;

public class ErpDto {
	private int id; // 등록번호
	private Sports sports; // 운동 부위
	private String sportNm; // 운동 종목
	private int workoutSet;
	private int workoutNum;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	public ErpDto() {
	}

	public ErpDto(int id, Sports sports, String sportNm, int workoutSet, int workoutNum, LocalDateTime regDt,
			LocalDateTime modDt) {
		super();
		this.id = id;
		this.sports = sports;
		this.sportNm = sportNm;
		this.workoutSet = workoutSet;
		this.workoutNum = workoutNum;
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

	public int getWorkoutSet() {
		return workoutSet;
	}

	public void setWorkoutSet(int workoutSet) {
		this.workoutSet = workoutSet;
	}

	public int getWorkoutNum() {
		return workoutNum;
	}

	public void setWorkoutNum(int workoutNum) {
		this.workoutNum = workoutNum;
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
		return "ErpDto [id=" + id + ", sports=" + sports + ", sportNm=" + sportNm + ", workoutSet=" + workoutSet
				+ ", workoutNum=" + workoutNum + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}

}
