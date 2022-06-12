import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AsciiArt {
    public static void main(String[] args) throws IOException
    {
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("EASCII characters.csv"));
            while ((line = br.readLine()) != null) {
                String[] eascii = line.split(splitBy);
                int img_width = findImageWidth(100, eascii[0], "Arial");
                PrintASCII(eascii[0], img_width, 150, "*");
                System.out.println(eascii[1]);
                System.out.println();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    static void PrintASCII(String art_text,int width, int height, String symbol)
    {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(art_text, 10, getBaselinePosition(g, font));

        for (int y=0;y<height;y++)
        {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
                sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? symbol : " ");
            }
            if (sb.toString().trim().isEmpty())
                continue;
            System.out.println(sb);
        }
    }

    private static int getBaselinePosition(Graphics g, Font font)
    {
        FontMetrics metrics = g.getFontMetrics(font);
        return metrics.getAscent() - metrics.getDescent();
    }
    private static int findImageWidth(int textHeight, String artText, String fontName)
    {
        BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.getGraphics();
        g.setFont(new Font(fontName, Font.BOLD, textHeight));
        return g.getFontMetrics().stringWidth(artText);
    }
}