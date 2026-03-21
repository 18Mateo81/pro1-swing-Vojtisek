package pro1.utils;

import java.util.Random;

public class ColorUtils {
    static Random random = new Random();

    public static String randomColor(){
        String r = String.format("%02X",random.nextInt(256));
        String g = String.format("%02X",random.nextInt(256));
        String b = String.format("%02X",random.nextInt(256));
        return "#"+r+g+b;
    }

    public static String color(int rValue, int gValue, int bValue){
        String r = String.format("%02X",rValue);
        String g = String.format("%02X",gValue);
        String b = String.format("%02X",bValue);
        return "#"+r+g+b;
    }
    public static String getColorForPosition(int x, int y, int width, int height) {
        float redFactor = (float) x / width;
        float greenFactor = (float) y / height;

        int r = (int) (redFactor * 255);
        int g = (int) (greenFactor * 255);
        int b = 0;
        return color(r, g, b);
    }
}
