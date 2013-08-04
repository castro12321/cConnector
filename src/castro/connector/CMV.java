package castro.connector;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;

public class CMV
{
	private static MultiverseCore multiverse = CConnector.multiverse;
	
	public static MVWorldManager getMVMgr()
	{
		return multiverse.getMVWorldManager();
	}
	
	
	public static boolean unloadWorld(String world)
	{
		return getMVMgr().unloadWorld(world);
	}
	
	
	public static boolean loadWorld(String world)
	{
		return getMVMgr().loadWorld(world);
	}
	
	
	public static boolean regenWorldWithRandomSeed(String world)
	{
		return regenWorld(world, true, true, null);
	}
	public static boolean regenWorld(String world, boolean useNewSeed, boolean randomSeed, String seed)
	{
		return getMVMgr().regenWorld(world, useNewSeed, randomSeed, seed);
	}
}
