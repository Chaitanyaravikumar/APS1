package com.cg.aps.entity;

import java.time.LocalDate;
import javax.persistence.Entity;



@Entity

public class SecurityEntity extends BaseEntity 
{
	private Integer alertId;
	private String alertMessage;
	private String alertType;
	private LocalDate alertDate;
	
	
	
	
	public SecurityEntity(Integer alertId, String alertMessage, String alertType, LocalDate alertDate) {
		super();
		this.alertId = alertId;
		this.alertMessage = alertMessage;
		this.alertType = alertType;
		this.alertDate = alertDate;
	}
	public Integer getAlertId() 
	{
		return alertId;
	}
	public void setAlertId(Integer alertId)
	{
		this.alertId = alertId;
	}
	public String getAlertMessage()
	{
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) 
	{
		this.alertMessage = alertMessage;
	}
	public String getAlertType()
	{
		return alertType;
	}
	public void setAlertType(String alertType) 
	{
		this.alertType = alertType;
	}
	public LocalDate getAlertDate() 
	{
		return alertDate;
	}
	public void setAlertDate(LocalDate alertDate) 
	{
		this.alertDate = alertDate;
	}
	
}
