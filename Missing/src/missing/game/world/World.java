/*	File: World.java
 * 	Author:
 * 	Chris Rabe		300334207
 *  Edward Kelly	300334192
 * 
 * 	Date			Author				changes
 * 	8 Sep 16		Chris Rabe			created world class
 *  8 Sep 16		Edward Kelly		created constructor, setupWorld, setLocation
 */

package missing.game.world;
import java.awt.Point;
import java.util.List;

import missing.game.characters.Player;
import missing.game.items.Item;
import missing.game.world.nodes.WorldNode;
import missing.game.world.nodes.WorldTile.TileObject;
import missing.helper.WorldInitialiser;

/**
 * This class contains all the logic for moving around the players within the
 * game world as well as performing appropriate checking if item and players
 * collide.
 */
public class World {
	public static final int WORLD_WIDTH = 25;
	public static final int WORLD_HEIGHT = 25;
	
	/** The WorldNodes that make up the World */
	private WorldNode[][] worldNodes;
	/** Reference to the players in the world */
	private List<Player> players;
	
	public World(List<Player> players){
		this.players = players;
		worldNodes = new WorldNode[WORLD_WIDTH][WORLD_HEIGHT];
		setupWorld();
	}
	
	/**
	 * Creates the world, places items and players
	 */
	private void setupWorld(){
		for (int x=0; x < WORLD_WIDTH; x++){
			for (int y=0; y < WORLD_HEIGHT; y++){
				worldNodes[x][y] = new WorldNode(new Point(x,y));
			}
		}
		// TODO: add tiles to world, will need to parse tile info. may not be done in this class
		
		// add players to world
		for (Player p : players){
			setLocation(p, p.getWorldLocation(), p.getTileLocation());
		}
		
		// add items to world
		List<Item> items = WorldInitialiser.initItems();
		for (Item item : items){
			setLocation(item, item.getWorldLocation(), item.getTileLocation());
		}
		
		
	}
	
	/**
	 * Places an object at a given location. Used for placing items and placing/moving players
	 * Can also pass a null object to set a square to blank
	 * @param object object to be placed
	 * @param destWorldNode WorldNode destination
	 * @param destTile WorldTile destination
	 */
	public void setLocation(TileObject object, Point destWorldNode, Point destTile){
		//TODO: need to implement setTileObject method in WorldNode
		//worldNodes[destWorldNode.x][destWorldNode.y].setTileObject(object, destTile);
	}
	
	
	
}
