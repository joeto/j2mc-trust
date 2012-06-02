package to.joe.j2mc.trust.command;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import to.joe.j2mc.core.J2MC_Manager;
import to.joe.j2mc.core.command.MasterCommand;
import to.joe.j2mc.trust.J2MC_trust;

public class RegisterCommand extends MasterCommand{

    public RegisterCommand(J2MC_trust trust) {
        super(trust);
    }

    @Override
    public void exec(CommandSender sender, String commandName, String[] args, Player player, boolean isPlayer) {
        if (isPlayer){
            if(args.length!=1 || args[0].length()!=5){
                player.sendMessage(ChatColor.DARK_AQUA + "Usage: /register key");
                player.sendMessage(ChatColor.DARK_AQUA + "Get your key: http://forums.joe.to/trust");
                return;
            }
            String authcode = args[0];
            try {
                PreparedStatement ps = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("SELECT * FROM minecraftusers WHERE minecraft_username <>\"\" AND authcode=?");
                ps.setString(1, authcode);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    player.sendMessage("Your account is already linked!");
                    return;
                }
                PreparedStatement ps2 = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("SELECT * FROM minecraftusers WHERE authcode=?");
                ps2.setString(1, authcode);
                ResultSet rs2 = ps2.executeQuery();
                //Verify their authcode is correct
                if(rs2.next()){
                    /*
                    //Check if user is on grandfather table
                    PreparedStatement prep = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("SELECT * FROM grandfatherlist WHERE name=?");
                    prep.setString(1, player.getName());
                    ResultSet result = prep.executeQuery();
                    //If user is on grandfather table
                    if(result.next()){
                        PreparedStatement updateUsersTable = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("UPDATE minecraftusers SET minecraft_username=?, status=3 WHERE authcode=?");
                        updateUsersTable.setString(1, player.getName());
                        updateUsersTable.setString(2, authcode);
                        updateUsersTable.executeUpdate();
                        //Grab their id
                        int id = rs2.getInt("minecraft_userid");
                        int epochTime = (int) System.currentTimeMillis() / 1000;
                        PreparedStatement insertIntoVouches = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("INSERT into minecraft_vouches (recipient_id,voucher_id,time_vouched,time_added,status) VALUES (?,?,?,?,?)");
                        insertIntoVouches.setInt(1, id);
                        insertIntoVouches.setInt(2, 0);
                        insertIntoVouches.setInt(3, epochTime);
                        insertIntoVouches.setInt(4, epochTime);
                        insertIntoVouches.setInt(5, 3);
                        insertIntoVouches.executeUpdate();
                        J2MC_Manager.getPermissions().addPermanentFlag(player, 't');
                        //FUCK YOU MBAXTER
                        PreparedStatement wipeFromGrandfather = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("DELETE FROM grandfatherlist WHERE name=?");
                        wipeFromGrandfather.setString(1, player.getName());
                        wipeFromGrandfather.executeUpdate();
                        player.sendMessage(ChatColor.DARK_AQUA + "Congratulations! Your account has been linked.");
                        return;
                        
                    }else{*/ //If user isn't on grandfather table
                        PreparedStatement updateUsersTable = J2MC_Manager.getMySQL().getFreshPreparedStatementHotFromTheOven("UPDATE minecraftusers SET minecraft_username=? WHERE authcode=?");
                        updateUsersTable.setString(1, player.getName());
                        updateUsersTable.setString(2, authcode);
                        updateUsersTable.executeUpdate();
                        player.sendMessage(ChatColor.DARK_AQUA + "Congratulations! Your account has been linked.");
                        return;
                    //}
                }else{
                    player.sendMessage(ChatColor.DARK_AQUA + "Incorrect key!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
}
