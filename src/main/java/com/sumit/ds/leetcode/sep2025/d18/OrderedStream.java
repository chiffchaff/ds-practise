package com.sumit.ds.leetcode.sep2025.d18;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-an-ordered-stream/description/
 */
public class OrderedStream {
    String val[] ;
    int ptr=1;
    public OrderedStream(int n) {
        val = new String[n+1];
    }

    public List<String> insert(int idKey, String value) {
        val[idKey] = value;
        List<String> res = new ArrayList<>();
        if(idKey == ptr){
            while(ptr < val.length && val[ptr] != null){
                res.add(val[ptr]);
                ptr++;
            }
        }
        return res;
    }
}
