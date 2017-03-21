package fr.snorcky.CustomJoin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import net.md_5.bungee.api.ChatColor;

public class Commandes implements CommandExecutor {

	private Main plugin;
	PluginDescriptionFile pdf;

	public Commandes(Main pl) {
		plugin = pl;
		this.pdf = pl.getDescription();

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player p = (Player)sender;

		if(cmd.getName().equalsIgnoreCase("cj")){

			if(p.hasPermission("customjoin.reload")){

				if(args.length == 0){
					p.sendMessage(ChatColor.RED + "Command's list :");
					p.sendMessage(ChatColor.AQUA + "/cj reload : Reload CustomJoin");
					p.sendMessage(ChatColor.AQUA + "/cj version : Show version's plugin");
				}

				if(args.length == 1){
					if(args[0].equalsIgnoreCase("reload")){
						p.sendMessage("Plugin reload");
						plugin.reloadConfig();
						Bukkit.getServer().getPluginManager().disablePlugin(plugin);
						Bukkit.getServer().getPluginManager().enablePlugin(plugin);
						
					}
					if(args[0].equalsIgnoreCase("version")){

						if(p.hasPermission("customjoin.version")){
							p.sendMessage(ChatColor.AQUA + "CustomJoin : " + pdf.getVersion());
						}
					}	
				}

			}
		}
		return false;
	}

}
