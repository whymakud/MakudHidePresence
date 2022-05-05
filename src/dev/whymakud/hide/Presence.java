package dev.whymakud.hide;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;

public class Presence extends JavaPlugin implements Listener {
	
   public void onEnable() {
      Bukkit.getPluginManager().registerEvents(this, this);
   }
   
   @EventHandler(priority = EventPriority.HIGHEST)
   public void onJoin(PlayerJoinEvent e) {
      Player l = e.getPlayer();
      Iterator intr = Bukkit.getOnlinePlayers().iterator();

      Player p;
      while(intr.hasNext()) {
         p = (Player)intr.next();
         p.hidePlayer(l);
      }

      intr = Bukkit.getOnlinePlayers().iterator();

      while(intr.hasNext()) {
         p = (Player)intr.next();
         l.hidePlayer(p);
      }

   }
}