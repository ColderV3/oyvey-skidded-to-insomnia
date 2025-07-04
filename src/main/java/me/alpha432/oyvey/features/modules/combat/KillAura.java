import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class KillAura extends Module {

    public ArrayList<String> friends = new ArrayList<>();

    public KillAura() {
        super("Kill Aura", Keyboard.KEY_R, 0xffff0000, true, Category.COMBAT);
        // Tu peux ajouter des noms d'amis ici en dur ou via une commande par la suite
        friends.add("");
        friends.add("");
    }

    public boolean hasFriend(Entity entity) {
        if (entity == null) return false;
        String name = entity.getName().getString();  // Récupère le pseudo
        return friends.contains(name);
    }

    public boolean canAttackEntity(EntityLivingBase entity) {
        return entity != null
            && entity.isAlive()
            && mc.player.isAlive()
            && mc.player.canSee(entity)
            && mc.player.getDistance(entity) <= range
            && entity != mc.player
            && !hasFriend(entity);   // On skip si c'est un ami
    }

    // Reste du code...
}
