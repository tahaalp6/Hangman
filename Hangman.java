import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Taha on 30.05.2017.
 */
public class Hangman {

    public static void main(String[] args) {
        String [] words = {"ekmek","bilgisayar","kütüphane","klavye","elektrik","matematik",
        "çikolata","sandalye","basketbol","mühendis","televizyon","fotoğraf","paragraf","cetvel","oksijen",
        "internet","otomobil","vidanjör","üniforma","yastık","stadyum","müzisyen","çamaşır","örümcek",
        "uygulama","makine","menekşe","balina","harekat","hareketli","turkuaz","kırmızı","laboratuvar"};

        // içerisinden rastgele kelime seç
        String secret = words[(int) (Math.random()*words.length)];
        char[] enteredL = new char[secret.length()];
        int tries = 0;
        Scanner input = new Scanner(System.in);
        String guess = new String();
        boolean wordisguessed = false;
        StringBuilder situation = new StringBuilder();
        int guessedcnt = 0;
        List<String> guessed = new ArrayList<String>();

        for (int i=0 ; i<secret.length() ; i++)
            situation.append("_");

        while(true)
        {
            if(tries==10) {
                System.out.println("10 hakkında doldu uzgunum :(");
                break;
            }
            System.out.print("Girilen harfler : ");
            for(String g : guessed) {
                System.out.print(g + " ");
            }
            System.out.println();
            System.out.println(situation+" tahmin ?");
            guess = input.next();
            String h = guess.substring(0,1);
            guessed.add(h);

            if(guess.equals(secret)) {
                System.out.println("Tebrikler! "+tries+" deneme de kazandınız.");
                break;
            }

            char k = guess.charAt(0);
            int say=0;
            int[] yerler = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

            for(int i = 0 ; i < secret.length() ; i++) {
                if(k==secret.charAt(i)) {
                    yerler[say]=i;
                    say++;
                }
            }

            boolean geldi = false;

            for(int i = 0  ;i < yerler.length ; i++) {
                if(yerler[i]!=-1) {
                    situation.setCharAt(yerler[i], k);
                    geldi = true;
                }
            }
            if(geldi==false) tries++;
            System.out.println(10-tries+" hakkiniz kaldi..");
        }
    }


}
