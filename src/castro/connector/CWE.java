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
