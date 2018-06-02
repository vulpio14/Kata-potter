package first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class calculations {
/**
 * class calculations has functions for determining the basic calculations
 * according to the given discounts	
 */
	    public calculations(){
	    	
	    }
	    /**
	     * function calcset takes each value from the given list and calculates
	     * the final price of the books accordingly.
	     * @param bookset
	     * @return double price
	     */
	public double calcSet(ArrayList<Integer> bookset){
		double pprice = 0;
		// loop through each element in the list that represents the set of the books
		for (int i = 0; i < bookset.size(); i++){
			pprice += determ(bookset.get(i));
			
		}
		return pprice;
		
	}
	
	/**
	 * function determ applies the discount rules according to
	 * the number of the books in the set
	 * @param value
	 * @return double price
	 */
	private double determ(int value){
		double price = 0;
		if (value == 0){
			price = 0;
		}
		else if (value == 1){
			price = 8;
		}
		else if (value == 2){
			price = (8.0*2.0*0.95);
		}
		else if (value == 3){
			price = (8.0*3.0*0.90);
		}
		else if (value == 4){
			price = (8*4.0*0.80);
		}
		else if (value == 5){
			price = (8*5*0.75);
		}
	    return price;
	}
}
