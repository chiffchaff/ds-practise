package com.sumit.ds.realinterviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Fraudster cache
ABC Company's fraud team has identified that fraudsters often try multiple
card numbers in short periods of time. Therefore - it's useful to keep a
small list of shoppers in memory - the ones that most recently
attempted fraud or were marked as fraudulent. Given that fraud
detection happens before payment authorizations - the cache is
expected to perform very well.
Given a maximum capacity - return an implementation of a fraudster
cache.
Sample test case:
On a fraudster cache with a capacity of 2, we do the following
6 operations:
1) Mark the shopper with attributes (shopper 1, 205.13.50.50,
fraud@gmail.com) as fraudulent
The cache now contains shopper1
2) Mark the shopper with attributes (shopper2, 201.16.13.55,
fraud@yahoo.com) as fraudulent
The cache now contains shopper1 and shopper2
3) Shopper shopper1 attempts to pay, we get them from the cache and
return their details.
The fraud attempt for shopper1 is reflected in the cache
4) Mark the shopper with attributes (shopper3, 202.56.0.17,
fraud@example.com) as fraudulent
shopper3 should be added to the cache, but we're at capacity, so we
need to remove 1 of the 2 shoppers from the cache.
We remove shopper2 - even though shopper1 was marked as fraud
first - they recently attempted fraud.
The cache now contains shopper1 and shopper3
5) Get shopper shopper1
Return the shopper attributes (shopper1, 205.13.50.50,
fraud@gmail.com)
6) Get shopper shopper2
This shopper was removed from the cache to make room for shopper3,
we no longer have their details in memory so we return null
 */

interface Shopper {
	String getUuid();
	String getIP();
	String getEmail();
}

class ShopperNode {
	Shopper shopper;
	public ShopperNode next;
	public ShopperNode prev;

	public ShopperNode() {
	}

	public ShopperNode(Shopper shopper) {
		this.shopper = shopper;
		next = null;
		prev = null;
	}

	public Shopper getShopper() {
		return shopper;
	}
}

class FraudsterCache {
	private Map<String, ShopperNode> map;
	private ShopperNode head;
	private ShopperNode tail;
	private int size;

	public FraudsterCache(int capacity) {
		size = capacity;
		map = new HashMap<>();
		head = new ShopperNode();
		tail = new ShopperNode();
		head.next = tail;
		tail.prev = head;
	}

	private void deleteNode(ShopperNode p) {
		ShopperNode pre = p.prev;
		ShopperNode nex = p.next;
		pre.next = nex;
		nex.prev = pre;
	}

	private void addNode(ShopperNode newnode) {
		ShopperNode temp = head.next;
		head.next = newnode;
		newnode.prev = head;
		newnode.next = temp;
		temp.prev = newnode;
	}

	public Shopper getFraudster(String uuid) {
		if (!map.containsKey(uuid)) {
			return null;
		}

		ShopperNode p = map.get(uuid);
		deleteNode(p);
		addNode(p);
		map.put(uuid, head.next);
		return p.getShopper();
	}

	public void markFraud(Shopper shopper) {
		if (map.containsKey(shopper.getUuid())) {
			ShopperNode c = map.get(shopper.getUuid());
			deleteNode(c);
			c.shopper = shopper;
			addNode(c);
			map.put(shopper.getUuid(), head.next);
		} else {
			if (map.size() == size) {
				ShopperNode prev = tail.prev;
				deleteNode(prev);
				ShopperNode l = new ShopperNode(shopper);
				addNode(l);
				map.remove(prev.getShopper().getUuid());
				map.put(shopper.getUuid(), head.next);
			} else {
				ShopperNode l = new ShopperNode(shopper);
				addNode(l);
				map.put(shopper.getUuid(), head.next);
			}
		}
	}
}

class SampleShopperImpl implements Shopper {
	private String uuid;
	private String ip;
	private String email;

	public SampleShopperImpl(String uuid, String ip, String email) {
		this.uuid = uuid;
		this.ip = ip;
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public String getIP() {
		return ip;
	}

	public String getEmail() {
		return email;
	}

	public String toString() {
		return uuid + "," + ip + "," + email;
	}
}

public class AdyenFraudsterLRUCache {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int capacity = Integer.parseInt(scanner.nextLine());
		FraudsterCache cache = new FraudsterCache(capacity);
		int opCount = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < opCount; i++) {
			String[] line = scanner.nextLine().split(":");
			String op = line[0];
			if ("markFraud".equals(op)) {
				String[] shopper = line[1].split(",");
				cache.markFraud(new SampleShopperImpl(shopper[0], shopper[1], shopper[2]));
			} else if ("getFraudster".equals(op)) {
				System.out.println(cache.getFraudster(line[1]));
			}
		}
	}
}
