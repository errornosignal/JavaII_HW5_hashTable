
/**
 * LinearProbingHashTable Class
 * @author Reid Nolan
 * @since 11/07/2017
 * @version 1.0
 */
class LinearProbingHashTable
{
    private int currentSize, maxSize;
    private String[] keys;
    private String[] values;


    /**
     * constructor
     * @param kMAX_SIZE kMAX_SIZE
     */
    public LinearProbingHashTable(int kMAX_SIZE)
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
     * @return currentSize
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
        //System.out.println("maxSize at hash = " + maxSize);
        return key.hashCode() % maxSize;
    }

    /**
     * inserts key-value pair
     * @param key key
     * @param value return
     */
    public void insert(String key, String value)
    {
        int tmp = hash(key);
        int i = tmp;
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
            i = (i + 1) % maxSize;
        } while (i != tmp);
    }

    /**
     * gets value for a given key
     * @param key key
     * @return null
     */
    public String get(String key)
    {
        int i = hash(key);
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                return values[i];
            i = (i + 1) % maxSize;
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
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = values[i] = null;

        //rehash all keys
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
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
        System.out.println("\nHash Table - " + tableName + ": ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println("[" + keys[i] +" - "+ values[i] + "]");
        System.out.println();
    }
}