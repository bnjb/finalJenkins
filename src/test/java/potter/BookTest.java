package potter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

    private Book book;
    private static final Integer BOOK_1 = 0;
    private static final Integer BOOK_2 = 1;
    private static final Integer BOOK_3 = 2;
    private static final Integer BOOK_4 = 3;
    private static final Integer BOOK_5 = 4;

    @Before
    public void setUp() {
        book = new Book();
    }

    @Test
    public void ShouldReturnZeroForNoBooks() {
        //when
        double price = book.price(new Integer[]{});

        //then
        Assert.assertEquals(price, (double)0, 0);
    }


    @Test
    public void ShouldReturnEightForOneBook() {
        //when
        double price1 = book.price(BOOK_1);
        //then
        Assert.assertEquals((double)8, price1, 0);

        //when
        double price2 = book.price(BOOK_2);
        //then
        Assert.assertEquals((double)8, price2, 0);

        //when
        double price3 = book.price(BOOK_3);
        //then
        Assert.assertEquals((double)8, price3, 0);

        //when
        double price4 = book.price(BOOK_4);
        //then
        Assert.assertEquals((double)8, price4, 0);

        //when
        double price5 = book.price(BOOK_5);
        //then
        Assert.assertEquals((double)8, price5, 0);

    }

    @Test
    public void ShouldReturn16ForTwoSameBooks() {
        //when
        double price1 = book.price(BOOK_1, BOOK_1);
        //then
        Assert.assertEquals((double)16, price1, 0);

        //when
        double price2 = book.price(BOOK_2, BOOK_2);
        //then
        Assert.assertEquals((double)16, price2, 0);

        //when
        double price3 = book.price(BOOK_3, BOOK_3);
        //then
        Assert.assertEquals((double)16, price3, 0);

        //when
        double price4 = book.price(BOOK_4, BOOK_4);
        //then
        Assert.assertEquals((double)16, price4, 0);

        //when
        double price5 = book.price(BOOK_5, BOOK_5);
        //then
        Assert.assertEquals((double)16, price5, 0);
    }

    @Test
    public void ShouldReturn24ForThreeSameBooks() {
        //when
        double price1 = book.price(BOOK_1, BOOK_1, BOOK_1);
        //then
        Assert.assertEquals((double)24, price1, 0);
    }

    @Test
    public void ShouldReturn32ForFourSameBooks() {
        //when
        double price1 = book.price(BOOK_1, BOOK_1, BOOK_1, BOOK_1);
        //then
        Assert.assertEquals((double)32, price1, 0);
    }

    @Test
    public void ShouldReturn40ForFiveSameBooks() {
        //when
        double price1 = book.price(BOOK_1, BOOK_1, BOOK_1, BOOK_1, BOOK_1);
        //then
        Assert.assertEquals((double)40, price1, 0);
    }

    @Test
    public void ShouldApply5PercentForTwoDifferentBooks() {
        //when
        double price = book.price(BOOK_1, BOOK_2);
        //then
        Assert.assertEquals((double) 8 * 2 * 0.95, price, 0);

        //when
        double price2 = book.price(BOOK_1, BOOK_3);
        //then
        Assert.assertEquals((double) 8 * 2 * 0.95, price2, 0);

        //when
        double price3 = book.price(BOOK_2, BOOK_4);
        //then
        Assert.assertEquals((double) 8 * 2 * 0.95, price3, 0);
    }

    @Test
    public void ShouldApply10PercentForThreeDifferentBooks() {
        //when
        double price = book.price(BOOK_1, BOOK_2, BOOK_3);
        //then
        Assert.assertEquals((double) 8 * 3 * 0.9, price, 0);

        //when
        double price2 = book.price(BOOK_1, BOOK_3, BOOK_5);
        //then
        Assert.assertEquals((double) 8 * 3 * 0.9, price2, 0);

        //when
        double price3 = book.price(BOOK_2, BOOK_4, BOOK_5);
        //then
        Assert.assertEquals((double) 8 * 3 * 0.9, price3, 0);
    }

    @Test
    public void ShouldAppluy20PercentForFourDifferentBooks() {
        //when
        double price = book.price(BOOK_1, BOOK_2, BOOK_3, BOOK_4);
        //then
        Assert.assertEquals((double) 8 * 4 * 0.8, price, 0);

        //when
        double price2 = book.price(BOOK_1, BOOK_3, BOOK_4, BOOK_5);
        //then
        Assert.assertEquals((double) 8 * 4 * 0.8, price2, 0);

        //when
        double price3 = book.price(BOOK_2, BOOK_3, BOOK_4, BOOK_5);
        //then
        Assert.assertEquals((double) 8 * 4 * 0.8, price3, 0);
    }

    @Test
    public void ShouldApply25PercentForFiveDifferentBooks() {
        //when
        double price = book.price(BOOK_1, BOOK_2, BOOK_3, BOOK_4, BOOK_5);
        //then
        Assert.assertEquals((double) 8 * 5 * 0.75, price, 0);
    }

    @Test
    public void ShouldApply10PercentForFourBooksWithThreeDifferent() {
        //when
        double price = book.price(BOOK_1, BOOK_2, BOOK_3, BOOK_3);
        //then
        Assert.assertEquals((8 * 3 * 0.9) + 8, price, 0);
    }

    @Test
    public void ShouldApply10PercentForSixBooksWithTwoSetOfThreeDifferentBooks() {
        //when
        double price = book.price(BOOK_1, BOOK_2, BOOK_2, BOOK_3, BOOK_3, BOOK_1);
        //then
        Assert.assertEquals((8 * 3 * 0.9) + (8 * 3 * 0.9), price, 0);
    }

    @Test
    public void TestSeveralSimpleDiscounts() {
        //when
        double price = book.price(BOOK_1, BOOK_1, BOOK_2);
        //then
        Assert.assertEquals((8 * 2 * 0.95) + 8 , price, 0);

        //when
        double price2 = book.price(BOOK_1, BOOK_1, BOOK_2, BOOK_2);
        //then
        Assert.assertEquals((8 * 2 * 0.95) + (8 * 2 * 0.95) , price2, 0);

        //when
        double price3 = book.price(BOOK_1, BOOK_1, BOOK_2, BOOK_3, BOOK_3, BOOK_4);
        //then
        Assert.assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95) , price3, 0);

        //when
        double price4 = book.price(BOOK_1, BOOK_2, BOOK_2, BOOK_3, BOOK_4, BOOK_5);
        //then
        Assert.assertEquals((8 * 5 * 0.75) + 8 , price4, 0);

    }

}