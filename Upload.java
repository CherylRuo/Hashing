
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CherylRuo
 */
public class Upload {
        
    public ArrayList<String> str()
    {
        ArrayList<String> words = new ArrayList<>();
        Scanner sc;
        File file = new File("src/input.txt");
        PrintStream out = null;
        try 
        {
            out = new PrintStream(new FileOutputStream("output.txt"));
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.setOut(out);
        try 
        {
            sc = new Scanner(file);

            while(sc.hasNextLine())
            {
                String piece = sc.nextLine();
                words.add(piece.toLowerCase());
            }
            sc.close();
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
        return words;
    }
    public ArrayList<String> smallDictionary()
    {
        ArrayList<String> smallDictionary = new ArrayList<>();
        Scanner sc;
        File file = new File("src/Small-dictionary25K.txt");
        try 
        {
            sc = new Scanner(file);
            
            while(sc.hasNextLine())
            {
                String piece = sc.nextLine();
                smallDictionary.add(piece.toLowerCase());
            }
            sc.close();
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
        return smallDictionary;
    }
}
