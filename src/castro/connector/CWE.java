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

import com.sk89q.worldedit.session.SessionOwner;

public class CWE
{
	private static final int k = 1000;
	private static final int m = 1000*k;
	
	// Limit management
	private static int limit;
	private static SessionOwner player;
	
	private static void check(String permission, int limit)
	{
		if(player.hasPermission(permission))
			CWE.limit = limit;
	}
	
	public static int getLimit(SessionOwner p)
	{
		limit  = 0;
		player = p;
		
		check("aliquam.player"      , 50*k);
		check("aliquam.familiar"    , 100*k);
		check("aliquam.builder"     , 250*k);
		check("aliquam.advbuilder"  , 500*k);
		check("aliquam.designer"    , 1000*k);
		check("aliquam.architect"   , 1000*k);
		
		check("aliquam.welimit.100k", 100*k);
		check("aliquam.welimit.500k", 500*k);
		check("aliquam.welimit.2m"  , 2*m);
		check("aliquam.welimit.5m"  , 5*m);
		
		check("aliquam.welimit.x2"  , limit * 2);
		check("aliquam.welimit.x22" , limit * 2);
		check("aliquam.welimit.x3"  , limit * 3);
		check("aliquam.welimit.x33" , limit * 3);
		check("aliquam.welimit.vote", limit * 2);
		
		// Hard limit for regular players
		if(limit > 3*m)
			limit = 3*m;
		
		check("aliquam.mod", -1);
		
		return limit;
	}
}
