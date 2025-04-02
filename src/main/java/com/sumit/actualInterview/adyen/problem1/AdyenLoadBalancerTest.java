package com.sumit.actualInterview.adyen.problem1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdyenLoadBalancerTest {

    @Test
    public void testExampleCase() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 10;
        int msSinceMidnight = 10;
        int expectedHost = 9;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }

    @Test
    public void testEdgeCaseAtMidnight() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 5;
        int msSinceMidnight = 0;
        int expectedHost = 1;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }

    @Test
    public void testEdgeCaseAtEndOfFirstCycle() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 3;
        int msSinceMidnight = 2;
        int expectedHost = 3;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }

    @Test
    public void testBackwardsDirection() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 4;
        int msSinceMidnight = 5;
        int expectedHost = 2;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }

    @Test
    public void testFullCycle() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 6;
        int msSinceMidnight = 10;  // This should be in the second half of the cycle
        int expectedHost = 1;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }

    @Test
    public void testLargeNumberOfHosts() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 1000;
        int msSinceMidnight = 999;
        int expectedHost = 1000;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }

    @Test
    public void testExactlyAtCycleBoundary() {
        AdyenLoadBalancer loadBalancer = new AdyenLoadBalancer();
        int n = 7;
        int msSinceMidnight = 6; // At the boundary of first and second direction switch
        int expectedHost = 7;
        assertEquals(expectedHost, loadBalancer.getReceivingHost(n, msSinceMidnight));
    }
}
