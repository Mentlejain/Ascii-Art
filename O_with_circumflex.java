public class O_with_circumflex extends AsciiArt
{
    static void PrintASCII(int width, int height, String symbol)
    {
        float radius= (float) (width/2);
        double dist;
        float l=radius/2;

        for(int i=0;i<radius/2;i++)
        {
            for(int k=0;k<width/2-l-i;k++)
                System.out.print(' ');
            for (int j = 0; j <= radius; j++)
            {
                if (j== l || j == radius-l)
                    System.out.print(symbol);
                else
                    System.out.print(' ');
            }
            l--;
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i <= 2 * radius; i++)
        {
            for(int k=0;k<l-radius;k++)
                System.out.print(' ');
            for (int j = 0; j <= 2 * radius; j++)
            {
                dist = Math.sqrt((i - radius) * (i - radius) +
                        (j - radius) * (j - radius));
                if (dist > radius - 0.5 && dist < radius + 0.5)
                    System.out.print(symbol);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        PrintASCII(20,10,"*");
    }
}
