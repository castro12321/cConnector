/* cConnector
 * Copyright (C) 2013 Norbert Kawinski (norbert.kawinski@gmail.com)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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