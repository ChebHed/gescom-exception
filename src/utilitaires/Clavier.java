/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitaires;

/**
 *
 * @author alain.arsane


Saise de valeurs de type : 
	Entier, Double, Float, Long ou chaîne
	Sans message de prompt,
	Avec message de prompt.
 */
import java.io.*;
public class Clavier {
    static String s = "";
        private static String saisie() {
        try {
            BufferedReader tampon = new BufferedReader(new InputStreamReader(System.in));
            s = tampon.readLine();
        } catch (IOException ex) {
        }
        return s;
    }
    public static int saisie_int() 
    {
	s = saisie();
        return (Integer.valueOf(s).intValue());
    }
    
    public static int saisie_int(String message)
    {
	System.out.print(message);
	s = saisie();
        return (Integer.valueOf(s).intValue());
    }
	
    public static float saisie_float() 
    {
	s = saisie();
	return (Float.valueOf(s).floatValue());
    }
	
    public static float saisie_float(String message)
    {
	System.out.print(message);    
	s = saisie();
	return (Float.valueOf(s).floatValue());
    }
	
    public static long saisie_long()
    {
	s = saisie();
	return (Long.valueOf(s).longValue());
    }
		
    public static long saisie_long(String message)
    {
	System.out.print(message);  
	s = saisie();
	return (Long.valueOf(s).longValue());
    }
	
    public static double saisie_double()
    {
	s = saisie();
	return (Double.valueOf(s).doubleValue());
    }
	
    public static double saisie_double(String message)   
    {
	System.out.print(message); 
	s = saisie();
	return (Double.valueOf(s).doubleValue());
    }
	
    public static String saisie_string()
    {
	s = saisie();
	return (s);
    }
	
    public static String saisie_string(String message)
    {
	System.out.print(message);
	s = saisie();
	return (s);
    }	
}
