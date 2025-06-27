package com.dsa.src.dsa_sheet.linkedlists;

public class NodeRan {

    int data;
    NodeRan next;
    NodeRan random;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeRan getNext() {
        return next;
    }

    public void setNext(NodeRan next) {
        this.next = next;
    }

    public NodeRan getRandom() {
        return random;
    }

    public void setRandom(NodeRan random) {
        this.random = random;
    }

    public NodeRan(int data, NodeRan next, NodeRan random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }

    public NodeRan(int data) {
        this.data = data;
    }
}
