package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Table(name="visitor")
public class VisitorEntity extends BaseEntity{
	
	//Fields
	//@Id
	private int visitorNo;
	private String name;
	private String ownerName;
	//@Id
	private String flatNo;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate date;
	private String arrivalTime;
	private String departureTime;
	
	
	public int getVisitorNo() 
	{
		return visitorNo;
	}
	public void setVisitorNo(int visitorNo) 
	{
		this.visitorNo = visitorNo;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getOwnerName() 
	{
		return ownerName;
	}
	public void setOwnerName(String ownerName) 
	{
		this.ownerName = ownerName;
	}
	public String getFlatNo() 
	{
		return flatNo;
	}
	public void setFlatNo(String flatNo)
	{
		this.flatNo = flatNo;
	}
	public LocalDate getDate() 
	{
		return date;
	}
	public void setDate(LocalDate date) 
	{
		this.date = date;
	}
	public String getArrivalTime() 
	{
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) 
	{
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() 
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}
	
	/*
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "flatNo"),name = "flatNo")
	private FlatEntity flat;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "userId"),name = "userId")
	private GuardTrainingEntity guard;
	 */
	
	
	
	
	
}
