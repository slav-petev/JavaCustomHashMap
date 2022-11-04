package org.example;

public class Dictionary<K, V> {
    private static final int INITIAL_CAPACITY = 1 << 4;

    private KeyValuePair<K, V>[] buckets;
    private int size = 0;

    public Dictionary() {
        this(INITIAL_CAPACITY);
    }

    public Dictionary(int capacity) {
        this.buckets = new KeyValuePair[capacity];
    }

    public void put(K key, V value) {
        KeyValuePair<K, V> entry = new KeyValuePair<>(key, value, null);

        int bucketIndex = key.hashCode() % this.buckets.length;
        KeyValuePair<K, V> existing = this.buckets[bucketIndex];
        if (existing == null) {
            this.buckets[bucketIndex] = entry;
            this.size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;

                    return;
                }

                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                this.size++;
            }
        }
    }

    public V get(K key) {
        int bucketIndex = key.hashCode() % this.buckets.length;
        KeyValuePair<K, V> bucket = this.buckets[bucketIndex];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }

            bucket = bucket.next;
        }

        return null;
    }
}
