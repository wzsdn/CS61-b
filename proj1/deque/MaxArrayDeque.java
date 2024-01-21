package deque;

import afu.org.checkerframework.checker.oigj.qual.O;
import net.sf.saxon.functions.Minimax;

import java.util.Comparator;

public class MaxArrayDeque <T> extends ArrayDeque<T>{
    private  Comparator<T> Cpr;
    public MaxArrayDeque(Comparator<T> c){
      Cpr=c;
    }
    public T max(Comparator<T> C){
        if(is_empty()) return null;
        int Maxidex=0;
        for(int i=1;i<size();i++){
            if(C.compare(get(i),get(Maxidex))>0)
                Maxidex=i;
        }
        return get(Maxidex);
    }
    public T max(){
        return max(Cpr);
    }
    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass()!=this.getClass()) return false;
        MaxArrayDeque<T> t=(MaxArrayDeque<T>) o;
        if(t.size()!=size()) return false;
        if(!t.max().toString().equals(max().toString()))
            return false;
        else return super.equals(o);

    }

}
