package locations;

import monster.Obstacle;
import player.Player;

import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();

        System.out.println("Şuan buradasınız :"+this.getName());
        System.out.println("Dikkatli ol!!! Burada "+obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor");
        System.out.print("<S>avaşmak veya <K>aç : ");
        String selenctCase = scanner.nextLine();
        selenctCase=selenctCase.toUpperCase();
        if (selenctCase.equals("S")){
            System.out.println("Savaş");
            if (combat(obsNumber)){
                System.out.println(this.getName()+" Tüm düşmanları temizlediniz.");
                return true;
            }
        }

        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz!!!!!!!!");
            System.out.println("GAME OVER!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                int whoStarts = random.nextInt(2);
                if (whoStarts == 0) { // Oyuncunun hamlesi
                    System.out.println("İlk hamleyi siz yapıyorsunuz!");
                    playerAttack();
                } else { // Canavarın hamlesi
                    System.out.println("Canavar ilk hamleyi yapıyor!");
                    obstacleAttack();
                }

                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = scanner.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    playerAttack();
                } else {
                    return false; // Kaçış seçildiyse döngüden çık
                }

                if (this.getObstacle().getHealth() > 0) { // Canavar hala hayattaysa saldırsın
                    obstacleAttack();
                }
            }

            if (this.getPlayer().getHealth() > 0) { // Oyuncu kazandıysa
                System.out.println("Düşmanı yendiniz!!");
                // ... (Ödül verme kodları)
            } else { // Canavar kazandıysa
                // ... (Ölümle ilgili kodlar)
            }
        }

        return true; // Tüm düşmanlar yenildiyse true döndür
    }

    private void playerAttack() {
        System.out.println("Siz vurdunuz!!!");
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        afterHit();
    }

    private void obstacleAttack() {
        System.out.println("Canavar size vurdu!!");
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInvertory().getArmor().getBlock();
        if (obstacleDamage < 0) {
            obstacleDamage = 0;
        }
        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
        afterHit();
    }

    public void afterHit(){
        System.out.println("Canınız : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Canı : "+this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri : ");
        System.out.println("-----------------------");
        System.out.println("Sağlık : "+this.getPlayer().getHealth());
        System.out.println("Silah : "+this.getPlayer().getInvertory().getWeapon().getName());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Zırh : "+this.getPlayer().getInvertory().getArmor().getName());
        System.out.println("Blok : "+this.getPlayer().getInvertory().getArmor().getBlock());
        System.out.println("Para : "+this.getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" Değerleri");
        System.out.println("-----------------------");
        System.out.println("Sağlık : "+ this.getObstacle().getHealth());
        System.out.println("Hasar : "+ this.getObstacle().getDamage());
        System.out.println("Sağlık : "+ this.getObstacle().getHealth());
        System.out.println("Para : "+this.getObstacle().getAward());

    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.maxObstacle)+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
