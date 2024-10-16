package com.sumit.ds.realinterviews.adyen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingPayment {

    public static void main(String[] args) {
        List<Payment> payments = Arrays.asList(
                new Payment("paymentA", 2),
                new Payment("paymentB", 2),
                new Payment("paymentC", 5),
                new Payment("paymentD", 1),
                new Payment("paymentE", 2)
        );

        int transferAmount = 5;
        List<List<Payment>> possiblePaymentSets = findPaymentSets(transferAmount, payments);

        // Display the result
        int index = 1;
        for (List<Payment> paymentSet : possiblePaymentSets) {
            System.out.print("Possible payment set " + index++ + ": ");
            for (Payment payment : paymentSet) {
                System.out.print(payment.name + "["+payment.amount+"] ");
            }
            System.out.println();
        }
    }

    public static List<List<Payment>> findPaymentSets(int transferAmount, List<Payment> payments) {
        List<List<Payment>> result = new ArrayList<>();
        List<Payment> currentSet = new ArrayList<>();
        findPaymentSetsHelper1(transferAmount, payments, 0, currentSet, result);
        return result;
    }

    private static void findPaymentSetsHelper(int transferAmount, List<Payment> payments, int startIndex,
                                              List<Payment> currentSet, List<List<Payment>> result) {
        if (transferAmount == 0) {
            result.add(new ArrayList<>(currentSet));
            return;
        }

        for (int i = startIndex; i < payments.size(); i++) {
            if (payments.get(i).amount <= transferAmount) {
                currentSet.add(payments.get(i));
                findPaymentSetsHelper(transferAmount - payments.get(i).amount, payments, i + 1, currentSet, result);
                currentSet.remove(currentSet.size() - 1);
            }
        }
    }

    private static void findPaymentSetsHelper1(int transferAmount, List<Payment> payments, int startIndex,
                                              List<Payment> currentSet, List<List<Payment>> result) {
        if (transferAmount == 0 || startIndex == payments.size()) {
            if(transferAmount == 0) {
                result.add(new ArrayList<>(currentSet));
            }
            return;
        }
        findPaymentSetsHelper1(transferAmount, payments, startIndex + 1, currentSet, result); //exclude case

        if(payments.get(startIndex).amount <= transferAmount) {
            currentSet.add(payments.get(startIndex));
            findPaymentSetsHelper1(transferAmount - payments.get(startIndex).amount, payments, startIndex + 1, currentSet, result); //include case
            currentSet.remove(currentSet.size() - 1);
        }
    }

    private static void findPaymentSets(int transferAmount, List<Payment> payments, int currentIndex,
                                        List<Payment> currentSet, List<List<Payment>> result) {
        if (currentIndex == payments.size()) {
            if (transferAmount == 0) {
                result.add(new ArrayList<>(currentSet));
            }
            return;
        }

        // Case 1: Skip the current payment
        findPaymentSets(transferAmount, payments, currentIndex + 1, currentSet, result);

        // Case 2: Include the current payment if it doesn't exceed the remaining amount
        Payment currentPayment = payments.get(currentIndex);
        if (transferAmount >= currentPayment.amount) {
            currentSet.add(currentPayment);
            findPaymentSets(transferAmount - currentPayment.amount, payments, currentIndex + 1, currentSet, result);
            currentSet.remove(currentSet.size() - 1); // Backtrack to explore other possibilities
        }
    }
}


class Payment {
    String name;
    int amount;

    Payment(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
