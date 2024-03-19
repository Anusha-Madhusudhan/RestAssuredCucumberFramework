/**
 * 
 */
package requestPayloads;

/**
 *  "metadata" : {
         "Color" : "Black",
         "Notes" : "Scratches on the front side of the car"
         },
 */
public class MetaData {
	
	String Color;
	String Notes;
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}

}
