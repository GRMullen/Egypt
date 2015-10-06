package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class InfoArea extends GContainer {
	public InfoArea() {
		setSize(100, 700);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("infobar.jpeg");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
		setSlowTile();
		setNormalTile();
		setFastTile();
	}
	
	private void setSlowTile() {
		Tile tile = new Tile(ImageCache.forClass(TowerGame.class).get("enemy.png"), 1.0);
		tile.setAnchorTopLeft();
		tile.setScale(0.9);
		tile.setX(50);
		tile.setY(10);
		add(tile);
		
	}
	
	private void setNormalTile() {
		Tile tile = new Tile(ImageCache.forClass(TowerGame.class).get("enemy.png"), 2.0);
		tile.setAnchorTopLeft();
		tile.setScale(0.9);
		tile.setX(150);
		tile.setY(10);
		add(tile);
	}
	
	private void setFastTile() {
		Tile tile = new Tile(ImageCache.forClass(TowerGame.class).get("enemy.png"), 3.0);
		tile.setAnchorTopLeft();
		tile.setScale(0.9);
		tile.setX(250);
		tile.setY(10);
		add(tile);
	}
}
