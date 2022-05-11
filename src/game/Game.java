package game;

import java.util.Scanner;

public class Game {
    static Scanner sc=new Scanner(System.in);
    Player player;
    Location location;
    public void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.println("Oyuna Başlamadan Önce adınızı giriniz :  ");
        //String playerName=sc.nextLine();
        player =new Player(sc.nextLine());
        player.selectCha();
        statrt();
    }

    private void statrt() {
       while (true){
           System.out.println();
           System.out.println("========================================");
           System.out.println();
           System.out.println("Eylem Gerçekleştirmek için Bir Yer seçiniz : ");
           System.out.println(" 1. Güvenli ev---> Size ait Güvenli bir Alan Düşman Yok ......");
           System.out.println(" 2. Mağara-------> Belki   karşınıza   Zombi   Çıkabilir .....");
           System.out.println(" 3. Orman -------> Belki   karşınıza   Vampir  Çıkabilir .....");
           System.out.println(" 4. Nehir -------> Belki   karşınıza   Ayı     Çıkabilir .....");
           System.out.println(" 5. Mağaza-------> Silah   veya   Zırh         alabilirsiniz..");
           int selLoc=sc.nextInt();
           while (selLoc<0||selLoc>5){
               System.out.println("Lütfen Geçerli Bir Değer Giriniz.....");
           }
           switch (selLoc){
               case 1:
                   location=new SafeHouse(player);
                   break;
               case 2:
                   location=new Cave(player);
                   break;
               case 3:
                   location =new Forest(player);
                   break;
               case 4:
                   location=new River(player);
                   break;
               case 5:
                   location=new ToolStore(player);
                   break;
               default:
                   location=new SafeHouse(player);
           }
           if(location.getClass().getName().equals("SafeHouse")){
               if(player.getIvn().isFood()&&player.getIvn().isWater()&&player.getIvn().isFirewood()){
                   System.out.println("TEBRİKLER OYUNU KAZANDINIZ");
                   break;
               }
           }
          if(!location.getLocation()){
              System.out.println("Oyun Bitti");
              break;
          }
       }
    }
}
