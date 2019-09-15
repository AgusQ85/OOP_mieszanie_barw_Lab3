package RGB;


public class RGB_Miksuj {

    public void init(RGB_GetSet rgb, int r, int g, int b){

        if((r >= 0 && g >= 0 && b >= 0) && (r <= 255 && g <= 255 && b <= 255))
        {
            rgb.setR_value(r);
            rgb.setG_value(g);
            rgb.setB_value(b);
        }
    }

    public String ostateczny_kolor(RGB_GetSet rgb){
        return String.format("[%d,%d,%d]",rgb.getR_value(),rgb.getG_value(),rgb.getB_value());
    }

    public void mieszanieBarw (RGB_GetSet colorOne, RGB_GetSet colorTwo, RGB_GetSet mixedColor){
        mixedColor.setR_value((colorOne.getR_value() + colorTwo.getR_value())/2);
        mixedColor.setG_value((colorOne.getG_value() + colorTwo.getG_value())/2);
        mixedColor.setB_value((colorOne.getB_value() + colorTwo.getB_value())/2);
    }
}
