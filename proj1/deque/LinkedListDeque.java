package deque;

import net.sf.saxon.trans.SymbolicName;

import java.util.Iterator;

public class LinkedListDeque<T> implements  Iterable<T>,Deque<T>{

    private class Node{
        T value;
        Node next;
        Node Before;
        public Node(T V,Node Ne,Node Be){
            value=V;
            next=Ne;
            Before=Be;
        }
    }
    private int size;
    private Node Fsentinel;
    private Node BakFsentinel;

    private Node Esentinel;


    public LinkedListDeque(){
       Fsentinel=new Node(null,null,null);
       Esentinel=new Node(null, Fsentinel,Fsentinel);
       Fsentinel.next=Esentinel;
       Fsentinel.Before=Esentinel;
       BakFsentinel=Fsentinel;
        size=0;
    }
    public int size(){
        return size;
    }
    public void  addFirst(T item){
        Node node=new Node(item,Fsentinel.next,Fsentinel);
        Fsentinel.next.Before=node;
        Fsentinel.next=node;
        size++;
    }
    public void addLast(T item){
        Node node=new Node(item,Esentinel,Esentinel.Before);
        Esentinel.Before.next=node;
        Esentinel.Before=node;
        size++;
    }
       public boolean is_Empty() {
        return size==0;
     }
    public void printDeque(){
        Node cur=Fsentinel.next;
        while(cur!=Esentinel){
            System.out.print(cur.value+" ");
            cur=cur.next;
        }
    }
      public T removeFirst(){
        if(size==0) return (T)null;
         T re=(T)Fsentinel.next.value;
         Node temp=Fsentinel.next.next;
         temp.Before=Fsentinel;
         Fsentinel.next=temp;
         size--;
         return re;
      }

    public T removeLast(){
        if(size==0) return null;
        T re=(T)Esentinel.Before.value;
        Node temp=Esentinel.Before.Before;
        temp.next=Esentinel;
        Esentinel.Before=temp;
        size--;
        return re;
    }
    public T get(int index){
        if(index+1>size) return null;
        Node cur=Fsentinel;
        while(index>=0){
            cur=cur.next;
            index--;
        }
        return cur.value;
    }
    public T getRecursive(int index){
        if(index+1>size) return null;
        Fsentinel=Fsentinel.next;
        if(index==0){
            T ans= Fsentinel.value;
            Fsentinel=BakFsentinel;
            return ans;
        }
        index--;
        return getRecursive(index);
    }
    @Override
    public Iterator<T> iterator(){
        return  new LinkedListIterator();
    }
   private class LinkedListIterator implements Iterator<T>{
       private int pos;
        public LinkedListIterator(){
            pos=0;
        }
        @Override
      public boolean hasNext(){
          return pos<size;
      }

       @Override
       public T next() {
            int tem=pos;
            Node node= Fsentinel;
            while(tem>=0){
                node=node.next;
                tem--;
            }
            T ans=node.value;
            pos++;
            return ans;
       }
   }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        LinkedListDeque<T> x=(LinkedListDeque<T>)obj;
        if(x.size()!=this.size) return false;
       boolean ans=true;
        int n=size;
        Node cur=Fsentinel;
        Node cur1=x.Fsentinel;
        while(n>0){
            cur=cur.next;
            cur1=cur1.next;
            n--;
            if(!cur.value.toString().equals(cur1.value.toString())) ans=false;
        }
        return ans;

    }


}
