//: net/mindview/util/Pair.java
package com.rxx.thinkinjava.concurrency.util;

public class Pair<K,V> {
  public final K key;
  public final V value;
  public Pair(K k, V v) {
    key = k;
    value = v;
  }
} ///:~
