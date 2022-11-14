package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;




@Entity

public class GuardSalaryEntity extends BaseEntity {
	

	private int guardId;
	private String guardName;
	private long amount;
	private String status;
	private LocalDate date;
	
	
	
	public GuardSalaryEntity(int guardId, String guardName, long amount, String status, LocalDate date) {
		super();
		this.guardId = guardId;
		this.guardName = guardName;
		this.amount = amount;
		this.status = status;
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
	public long getAmount()
	{
		return amount;
	}
	public void setAmount(long amount) 
	{
		this.amount = amount;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
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
		return "GuardSalaryEntity [guardId=" + guardId + ", guardName=" + guardName + ", amount=" + amount + ", status="
				+ status + ", date=" + date + "]";
	}
	
	
}
