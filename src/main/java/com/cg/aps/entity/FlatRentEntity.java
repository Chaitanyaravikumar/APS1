package com.cg.aps.entity;
import javax.persistence.Entity;


@Entity

public class FlatRentEntity extends BaseEntity 
{
		
		private String flatId;
		private String renterName;
		private String amount;
		private String type;
		
		
		
		public FlatRentEntity(String flatId, String renterName, String amount, String type) {
			super();
			this.flatId = flatId;
			this.renterName = renterName;
			this.amount = amount;
			this.type = type;
		}
		
		public String getFlatId()
		{
			return flatId;
		}
		public void setFlatId(String flatId) 
		{
			this.flatId = flatId;
		}
		public String getRenterName()
		{
			return renterName;
		}
		public void setRenterName(String renterName) 
		{
			this.renterName = renterName;
		}
		public String getAmount() 
		{
			return amount;
		}
		public void setAmount(String amount)
		{
			this.amount = amount;
		}
		public String getType() 
		{
			return type;
		}
		public void setType(String type)
		{
			this.type = type;
		}
		@Override
		public String toString() {
			return "FlatRentEntity [flatId=" + flatId + ", renterName=" + renterName + ", amount=" + amount + ", type="
					+ type + "]";
		}

	

}
