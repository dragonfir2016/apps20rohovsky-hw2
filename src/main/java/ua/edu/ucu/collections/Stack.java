package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst;

    Stack(){
        this.lst = new ImmutableLinkedList();
    }
    public Object peek(){
        return lst.getLast();
    }

    public Object pop(){
        Object el = lst.getLast();
        this.lst = this.lst.removeLast();
        return el;
    }

    public void push(Object e){
        this.lst = this.lst.addLast(e);
    }
}
