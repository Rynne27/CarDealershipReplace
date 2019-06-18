package com.revature.cardealership;

public class AllOffers {

			int customer_id;
		    String vin_No;
		    int offer_price;
		    int statusid;
		    
		    
			public AllOffers(int customer_id, String vin_No, int offer_price, int statusid) {
				super();
				this.customer_id = customer_id;
				this.vin_No = vin_No;
				this.offer_price = offer_price;
				this.statusid = statusid;
			}
			
			public AllOffers(int int1, int int2, double double1, int int3) {
				// TODO Auto-generated constructor stub
			}

			public int getCustomer_id() {
				return customer_id;
			}
			public void setCustomer_id(int customer_id) {
				this.customer_id = customer_id;
			}
			public String getVIN_No() {
				return vin_No;
			}
			public void setVIN_No(String vin_No) {
				vin_No = vin_No;
			}
			public int getOffer_price() {
				return offer_price;
			}
			public void setOffer_price(int offer_price) {
				this.offer_price = offer_price;
			}
			public int getStatusid() {
				return statusid;
			}
			public void setStatusid(int statusid) {
				this.statusid = statusid;
			}
		    
		    
}
