/**
 * 
 */
package requestPayloads;

/**
 *  "metrics" : {
         "yoymaintenancecost" : 2190.76,
         "depreciation": 2256.43,
         "rentalcount" : {
             "lastweek" : 4,
             "yeartodate" : 221
             }
         }
 */
public class Metrics {

	public int getYoymaintenancecost() {
		return yoymaintenancecost;
	}
	public void setYoymaintenancecost(int yoymaintenancecost) {
		this.yoymaintenancecost = yoymaintenancecost;
	}
	public int getDepreciation() {
		return depreciation;
	}
	public void setDepreciation(int depreciation) {
		this.depreciation = depreciation;
	}
	public RentalCount getRentalcount() {
		return rentalcount;
	}
	public void setRentalcount(RentalCount rentalcount) {
		this.rentalcount = rentalcount;
	}
	int yoymaintenancecost;
	int depreciation;
	RentalCount rentalcount;
}
