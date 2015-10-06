package gamesrc;

import java.util.ArrayList;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.ImageCache;
import jgame.controller.MouseLocationController;
import jgame.listener.FrameListener;
import jgame.listener.LocalClickListener;
import Turrets.TurretFive;
import Turrets.TurretFour;
import Turrets.TurretOne;
import Turrets.TurretThree;
import Turrets.TurretTwo;

public class TGLevelOneView extends GContainer {
	
	private l1PlayArea pal1 = new l1PlayArea();
	private MenuArea ma = new MenuArea();
	private InfoArea ia = new InfoArea();
	public boolean enemyPresent = false;
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Turret> turretList = new ArrayList<Turret>();
	
	private boolean settingTurret = false;
	public TGLevelOneView() {
		setSize(900,700); 
		
		// sets up play area
		pal1.setAnchorTopLeft();
		pal1.setLocation(100,0);
		add(pal1);
		
		// sets up menu
		ma.setAnchorTopLeft();
		ma.setLocation(0,0);
		add(ma);
		
		// sets up info
		ia.setAnchorTopLeft();
		ia.setLocation(0,570);
		add(ia);
		
	}
	
	public void initializeTurret(int tn) {
		if (settingTurret) {
			return;
		}
		settingTurret = true;
		
		Turret t = chooseTurret(tn);
		this.pal1.addAtCenter(t);
		turretList.add(t);
		
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		
		final LocalClickListener dropListener = new LocalClickListener() {

			@Override
			public void invoke(GObject target, Context context) {
				target.removeController(mlc);
				target.removeListener(this);
				settingTurret = false;
			}
			
		};
		t.addListener(dropListener);
		
		//allows turrets to track enemies
		this.addListener(new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				for (int i = 0; i < turretList.size(); i++) {
					if (enemyPresent) turretList.get(i).face(enemyList.get(enemyList.size()-1).getX(),enemyList.get(enemyList.size()-1).getY());
					else turretList.get(i).face(getWidth()/2,getHeight()/2);
					turretList.get(i).setRotation(turretList.get(i).getRotation());
				}

			}
		});
		
	}
	
	public void initializeSlowEnemy() {
		SlowEnemy first = new SlowEnemy(ImageCache.forClass(TowerGame.class).get("enemy.png"));
		this.pal1.add(first);
		first.setLocation(300,100);
		enemyList.add(first);
		enemyPresent = true;
	}
	
	public void initializeNormalEnemy() {
		NormalEnemy first = new NormalEnemy(ImageCache.forClass(TowerGame.class).get("enemy.png"));
		this.pal1.add(first);
		first.setLocation(300,100);
		enemyList.add(first);
		enemyPresent = true;
	}
	
	public void initializeFastEnemy() {
		FastEnemy first = new FastEnemy(ImageCache.forClass(TowerGame.class).get("enemy.png"));
		this.pal1.add(first);
		first.setLocation(300,100);
		enemyList.add(first);
		enemyPresent = true;
	}
	
	public Turret chooseTurret(int turretNumber) {
		switch(turretNumber) {
		case 0:
			return new TurretOne(ImageCache.forClass(TowerGame.class).get("tiles/d1.png"));
		case 1:
			return new TurretTwo(ImageCache.forClass(TowerGame.class).get("tiles/d2.png"));
		case 2:
			return new TurretThree(ImageCache.forClass(TowerGame.class).get("tiles/d3.png"));
		case 3:
			return new TurretFour(ImageCache.forClass(TowerGame.class).get("tiles/d4.png"));
		case 4:
			return new TurretFive(ImageCache.forClass(TowerGame.class).get("tiles/d5.png"));
		default: return null;
		}
	}
	
}
