package game;

public abstract class BattleLoc extends Location{
    protected   Obstacle obstacle;
    protected String award;
    BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle=obstacle;
        this.name=name;
        this.award=award;
    }
    public boolean getLocation(){
    int obsCount=obstacle.count();
        System.out.println("Şuan ki konumunuz : "+this.getName());
        System.out.println("Dikkat ol! Burada "+obsCount+ "  tane "+obstacle.getName()+"  yaşıyor");
        System.out.print("<S>avaş veya <K>aç");
        String selCase=sc.nextLine();
        if(selCase.equalsIgnoreCase("S")){
            if(combat(obsCount)){
                System.out.println(this.getName()+"   Lokasyonundaki  Düşman Etkisiz Kılındı");
                if(this.award.equals("Food")&&!player.getIvn().isFood()){
                    System.out.println(this.award+" Kazandınız ");
                    player.getIvn().setFood(true);
                }else if(this.award.equals("Firewood")&&!player.getIvn().isFirewood()){
                    System.out.println(this.award+" Kazandınız ");
                    player.getIvn().setFirewood(true);
                }else if(this.award.equals("Water")&&!player.getIvn().isWater()){
                    System.out.println(this.award+" Kazandınız ");
                    player.getIvn().setWater(true);
                }

                return true;
            }
            if(player.getHealtly()<=0) {
                System.out.println("Hakkın Rahmetine Kavuştun ...\n"+player.getName()+" Kardeşimizin Ruhu İçin El-Fatiha....");
                return false;
            }
        }
        return true;
    }
    public boolean combat(int obsCount){
        for (int i = 0; i < obsCount; i++) {
            int defObsHealt=obstacle.getHeald();
            playerStats();
            enemyStats();
            while (player.getHealtly()>0 && obstacle.getHeald()>0){
                System.out.print("<V>ur veya <K>aç");
                String selCase=sc.nextLine();
                System.out.println();
                //selCase=selCase.toUpperCase();
                if(selCase.equalsIgnoreCase("V")){
                    System.out.println("Çarpışma Başladı Siz Vurdunuz");
                    obstacle.setHeald(obstacle.getHeald()- getPlayer().getTotalDamage());
                    afterHit();
                    if(obstacle.getHeald()> 0){
                        System.out.println();
                        System.out.println("Canavar Karşılık Verdi");
                        player.setHealtly(player.getHealtly()-(obstacle.getDamage()-player.getIvn().getArmor()));
                        afterHit();
                    }
                }else {
                   return false;
                }
            }
            if (obstacle.getHeald()<=0 && player.getHealtly()>0){
                System.out.println("Canavarlar Öldü!!!!!......");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Güncel Paranız : "+player.getMoney());
                obstacle.setHeald(defObsHealt);
            }else {
                return false;
            }
        }
        return true;
    }
public void afterHit(){
    System.out.println("Oyuncu Canı : "+player.getHealtly());
    System.out.println();
    System.out.println(obstacle.getName()+" Canı : " +obstacle.getHeald());
    System.out.println();
}
    private void playerStats() {
        System.out.println("Oyuncu Değerleri \n--------------------");
        System.out.println("Oyun Hakkı : "+player.getHealtly());
        System.out.println("Hasar      : "+player.getTotalDamage());
        System.out.println("Para       : "+player.getMoney());
        if(player.getIvn().getDamage()>0){
            System.out.println("Silah      : "+player.getIvn().getwName());
        }if(player.getIvn().getArmor()>0){
        System.out.println("Zırh     : "+player.getIvn().getwName());
        }
    }
    public void enemyStats(){
        System.out.println("-------------------------- ");
        System.out.println(obstacle.getName()+"Değerleri--\n-----------");
        System.out.println("Can   : "+obstacle.getHeald());
        System.out.println("Hasar : "+obstacle.getDamage());
        System.out.println("Ödül  : "+obstacle.getAward());
    }
}
