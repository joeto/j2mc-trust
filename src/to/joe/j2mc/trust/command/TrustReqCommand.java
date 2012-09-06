package to.joe.j2mc.trust.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.J2MC_Core;
import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.trust.J2MC_trust;

public class TrustReqCommand extends MasterCommand {

    J2MC_trust plugin;

    public TrustReqCommand(J2MC_trust trust) {
        super(trust);
        this.plugin = trust;
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer) {
            if (J2MC_Manager.getPermissions().hasFlag(player.getName(), 't')) {
                player.sendMessage(ChatColor.AQUA + "You're already trusted, you don't need to request help!");
            } else {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usage: /trustreq <message>");
                    return;
                }
                String reqMessage = J2MC_Core.combineSplit(0, args, " ");
                for (Player target : J2MC_Manager.getCore().getServer().getOnlinePlayers()) {
                    if (J2MC_Manager.getPermissions().hasFlag(target.getName(), 't')) {
                        target.sendMessage(ChatColor.AQUA + "[TRUSTED REQUEST] <" + player.getName() + "> " + reqMessage);
                    }
                }
                player.sendMessage(ChatColor.AQUA + "Notified all trusted users online that you need help.");
                player.sendMessage(ChatColor.AQUA + "Please wait patiently.");
            }
        }
    }
}
