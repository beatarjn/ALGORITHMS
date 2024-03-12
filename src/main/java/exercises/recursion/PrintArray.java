package exercises.recursion;

public class PrintArray {

//    Print all elements from an array of ints of length 50 with random values.

    public static void main(String[] args) {
        print(new int[]{2, 6, 4, 87, 746, 46}, 0);
    }

    static void print(int[] array, int index) {
        int length = array.length;
        if (index == length) {
            return;
        }
        System.out.println(array[index]);
        print(array, index + 1);
    }

}
