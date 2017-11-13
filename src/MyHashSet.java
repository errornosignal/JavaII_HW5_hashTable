//import java.util.Map;
//
//public class HashTable<T> implements MySet<T>
//{
//
//    private Object[] table;
//
//    private int size;
//
//    private static final int DEFAULT_CAPACITY = 31;
//
//    private static final double LOAD_FACTOR = .6;
//
//    public MyHashSet(int capacity) {
//        this.table = new Object[Math.max(capacity, DEFAULT_CAPACITY)];
//        this.size = 0;
//    }
//
//    public MyHashSet() {
//        this(DEFAULT_CAPACITY);
//    }
//
//    public boolean isEmpty() {
//        return this.size == 0;
//    }
//
//    public int size() {
//        return this.size;
//    }
//
//    private int getIndex(T element) {
//        int offset = 1;
//        int currentIndex = this.mapIndex(element.hashCode());
//        while (this.table[currentIndex] != null &&
//                !this.table[currentIndex].equals(element)) {
//            currentIndex += offset;
//            offset += 2;
//            if (currentIndex >= this.table.length) {
//                currentIndex -= this.table.length;
//            } // else current index is fine doNothing();
//        }
//        return currentIndex;
//    }
//
//    private int mapIndex(int hash) {
//        int index = this.hash(hash);
//        index %= this.table.length;
//        if (index < 0) {
//            index += this.table.length;
//        } // else, the index is positive doNothing();
//        return index;
//    }
//
//    private int hash(int hashCode) {
//        int h = hashCode;
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
//
//    @Override
//    public boolean put(T element) {
//        if (element == null) {
//            throw new IllegalArgumentException("Element cannot be null");
//        } // else element is not null doNothing();
//
//        int index = this.getIndex(element);
//        if (element.equals(this.table[index])) {
//            return false;
//        } // else, not equal so it must be null! doNothing();
//
//        this.table[index] = element;
//        this.size++;
//        this.ensureCapacity();
//        return true;
//    }
//
//    private void ensureCapacity() {
//        double currentLoadFactor = (double) this.size / (double) this.table.length;
//        if (Double.compare(currentLoadFactor, LOAD_FACTOR) > 0) {
//            this.rehash();
//        } // else, the load factor is fine doNothing();
//    }
//
//    @SuppressWarnings("unchecked")
//    private void rehash() {
//        Object[] oldTable = this.table;
//        this.table = new Object[(this.table.length * 3) / 2 + 1];
//        this.size = 0;
//        for (Object object : oldTable) {
//            // We know this will not fail as the only items added to the table
//            // are added with the put method which takes an object of type T.
//            // objects are not added to this table in any other manner. This
//            // case to type T will always be safe.
//            if (object != null) this.put((T) object);
//            // else object is null, doNothing();
//        }
//    }
//
//    @Override
//    public boolean contains(T element) {
//        int currentPosition = this.getIndex(element);
//        return this.table[currentPosition] != null &&
//                this.table[currentPosition].equals(element);
//    }
//}
