
/**
 * QuadraticProbingHashTable Class
 * @author Reid Nolan
 * @since 11/07/2017
 * @version 1.0
 */
class QuadraticProbingHashTable
{
    private int currentSize, maxSize;
    private String[] keys;
    private String[] values;

    /**
     * constructor
     * @param kMAX_SIZE kMAX_SIZE
     */
    public QuadraticProbingHashTable(int kMAX_SIZE)
    {
        currentSize = 0;
        maxSize = kMAX_SIZE;
        keys = new String[maxSize];
        values = new String[maxSize];
    }

    /**
     * clears hash table
     */
    public void makeEmpty()
    {
        currentSize = 0;
        keys = new String[maxSize];
        values = new String[maxSize];
    }

    /**
     * gets size of hash table
     * @return return
     */
    public int getSize()
    {
        return currentSize;
    }

    /**
     * checks if hash table is full
     * @return currentSize == maxSize
     */
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    /**
     * checks if hash table is empty
     * @return getSize() == 0
     */
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /**
     * checks if hash table contains a key
     * @param key key
     * @return get(key) !=  null
     */
    public boolean contains(String key)
    {
        return get(key) !=  null;
    }

    /**
     * gets hash code of a given key
     * @param key key
     * @return key.hashCode() % maxSize
     */
    private int hash(String key)
    {
        return key.hashCode() % maxSize;
    }

    /**
     * inserts key-value pair
     * @param key key
     * @param value value
     */
    public void insert(String key, String value)
    {
        int tmp = hash(key);
        int i = tmp, h = 1;
        do
        {
            if (keys[i] == null)
            {
                keys[i] = key;
                values[i] = value;
                currentSize++;
                return;
            }
            if (keys[i].equals(key))
            {
                values[i] = value;
                return;
            }
            i = (i + h * h++) % maxSize;
        } while (i != tmp);
    }

    /**
     * gets value for a given key
     * @param key key
     * @return null
     */
    public String get(String key)
    {
        int i = hash(key), h = 1;
        while (keys[i] != null && i > 0)
        {
            if (keys[i].equals(key))
                return values[i];
            i = (i + h * h++) % maxSize;
            //System.out.println("i "+ i);
        }
        return null;
    }

    /**
     * removes key and its value
     * @param key key
     */
    public void remove(String key)
    {
        if (!contains(key))
            return;

        //find position key and delete
        int i = hash(key), h = 1;
        while (!key.equals(keys[i]))
            i = (i + h * h++) % maxSize;
        keys[i] = values[i] = null;

        //rehash all keys
        for (i = (i + h * h++) % maxSize; keys[i] != null; i = (i + h * h++) % maxSize)
        {
            String tmp1 = keys[i], tmp2 = values[i];
            keys[i] = values[i] = null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }

    /**
     * prints HashTable
     * @param tableName tableName
     */
    public void printHashTable(String tableName)
    {
        System.out.println("Hash Table - " + tableName + ": ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println("[" + keys[i] +" - "+ values[i] + "]");
        System.out.println();
    }
}