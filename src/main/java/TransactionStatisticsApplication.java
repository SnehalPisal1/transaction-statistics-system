/*
1. Transaction Statistics API (N26 Classic)

Build a RESTful API with endpoints to:

POST a new transaction with an amount and timestamp.

GET real-time statistics (sum, average, min, max, count) of transactions from the last 60 seconds.

Ensure thread safety and high performance for concurrent requests.

This is a well-documented N26 interview challenge, often implemented in Java with Spring Boot.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedDeque;

@SpringBootApplication
@RestController
public class TransactionStatisticsApplication {


    ConcurrentLinkedDeque<Transaction> transactions = new ConcurrentLinkedDeque<>();
    public static void main(String args[]){

        SpringApplication.run(TransactionStatisticsApplication.class, args);
    }

    static class Statistics{
        private double sum;
        private double average;
        private double min;
        private double max;
        private double count;

        public Statistics(double sum, double average, double min, double max, double count) {
            this.sum = sum;
            this.average = average;
            this.min = min;
            this.max = max;
            this.count = count;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getCount() {
            return count;
        }

        public void setCount(double count) {
            this.count = count;
        }
    }
    static class Transaction {

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Transaction(double amount, LocalDateTime timestamp) {
            this.amount = amount;
            this.timestamp = timestamp;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        private double amount;
        private LocalDateTime timestamp;


    }
}
