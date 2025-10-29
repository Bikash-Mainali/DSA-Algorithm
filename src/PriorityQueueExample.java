/**
 * 🧩 Problem Summary
 * <p>
 * You have an incoming stream of requests, each containing:
 * <p>
 * order_id
 * order_date
 * completion_date
 * <p>
 * <p>
 * You must:
 * <p>
 * Process them based on priority.
 * <p>
 * Priority is determined first by order_date, then by completion_date (i.e., earlier orders first; if same order_date, earlier completion_date first).
 */

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ⚙️ 1. What Data Structure to Use?
 *
 * ✅ Answer: Use a Priority Queue (java.util.PriorityQueue)
 * Because:
 *
 * It automatically keeps elements in sorted order based on a Comparator.
 *
 * Insertion (offer) and removal (poll) are both O(log n).
 *
 * Perfect for streaming / real-time request processing.
 */

public class PriorityQueueExample {

    // ✅ Comparator: order by orderDate, then completionDate
    public static class OrderComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            int result = o1.getOrderDate().compareTo(o2.getOrderDate());
            if (result == 0) {
                result = o1.getCompletionDate().compareTo(o2.getCompletionDate());
            }
            return result;
        }
    }

    public static void priorityQueue() {
        PriorityQueue<Order> priorityQueue = new PriorityQueue<>(new OrderComparator());
        LocalDateTime now = LocalDateTime.now();

        Order order1 = Order.builder()
                .orderId(1L)
                .orderDate(now.minusDays(1))
                .completionDate(now.minusDays(10))
                .build();

        Order order2 = Order.builder()
                .orderId(2L)
                .orderDate(now.minusDays(1))
                .completionDate(now.minusHours(5))
                .build();

        Order order3 = Order.builder()
                .orderId(3L)
                .orderDate(now.minusDays(2))
                .completionDate(now.minusHours(3))
                .build();

        priorityQueue.add(order1);
        priorityQueue.add(order2);
        priorityQueue.add(order3);

        priorityQueue.stream().sorted(Comparator.comparing(Order::getOrderDate).thenComparing(Order::getCompletionDate)).forEach(System.out::println);

        //System.out.println(priorityQueue);  this does not maintain order just prints the heap array

        System.out.println("🧾 Processing orders by priority:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void main(String[] args) {
        PriorityQueueExample.priorityQueue();
    }
}

class Order {
    private  Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    private  LocalDateTime orderDate;
    private  LocalDateTime completionDate;

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private  Long orderId;
        private  LocalDateTime orderDate;
        private  LocalDateTime completionDate;

        public Builder() {

        }

        public void setCompletionDate(LocalDateTime completionDate) {
            this.completionDate = completionDate;
        }

        public void setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder completionDate(LocalDateTime completionDate) {
            this.completionDate = completionDate;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.orderId = this.orderId;
            order.orderDate = this.orderDate;
            order.completionDate = this.completionDate;
            return order;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "completionDate=" + completionDate +
                ", orderId=" + orderId +
                ", orderDate=" + orderDate +
                '}';
    }
}

