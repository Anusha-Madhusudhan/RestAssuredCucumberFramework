/**
 * 
 */
package requestPayloads;

/**
 * "perdayrent" : {
        "Price" : 140,
         "Discount" : 15
         },
 */
public class PerDayRent {
	
	int Price;
	int Discount;
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	
	

}
