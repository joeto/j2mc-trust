package to.joe.j2mc.trust;

import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.trust.command.*;

public class J2MC_Trust extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("Trusted module disabled");
    }

    @Override
    public void onEnable() {
        this.getCommand("amitrusted").setExecutor(new AmITrustedCommand(this));
        this.getCommand("register").setExecutor(new RegisterCommand(this));
        this.getCommand("trust").setExecutor(new TrustCommand(this));
        this.getCommand("trustreq").setExecutor(new TrustReqCommand(this));

        this.getLogger().info("Trusted module enabled");
    }

}
