
/**
 * HashEntry Class
 * @author Reid Nolan
 * @since 11/07/2017
 * @version 1.0
 */
class HashEntry
{
    //class variables
    int key = 0;
    String value = "";

    /**
     * constructor
     * @param key key
     * @param value value
     */
    HashEntry(int key, String value)
    {
        this.key = key;
        this.value = value;
    }

    HashEntry(String inactive)
    {
        this.value = inactive;
    }
}