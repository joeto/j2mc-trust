package to.joe.j2mc.trust.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.trust.J2MC_trust;

public class AmITrustedCommand extends MasterCommand{
    
    public AmITrustedCommand(J2MC_trust trust) {
        super(trust);
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer) {
            if (J2MC_Manager.getPermissions().hasFlag(player.getName(), 't')) {
                player.sendMessage(ChatColor.AQUA + "You are trusted! Yay!");
            } else {
                player.sendMessage(ChatColor.AQUA + "You are not trusted. Get it!");
                player.sendMessage(ChatColor.AQUA + "Visit http://forums.joe.to/viewtopic.php?f=226&t=63434 to get trusted");
            }
        }
    }
}
