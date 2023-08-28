public class IntegerArray {
    private Integer[] a;
    public IntegerArray(int size){
        a=new Integer[size];
    }
    public void setElement(int index,Integer element){
        if(index>=0&& index<a.length)
            a[index]=element;
        else
            throw new RuntimeException("Array index is out of Bounds");
    }
    public Integer getElement(int index){
        if(index>=0&& index<a.length)
            return a[index];
        else
            throw new RuntimeException("Array index is out of Bounds");
    }

    private class IntegerArrayIterator{
        private int index =-1;
        public boolean hasNext(){
            return index<a.length;
        }
        public Integer next(){
            if(index==a.length) throw new RuntimeException("Array index is out of Bounds");
            return a[++index];
        }
    }
    public IntegerArrayIterator getIterator(){
        return new IntegerArrayIterator();
    }
}
