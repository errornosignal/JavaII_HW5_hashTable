
/**
 * DoubleHashingTable Class
 * @author Reid Nolan
 * @since 11/07/2017
 * @version 1.0
 */

class DoubleHashingTable
{
    private final static String inactive = "INACTIVE";
    private int size = 0;
    private int tableSize = 0;
    private int primeSize = 0;
    private HashEntry[] table;

    /**
     * constructor
     * @param kMAX_SIZE kMAX_SIZE
     */
    public DoubleHashingTable(int kMAX_SIZE)
    {
        size = 0;
        tableSize = kMAX_SIZE;
        table = new HashEntry[tableSize];
        for (int i = 0; i < tableSize; i++)
            table[i] = null;
        primeSize = getPrime();
    }

    /**
     * gets prime number less than table size for myHash2 function
     * @return i/3
     */
    public int getPrime()
    {
        for (int i = tableSize - 1; i >= 1; i--)
        {
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0)
                    fact++;
            if (fact == 0)
                return i;
        }
        /* Return a prime number */
        return 3;
    }

    /**
     * gets number of key-value pairs
     * @return size/size == 0
     */
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * clears hash table
     */
    public void makeEmpty()
    {
        size = 0;
        for (int i = 0; i < tableSize; i++)
            table[i] = null;
    }

    /**
     * gets value of a key
     * @param key key
     * @return table[hash1].value
     */
    public String get(int key)
    {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);

        while (table[hash1] != null && !(table[hash1].key == key))
        {
            hash1 += hash2;
            hash1 %= tableSize;
        }
        return table[hash1].value;
    }

    /**
     * inserts a key value pair
     * @param key key
     * @param value value
     */
    public void insert(int key, String value)
    {
        if (size == tableSize)
        {
            //System.out.println("Table full");
            return;
        }
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);
        while (table[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= tableSize;
        }
        table[hash1] = new HashEntry(key, value);
        size++;
    }

    /**
     * removes a key
     * @param key key
     */
    public void remove(int key)
    {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);
        while (table[hash1] != null && !(table[hash1].key == key))
        {
            hash1 += hash2;
            hash1 %= tableSize;
        }
        table[hash1] = null;
        size--;
        //table[hash1] = new HashEntry(inactive); //TODO get INACTIVE to work

    }

    /**
     * gives a hash value for a given int
     * @param number number
     * @return hashValue
     */
    private int myHash1(int number)
    {
        int hashValue = number;
        hashValue %= tableSize;
        if (hashValue < 0)
            hashValue += tableSize;
        return hashValue;
    }

    /**
     * function for double hashing
     * @param number number
     * @return primeSize - hashValue % primeSize
     */
    private int myHash2(int number)
    {
        int hashValue = number;
        hashValue %= tableSize;
        if (hashValue < 0)
            hashValue += tableSize;
        return primeSize - hashValue % primeSize;
    }

    /**
     * prints hash table
     * @param tableName tableName
     */
    public void printHashTable(String tableName)
    {
        System.out.println("Hash Table - " + tableName + ": ");
        for (int i = 0; i < tableSize; i++)
            if (table[i] != null)
                System.out.println("[" + table[i].key + " - " +table[i].value + "]");
        System.out.println();
    }

}