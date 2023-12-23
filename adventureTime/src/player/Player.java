package player;

import items.Invertory;
import items.Weapon;
import locations.Location;
import locations.SafeHouse;
import locations.ToolStore;

import java.util.Scanner;

public class Player {
    Scanner scanner =new Scanner(System.in);

    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String charName;
    private String name;
    private Invertory invertory;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Invertory getInvertory() {
        return invertory;
    }

    public void setInvertory(Invertory invertory) {
        this.invertory = invertory;
    }

    public Player(String name){
        this.name=name;
        this.invertory=new Invertory();
    }
    public void selectChar(){
        Samurai samurai =new Samurai();
        Archer archer=new Archer();
        Knight knight=new Knight();

        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        System.out.println("-----------------------------");

        for (GameChar gameChar: charList){
            System.out.println("ID: "+gameChar.getId()+"Karakter:"+gameChar.getName()+" Hasar:"+gameChar.getDamage()+" Sağlık:"+gameChar.getHealth()+" Para:"+gameChar.getMoney());
        }
        System.out.println("------------------------------");
        System.out.print("Lütfen bir karakter seçiniz : ");
        int selectChar = scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Seçilen Karakter :"+this.getCharName()+" ,Hasar:"+this.getTotalDamage()+", Sağlık:"+this.getHealth()+", Para:"+this.getMoney());
    }



    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }
    public void printInfo(){
        System.out.println("Silahınız: "+this.getInvertory().getWeapon().getName()+", Zırhınız: "+this.getInvertory().getArmor().getName()+", Block: "+this.getInvertory().getArmor().getBlock()+", Hasar:"+this.getTotalDamage()+", Sağlık:"+this.getHealth()+", Para:"+this.getMoney());
    }


    public int getTotalDamage(){
        return damage + this.getInvertory().getWeapon().getDamage();
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        if (health<0){
            health=0;
        }
        this.health=health;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public String getCharName(){
        return charName;
    }
    public void setCharName(String charName){
        this.charName=charName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Weapon getWeopon(){
        return this.getInvertory().getWeapon();

    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
