package gamesrc;

import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class Tile extends GButton {
	public Tile(Image image, final int tn) {
		setSize(90,90);
		
		GSprite sNone = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonnone.png"));
		GSprite sHover = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonhover.png"));
		GSprite sPressed = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonpressed.png"));
		
		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);
		
		GSprite tIcon = new GSprite(image);
		tIcon.setScale(0.8);
		addAtCenter(tIcon);
		
		towerListen(tn);
	}
	
	public Tile(Image image, double en) {
		setSize(90,90);
		
		GSprite sNone = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonnone.png"));
		GSprite sHover = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonhover.png"));
		GSprite sPressed = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonpressed.png"));
		
		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);
		
		GSprite tIcon = new GSprite(image);
		tIcon.setScale(0.8);
		addAtCenter(tIcon);
		
		if (en == 1.0) {
		slowEnemyListen();
		}
		if (en == 2.0) {
		normalEnemyListen();
		}
		if (en == 3.0) {
		fastEnemyListen();
		}
	}

	public void towerListen(final int tn) {
		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(TGLevelOneView.class).initializeTurret(tn);
				//getFirstAncestorOf(TGLevelOneView.class).initializeEnemy();
				
				
			}
		});
	}
	
	public void slowEnemyListen() {
		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(TGLevelOneView.class).initializeSlowEnemy();
			}
		});
	}
	public void normalEnemyListen() {
		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(TGLevelOneView.class).initializeNormalEnemy();
			}
		});
	}
	public void fastEnemyListen() {
		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(TGLevelOneView.class).initializeFastEnemy();
			}
		});
	}
}
 