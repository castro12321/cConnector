/* cConnector
 * Copyright (C) 2013 Norbert Kawinski (norbert.kawinski@gmail.com)

 */

package castro.connector;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CVS
{	
	public static boolean canUse(String command, Player p)
	{
		if(!p.hasPermission("voxelsniper.sniper"))
			return false;
		if (p.hasPermission("voxelsniper.*"))
			return true;
		if (p.hasPermission("voxelsniper.command." + command))
			return true;
		
		switch(command)
		{
		case "vchunk":	// reloads chunk you are standing on
		case "u":		// undo
		case "d":		// default
		case "vs":		// shows your sniper settings
		case "vc":		// sets center
		case "vh":		// sets brush height
		case "vi":		// sets data variable <0; 15>
		case "vir":		// sets data variable <0; 15> for replacing
		case "vr":		// sets replace material
		case "vl":		// Determines which block types get extruded. (in brush /b ex)
		case "v":		// sets material for block placing
		case "b":		// selects brush, or sets its size
		case "p":		// selects performers (whatever it is lol)
			return true;
				
		case "goto":	// teleports to specified location
		case "paint":	// Switches to next painting
		case "btool":	// binds item to work like arrow/gunpowder.
		case "uuu":		// ultimate undo user
		case "uu":		// undo user
		case "bms":		// saves preset
		case "bml":		// loads preset
		default:
			p.sendMessage(ChatColor.RED + "You don't have permission for this command!");
			return false;
		}
	}
	
	
	public static boolean canUseBrush(String[] args, Player p)
	{
		if (p.hasPermission("voxelsniper.*"))
			return true;
		if (p.hasPermission("voxelsniper.brush." + args[0]))
			return true;
		
		switch(args[0])
		{
		case "ball":    case "b":
		case "disc":    case "d":
		case "pull":    case "p":
		case "snipe":   case "s":
		case "voxel":   case "v":
		case "erode":   case "e":
		case "ruler":   case "r":
		case "ring":    case "ri":
		case "drain":   // no aliases, lol
		case "ocean":   case "o":
		case "canyon":  case "ca":
		case "eraser":  case "erase":
		case "scanner":     case "sc":
		case "heatray":     case "hr":
		case "ellipse":     case "el":
		case "overlay":     case "over":
		case "extrude":     case "ex":
		case "snowcone":    case "snow":
		case "discface":    case "df":
		case "filldown":    case "fd":
		case "underlay":    case "under":
		case "cylinder":    case "c":
		case "copypasta":   case "cp":
		case "cleansnow":   case "cls":
		case "shellball":   case "shb":
		case "domebrush":   case "dome":
		case "blendball":   case "bb":
		case "blenddisc":   case "bd":
		case "voltmeter":   case "volt":
		case "voxeldisc":   case "vd":
		case "splatball":   case "sb":
		case "splatdisc":   case "sd":
		case "splatblob":   case "blob":
		case "splatvoxel":  case "sv":
		case "clonestamp":  case "cs":
		case "blendvoxel":  case "bv":
		case "shellvoxel":  case "shv":
		case "randomerode":      case "re":
		case "generatetree":     case "gt":
		case "voxeldiscface":    case "vdf":
		case "splatvoxeldisc":   case "svd":
		case "blendvoxeldisc":   case "bvd":
		case "spiralstaircase":  case "sstair":
		case "splatteroverlay":  case "sover":
		case "checkervoxeldisc": case "cvd":
			return true;    
		}
		
		p.sendMessage(ChatColor.RED + "You don't have permission to this brush!");
		return false;
	}
}

/*
	?BLOCK_RESET_SURFACE(BlockResetSurfaceBrush.class, "brbs", "blockresetbrushsurface"), // [25] \\ ---
	?BLOCK_RESET(BlockResetBrush.class, "brb", "blockresetbrush"), // [1] \\ ---
	-MOVE(MoveBrush.class, "mv", "move"), // [1] \\ ???
*/