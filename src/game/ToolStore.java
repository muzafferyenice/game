package game;

public class ToolStore extends NormalLoc{

    ToolStore(Player player) {
        super(player, "Mağaza");
    }

    public  boolean getLocation(){
        System.out.println("Para : "+player.getMoney());
        System.out.println("1. Silahlar\n2. Zırhlar\n3. Çıkış");
        System.out.println("Seçiminiz");
        int selTool=sc.nextInt();
        int selItemID;
        switch (selTool){
            case 1:
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID=armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                break;
            default:
        }
        return true;
    }

    private void buyArmor(int itemID) {
        int avoid=0,pice=0;
        String aName=null;
        if (itemID>0||itemID<4){
            switch (itemID){
                case 1:
                    avoid=1;
                    aName="Hafif Zırh";
                    pice=15;
                    break;
                case 2:
                    avoid=3;
                    aName="Orta Zırh";
                    pice=25;
                    break;
                case 3:
                    avoid=5;
                    aName="Ağır Zırh";
                    pice=45;
                    break;
                case 4:
                    System.out.println("Çıkış Yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz İşlem....");
                    break;
            }
            if(pice>0){
                if (player.getMoney()>=pice) {
                   player.getIvn().setArmor(avoid);
                   player.getIvn().setaName(aName);
                    player.setMoney(player.getMoney()-pice);
                    System.out.println(aName+" Satın Aldınız \nEngellenen Hasar : "+player.getIvn().getArmor()+"\nYeni Hasar : "+player.getTotalDamage());
                    System.out.println(" Kalan Para : "+player.getMoney());
                }else {
                    System.out.println("Yetersiz Bakiye");
                }
            }
        }

    }

    private int armorMenu() {
        System.out.println("1. Hafif  <Para: 15 - Engelleme : 1>");
        System.out.println("2  Orta   <Para: 25 - Engelleme : 3>");
        System.out.println("3. Ağır   <Para: 45 - Engelleme : 5>");
        System.out.println("4. Çıkış");
        System.out.println("Zırh  Seçiniz");
        int selArmorID=sc.nextInt();
        return selArmorID;

    }

    private void buyWeapon(int itemID) {
        int damage=0,pice=0;
        String wName=null;
        if (itemID>0||itemID<4){
            switch (itemID){
                case 1:
                    damage=2;
                    wName="Tabanca";
                    pice=25;
                    break;
                case 2:
                    damage=3;
                    wName="Kılıç";
                    pice=35;
                    break;
                case 3:
                    damage=7 ;
                    wName="Tüfek";
                    pice=45;
                    break;
                case 4:
                    System.out.println("Çıkış Yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz İşlem....");
                    break;
            }
            if(pice>0){
            if (player.getMoney()>=pice) {
                player.getIvn().setDamage(damage);
                player.getIvn().setwName(wName);
                player.setMoney(player.getMoney()-pice);
                System.out.println(wName+" Satın Aldınız \nOnceki Hasar : "+player.getDamage()+"\nYeni Hasar : "+player.getTotalDamage());
                System.out.println(" Kalan Para : "+player.getMoney());
            }else {
                System.out.println("Yetersiz Bakiye");
            }
            }
            }
    }

    public int weaponMenu() {
        System.out.println("1. Tabanca <Para: 25 - Hasar : 2>");
        System.out.println("2  Kılıç   <Para: 35 - Hasar : 3>");
        System.out.println("3. Tüfek   <Para: 45 - Hasar : 7>");
        System.out.println("4. Çıkış");
        System.out.println("Silah Seçiniz");
        int selWeaponID=sc.nextInt();
        return selWeaponID;

    }
}
