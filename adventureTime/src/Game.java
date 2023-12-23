import locations.*;
import player.Player;

import java.util.Scanner;

public class Game {
    Scanner scanner =new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoş geldiniz");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName=scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName()+" Hoşgelniz");
        System.out.println("Tüm dünyayı kurtarmalısın");
        player.selectChar();

        while (true){
            player.printInfo();
            Location location=null;
            System.out.println();
            System.out.println("**************** Bölgeler ****************");
            System.out.println("1-Güvenli Ev -->burada düşman yoktur");
            System.out.println("2-Eşya Dükkanı -->burada alışveriş yapabilirsiniz");
            System.out.println("3-Mağara -->burada savaşarak özel ödül kazanabilirsin Karşınıza Zombi Çıkabilir");
            System.out.println("4-Orman -->burada savaşarak özel ödül kazanabilirsin Karşınıza Vampir Çıkabilir");
            System.out.println("5-Şelale -->burada savaşarak özel ödül kazanabilirsin Karşınıza Ayı Çıkabilir");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc =scanner.nextInt();
            switch (selectLoc){
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    location=new SafeHouse(player);
            }
            if (!location.onLocation()){
                System.out.println("Öldünüz ");
                break;
            }


        }


    }
}
