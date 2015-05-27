
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CherylRuo
 */
public class Anagramchecker {
    
    Upload upload = new Upload();
    HashTable ht = new HashTable();
    ArrayList<String> str = upload.str();
    ArrayList<String> smallDictionary = upload.smallDictionary();

    public Anagramchecker()
    {
        for(int i=0; i<smallDictionary.size(); i++)
        {
            ht.addKey(smallDictionary.get(i));
        }
    }
           
    public ArrayList<String> makeAnagram(String word) 
    {
        ArrayList<String> result = new ArrayList<>();
        if(word.length() == 0)
        {
            result.add(word);
            return result;
        }
        else
        {
            for(int i=0; i<word.length(); i++)
            {
                String shorterstr = word.substring(0, i) + word.substring(i+1);
                ArrayList<String> shorterPermutations = makeAnagram(shorterstr);
                for(String s : shorterPermutations)
                {
                    result.add(word.charAt(i)+s);
                }
            }
        }
        return result;  
    }
    
    public void checkSpell()
    {
        for(int i=0; i<str.size(); i++)
        {
            if(ht.contains(str.get(i)))
            {
                System.out.println("\"" + str.get(i) + "\" in index " + i + " is correct spelling.");
            }
            else
            {
                System.out.println("\"" + str.get(i) + "\" in index " + i + " is incorrect spelling.");
            }
        }
    }
    
    public void checkAnagram()
    {
        for(int i=0; i<str.size(); i++)
        {
            ArrayList<String> result = makeAnagram(str.get(i));
            for (String r : result) 
            {
                if(ht.contains(str.get(i)) && !str.contains(r))
                {
                    if (ht.contains(r)) 
                    {
                        System.out.println("The word \"" +str.get(i) + "\" in index " + i + " has anagrams. Its anagram is: " + r);
                    }
                }
                else if(!ht.contains(str.get(i)) && !str.contains(r))
                {
                    if(ht.contains(r))
                    {
                        System.out.println("The string \"" +str.get(i) + "\" in index " + i + " is incorrect spelling. A correct reference is: " + r);
                    }
                }
            }
        }
    }
}
