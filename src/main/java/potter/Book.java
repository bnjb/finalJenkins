package potter;

import java.util.*;

public class Book {

    public static final double ONE_BOOK_PRICE = 8;

    /**
     * Compute price
     * @param books
     * @return
     */
    public double price(Integer... books){
        double price = 0d;
        List<Integer> bookList = Arrays.asList(books);
        List<Set<Integer>> setsOfDifferentBooks = createAllSetsOfDifferentBooks(bookList);
        for (Set<Integer> set : setsOfDifferentBooks) {
            double discount = BookDiscount.getBookDiscount(set.size());
            double totalPriceWithoutDiscount = set.size() * ONE_BOOK_PRICE;
            price += totalPriceWithoutDiscount - (totalPriceWithoutDiscount * discount);
        }
        return price;
    }

    /**
     * Represents books in the form of different sets
     * @param allBooks
     * @return
     */
    private List<Set<Integer>> createAllSetsOfDifferentBooks(List<Integer> allBooks) {
        List<Integer> remainingBooks = new ArrayList<Integer>(allBooks);
        List<Set<Integer>> setsOfDifferentBooks = new ArrayList<Set<Integer>>();
        //iterate on remaining books
        while (remainingBooks.size() > 0) {
            Set<Integer> setOfDifferentBooks = new HashSet<Integer>();
            setOfDifferentBooks.addAll(remainingBooks);
            setsOfDifferentBooks.add(setOfDifferentBooks);
            removeAddedBooks(setOfDifferentBooks, remainingBooks);
        }
        return setsOfDifferentBooks;
    }

    /**
     * Update non treated books list
     * @param countedBooks
     * @param remainingBooks
     */
    private void removeAddedBooks(Set<Integer> countedBooks, List<Integer> remainingBooks) {
        for (Integer countedBook : countedBooks) {
            remainingBooks.remove(countedBook);
        }
    }

}