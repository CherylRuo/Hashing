
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CherylRuo
 */
public class HashTable {
    
    private final ArrayList<LinkedList<String>> hashtable = new ArrayList<>();

    public HashTable()
    {
        for(int i=0; i<5003; i++)
        {
            LinkedList<String> buckets = new LinkedList<>();
            hashtable.add(buckets);
        }
    }
      
    public boolean contains(String value) 
    {
        int key=7;
        for (int i=0; i < value.length(); i++) 
        {
            key = (key * 31 + value.charAt(i)) % 5003;
        }
        
        return hashtable.get(key).contains(value);
    }
    
    public void addKey(String value)
    {
        int key=7;
        for (int i=0; i < value.length(); i++) 
        {
            key = (key * 31 + value.charAt(i)) % 5003;
        }
        if(!this.contains(value))
        {
            hashtable.get(key).add(value);
        }
    }
}