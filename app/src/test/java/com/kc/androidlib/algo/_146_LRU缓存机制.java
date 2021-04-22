package com.kc.androidlib.algo;

import org.junit.Test;

import java.util.LinkedHashMap;

public class _146_LRU缓存机制 {

    @Test
    public void method1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println( lruCache.get(1));

        lruCache.put(3, 3);
        System.out.println( lruCache.get(2));

        lruCache.put(4, 4);
        System.out.println( lruCache.get(1));
        System.out.println( lruCache.get(3));
        System.out.println( lruCache.get(4));
    }

    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key , int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


}
