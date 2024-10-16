package com.sumit.ds.realinterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Subset sum problem
 */

/**
 * Missing payment list
ABC Bank regularly receives bank transfers from Visa accompanied by a list
of payments the transfer corresponds to. Occasionally they forget to
send us that list.
Given the amount of the bank transfer and the list of Visa payments
we've processed recently - return the possible payment sets the bank
transfer could correspond to. You can return the payment sets in any
order.
Example test case:
The bank transfer quantity is 5.
We've processed the following payments:
paymentA with quantity 2
paymentB with quantity 2
paymentC with quantity 5
paymentD with quantity 1
paymentE with quantity 2
A bank transfer of 5 could correspond to:
The single payment with the value of 5 - paymentC
The payment with value of 1 - paymentD together with any 2 of the 3
payments with value of 2:
paymentD, paymentA and paymentB
paymentD, paymentA and paymentE
paymentD, paymentB and paymentE
 */

interface Payment {
    String getId();
    int getValue();
}

class MissingPaymentList {
    public static List<List<Payment>> getPossiblePayments(long transferAmount, List<Payment> recentPayments) {
        List<List<Payment>> result = new ArrayList<>();
        possibleSets(result, new ArrayList<>(), recentPayments, 0, transferAmount);
//        newwaypossiblesets(result, recentPayments, transferAmount);
        return result;
    }
    
    private static void possibleSets(List<List<Payment>> result, List<Payment> currentSet,
                                     List<Payment> payments, int start, long remainingQuantity) {
        if (remainingQuantity == 0) {
            result.add(new ArrayList<>(currentSet));
            return;
        }

        for (int i = start; i < payments.size(); i++) {
            Payment payment = payments.get(i);
            if (payment.getValue() > 0 && remainingQuantity >= payment.getValue() && !currentSet.contains(payment)) {
                currentSet.add(payment);
                possibleSets(result, currentSet, payments, i, remainingQuantity - payment.getValue());
                currentSet.remove(currentSet.size() - 1);
            }
        }
    }
    
    private static void newwaypossiblesets(List<List<Payment>> result, List<Payment> recentPayments, long transferAmount) {
    	int i = 0;
    	Set<List<Payment>> resultSet = new HashSet<>();
    	while (i < recentPayments.size()) {
    		List<Payment> newSet = new ArrayList<>();
    		long remainingAmount = transferAmount;
    		remainingAmount -= recentPayments.get(i).getValue();
    		newSet.add(recentPayments.get(i));
    		
    		for (int j=0; j<recentPayments.size() && remainingAmount > 0; j++) {
    			if (i!=j && remainingAmount >= recentPayments.get(j).getValue()) {
	    			remainingAmount -= recentPayments.get(j).getValue();
	        		newSet.add(recentPayments.get(j));
    			}
    		}
    		
    		if (remainingAmount == 0) {
    			resultSet.add(newSet);
    		}
    		
    		i++;
    	}
    	
    	result.addAll(resultSet);
    }
}

class SamplePaymentImpl implements Payment {
    private final String id;
    private final int value;

    SamplePaymentImpl(String id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String toString() {
        return value + "@" + id;
    }
}

public class AdyenMissingPayment {
    public static void main(String args[] ) throws Exception {
    	System.out.println("Enter the transfer Amount: ");
        Scanner scanner = new Scanner(System.in);
        long transferAmount = Long.parseLong(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<Payment> recentPayments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] payment = scanner.nextLine().split("@");
            recentPayments.add(new SamplePaymentImpl(payment[1], Integer.parseInt(payment[0])));
        }
        List<List<Payment>> result = MissingPaymentList.getPossiblePayments(transferAmount, recentPayments);
        
        // deterministic dump to System.out
        for (List<Payment> possiblePayments : result) {
            Collections.sort(possiblePayments, Comparator.comparing(Payment::getId));
        }
        Collections.sort(result, (l1, l2) -> {
            for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                int c = l1.get(i).getId().compareTo(l2.get(i).getId());
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(l1.size(), l2.size());
        });
        
        for (List<Payment> possiblePayments : result) {
            System.out.println(possiblePayments);
        }
    }
}


