package chapter02;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * R�mov� Dups! Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * Hints: #9, #40
 * @param <E> any type can be used for this question
 *
 * My Appraoch <br>
 * Create a hash table and iteratively store all the elements currently not in the hash table.
 * If the hash table already contains the element, then the linked list must have a duplicate data.
 */
public class Q01<E> {
    LinkedList<E> unsortedList;

    public Q01(LinkedList<E> unsortedList) {
        this.unsortedList = unsortedList;
    }

    /**
     * Evaluates each element and if there is a duplicate element, return true.
     *
     * @return true if there exists a duplicate element.
     */
    public boolean existsDuplicate() {
        Hashtable<E, E> hashtable = new Hashtable();

        Iterator<E> listIterator = unsortedList.iterator();

        while (listIterator.hasNext()) {
            E nextElement = listIterator.next();
            if (hashtable.contains(nextElement))
                return true;
            else
                hashtable.put(nextElement, nextElement);
        }
        return false;
    }

    /**
     * Removes any duplicates from a list
     */
    public void removeDuplicates() {
        Hashtable<E, E> hashtable = new Hashtable<>();
        Iterator<E> listIterator = unsortedList.iterator();

        int currentIndex = 0;
        while(listIterator.hasNext()) {
            E nextElement = listIterator.next();

            if(hashtable.contains(nextElement))
                unsortedList.remove(currentIndex);
            else
                hashtable.put(nextElement, nextElement);

            currentIndex++;
        }
    }
}
