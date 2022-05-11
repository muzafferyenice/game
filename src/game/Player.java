package game;

import java.util.Scanner;

public class Player {
    static Scanner sc=new Scanner(System.in);
    private int damage,healtly,money,rHeatly;
    private String name,cName;
    Inventory ivn;

    public Player(String name) {
        this.name = name;
        this.ivn=new Inventory();
    }
    public void selectCha(){
        //System.out.println(chaMenu());
        switch (chaMenu()){
            case 1:
                initPlayer("Samuray",5,21,15);
                break;
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
            case 3:
                initPlayer("Sovalye",8,24,5);

                break;
            default:
                initPlayer("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakter : "+getcName()+"\tHasar : "+getDamage()+"\tSağlık : "+getHealtly()+"Para : "+getMoney() );

}

    private int chaMenu() {
        System.out.println("Lütfen Karakter seçiniz ....");
        System.out.println("1-Samuray  \tHasar : 5 \tSağlık : 21 \t Para 15");
        System.out.println("2-Okçu     \tHasar : 7 \tSağlık : 18 \t Para 20");
        System.out.println("3-Sovalye  \tHasar : 8 \tSağlık : 24 \t Para 5");
        System.out.println("Seçiminiz,,,,,,");
        int chaID=sc.nextInt();
        while (chaID<1||chaID>3){
            System.out.println("lütfen geçerli Bir ID giriniz");
            chaID=sc.nextInt();
        }return chaID;
    }
     public void initPlayer(String cName, int dmg,int hlty,int mny){
         setcName(cName);
         setDamage(dmg);
         setHealtly(hlty);
         setMoney(mny);
         setrHeatly(hlty);
     }
     public int getTotalDamage(){
        return this.getDamage()+this.getIvn().getDamage();
     }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealtly() {
        return healtly;
    }

    public void setHealtly(int healtly) {
        this.healtly = healtly;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getIvn() {
        return ivn;
    }

    public void setIvn(Inventory ivn) {
        this.ivn = ivn;
    }

    public int getrHeatly() {
        return rHeatly;
    }

    public void setrHeatly(int rHeatly) {
        this.rHeatly = rHeatly;
    }

    //nasıl olacak
}
