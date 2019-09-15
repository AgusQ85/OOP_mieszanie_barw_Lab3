package RGB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;

public class RGB_Kontroler {
    @FXML
    private Button button_Kolor1;
    @FXML
    private Button button_Kolor2;
    @FXML
    private Button mix;
    @FXML
    private Button button_miksuj_kolory;
    @FXML
    private TextArea txt;
    @FXML
    private ColorPicker wybierz_Kolor1;
    @FXML
    private ColorPicker wybierz_kolor2;

    private RGB_Miksuj RGB_Kontroler = new RGB_Miksuj();
    private RGB_GetSet kolor1 = new RGB_GetSet();
    private RGB_GetSet kolor2 = new RGB_GetSet();
    private RGB_GetSet kolor_mix = new RGB_GetSet();
    private int r1 = 0,r2 = 0;
    private int g1 = 0,g2 = 0;
    private int b1 = 0,b2 = 0;
    private String sColor1 = "";
    private String sColor2 = "";

    @FXML
    private void onActionCallback(ActionEvent e){
        if(e.getSource() == button_Kolor1 || e.getSource() == button_Kolor2){
            if(e.getSource() == button_Kolor1) sColor1 = wybierz_Kolor1.getValue().toString();
            else sColor1 = wybierz_kolor2.getValue().toString();
            r1 = Integer.parseInt(sColor1.substring(2,4),16);
            g1 = Integer.parseInt(sColor1.substring(4,6),16);
            b1 = Integer.parseInt(sColor1.substring(6,8),16);
            RGB_Kontroler.init(kolor1,r1,g1,b1);
            txt.setText(RGB_Kontroler.ostateczny_kolor(kolor1));
        }

        if(e.getSource() == mix){
            sColor1 = wybierz_Kolor1.getValue().toString();
            sColor2 = wybierz_kolor2.getValue().toString();
            r1 = Integer.parseInt(sColor1.substring(2,4),16);
            g1 = Integer.parseInt(sColor1.substring(4,6),16);
            b1 = Integer.parseInt(sColor1.substring(6,8),16);
            r2 = Integer.parseInt(sColor2.substring(2,4),16);
            g2 = Integer.parseInt(sColor2.substring(4,6),16);
            b2 = Integer.parseInt(sColor2.substring(6,8),16);
            RGB_Kontroler.init(kolor1,r1,g1,b1);
            RGB_Kontroler.init(kolor2,r2,g2,b2);
            RGB_Kontroler.mieszanieBarw(kolor1, kolor2, kolor_mix);
            txt.setText(RGB_Kontroler.ostateczny_kolor(kolor_mix));
            button_miksuj_kolory.setStyle(String.format("-fx-background-color: #%02X%02X%02X;", kolor_mix.getR_value(), kolor_mix.getG_value(), kolor_mix.getB_value()));
        }
    }
}
