package com.sumit.ds.fremont.meetup;

import java.util.HashMap;
import java.util.Map;

/**
 * Q.1 We need a functionality to block an user who makes more than 10 requests
 * in last 5 minutes. You need to implement the following function. {{ boolean
 * block_user(int user_id) { //TODO: return true in case u want to block user }
 * }}
 * 
 * https://fipg.slack.com/archives/general/p1474391241000005
 * @author sumijaiswal
 *
 */
public class RateLimiter {
	private Map<Integer, Counter> cache = new HashMap<Integer, Counter>();

	public boolean blockUser(int userId) {
		boolean result = false;
		if (cache.containsKey(userId)) {
			Counter c = cache.get(userId);
			if (diff(System.currentTimeMillis(), c.getTimestamp()) < 5) {
				if (c.count < 10) {
					c.setCount(c.count++);
					result = true;
				} else {
					result = false;
				}
			} else {
				c = new Counter(System.currentTimeMillis(), 1);
				cache.put(userId, c);
				result = true;
			}
		} else {
			Counter c = new Counter(System.currentTimeMillis(), 1);
			cache.put(userId, c);
			result = true;
		}
		return result;
	}

	private static long diff(long currentTimestamp, long startTimestamp) {
		return (currentTimestamp - startTimestamp) / 1000 * 60;
	}

	class Counter {
		private long startTimestamp;
		private int count;

		public Counter(long startTimestamp, int count) {
			this.startTimestamp = startTimestamp;
			this.count = count;
		}

		public long getTimestamp() {
			return this.startTimestamp;
		}

		public int getCount() {
			return this.count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public void setTimestamp(long timestamp) {
			this.startTimestamp = timestamp;
		}
	}
}
