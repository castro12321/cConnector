package castro.connector;

import com.sk89q.worldedit.LocalPlayer;


public class CWE
{
	private static final int k = 1000;
	
	// Limit management
	private static int limit;
	private static LocalPlayer player;
	private static void check(String permission, int limit)
	{
		if(player.hasPermission(permission))
			CWE.limit = limit;
	}
	public static int getLimit(LocalPlayer p)
	{
		limit = 0;
		player = p;
		
		check("aliquam.familiar"	, 10*k);
		check("aliquam.builder"		, 30*k);
		check("aliquam.advbuilder"	, 70*k);
		check("aliquam.designer"	, 150*k);
		check("aliquam.architect"	, 450*k);
		
		check("aliquam.welimit.25k"	, 25*k);
		check("aliquam.welimit.100k", 100*k);
		check("aliquam.welimit.250k", 250*k);
		
		check("aliquam.mod", -1);
		
		return limit;
	}
}
