package deque;

import afu.org.checkerframework.checker.oigj.qual.O;


import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>,Deque<T>{
    private T[] items;
    private int size;
    private int Capacity;
    private int Fpos,Epos;
    public ArrayDeque(){
        items=(T[])new Object[8];
        Capacity=8;
        size=0;
        Fpos=4;
        Epos=5;
    }

    public void addFirst(T item){
        if(size==Capacity) resize();
        items[(Fpos+Capacity)%Capacity]=item;
        Fpos--;
        size++;
    }
    public void addLast(T item){
        if(size==Capacity) resize();
        items[Epos%Capacity]=item;
        Epos++;
        size++;
    }
    private void resize(){
          T a[]=(T[])new Object[Capacity*2];
         int n=size;
         int begin=Capacity/2;

         while(n!=0){
             a[begin++]=items[(++Fpos+size)%size];
             n--;
         }
         Fpos=Capacity/2-1;
         Epos=Capacity/2+size;
         items=a;
         Capacity*=2;
    }
    public void printDeque(){
        int n=size;
       int begin=Fpos;
        while(n!=0){
            System.out.println(items[(++begin+Capacity)%Capacity]);
            n--;
        }
    }


    public boolean is_Empty() {
        return size==0;
    }

    public T removeFirst(){
        if(size==0) return null;
        T ans=items[(Fpos+1+Capacity)%Capacity];
        Fpos++;
        size--;
        return ans;
    }
    public T removeLast(){
        if(size==0) return null;
        T ans=items[(Epos-1)%Capacity];
        Epos--;
        size--;
        return ans;
    }
    public int size(){
        return size;
    }
    public boolean is_empty(){
        return size==0;
    }
    public T get(int index){
        if(index+1>size) return null;
        int begin=Fpos+index+1;
        return items[(begin+Capacity)%Capacity];
    }
    @Override
  public Iterator<T> iterator(){
  return new ArrayDequeiterator();
  }
  private class ArrayDequeiterator implements Iterator<T>{
        private int pos=0;
        @Override
        public T next(){

         int begin=Fpos+pos+1;
         pos++;
         return items[(begin+Capacity)%Capacity];

        }
        @Override
        public boolean hasNext(){
             return pos<size;
        }
  }
  @Override
  public boolean equals(Object a){
        if(a==null) return false;
        if(a==this) return true;
        if(a.getClass()!=this.getClass()) return false;
        ArrayDeque<T> X=(ArrayDeque<T>)a;
        if(size!= X.size()) return false;
        boolean equal=true;
        int n=size;
        int pos=Fpos;
        int pos1=X.Fpos;
        while(n!=0){
            if(!items[(++pos+Capacity)%Capacity].toString().equals
                    (X.items[(++pos1+X.Capacity)%X.Capacity].toString()))
                equal=false;
            n--;
        }
        return equal;

  }


}
