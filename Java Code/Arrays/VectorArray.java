import java.util.ArrayList;

class VectorArray {

    public static void main (String[] args) {
        ResizingVector resizingVector = new ResizingVector();

        System.out.println(resizingVector.is_empty());

        // Pushing a few elements
        resizingVector.push(2);
        resizingVector.push(3);
        resizingVector.push(5);
        resizingVector.push(1);

        // Pushing an element at a particular index
        resizingVector.insert(2, 6);

        System.out.println(resizingVector.size());
        System.out.println(resizingVector.itemAt(2));

        resizingVector.prepend(5);

        System.out.println(resizingVector.pop());

        resizingVector.delete(3);
        resizingVector.remove(5);

        System.out.println(resizingVector.find(9));

    }
}

class ResizingVector {
    ArrayList<Integer> arr = new ArrayList<>();

    public ResizingVector() {
        this.arr = arr;
    }

    public int size() {
        return arr.size();
    }

    public boolean is_empty() {
        return arr.size() == 0;
    }

    public int itemAt(int ind) {
        if (ind >= 0 && ind < arr.size()) {
            return arr.get(ind);
        }
        else {
            return -1;
        }
    }

    public void push(int item) {
        arr.add(item);
    }

    public void insert (int ind, int item) {
        if (ind <= arr.size()) {
            arr.add(ind, item);
        }
    }

    public void prepend (int item) {
        arr.add(0, item);
    }

    public int pop() {
        if (arr.size() > 0) {
            int item = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            return item;
        }
        else {
            return -1;
        }
    }

    public int delete(int ind) {
        if (ind >= 0 && ind < arr.size()) {
            int item = arr.get(ind);
            arr.remove(ind);
            return item;
        }
        return -1;
    }

    public void remove(int item) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i=0;i<arr.size();i++) {
            if (arr.get(i) == item) {
                indices.add(i);
            }
        }

        for (int i=indices.size()-1;i>=0;i--) {
            arr.remove(i);
        }
    }

    public int find(int item) {
        for (int i=0;i<item;i++) {
            if (arr.get(i) == item) {
                return i;
            }
        }
        return -1;
    }
}
