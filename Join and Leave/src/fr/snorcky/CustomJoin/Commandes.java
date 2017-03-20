package fr.snorcky.CustomJoin;

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
					p.sendMessage(ChatColor.RED + "Commande disponible :");
					p.sendMessage(ChatColor.AQUA + "/cj reload : Recharger le plugin");
					p.sendMessage(ChatColor.AQUA + "/cj version : Affiche la version du Plugin");
				}

				if(args.length == 1){
					if(args[0].equalsIgnoreCase("reload")){
						plugin.reloadConfig();
						p.sendMessage("Plugin reload");
					}
					if(args[0].equalsIgnoreCase("version")){

						if(p.hasPermission("customjoin.version")){
							p.sendMessage(ChatColor.AQUA + "Version du plugin: " + pdf.getVersion());
						}
					}	
				}

			}
		}
		return false;
	}

}
