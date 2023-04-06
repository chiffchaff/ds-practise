package com.sumit.ds.random;

import org.junit.Test;

import java.util.*;

/**
 * Oracle Interview Questions: Top K categories from a product catalog (category ->product) ::: Use Max or min Heap
 */
public class TopKElement {

        private Map<String, Integer> categoryCount;
        private List<String> catalog;

        public TopKElement(List<String> catalog) {
            this.catalog = catalog;
            this.categoryCount = new HashMap<>();
        }

        public List<String> findTopCategories(int k) {
            // count the number of products for each category
            for (String entry : catalog) {
                String[] parts = entry.split(" : ");
                String category = parts[0];
                if (!categoryCount.containsKey(category)) {
                    categoryCount.put(category, 0);
                }
                categoryCount.put(category, categoryCount.get(category) + 1);
            }

            // use a priority queue to store the top k categories
            PriorityQueue<String> topCategories = new PriorityQueue<>(
                    (a, b) -> categoryCount.get(b) - categoryCount.get(a));

            for (String category : categoryCount.keySet()) {
                topCategories.offer(category);
                if (topCategories.size() > k) {
                    topCategories.poll();
                }
            }

            // return the result as a list
            List<String> result = new ArrayList<>();
            while (!topCategories.isEmpty()) {
                result.add(topCategories.poll());
            }
            return result;
        }


    @Test
    public void test(){

    }
}
