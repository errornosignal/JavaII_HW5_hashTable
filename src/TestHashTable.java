/*
      A little program to test the HashTable class.  Note that I
      start with a really small table so that I can easily test
      the resize() method.
   */

public class TestHashTable {

    public static void main(String[] args){

        System.out.println("JavaII_HW5_hashTable" + "\n");

        HashTable<Integer, Double> table = new HashTable<>();
        Integer key;
        Double value;

        RandomDoubleGenerator.getRandomDoubles();

        //table.put(0,1.01);

        //add pre-defined amount of key/values pairs to table
//        for (int i = 0; i < RandomDoubleGenerator.kDOUBLES_TO_GENERATE; i++)
//        {
//            table.put(i, RandomDoubleGenerator.randomDoubleList.get(i));
//        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("   1. test put(key,value)");
            System.out.println("   2. test get(key)");
            System.out.println("   3. test containsKey(key)");
            System.out.println("   4. test remove(key)");
            System.out.println("   5. show complete contents of hash table.");
            System.out.println("   6. EXIT");
            //System.out.print("Enter your command:  ");
            switch ( Validator.getInt("Enter your command:  ")) {
                case 1:
                    //System.out.print("\n   Key = ");
                    key = Validator.getInt("\n   Key = ");
                    //System.out.print("   Value = ");
                    value = Validator.getDouble("   Value = ");
                    table.put(key, value);
                    break;
                case 2:
                    //System.out.print("\n   Key = ");
                    key = Validator.getInt("\n   Key = ");
                    System.out.println("   Value = " + table.get(key));
                    break;
                case 3:
                    //System.out.print("\n   Key = ");
                    key = Validator.getInt("\n   Key = ");
                    System.out.println("   containsKey[" + key + "] is "
                            + table.containsKey(key));
                    break;
                case 4:
                    //System.out.print("\n   Key = ");
                    key = Validator.getInt("\n   Key = ");
                    table.remove(key);
                    break;
                case 5:
                    table.dump();
                    break;
                case 6:
                    return;  // End program by returning from main()
                default:
                    System.out.println("   Illegal command.");
                    break;
            }
            System.out.println("\nHash table size is " + table.size());
        }
    }

} // end class TestHashTable
