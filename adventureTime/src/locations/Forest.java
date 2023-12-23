package locations;

import monster.Obstacle;
import monster.Vampire;
import player.Player;

public class Forest extends BattleLoc{

    public Forest(Player player) {
        super(player,"Orman",new Vampire(),"Odun",3);
    }
}
