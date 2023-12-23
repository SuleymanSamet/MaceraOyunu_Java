package locations;

import monster.Obstacle;
import monster.Zombie;
import player.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player,"Mağara",new Zombie(),"Yemek",3);
    }
}
