package com.example.linkedlist;;

public class LinkedList {

    public static Node head;

    public static class Node{

        String puppies;
        Node next;

        Node(String pup){
            puppies = pup;
            next = null;
        }
    }

    Node reverse(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    void printList(Node node){
        while(node != null){
            System.out.print(node.puppies + " => ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.head = new Node("Corgi");
        list.head.next = new Node("French Bulldog");
        list.head.next.next = new Node ("Dachshund");
        list.head.next.next.next = new Node ("Boxer");
        list.head.next.next.next.next = new Node ("Siberian Husky");
        list.head.next.next.next.next.next = new Node ("Australian Shepherd");
        list.head.next.next.next.next.next.next = new Node ("Shih Tzu");
        list.head.next.next.next.next.next.next.next = new Node ("Akita");
        list.head.next.next.next.next.next.next.next.next = new Node ("St. Bernard");
        list.head.next.next.next.next.next.next.next.next.next = new Node ("Maltese");
        list.head.next.next.next.next.next.next.next.next.next.next = new Node ("Greyhound");


        System.out.println("Given Linked List: ");
        list.printList(head);
        head = list.reverse(head);
        System.out.println(" ");
        System.out.println("Reversed Linked List: ");
        list.printList(head);
    }
}
