package com.cg.aps.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;


import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="base")
public class BaseEntity implements DropdownList{
	@Id
    @GeneratedValue
    protected long id;
    @CreatedBy
    protected String createdBy;
    @LastModifiedBy
    protected String modifiedBy;
    @CreationTimestamp
    protected LocalDateTime createdDateTime;
    @UpdateTimestamp
    protected LocalDateTime modifiedDateTime;
    
    public BaseEntity()
    {
        // TODO Auto-generated constructor stub
    }
    public BaseEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,LocalDateTime modifiedDateTime)
    {
        super();
        this.id = id;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }
    public long getId()
    {
        return id;
    }

   public void setId(long id)
    {
        this.id = id;
    }

   public String getCreatedBy()
    {
        return createdBy;
    }

   public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

   public String getModifiedBy()
    {
        return modifiedBy;
    }

   public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

   public LocalDateTime  getCreatedDateTime()
    {
        return createdDateTime;
    }

   public void setCreatedDateTime(LocalDateTime createdDateTime)
    {
        this.createdDateTime = createdDateTime;
    }

   public LocalDateTime  getModifiedDateTime()
    {
        return modifiedDateTime;
    }

   public void setModifiedDateTime(LocalDateTime modifiedDateTime)
    {
        this.modifiedDateTime = modifiedDateTime;
    }
@Override
public String getKey() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getValue() {
	// TODO Auto-generated method stub
	return null;
}
}
