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

import com.sk89q.worldedit.LocalPlayer;


public class CWE
{
	private static final int k = 1000;
	private static final int m = 1000*k;
	
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
		limit  = 0;
		player = p;
		
		check("aliquam.player"      , 10*k);
		check("aliquam.familiar"    , 30*k);
		check("aliquam.builder"     , 100*k);
		check("aliquam.advbuilder"  , 300*k);
		check("aliquam.designer"    , 1000*k);
		check("aliquam.architect"   , 1000*k);
		
		check("aliquam.welimit.25k" , 25*k);
		check("aliquam.welimit.100k", 100*k);
		check("aliquam.welimit.250k", 250*k);
		check("aliquam.welimit.500k", 500*k);
		check("aliquam.welimit.1m"  , 1*m);
		check("aliquam.welimit.2m"  , 2*m);
		check("aliquam.welimit.5m"  , 5*m);
		
		check("aliquam.welimit.x2"  , limit * 2);
		check("aliquam.welimit.x22" , limit * 2);
		check("aliquam.welimit.x222", limit * 2);
		check("aliquam.welimit.x5"  , limit * 5);
		check("aliquam.welimit.x55" , limit * 5);
		check("aliquam.welimit.x555", limit * 5);
		
		check("aliquam.mod", -1);
		
		return limit;
	}
}
