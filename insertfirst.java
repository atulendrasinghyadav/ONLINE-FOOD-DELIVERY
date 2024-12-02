import java.util.*;
class Linkedlist{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    public void addlast(int data){
        Node New = new Node(data);
        if (head == null) {
            head = New;
        }
        else{
            New.next = head;
            head = New;
        }
    }
    public void display(){
        if(head == null){
            System.out.println("Empty");
        }
        else{
            Node temp = head;
            while (temp.next!=null) { 
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
}
public class insertfirst {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Linkedlist l2 = new Linkedlist();
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the data: ");
            int data = sc.nextInt();
            l2.addlast(data);
        }
        l2.display();
    }
}