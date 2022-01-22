import java.util.*;

class Problem1
{
    static String str;
    static int cash, n, a, b;
    static void swapfunc ()
    {
        char s[] = str.toCharArray ();
        int i = 0;
        for (int a = 0; a < s.length; a++)
            if (s[a] == '1')
            {
                i = a;
                break;
            }
        int j = s.length - 1;
        while (j > i)
        {
            if (cash < a)
                break;
            if (s[j] == '0')
            {
                if (s[i] == '0')
                    i++;
                else
                {
                    char temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                    cash -= a;
                    j--;
                }
            }
            else
                j--;
        }
        str = new String (s);
    }
    static void flipfunc ()
    {
        char s[] = str.toCharArray ();
        int i = 0;

        for (int a = 0; a < s.length; a++)
            if (s[a] == '1')
            {
                i = a;
                break;
            }
        while (cash >= b)
        {
            if (i == s.length)
                break;
            if (s[i] == '1')
            {
                s[i] = '0';
                i++;
                cash -= b;
            }
        }
        str = new String (s);
    }
    public static void main (String[]args)
    {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        str = sc.next ();
        cash = sc.nextInt ();
        a = sc.nextInt ();
        b = sc.nextInt ();
        if (a < b)
        {
            swapfunc ();
            flipfunc ();
        }
        else
        {
            flipfunc ();
            swapfunc ();
        }
        System.out.println (Integer.parseInt (str, 2));
    }
}
