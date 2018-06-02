package first;
public class Test {

  private static double price(Book... books) {
    // TODO: Here you must create an instance of the class Cart
    // which will calculate the price by applying disconunts
	
    Cart mycart = new Cart(books);
    
    return mycart.getprice();
  }

  private static void assert_equal(double x, double y) {
    if (x != y) {
      throw new RuntimeException("" + x + " is not equal to " + y);
    }
  }

  public static void main(String[] args) {
    // testBasics
    assert_equal(0, price());
    assert_equal(8, price(Book.BOOK_ONE));
    assert_equal(8, price(Book.BOOK_TWO));
    assert_equal(8, price(Book.BOOK_THREE));
    assert_equal(8, price(Book.BOOK_FOUR));
    assert_equal(8, price(Book.BOOK_FIVE));
    assert_equal(8 * 2, price(Book.BOOK_ONE, Book.BOOK_ONE));
    assert_equal(8 * 3, price(Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_TWO));

    // testSimpleDiscounts;
    assert_equal(8 * 2 * 0.95, price(Book.BOOK_ONE, Book.BOOK_TWO));
    assert_equal(8 * 3 * 0.9, price(Book.BOOK_ONE, Book.BOOK_THREE, Book.BOOK_FIVE));
    assert_equal(8 * 4 * 0.8, price(Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_FIVE));
    assert_equal(8 * 5 * 0.75, price(Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_FOUR, Book.BOOK_FIVE));

    // testSeveralDiscounts;
    assert_equal(8 + (8 * 2 * 0.95), price(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO));
    assert_equal(2 * (8 * 2 * 0.95), price(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_TWO));
    assert_equal((8 * 4 * 0.8) + (8 * 2 * 0.95), price(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_THREE, Book.BOOK_FOUR));
    assert_equal(8 + (8 * 5 * 0.75), price(Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_FOUR, Book.BOOK_FIVE));

    //  testEdgeCases;
    assert_equal(2 * (8 * 4 * 0.8), price(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_THREE, Book.BOOK_THREE, Book.BOOK_FOUR, Book.BOOK_FIVE));
    assert_equal(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
                 price(Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_ONE, Book.BOOK_ONE,
                 Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_TWO, Book.BOOK_TWO,
                 Book.BOOK_THREE, Book.BOOK_THREE, Book.BOOK_THREE, Book.BOOK_THREE,
                 Book.BOOK_FOUR, Book.BOOK_FOUR, Book.BOOK_FOUR, Book.BOOK_FOUR, Book.BOOK_FOUR,
                 Book.BOOK_FIVE, Book.BOOK_FIVE, Book.BOOK_FIVE, Book.BOOK_FIVE));
  }
}
