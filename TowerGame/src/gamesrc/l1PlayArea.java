package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class l1PlayArea extends GContainer {
	public l1PlayArea() {
		setSize(800, 600);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("lvl1.png");
		GSprite gs = new GSprite(bg);
		setBackgroundSprite(gs);
	}
}
