
import java.io.*;
import java.util.*;

/**
 * JavaII_HW5_hashTable
 * Main Class
 * For testing Hash Tables
 * @author Reid Nolan
 * @since 11/07/2017
 * @version 1.0
 */

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("JavaII_HW5_hashTable" + "\n");

        final int kMAX_SIZE = 100000;
        final int kTO_REMOVE = 20000;

        //create two hashTables (made a 3rd)
//        LinearProbingHashTable LinearProbingHashTable = new LinearProbingHashTable(kMAX_SIZE);
        QuadraticProbingHashTable QuadraticProbingHashTable = new QuadraticProbingHashTable(kMAX_SIZE);
        DoubleHashingTable DoubleHashingTable = new DoubleHashingTable(kMAX_SIZE);

        //create random doubles
        randomDoubleGenerator.getRandomDoubles();

        //add pre-defined amount of key/values pairs to both tables (all 3)
        for (int i = 0; i < randomDoubleGenerator.kDOUBLES_TO_GENERATE; i++)
        {
            double newRandomDouble = randomDoubleGenerator.randomDoubleList.get(i);
            String count = Integer.toString(i);

//            LinearProbingHashTable.insert(count, Double.toString(newRandomDouble));
            DoubleHashingTable.insert(i, Double.toString(newRandomDouble));
            QuadraticProbingHashTable.insert(count, Double.toString(newRandomDouble));
        }

        //remove pre-defined amount of key/values pairs from both tables (all 3)
        for (int i = 0; i < kTO_REMOVE; i++)
        {
            String count = Integer.toString(i);

//            LinearProbingHashTable.remove(count);
            DoubleHashingTable.remove(i);
            QuadraticProbingHashTable.remove(count);
        }

        //print test results for LinearProbingHashTable
//        LinearProbingHashTable.printHashTable("LinearProbingHashTable");
//        System.out.println("LinearProbingHashTable.size = " + LinearProbingHashTable.getSize());
//        System.out.println("\n");

        //print test results for DoubleHashingTable
        DoubleHashingTable.printHashTable("DoubleHashingTable");
        System.out.println("DoubleHashingTable.size = " + DoubleHashingTable.getSize());
        System.out.println("\n");

        //print test results for QuadraticProbingHashTable
        QuadraticProbingHashTable.printHashTable("QuadraticProbingHashTable");
        System.out.println("QuadraticProbingHashTable.size = " + QuadraticProbingHashTable.getSize());
        System.out.println("\n");

        File file1 = new File("DoubleHashingTable.txt");
        FileWriter fileWriter1 = new FileWriter(file1);
        BufferedWriter writer1 = new BufferedWriter(fileWriter1);
        ArrayList<String> arrayList1 = new ArrayList<>();

        File file2 = new File("QuadraticProbingHashTable.txt");
        FileWriter fileWriter2 = new FileWriter(file2);
        BufferedWriter writer2 = new BufferedWriter(fileWriter2);
        ArrayList<String> arrayList2 = new ArrayList<>();

        writer1.write("DoubleHashingTable.txt" + "\n");
        writer2.write("QuadraticProbingHashTable.txt" + "\n");

        System.out.println("DoubleHashingTable");
        for (int i = 0; i < DoubleHashingTable.getSize(); i++)
        {
            String emp1 = DoubleHashingTable.get(i);
            String s1 = "[" + i + " " + emp1 + "]";
            System.out.println("s1 = " + s1);
            arrayList1.add(s1);
            writer1.write(s1 + "\n");
        }

        System.out.println();
        System.out.println("QuadraticProbingHashTable");
        for (int i = 0; i < QuadraticProbingHashTable.getSize()-2; i++) //TODO find ArrayOutOfBounds Problem
        {
            String emp2 = QuadraticProbingHashTable.get(String.valueOf(i));
            String s2 = ("[" + i + " " + emp2 + "]");
            System.out.println("s2 = " + s2);
            arrayList2.add(s2);
            writer2.write(s2 + "\n");
        }

        writer1.flush();
        writer2.flush();
    }
}