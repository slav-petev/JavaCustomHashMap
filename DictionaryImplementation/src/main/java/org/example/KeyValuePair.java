package org.example;

public class KeyValuePair<K, V> {
    final K key;
    V value;
    KeyValuePair<K, V> next;

    public KeyValuePair(K key, V value, KeyValuePair<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
