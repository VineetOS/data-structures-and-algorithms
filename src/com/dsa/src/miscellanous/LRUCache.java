package com.dsa.src.miscellanous;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        else{
            Node currNode = map.get(key);
            // Move the accessed node to the front of the list
            moveNodeToFront(currNode);
            return currNode.value;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            currNode.value = value;
            // Move the updated node to the front of the list
            moveNodeToFront(currNode);
        }else{
            if(map.size()==this.capacity){
                // Remove the least recently used node
                Node removedNode = removeLastNode();
                map.remove(removedNode.key);
            }
            Node newNode = new Node(key, value);
            // Add the new node to the front of the list
            addNodeToFront(newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeLastNode(){
        Node removedNode = tail.prev;
        removeNode(removedNode);
        return removedNode;
    }

    private void addNodeToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }

    private void moveNodeToFront(Node node) {
        removeNode(node);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}



