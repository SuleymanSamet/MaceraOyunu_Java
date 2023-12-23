package locations;

import items.Armor;
import items.Weapon;
import player.Player;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------- Mağazaya hoş geldiniz ! ---------");
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-çıkış yap");
        int selectCase=scanner.nextInt();
        System.out.print("Yapmak istediğiniz işlemi seçin : ");
        while (selectCase<1 || selectCase>3){
            System.out.print("GEÇERSİZ DEĞER tekrar giriniz :");
            selectCase=scanner.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapend();
                buyWeopan();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                return true;
        }
        return true;
    }
    public void printWeapend(){
        System.out.println("------ Silahlar ------");
        System.out.println();
        for (Weapon w: Weapon.weapons()){
            System.out.println(w.getId()+"-"+w.getName()+"<Para : "+w.getPrice()+", Hasar : >"+w.getDamage());
        }
    }

    public void buyWeopan(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeapendID=scanner.nextInt();
        while (selectWeapendID<1 || selectWeapendID>Weapon.weapons().length){
            System.out.print("GEÇERSİZ DEĞER tekrar giriniz :");
            selectWeapendID=scanner.nextInt();
        }

        Weapon selectedWeapend = Weapon.getWeponObjByID(selectWeapendID);
        if (selectedWeapend != null){
            if (selectedWeapend.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır!!!!!");
            }else {
                System.out.println(selectedWeapend.getName()+"Silahını satın aldınız ");
                int balance =this.getPlayer().getMoney()-selectedWeapend.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız : "+this.getPlayer().getMoney());
                System.out.println("Önceki silahınız : "+this.getPlayer().getInvertory().getWeapon().getName());
                this.getPlayer().getInvertory().setWeapon(selectedWeapend);
                System.out.println("Yeni silahınız : "+this.getPlayer().getInvertory().getWeapon().getName());
            }

        }

    }

    public void printArmor(){
        System.out.println("------ Zırhlar ------");
        System.out.println();
        for (Armor a :Armor.armors()){
            System.out.println(a.getId()+"-"+a.getName()+"<Fiyat :"+a.getPrice() + ",Savunma :"+a.getBlock() +">");
        }

    }
    public void buyArmor(){
        System.out.print("Bir zırh seçiniz : ");
        int selectArmorID=scanner.nextInt();
        while (selectArmorID<1 || selectArmorID>Armor.armors().length){
            System.out.print("GEÇERSİZ DEĞER tekrar giriniz :");
            selectArmorID=scanner.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
        if (selectedArmor != null){
            if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır!!!!!");
            }else {
                System.out.println(selectedArmor.getName()+"zırhı satın aldınız !");
                int balance=this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInvertory().setArmor(selectedArmor);
                System.out.println("Kalan Paranız : "+this.getPlayer().getMoney());


            }
        }

    }


}
