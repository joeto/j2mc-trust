package to.joe.j2mc.trust.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.trust.J2MC_Trust;

public class TrustedCommand extends MasterCommand<J2MC_Trust> {

    public TrustedCommand(J2MC_Trust trust) {
        super(trust);
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer) {
            if (J2MC_Manager.getPermissions().hasFlag(player.getName(), 't')) {
                player.sendMessage(ChatColor.AQUA + "What are you doing reading this? You're already trusted :D");
            } else {
                player.sendMessage(ChatColor.AQUA + "Trusted status gives special privileges");
                player.sendMessage(ChatColor.AQUA + "You want it? Visit http://forums.joe.to/viewtopic.php?f=226&t=63434");
            }
        }
    }

}
