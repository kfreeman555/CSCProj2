
/**
 * Created by kadefreeman on 4/10/16.
 */

public interface SymbolTable<Key, Value> {

    /**
     * inserts the key-value pair (key,value) into the symbol table, overwriting
     * any previous pair of the form (key,*) if present
     * @param key the key
     */
    void put (Key key, Value value);

    /**
     * gets the Value corresponding to the Key, key
     * @param key the key
     * @returns the associated value or null if no value is associated to key
     */
    Value get(Key key);

    /**
     * determines if the symbol table contains a key-value par with Key equal
     * to key
     * @param key the key to test for
     * @returns true if such a key-value pair is present, false otherwise
     */
    boolean containsKey(Key key);
}
