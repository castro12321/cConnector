package castro.connector;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import castro.base.plugin.CPlugin;
import castro.base.plugin.CPluginSettings;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import de.diddiz.LogBlock.Consumer;
import de.diddiz.LogBlock.LogBlock;


public class CConnector extends CPlugin implements Listener 
{
	public static LogBlock			logblock;
	public static WorldEditPlugin	worldedit;
	public static WorldGuardPlugin	worldguard;
	public static MultiverseCore	multiverse;
	
	public static Player player; // current player for execution by WE and Voxel
	private static Consumer consumer;
	
	
	@Override
	protected CPluginSettings getSettings()
	{
		return new CPluginSettings(); // Don't do anything
	}
	
	
	@Override
	protected void init()
	{
		PluginManager PM = getServer().getPluginManager();
		logblock	= (LogBlock)		PM.getPlugin("LogBlock");
		worldedit	= (WorldEditPlugin)	PM.getPlugin("WorldEdit");
		worldguard	= (WorldGuardPlugin)PM.getPlugin("WorldGuard");
		multiverse	= (MultiverseCore)PM.getPlugin("Multiverse-Core");
		
		consumer = logblock.getConsumer();
	}
	
	
	/**
	 * LogBlock
	 */
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
}