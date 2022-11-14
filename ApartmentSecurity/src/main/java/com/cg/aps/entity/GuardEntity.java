package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;






@Entity


public class GuardEntity extends BaseEntity{
	
	private int guardId;
	private String guardName;
	private String mobileNo;
	private String status;
	private String timing; 
	private LocalDate date;
	
	
	
	public GuardEntity(int guardId, String guardName, String mobileNo, String status, String timing, LocalDate date) {
		super();
		this.guardId = guardId;
		this.guardName = guardName;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timing = timing;
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
	public String getMobileNo() 
	{
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) 
	{
		this.mobileNo = mobileNo;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public String getTiming() 
	{
		return timing;
	}
	public void setTiming(String timing) 
	{
		this.timing = timing;
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
		return "GuardEntity [guardId=" + guardId + ", guardName=" + guardName + ", mobileNo=" + mobileNo + ", status="
				+ status + ", timing=" + timing + ", date=" + date + "]";
	}
	
}
