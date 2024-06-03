package org.example.policies;

import org.example.util.DoublyLinkedList;
import org.example.util.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LruEvictionPolicy implements EvictionPolicy{

    private  DoublyLinkedList<Integer> list;
    private Map<Integer, DoublyLinkedListNode<Integer>> map;

    public LruEvictionPolicy() {
        map = new HashMap<>();
        list = new DoublyLinkedList<>();
    }
    @Override
    public void markAccessed(int k) {
        if (!map.containsKey(k)) {
            map.put(k, new DoublyLinkedListNode<>(k));
            list.addNodeAtLast(map.get(k));
        } else {
            list.detachNode(map.get(k));
            list.addNodeAtLast(map.get(k));
        }
    }
    @Override
    public int evictKey() {
        DoublyLinkedListNode e = list.getFirstNode();
        list.detachNode(e);
        return (int) e.element;
    }
}
