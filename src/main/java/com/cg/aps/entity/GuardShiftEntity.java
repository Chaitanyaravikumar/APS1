package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity


public class GuardShiftEntity extends BaseEntity {

	
	private int guardId;
	private String guardName;
	private String time;
	private LocalDate date;
	
	
	public GuardShiftEntity(int guardId, String guardName, String time, LocalDate date) {
		super();
		this.guardId = guardId;
		this.guardName = guardName;
		this.time = time;
		this.date = date;
	}
	
	public int getGuardId() 
	{
		return guardId;
	}
	public void setGuardId(int guardId) 
	{
		this.guardId = guardId;
	}
	public String getGuardName() 
	{
		return guardName;
	}
	public void setGuardName(String guardName) 
	{
		this.guardName = guardName;
	}
	public String getTime() 
	{
		return time;
	}
	public void setTime(String time) 
	{
		this.time = time;
	}
	public LocalDate getDate() 
	{
		return date;
	}
	public void setDate(LocalDate date) 
	{
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "GuardShiftEntity [guardId=" + guardId + ", guardName=" + guardName + ", time=" + time + ", date=" + date
				+ "]";
	}
	
	
}
