package fr.snorcky.CustomJoin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;

public class CustomMessage implements Listener {

	private FileConfiguration config;
	private Main m;


	public CustomMessage(Main main) {
		this.m = main;
		this.config = m.getConfig();
	}


	@EventHandler (priority = EventPriority.HIGH)
	public void onJoinMessage(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String colorjoin = config.getString("custom-message.join-msg");
		String colormsgjoin = ChatColor.translateAlternateColorCodes('&', colorjoin);
		String colorfj = config.getString("custom-message.welcome-msg");
		String colormsgfj = ChatColor.translateAlternateColorCodes('&', colorfj);
		
		if(config.getBoolean("disable.join") == true){
			e.setJoinMessage(null);;
		} else {
			if(!p.hasPlayedBefore()) {
				e.setJoinMessage(colormsgfj.replaceAll("%p", p.getName()));
			}else{
				e.setJoinMessage(colormsgjoin.replaceAll("%p", p.getName()));
			}
		}
	}


	@EventHandler (priority = EventPriority.HIGH)
	public void onLeaveMessage(PlayerQuitEvent e2){
		Player p = e2.getPlayer();
		String colorleave = config.getString("custom-message.leave-msg");
		String colormsgleave = ChatColor.translateAlternateColorCodes('&', colorleave);
		if(config.getBoolean("disable.leave") == true ){
			e2.setQuitMessage(null);
		} else {
			e2.setQuitMessage(colormsgleave.replaceAll("%p", p.getName()));
		}
	}
		
}
