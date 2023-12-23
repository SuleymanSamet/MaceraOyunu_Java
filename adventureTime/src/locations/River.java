package locations;

import monster.Bear;
import monster.Obstacle;
import player.Player;

public class River extends BattleLoc{
    public River(Player player) {
        super(player,"Nehir",new Bear(),"Su",2);
    }
}
