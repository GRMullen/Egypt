package Turrets;

import gamesrc.Bullet;
import gamesrc.TowerGame;
import gamesrc.Turret;

import java.awt.Image;

import jgame.ImageCache;

public class TurretFive extends Turret {
	public TurretFive(Image image) {
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
