public class Pound extends AsciiArt
{
    static void PrintASCII(int width, int height, String symbol)
    {
        int l=width/2;
        float radius= (float) (width/16);
        double dist;
        for (int i = 0; i <= 2 * radius; i++)
        {
            for(int k=0;k<l-radius;k++)
                System.out.print(' ');
            for (int j = 0; j <= 2 * radius; j++) {
                dist = Math.sqrt((i - radius) * (i - radius) +
                        (j - radius) * (j - radius));
                if (dist > radius - 0.5 && dist < radius + 0.5)
                    System.out.print(symbol);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if((j==l) || (j==width-l) || (i == height/2 && j>l && j<(width - l)))
                    System.out.print(symbol);
                else
                    System.out.print(' ');
            }
            System.out.println();
            l--;
        }
    }
    public static void main(String args[])
    {
        PrintASCII(40,20,"*");
    }
}
