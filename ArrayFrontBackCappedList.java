
// Written by Frances Belleza - Project A

// STIPULATIONS:
//  - implement every method from the interface
//  - follow the API descriptions from the interface file & extra char
//  - account for special conditions such as empty lists & singletons
//  - code should NOT crash
// *CHECK SELF NOTES ON IPAD*
//          [passed] PT1
//          [passed] PT2
//          [passed] EC? YAY!
public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T>  {

    private T[] list;
    private int numberOfElements;
    private int capacity;

    public ArrayFrontBackCappedList(int capacity) {
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
        numberOfElements = 0;

    }
// PART ONE TESTERS:
//        Object[] objs = {2, 4, 6, 8, 9, null, null, null, null, null};
//        this.list = (T[]) objs;
//        this.numberOfElements = 5;

    @Override
    public String toString() {
        String s = "[";

        for(int x = 0; x < numberOfElements; x++) {
            s += list[x];
            if(x < numberOfElements-1) {
                s += ", ";
            }
        }
        s += "]";

        return "size=" + numberOfElements + "; capacity=" + capacity + ";   " + s;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfElements == list.length;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public T getEntry(int position) {
        if(position >= 0 && position <= numberOfElements) {
            return list[position];
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        for(int x = 0; x < list.length; x++) {
            list[x] = null;
        }
        numberOfElements = 0;
    }

    @Override
    public boolean addBack(T newEntry) {
        if(!isFull()) {
            list[numberOfElements] = newEntry;
            numberOfElements++;
            return true;
        } else {
            return false; // bc full
        }
    }

    // shifting right
    @Override
    public boolean addFront(T newEntry) {
        if(!isFull()) {
            for(int x = numberOfElements-1; x >= 0; x--) {
                list[x+1] = list[x];
            }
            list[0] = newEntry;
            numberOfElements++;
            return true;
        } else {
            return false;
        }
    }

    // shift left & null out last element
    @Override
    public T removeFront() {
        if(!isEmpty()) {
            T elementRemoved = list[0];
            for(int x = 1; x < numberOfElements; x++) {
                list[x-1] = list[x];
            }
            numberOfElements--;
            list[numberOfElements] = null;
            return elementRemoved;
        } else {
            return null; // empty list
        }
    }

    // size -1
    @Override
    public T removeBack() {
        if(!isEmpty())  {
            numberOfElements--;
            T elementRemoved = list[numberOfElements];
            return elementRemoved;
        } else {
            return null; // empty
        }
    }

    @Override
    public int indexOf(T anEntry) {
        for(int x = 0; x < list.length; x++) {
            if(list[x].equals(anEntry)) {
                return x;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T anEntry) {
        int indexAt = -1;

        for(int x = 0; x < numberOfElements; x++) {
            if(list[x].equals(anEntry)) {
                indexAt = x;
            }
        }

        return indexAt;
    }

    @Override
    public boolean contains(T anEntry) {
        return lastIndexOf(anEntry) >= 0;
    }


}
