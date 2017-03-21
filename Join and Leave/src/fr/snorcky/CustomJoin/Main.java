package fr.snorcky.CustomJoin;

import java.io.File;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable(){
		
		File config = new File(getConfig().getCurrentPath());

        if (!config.exists())
        {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

		PluginManager pm = getServer().getPluginManager();
		Listener l = new CustomMessage(this);
		pm.registerEvents(l, this);
		
		getCommand("cj").setExecutor(new Commandes(this));
	}

	public void onDisable(){	
		System.out.println("Disable");
	}
	
}
