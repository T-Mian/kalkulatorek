package Controlerr;
/*
Calkulator  Tomasz Mianecki (zamiana button na image i zabawa tym)
 */


// import sektor
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;


// klasa główna
public class MainControl {


    private  double num;
    private int calkulate ;

    // obiekty z pliku fxml
    @FXML
    public ImageView img_btn_kropka;
    @FXML
    public ImageView img_c;
    @FXML
    public ImageView imBtn_1;
    @FXML
    public ImageView imBtn_2;
    @FXML
    public ImageView imBtn_3;
    @FXML
    public ImageView imBtn_4;
    @FXML
    public ImageView imBtn_5;
    @FXML
    public ImageView imBtn_6;
    @FXML
    public ImageView imBtn_7;
    @FXML
    public ImageView imBtn_8;
    @FXML
    public ImageView imBtn_9;
    @FXML
    public ImageView imBtn_0;
    @FXML
    public ImageView imBtn_rowna;
    @FXML
    public ImageView imBtn_odjac;
    @FXML
    public ImageView imBtn_plus;
    @FXML
    public ImageView imBtn_mnoz;
    @FXML
    public ImageView imBtn_dziel;

    @FXML
    public Label slowoLabel;
    @FXML
    public Label wynikLabel;
    @FXML
    public Label powyzejLabel;


    // kontrola dla efektów (połączenie z metodą efekty_specjalne  linijka 191)
    private boolean efekt = true;

    // sektor funkcji numerycznej (dodawanie do Labeli od lini 70 do 123)
    // efekty_specjalne 191 linijka a metoda_na.... 214 linijka
    @FXML
    public void onClik_1() {
        metoda_na_Cliki_numeryczne("1", "Jeden", imBtn_1);
    }

    @FXML
    public void onClik_2() {
        metoda_na_Cliki_numeryczne("2", "Dwa", imBtn_2);
    }

    @FXML
    public void onClik_3() {
        metoda_na_Cliki_numeryczne("3", "Trzy", imBtn_3);
    }

    @FXML
    public void onClik_4() {
        metoda_na_Cliki_numeryczne("4", "Cztery", imBtn_4);
    }

    @FXML
    public void onClik_5() {
        metoda_na_Cliki_numeryczne("5", "Pięć", imBtn_5);
    }

    @FXML
    public void onClik_6() {
        metoda_na_Cliki_numeryczne("6", "Sześć", imBtn_6);
    }

    @FXML
    public void onClik_7() {
        metoda_na_Cliki_numeryczne("7", "Siedem", imBtn_7);
    }

    @FXML
    public void onClik_8() {
        metoda_na_Cliki_numeryczne("8", "Osiem", imBtn_8);
    }

    @FXML
    public void onClik_9() {
        metoda_na_Cliki_numeryczne("9", "Dziewięć", imBtn_9);
    }


    public void onClik_0() {
        metoda_na_Cliki_numeryczne("0", "Zero", imBtn_0);
    }

    @FXML
    public void onClik_kropka() {
        metoda_na_Cliki_numeryczne(".", "Kropka", img_btn_kropka);
    }
    // metody na działania matematyczne od 125 linijki do 159
    @FXML
    public void onClik_Wynik() {
        matematyka(); // metoda linijka 162 (metoda do liczenia)
        efekty_specjalne(imBtn_rowna);
  }

    @FXML
    public void onClik_Dodawanie() {
        calkulate = 1; // do Swicha
        przygotowanie_labeli_i_swicha("+",imBtn_plus,"Dodawanie");
    }

    @FXML
    public void onClik_Odejmowanie() {
        calkulate = 2;// do Swicha
        przygotowanie_labeli_i_swicha("-",imBtn_odjac,"Odejmowanie");
    }

    @FXML
    public void onClik_mnozenie() {
        calkulate = 3;// do Swicha
        przygotowanie_labeli_i_swicha("*",imBtn_mnoz,"Mnożenie");
    }
    @FXML
    public void onClik_dzielenie() {
        calkulate = 4;// do Swicha
       przygotowanie_labeli_i_swicha("/",imBtn_dziel,"Dzielenie");
    }
    @FXML
    public void onCleer() {
        wynikLabel.setText("");
        powyzejLabel.setText("");
        slowoLabel.setText("Kasacja Danych");
        efekty_specjalne(img_c);
    }

    // metoda obliczeniowa ze Switch i z intem calkulate
    private  void  matematyka(){
        switch (calkulate){
            case 1 : //dodawanie
                double asn = num + Double.parseDouble(wynikLabel.getText()); // zapisuje ans jako doble i zparsuwuje info z wyniku
                wynikLabel.setText(Double.toString(asn));


                break;
            case 2 :// odejmowanie
                asn = num - Double.parseDouble(wynikLabel.getText());
                wynikLabel.setText(Double.toString(asn));

                break;
            case 3 : // mnozenie
                asn = num * Double.parseDouble(wynikLabel.getText());
                wynikLabel.setText(Double.toString(asn));

                break;
            case 4 : // dzielenie
                asn = num / Double.parseDouble(wynikLabel.getText());
                wynikLabel.setText(Double.toString(asn));

                break;


        }
    }

// ot aby się cos działo (jedna pętla )
    private void efekty_specjalne(ImageView imageView) {
    // wykozystuje boolean do sprawdzania czy "zacieniowac czy nie"
        if (efekt){
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(5.5);
            dropShadow.setHeight(20.3);
            dropShadow.setWidth(20.3);
            imageView.setEffect(dropShadow);

        }else {
            imageView.setEffect(null);
        }
        efekt= !efekt; // jakby nie było zmienic wartość na przeciwną
    }
    // wyciąga potrzebnego numa z stringa zeruje labelke i wpisuje num do wyższej labelki ze znakiem , dodaje opis
    private void przygotowanie_labeli_i_swicha(String znak,ImageView image,String opis) {
        num=Double.parseDouble(wynikLabel.getText()); // wyciąga doubla z labelki i konwertuje
        wynikLabel.setText("");// pucowanko Labelki
        powyzejLabel.setText(num + znak);// zapis na nową labelke z znakiem operacji
        slowoLabel.setText(opis);// opis
        efekty_specjalne(image);// efekty specjalne
    }
// wrzut do labelek i plus efekty
    private void metoda_na_Cliki_numeryczne(String licz, String opis, ImageView obraz) {
        wynikLabel.setText(wynikLabel.getText()+licz);
        slowoLabel.setText(opis);
        efekty_specjalne(obraz);
    }
}


