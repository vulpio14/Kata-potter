package first;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class setupsets {
	private ArrayList<Integer> bookset = new ArrayList<Integer>();
	private ArrayList<Integer> bookset2 = new ArrayList<Integer>();
	private ArrayList<Integer> array = new ArrayList<Integer>();
	private calculations calc = new calculations();
	private Set<Integer> distinctbooks = new HashSet<Integer>();
	private int length;
	private double finalprice = 0;
	/**
	 * constructor of the class setupsets that determines the distinct books
	 * of the set, the length of the cart and calls the helper functions in
	 * the class
	 * @param set
	 */
	public setupsets(ArrayList<Integer> set){
		bookset.addAll(set);
		length = bookset.size();
		// determine the distinct books in the cart
		distinctbooks.addAll(bookset);
		check();
		
	}

/**
 * 	getter for the price
 * @return double finalprice
 */
public double getprice(){
	return finalprice;
}

/**
 * function check() runs through all the possible cases of the given cart
 * and set ups the algorithm for calculating the final price of the cart
 */
public void check(){
	// if the number of the books in the cart is less than 5
	if (distinctbooks.size() > 5){
		finalprice = makeset(5);
		}
	// if the number of the books is the cart is 0
	else if (bookset.size() == 0){
		finalprice = 0;
	}
	// if the cart has only one find of the book
	else if (distinctbooks.size() == 1){
		array.add(1);
		finalprice = bookset.size() * calc.calcSet(array);
	}
	// if the cart has only one book of each type
	else if (bookset.size() == distinctbooks.size() && distinctbooks.size() != 1){
		finalprice = makeset(distinctbooks.size());
	}
	// if the cart has different number of book types
	else if (bookset.size() > distinctbooks.size() && distinctbooks.size() != 0){
		finalprice = makeset(distinctbooks.size());
	}
	
}
	/**
	 * Function make set puts all the books in the cart into a different set,
	 * where each book type is represented by the number(BOOK_ONE = 1 etc)
	 * and calculates the first possible smallest price, which will be if
	 * the books will be distributed into the maximum possible sets
	 * @param value
	 * @return double price
	 */
public double makeset(int value){
	double price = 0;
	int ssset = maxset(value);
	
	// form the set of the distinct books
	for (int i=0; i< ssset; i++){
	    for (Integer a: bookset){
	    	if (!bookset2.contains(a)){
	    		bookset2.add(a);
	    		
	    	}
	    }
	    // record the sets of the different books into a different array
	    // and remove these books from the original array
	    array.add(bookset2.size());
	    for (Integer a: bookset2){
	    	if (bookset.contains(a)){
	    		bookset.remove(a);
	    	}
	    }
	    bookset2.clear();
	}

	price = calc.calcSet(array);
	calcul(array);
	price  = compare(price);
	return price;
	
	

}
/**
 * function min calculates the min value of the given array
 * @param list
 * @return
 */
private int min(ArrayList<Integer> list){
	int min = 0;
	for (int i = 0; i<list.size()-1;i++){
		if (list.get(i) < list.get(i+1)){
			min = list.get(i);
		}
		else{
			min = list.get(i+1);
		}
	}
	return min;
}

/**
 * function max calculates the max possible valueof the given array
 * @param list
 * @return
 */

private int max(ArrayList<Integer> list){
	int max = 0;
	for (int i = 0; i<list.size()-1;i++){
		if (list.get(i) > list.get(i+1)){
			max = list.get(i);
		}
		else{
			max = list.get(i+1);
		}
	}
	return max;
}
/**
 * function calcul minimilize the difference between possible sets, so
 * that the difference between the minimal and maximum set will be the smalles possible
 * which may result in the biggest discount
 * @param array
 */
private void calcul(ArrayList<Integer> array){
	int min;
	int max;
	for (int i = 0; i < array.size(); i++){
		min = min(array);
		max = max(array);
		if ((max - min) > 1){
			array.remove(new Integer(max));
			array.add(max-1);
			array.remove(new Integer(min));
			array.add(min+1);
		}
	}
}
/**
 * function double compares the possible prices and returns the smallest one
 * @param price1
 * @return
 */
private double compare(double price1){
    
	if (price1 > calc.calcSet(array)){
		price1 = calc.calcSet(array);
	}
	return price1;
}

/**
 * function maxset determines the number of the sets of distinct books
 * that can be formed from the cart
 * @param value
 * @return
 */
private int maxset(int value){
	int maxsets = 0;
	int rem;
    rem = length % value;
	length = length / value;
	maxsets = length + 1;
	return maxsets;
}

}
