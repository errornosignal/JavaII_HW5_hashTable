import java.util.*;

/**
 * JavaII_HW5_hashTable
 * Main Class
 * Class for testing contains() and removes() methods on an array-based binary search tree
 * @author Reid Nolan
 * @since 11/05/2017
 * @version 1.0
 *
 */
//public class Main
//{
//    /**
//     *
//     * @param args args
//     */
//    public static void main(String[] args)
//    {
//        System.out.println("JavaII_HW5_hashTable" + "\n");
//
//        final int kTO_REMOVE = 20000;
//
//        //add values to HashSet
//        Hashtable<Integer, Double> doubleSet = new Hashtable<>();
//
//        //create random doubles
//        randomDoubleGenerator.getRandomDoubles();
//
//        //add pre-defined amount of key/values pairs to table
//        for(int i = 0; i < randomDoubleGenerator.kDOUBLES_TO_GENERATE; i++)
//        {
//            doubleSet.put(i, randomDoubleGenerator.randomDoubleList.get(i));
//        }
//
//        //remove pre-defined amount of key/values pairs from table
//        for (int i = kTO_REMOVE; i >= 0; i--)
//        {
//            doubleSet.remove(i);
//        }
//
//        //print key/value pairs to console
//        for(Map.Entry<Integer, Double> entry : doubleSet.entrySet())
//        {
//            Integer key = entry.getKey();
//            Double value = entry.getValue();
//            System.out.println("[" + key + " = " + value + "]");
//        }
//
//
//        //randomDoubleGenerator.getRandomDoubles();
//
//
////        //remove values from HashSet
////        for(int i = 0; i < 20000; i++)
////        {
////
////        }
//
//
//
//
////        final int kTO_GENERATE = 999999;
////        final int kTO_ADD = 100000;
////
////        ArrayList<Integer> integerList = new ArrayList<>();
////
////        for (int i = kTO_GENERATE; i > 0; i--)
////        {
////            integerList.add(i);
////        }
////
////        Collections.shuffle(integerList);
////
////        for (int i = 0; i < kTO_ADD; i++)
////        {
////            double randomNumber = Math.random() + integerList.get(i);
////            System.out.println(randomNumber);
////        }
//
//
////        //add 1st few values to binarySearchTree
////        BST<Integer> bst = new BST<>();
////        for(int i = 0; i < kTO_ADD; i++)
////        {
////            bst.insert(numberList.get(i));
////        }
//
////        //test contains method
////        System.out.println("Tree contains 5: " + bst.contains(5));
////        System.out.println("Tree contains 90000: " + bst.contains(90000));
////        System.out.println();
////
////        //test remove method
////        System.out.println("Running remove method...");
////        bst.remove(5);
////
////        //verify remove method works and contains reports accurately
////        System.out.println();
////        System.out.println("Tree contains 5: " + bst.contains(5));
////        System.out.println("Tree contains 90000: " + bst.contains(90000));
//        }
//}

////////////////////////////////////////////////////////////////////////////////////////////////
//public class Main
//{
//    public static void main(String[] args)
//    {
//        System.out.println("JavaII_HW5_hashTable" + "\n");
//
//        final int kTO_REMOVE = 20000;
//
//        //add values to HashSet
//        HashTable<Integer, Double> doubleSet = new HashTable<>();
//
//        //create random doubles
//        RandomDoubleGenerator.getRandomDoubles();
//
//        //add pre-defined amount of key/values pairs to table
//        for (int i = 0; i < RandomDoubleGenerator.kDOUBLES_TO_GENERATE; i++)
//        {
//            doubleSet.put(i, RandomDoubleGenerator.randomDoubleList.get(i));
//        }
//
//        HashTable.dump();

/////////////////////////////////////////////////////////////////////////////////////////////////
//        Enumeration names;
//        names = doubleSet.keys();
//
//        while (names.hasMoreElements())
//        {
//            Integer key = (Integer) names.nextElement();
//            System.out.println("[" + key + " / " + doubleSet.get(key));
//        }


//        //remove pre-defined amount of key/values pairs from table
//        for (int i = kTO_REMOVE; i >= 0; i--)
//        {
//            doubleSet.remove(i);
//        }


//        double myDouble = Double.parseDouble(input);
//
//
//        }
//
//        System.out.println(doubleSet);
//
//            System.out.println(doubleSet);


//        MySet<Double> set = new MyHashSet<>();
//
//        set.put(1.5);
//        set.put(4.6);
//        set.put(1.5);
//        set.put(6.7);
//
//        System.out.println(set.contains(6.7));
//        System.out.println(set.contains(8.0));
//        System.out.println("");
//
//        MySet<String> stringSet = new MyHashSet<>();
//
//        stringSet.put("pollinating sandboxes");
//        stringSet.put("schoolworks = perversive");
//        stringSet.put("Microcomputers: the unredeemed lollipop...");
//
//        System.out.println(stringSet.contains("Microcomputers: the unredeemed lollipop..."));
//        System.out.println("");

//    }
//}