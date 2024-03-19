/**
 * 
 */
package requestPayloads;

/**
 * {
     "make": "Audi",
	  "model": "A7",
     "vin": "09AGHY64352JITEG98K",
     "metadata" : {
         "Color" : "Black",
         "Notes" : "Scratches on the front side of the car"
         },
     "perdayrent" : {
        "Price" : 140,
         "Discount" : 15
         },
     "metrics" : {
         "yoymaintenancecost" : 2190.76,
         "depreciation": 2256.43,
         "rentalcount" : {
             "lastweek" : 4,
             "yeartodate" : 221
             }
         }
    }
 */
public class RentalCar {
	
	String make;
	String model;
	String vin;
	MetaData metadata;
	PerDayRent perdayrent;
	Metrics metrics;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public MetaData getMetadata() {
		return metadata;
	}
	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}
	public PerDayRent getPerdayrent() {
		return perdayrent;
	}
	public void setPerdayrent(PerDayRent perdayrent) {
		this.perdayrent = perdayrent;
	}
	public Metrics getMetrics() {
		return metrics;
	}
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}
	

}
