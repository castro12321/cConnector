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

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CVS
{	
	public static boolean canUse(String command, Player p)
	{
		if (p.hasPermission("voxelsniper.*"))
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
			p.sendMessage(ChatColor.RED + "Nie masz prawa do uzywania tej komendy!");
			return false;
		}
	}
	
	
	public static boolean canUseBrush(String[] args, Player p)
	{
		if (p.hasPermission("voxelsniper.*"))
			return true;
		
		switch(args[0])
		{
			case "s":		// snipe (point)
			case "b":		// ball
			case "d":		// default (reset settings)
			case "v":		// voxel (cube)
			case "w":		// warp (teleport)
			case "e":		// erozja (melt/fill/)
			case "r":		// ruler
			case "l":		// line
			case "bb":		// blend ball
			case "vd":		// voxel disc
			case "df":		// disc face
			case "vdf":		// voxel disc face
			case "over":	// overlay
			case "volt":	// volt meter (redstone)
			case "dome":	// kopula
			case "drain":	// water/lava draining
			case "gt":		// grand trees
				return true;
				
				/*
				// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~przerwap~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    SNIPE(SnipeBrush.class, "s", "snipe"), // [ 1 ] \\
			    DISC(DiscBrush.class, "d", "disc"), // [ 2 ] \\
			    DISC_FACE(DiscFaceBrush.class, "df", "discface"), // [ 3 ] \\
			    BALL(BallBrush.class, "b", "ball"), // [ 4 ] \\
			    VOXEL(VoxelBrush.class, "v", "voxel"), // [ 5 ] \\
			    VOXEL_DISC(VoxelDiscBrush.class, "vd", "voxeldisc"), // [ 6 ] \\
			    VOXEL_DISC_FACE(VoxelDiscFaceBrush.class, "vdf", "voxeldiscface"), // [ 7 ] \\
			    ENTITY(EntityBrush.class, "en", "entity"), // [ 8 ] \\
			    OCEAN(OceanBrush.class, "o", "ocean"), // [ 9 ] \\
			    CLONE_STAMP(CloneStampBrush.class, "cs", "clonestamp"), // [ 11 ] \\
			    ERODE(ErodeBrush.class, "e", "erode"), // [ 12 ] \\
			    PULL(PullBrush.class, "pull", "pull"), // [ 13 ] \\
			    PAINTING(PaintingBrush.class, "paint", "painting"), // [ 14 ] \\
			    CANYON(CanyonBrush.class, "ca", "canyon"), // [ 15 ] \\
			    CANYON_SELECTION(CanyonSelectionBrush.class, "cas", "canyonselection"), // [ 16 ] \\
			    TWO_D_ROTATION(Rot2DBrush.class, "rot2", "rotation2D"), // [ 17 ] \\
			    WARP(WarpBrush.class, "w", "warp"), // [ 18 ] \\
			    FILL_DOWN(FillDownBrush.class, "fd", "filldown"), // [ 19 ] \\
			    SET(SetBrush.class, "set", "set"), // [ 20 ] \\
			    JOCKEY(JockeyBrush.class, "jockey", "jockey"), // [ 21 ] \\
			    ENTITY_REMOVAL(EntityRemovalBrush.class, "er", "entityremoval"), // [ 22 ] \\
			    RING(RingBrush.class, "ri", "ring"), // [ 23 ] \\
			    SHELL_SET(ShellSetBrush.class, "shs", "shellset"), // [ 24 ] \\
			    BIOME(BiomeBrush.class, "bio", "biome"), // [ 25 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~giltwist~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    SPLATTER_DISC(SplatterDiscBrush.class, "sd", "splatdisc"), // [ 1 ] \\
			    SPLATTER_VOXEL_DISC(SplatterVoxelDiscBrush.class, "svd", "splatvoxeldisc"), // [ 2 ] \\
			    SPLATTER_BALL(SplatterBallBrush.class, "sb", "splatball"), // [ 3 ] \\
			    SPLATTER_VOXEL(SplatterVoxelBrush.class, "sv", "splatvoxel"), // [ 4 ] \\
			    BLOB(BlobBrush.class, "blob", "splatblob"), // [ 5 ] \\
			    SPIRAL_STAIRCASE(SpiralStaircaseBrush.class, "sstair", "spiralstaircase"), // [ 6 ] \\
			    SPLATTER_OVERLAY(SplatterOverlayBrush.class, "sover", "splatteroverlay"), // [ 7 ] \\
			    BLEND_VOXEL_DISC(BlendVoxelDiscBrush.class, "bvd", "blendvoxeldisc"), // [ 8 ] \\
			    BLEND_VOXEL(BlendVoxelBrush.class, "bv", "blendvoxel"), // [ 9 ] \\
			    BLEND_DISC(BlendDiscBrush.class, "bd", "blenddisc"), // [ 10 ] \\
			    BLEND_BALL(BlendBallBrush.class, "bb", "blendball"), // [ 11 ] \\
			    LINE(LineBrush.class, "l", "line"), // [ 12 ] \\
			    SNOW_CONE(SnowConeBrush.class, "snow", "snowcone"), // [ 13 ] \\
			    SHELL_BALL(ShellBallBrush.class, "shb", "shellball"), // [ 14 ] \\
			    SHELL_VOXEL(ShellVoxelBrush.class, "shv", "shellvoxel"), // [ 15 ] \\
			    RANDOM_ERODE(RandomErodeBrush.class, "re", "randomerode"), // [ 16 ] \\
			    TRIANGLE(TriangleBrush.class, "tri", "triangle"), // [ 19 ] \\
			    ERASER(EraserBrush.class, "erase", "eraser"), // [ 20 ] \\
			    COPYPASTA(CopyPastaBrush.class, "cp", "copypasta"), // [ 22 ] \\
			    COMET(CometBrush.class, "com", "comet"), // [ 23 ] \\
			    JAGGED(JaggedLineBrush.class, "j", "jagged"), // [ 24 ] \\
			    THREEPOINTCIRCLE(ThreePointCircleBrush.class, "tpc", "threepointcircle"), // [ 25 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Ghost8700~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    GENERATE_TREE(GenerateTreeBrush.class, "gt", "generatetree"), // [ 1 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DivineRage~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    GENERATE_CHUNK(RegenerateChunkBrush.class, "gc", "generatechunk"), // [ 1 ] \\ // No documentation. Fucks up client-sided. Still works though.
			    TREE_GENERATE(TreeSnipeBrush.class, "t", "treesnipe"), // [ 2 ] \\
			    SCANNER(ScannerBrush.class, "sc", "scanner"), // [ 5 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Gavjenks~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    HEAT_RAY(HeatRayBrush.class, "hr", "heatray"), // [ 1 ] \\
			    OVERLAY(OverlayBrush.class, "over", "overlay"), // [ 4 ] \\
			    DOME(DomeBrush.class, "dome", "domebrush"), // [ 6 ] \\
			    RULER(RulerBrush.class, "r", "ruler"), // [ 7 ] \\
			    VOLT_METER(VoltMeterBrush.class, "volt", "voltmeter"), // [ 8 ] \\
			    LIGHTNING(LightningBrush.class, "light", "lightning"), // [ 9 ] \\
			    DRAIN(DrainBrush.class, "drain", "drain"), // [ 10 ] \\
			    THREE_D_ROTATION(Rot3DBrush.class, "rot3", "rotation3D"), // [ 11 ] \\
			    TWO_D_ROTATION_EXP(Rot2DvertBrush.class, "rot2v", "rotation2Dvertical"), // [ 21 ] \\
			    STENCIL(StencilBrush.class, "st", "stencil"), // [ 23 ] \\
			    STENCILLIST(StencilListBrush.class, "sl", "stencillist"), // [ 24 ] \\
			    BLOCK_RESET_SURFACE(BlockResetSurfaceBrush.class, "brbs", "blockresetbrushsurface"), // [25] \\
			    FLAT_OCEAN(FlatOceanBrush.class, "fo", "flatocean"), // [ 26 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~psanker~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    ELLIPSE(EllipseBrush.class, "el", "ellipse"), // [ 1 ] \\
			    CLEAN_SNOW(CleanSnowBrush.class, "cls", "cleansnow"), // [ 4 ] \\
			    EXTRUDE(ExtrudeBrush.class, "ex", "extrude"), // [ 5 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Deamon~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    SET_REDSTONE_FLIP(SetRedstoneFlipBrush.class, "setrf", "setredstoneflip"), // [ 1 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Jmck95~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    UNDERLAY(UnderlayBrush.class, "under", "underlay"), // [ 1 ] \\

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Kavukamari~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    CYLINDER(CylinderBrush.class, "c", "cylinder"),

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Monofraps~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    PUNISH(PunishBrush.class, "p", "punish"), // [ 1 ] \\
			    SIGN_OVERWRITE(SignOverwriteBrush.class, "sio", "signoverwrite"),

			    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MikeMatrix~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \\
			    MOVE(MoveBrush.class, "mv", "move"), // [1] \\
			    BLOCK_RESET(BlockResetBrush.class, "brb", "blockresetbrush"), // [1] \\
			    CHECKER_VOXEL_DISC(CheckerVoxelDiscBrush.class, "cvd", "checkervoxeldisc"); // [1] \\
				*/
		}
		
		p.sendMessage(ChatColor.RED + "Nie masz prawa do tego brush'a!");
		return false;
	}
}