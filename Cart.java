package first;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cart {
	// variable for the initial price
	private double price;
	ArrayList<Integer> bookset = new ArrayList<Integer>();
	
	// arrange books in the set
	public Cart(Book... book){
		for (Book b: book){
			if (b == Book.BOOK_ONE)
			{
				bookset.add(1);
			}
			else if (b == Book.BOOK_TWO){
				bookset.add(2);
			}
			else if (b == Book.BOOK_THREE){
				bookset.add(3);
			}
			else if (b == Book.BOOK_FOUR){
				bookset.add(4);
			}
			else if (b == Book.BOOK_FIVE){
				bookset.add(5);
			}
			}
		// create an instance of an object which calculates the optimal price
		setupsets setup = new setupsets(bookset);
		// record the price the price
		price = setup.getprice();
		
	}
	
	public double getprice(){
		return price;
	}
	
	
	
}
