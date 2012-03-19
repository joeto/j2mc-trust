package to.joe.j2mc.trust;

import org.bukkit.plugin.java.JavaPlugin;

import to.joe.j2mc.trust.command.AmITrustedCommand;
import to.joe.j2mc.trust.command.RegisterCommand;
import to.joe.j2mc.trust.command.TrustCommand;

public class J2MC_trust extends JavaPlugin{

    @Override
    public void onDisable() {
        this.getLogger().info("Trusted module disabled");
    }
    
    @Override
    public void onEnable() {
        this.getCommand("amitrusted").setExecutor(new AmITrustedCommand(this));
        this.getCommand("register").setExecutor(new RegisterCommand(this));
        this.getCommand("trust").setExecutor(new TrustCommand(this));
        
        this.getLogger().info("Trusted module enabled");
    }
    
}
