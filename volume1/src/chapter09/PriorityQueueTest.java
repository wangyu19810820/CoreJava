package chapter09;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");
        for(LocalDate localDate : pq) {
            System.out.println(localDate);
        }
        System.out.println("Removing elements...");
        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
