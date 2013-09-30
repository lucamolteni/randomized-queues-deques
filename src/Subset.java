public class Subset {
    public static void main(String[] args) {
        final int numElem = Integer.parseInt(args[0]);
        final RandomizedQueue<String> elems = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            elems.enqueue(item);
        }
        for (int i = 0; i < numElem; i++) {
            System.out.println(elems.dequeue());
        }
    }
}
