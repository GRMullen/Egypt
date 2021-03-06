package Turrets;

import gamesrc.Bullet;
import gamesrc.TowerGame;
import gamesrc.Turret;

import java.awt.Image;

import jgame.ImageCache;

public class TurretOne extends Turret {
	public TurretOne(Image image) {
		super(image);
	
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.forClass(TowerGame.class).get("bullet1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
