import java.lang.Math;

/*@12/20/2016
 @Ned Hulseman
 @Fermat's Last Theorem*/
 
 /*@description
    This program will loop through a chosen amount of numbers and find
    solutions that seemingly disprove Fermat's Last Theorem. Only they are
    just really really close solutions, but close enough to trick a basic
    calculator*/



public class FermatsLastTheorem
{
    public static void main (String[] args)
    {
        int a; /*used for the loop*/
        int b; 
        double c; 
        int n; 
        double fc = 10; /*Keeps track of the closest solution*/
        int fa = 10;
        int fb = 10;
        int fn = 3;
        double diff = 10; /*measures how close of a solution we have. Arbitrary assignment*/
        for (n = 3; n < 15; n++)
        {
            for (a = 2; a < 10000; a++)
            {
                for (b = 2; b < 10000; b++)
                {
                        c = Math.pow((Math.pow(a, n) + Math.pow(b, n)), (double)1/n);/*Solves for C for the formula*/
                        if (a != b && b!= Math.round(c) && a != Math.round(c)) /*Prevents non-interesting solutions*/
                        {
                            if (c > Math.round(c)) /*solutions for 'C' can either be slightly below or slightly above int(c)... But different math is needed*/
                            {
                                if ((c - Math.round(c)) < diff)/*Tests is we have a new nearest solution*/
                                {
                                    fc = c;/*Saves all values of the new nearest solution*/
                                    fa = a;
                                    fb = b;
                                    fn = n;
                                    diff = c - Math.round(c);
                                }                    
                            }
                            else
                            {
                                if ((Math.round(c) - c) < diff)/*Tests is we have a new nearest solution*/
                                {
                                    fc = c;
                                    fa = a;
                                    fb = b;
                                    fn = n;
                                    diff = Math.round(c) - c;
                                }                          
                            }
                        }
                    }
                }
            }
            /*Prints out the faux solution*/
            System.out.println("fac is " + fc);
            System.out.println("faa is " + fa);
            System.out.println("fab is " + fb);
            System.out.println("fan is " + fn);
        }
    }
