package gamesrc;

import java.awt.Color;

import gamesrc.TowerGame.Views;
import jgame.BaseGame;
import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GRootContainer;
import jgame.GSprite;
import jgame.Game;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class TGMenuView extends GContainer{
	
	public GRootContainer root = new GRootContainer(Color.BLACK);
	public TGMenuView() {
		setSize(900,700);
		
		MenuBackground mbg = new MenuBackground();
		addAtCenter(mbg);
		
		GSprite none_img = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonnone.png"));
		GSprite hover_img = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonhover.png"));
		GSprite pressed_img = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/buttonpressed.png"));
		
		GButton play_btn = new GButton();
		play_btn.setStateSprite(ButtonState.NONE, none_img);
		play_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		play_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		
		GSprite tIcon = new GSprite(ImageCache.forClass(TowerGame.class).get("tiles/start.png"));
		
		play_btn.setLocation(100, 100);
		tIcon.setScale(.6);
		play_btn.add(tIcon);
		add(play_btn);
		
		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				TowerGame.l1v();
				
				
			}
		});
		
	}

}
