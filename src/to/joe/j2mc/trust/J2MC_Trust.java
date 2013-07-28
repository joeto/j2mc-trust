package to.joe.j2mc.trust;

import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.trust.command.AmITrustedCommand;
import to.joe.j2mc.trust.command.RegisterCommand;
import to.joe.j2mc.trust.command.TrustReqCommand;
import to.joe.j2mc.trust.command.TrustedCommand;

public class J2MC_Trust extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("Trusted module disabled");
    }

    @Override
    public void onEnable() {
        this.getCommand("amitrusted").setExecutor(new AmITrustedCommand(this));
        this.getCommand("register").setExecutor(new RegisterCommand(this));
        this.getCommand("trusted").setExecutor(new TrustedCommand(this));
        this.getCommand("trustreq").setExecutor(new TrustReqCommand(this));

        this.getLogger().info("Trusted module enabled");
    }

}
