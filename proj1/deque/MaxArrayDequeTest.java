package deque;
import  org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void MaxEqualTest(){
        MaxArrayDeque<Integer> test=new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i=0;i<8;i++) test.addFirst(i);
        assertTrue("Max should be 7",test.max()==7);

    }

}
