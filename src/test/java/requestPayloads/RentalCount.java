/**
 * 
 */
package requestPayloads;

/**
 * "rentalcount" : {
             "lastweek" : 4,
             "yeartodate" : 221
             }
 */
public class RentalCount {

	int lastweek;
	int yeartodate;
	public int getLastweek() {
		return lastweek;
	}
	public void setLastweek(int lastweek) {
		this.lastweek = lastweek;
	}
	public int getYeartodate() {
		return yeartodate;
	}
	public void setYeartodate(int yeartodate) {
		this.yeartodate = yeartodate;
	}
	
}
