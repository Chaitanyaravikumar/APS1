package com.cg.aps.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity


@NoArgsConstructor
@Table(name="vehicle")
public class VehicleEntity extends BaseEntity {
	
	//Fields
	//@Id
	private String vehicleNo;
	private String vehicleType;
	private String ownerName;
	private String parkingNo;
	private String arrivalTime;
	private String departueTime;
	private LocalDate date;
	
	
	public VehicleEntity(String vehicleNo, String vehicleType, String ownerName, String parkingNo, String arrivalTime,
			String departueTime, LocalDate date) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
		this.ownerName = ownerName;
		this.parkingNo = parkingNo;
		this.arrivalTime = arrivalTime;
		this.departueTime = departueTime;
		this.date = date;
	
	} 
	
	
	public String getVehicleNo()
	{
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) 
	{
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType()
	{
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) 
	{
		this.vehicleType = vehicleType;
	}
	public String getOwnerName()
{
		return ownerName;
	}
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}
	public String getParkingNo()
	{
		return parkingNo;
	}
	public void setParkingNo(String parkingNo) 
	{
		this.parkingNo = parkingNo;
	}
	public String getArrivalTime()
	{
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) 
	{
		this.arrivalTime = arrivalTime;
	}
	public String getDepartueTime()
	{
		return departueTime;
	}
	public void setDepartueTime(String departueTime) 
	{
		this.departueTime = departueTime;
	}
	public LocalDate getDate() 
	{
		return date;
	}
	public void setDate(LocalDate date) 
	{
		this.date = date;
	}
	
	
	/*
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "flatNo"),name = "flatNo")
	@JsonIgnore
	private FlatEntity flat;
	 */
	
	}
	
	

