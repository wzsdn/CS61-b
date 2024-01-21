package deque;

public interface Deque<T> {
     int size();
     T get(int index);
     void addFirst(T item);
 void addLast(T item);
 T removeFirst();
    T removeLast();
    void printDeque();
 boolean is_Empty();
 boolean equals(Object o);

}
