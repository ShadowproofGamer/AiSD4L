public class ArrayStack<T> implements IStack<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private T array[];
    private int topIndex;
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialSize){
        array=(T[])(new Object[initialSize]);
        topIndex=0;
    }
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }
    @Override
    public boolean isEmpty() {
        return topIndex==0;}
    @Override
    public boolean isFull() {
        return topIndex==array.length;}
    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[--topIndex];}
    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException();
        array[topIndex++]=elem;}
    @Override
    public int size() {
        return topIndex;}
    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[topIndex-1];
    }
    //should never throw an exception, but it's needed for compilation
    public void reverse() throws EmptyStackException, FullStackException {
        ArrayStack<T> temp = new ArrayStack<>();
        int s = size();
        int t = size()-1;
        T elem = null;
        for (int i = 0; i < s; i++) {
            if (!isEmpty()) elem = pop();
            for (int j = 0; j < t; j++) {
                temp.push(pop());
            }
            push(elem);
            while (!temp.isEmpty()){
                push(temp.pop());
            }
            t--;
        }
    }
}
