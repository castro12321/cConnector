/* cConnector
 * Copyright (C) 2013 Norbert Kawinski (norbert.kawinski@gmail.com)

 */

package castro.connector;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import castro.base.plugin.CPlugin;
import castro.base.plugin.CPluginSettings;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;


public class CConnector extends CPlugin implements Listener 
{
	public static WorldGuardPlugin	worldguard;
	
	@Override
	protected CPluginSettings getSettings()
	{
		return new CPluginSettings(); // Don't do anything
	}
	
	
	@Override
	protected void init()
	{
		PluginManager PM = getServer().getPluginManager();
		worldguard	= (WorldGuardPlugin)PM.getPlugin("WorldGuard");
	}
	
	
	/**
	 * LogBlock
	 */
	/*
	public static void registerChange(Player p, BlockState before, BlockState after)
	{
		final String playerName = p.getName() + "-C";
		
		if(before.getTypeId() == 0)
			consumer.queueBlockPlace(playerName, after);
		else if(after.getTypeId() == 0)
			consumer.queueBlockBreak(playerName, before);
		else
			consumer.queueBlockReplace(playerName, before, after);
	}
	*/
}