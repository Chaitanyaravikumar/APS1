package com.cg.aps.entity;

import java.time.LocalDate;


import javax.persistence.Entity;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="delivery")
public class DeliveryEntity extends BaseEntity{
	
	
	private int deliveryId;
	private String ownerName;
	private String time;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate date;
	private String status;
	
	/*
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "flatNo"),name = "flatNo")
	private FlatEntity flat;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "userId"),name = "userId")
	private GuardTrainingEntity guard;
	 */
	
	public DeliveryEntity(int deliveryId, String ownerName, String time, LocalDate date, String status) {
		super();
		this.deliveryId = deliveryId;
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
		this.status = status;
	}
	
	public int getDeliveryId() 
	{
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) 
	{
		this.deliveryId = deliveryId;
	}
	public String getOwnerName()
	{
		return ownerName;
	}
	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
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
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "DeliveryEntity [deliveryId=" + deliveryId + ", ownerName=" + ownerName + ", time=" + time + ", date="
				+ date + ", status=" + status + "]";
	}

}
