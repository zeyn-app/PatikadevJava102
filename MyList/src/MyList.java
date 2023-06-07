public class MyList<T> {

    private T[] myList;
    private int capacity;
    private int index = 0;

    public MyList() {
        capacity = Domainconstants.DEFAULTCAPACITY;
        myList = (T[]) new Object[capacity];
    }

    public MyList(int capacity) {
        setCapacity(capacity);
        myList = (T[]) new Object[capacity];
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public T[] getMyList() {
        return myList;
    }

    public int size() {
        return index;
    }

    public void add(T data) {
        if (isFull()) {
            myList = reGenerateArray();
        }

        myList[index] = data;
        index++;

    }

    private boolean isFull() {
        return capacity - 1 == index;
    }

    private int duplicateCapacity(int capacity) {
        return capacity * 2;
    }

    private T[] reGenerateArray() {
        int duplicatedCapacity = duplicateCapacity(capacity);
        T[] newMyList = (T[]) new Object[duplicatedCapacity];

        for (int i = 0; i < capacity; i++) {
            newMyList[i] = myList[i];
        }

        setCapacity(duplicatedCapacity);
        myList = newMyList;

        return myList;
    }

    private boolean isValidIndex(int index) {
        return index <= this.index;
    }

    public T get(int index) {
        if (isValidIndex(index))
            return myList[index];
        return null;
    }

    public T remove(int index) {
        if (isValidIndex(index)) {
            for (int i = index; i < this.index - 1; i++) {
                myList[i] = myList[i + 1];
            }
            T removedElement = myList[index];
            myList[this.index] = null;
            this.index--;

            return removedElement;
        }

        return null;
    }

    // burada ne döndürülebilir???
    public T set(int index, T data) {
        if (isValidIndex(index)) {
            myList[index] = data;
            return data;
        }
        return null;
    }

    @Override
    public String toString() {
        String list = "[";
        for (int i = 0; i < index; i++) {
            list += i == index - 1 ? myList[i] : myList[i] + ", ";
        }
        list += "]";

        return list;
    }

    public int indexOf(T data) {
        for (int i = 0; i < index; i++) {
            if (myList[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = index - 1; i >= 0; i--) {
            if (myList[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void clear() {
        index = 0;
        capacity = Domainconstants.DEFAULTCAPACITY;
        myList = null;
    }

    public MyList<T> subList(int start, int finish) {
        if (start >= 0 & finish < index) {
            //throw new IndexOutOfBoundsException("")
            int length = finish - start;
            MyList newList = new MyList(length);
            for (int i = 0; i < length; i++) {
                newList.myList[i] = this.getMyList()[start + i];
            }
            return newList;
        }
        return null;
    }

    public boolean contains(T data){
        for(int i=0; i<index; i++){
            if(myList[i]==data) return true;
        }
        return false;
    }
}