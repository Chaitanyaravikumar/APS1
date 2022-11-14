package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="domestic_help")


public class DomesticHelpEntity extends BaseEntity {
    private String flatNo;
    private String ownerName;
    private String name;
    private String helpType;
    private String arrivalTime;
    private String departureTime;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate date;
    
    
    public DomesticHelpEntity(String flatNo,String ownerName,String name,String helpType,String arrivalTime,String departureTime,LocalDate date) {
        super();
        this.flatNo=flatNo;
        this.ownerName=ownerName;
        this.name=name;
        this.helpType=helpType;
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
        this.date=date;
    }
    
    public String getFlatNo() 
    {
        return flatNo;
    }

   public void setFlatNo(String flatNo)
   {
        this.flatNo = flatNo;
    }

   public String getOwnerName()
   {
        return ownerName;
    }

   public void setOwnerName(String ownerName) 
   {
        this.ownerName = ownerName;
    }

   public String getName()
   {
        return name;
    }

   public void setName(String name) 
   {
        this.name = name;
    }

   public String getHelpType() 
   {
        return helpType;
    }

   public void setHelpType(String helpType)
   {
        this.helpType = helpType;
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
        return "DomesticHelp [flatNo="+ flatNo +", ownerName="+ ownerName + ", name=" + name +", helpType=" + helpType +
                ", arrivalTime"+ arrivalTime+", depatureTime="+ departureTime +", date="+ date + "]";
    }
}
