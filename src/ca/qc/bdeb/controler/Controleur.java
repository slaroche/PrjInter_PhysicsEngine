package ca.qc.bdeb.controler;

import ca.qc.bdeb.module.Module;
import ca.qc.bdeb.vue.Affichable;
import ca.qc.bdeb.vue.Cibles;
import ca.qc.bdeb.vue.EngineScreen;
import ca.qc.bdeb.vue.MainMenu;
import ca.qc.bdeb.vue.Projectiles;
import ca.qc.bdeb.vue.Structures;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class Controleur {

    //State
    private int menu = 0;
    private int engineScreen = 1;
    private Module module;
    //Screens
    private MainMenu mainMenu;
    private EngineScreen engineScreenMenu;
    private Affichable nouvelleItemAffichable = null;

    public Controleur() throws SlickException {
	module = new Module(this);

	engineScreenMenu = new EngineScreen(engineScreen, this);
	mainMenu = new MainMenu(menu, this);
    }

    //Projectiles
    public void addProjectile(int x, int y, double v, double angle, double facRebond) throws SlickException {
	module.getListProjectiles().add(new Projectiles((x + 40), (500 - y), v, angle, facRebond, this));
    }

    public void enleverProjectiles(Projectiles projectile) {
	module.getListProjectiles().remove(projectile);
	engineScreenMenu.getListAnimationProjectiles().remove(0);
    }

    public double positionProjectileX(int i) {
	return module.getListProjectiles().get(i).getPosition().getX();
    }

    public double positionProjectileY(int i) {
	return module.getListProjectiles().get(i).getPosition().getY();
    }

    public ArrayList<Projectiles> getListProjectiles() {
	return module.getListProjectiles();
    }

    public void rebondProjectilesMur(Projectiles proj) {

	if ((proj.getPosition().getX() + proj.getBound().getX()) > module.getWidth()) {
	    proj.getPosition().setX(module.getWidth() - proj.getBound().getX());
	    module.rebond(proj, 'x');
	}

	if ((proj.getPosition().getY() + proj.getBound().getY()) > (module.getHeight() - 85)) {
	    proj.getPosition().setY((module.getHeight() - 85) - proj.getBound().getY());
	    module.rebond(proj, 'y');
	}
	if (proj.getPosition().getX() < 0) {
	    proj.getPosition().setX(0);
	    module.rebond(proj, 'x');
	}

	if (proj.getPosition().getY() < 75) {
	    proj.getPosition().setY(75);
	    module.rebond(proj, 'y');
	}
    }

    public void rebondProjectilesMurLoop() {
	for (int i = 0; i < module.getListProjectiles().size(); i++) {

	    rebondProjectilesMur(module.getListProjectiles().get(i));
	}
    }

    public void bougerProjectiles() {
	for (int i = 0; i < module.getListProjectiles().size(); i++) {
	    module.getListProjectiles().get(i).getPosition().setX(module.getListProjectiles().get(i).getPosition().getX() + module.getListProjectiles().get(i).getVitesse().getX());
	    module.getListProjectiles().get(i).getPosition().setY(module.getListProjectiles().get(i).getPosition().getY() - module.getListProjectiles().get(i).getVitesse().getY());
	    module.getListProjectiles().get(i).getVitesse().setY(module.getListProjectiles().get(i).getVitesse().getY() - (module.getListProjectiles().get(i).getGravity() / 100));
	}
    }

    public double orientationProjectil(Projectiles proj) {
	double angle;
	angle = Math.atan(proj.getVitesse().getX() / proj.getVitesse().getY());
	if (proj.getVitesse().getY() < 0) {
	    angle = angle + Math.PI;
	}
	return Math.toDegrees(angle);
    }

    //Structures
    public void addStructure(int x, int y) throws SlickException {
	module.getListStructures().add(new Structures(x, y, this));
    }

    public void enleverStructure(Structures structure) {
	module.getListStructures().remove(structure);
	engineScreenMenu.getListImagesStructures().remove(0);
    }

    public double positionStructureX(int i) {
	return module.getListStructures().get(i).getPosition().getX();
    }

    public double positionStructureY(int i) {
	return module.getListStructures().get(i).getPosition().getY();
    }

    public ArrayList<Structures> getListStructures() {
	return module.getListStructures();
    }

    public void rebondProjectilesStructures(Projectiles proj, Structures struc) {

	if (proj.getPosition().getX() > struc.getPosition().getX() && proj.getPosition().getX() < (struc.getPosition().getX() + struc.getBound().getX()) && proj.getPosition().getY() < struc.getPosition().getY()) {
	    if (proj.getVitesse().getX() < 0) {
		if (Math.abs((struc.getPosition().getX() + struc.getBound().getX()) - proj.getPosition().getX()) > Math.abs(struc.getPosition().getY() - proj.getPosition().getY())) {
		    proj.getPosition().setY(struc.getPosition().getY());
		    module.rebond(proj, 'y');

		} else {
		    proj.getPosition().setX((struc.getPosition().getX() + struc.getBound().getX()));
		    module.rebond(proj, 'x');
		}

	    } else {
		if (Math.abs(struc.getPosition().getX() - proj.getPosition().getX()) > Math.abs(struc.getPosition().getY() - proj.getPosition().getY())) {
		    proj.getPosition().setY(struc.getPosition().getY());
		    module.rebond(proj, 'y');
		} else {
		    proj.getPosition().setX(struc.getPosition().getX());
		    module.rebond(proj, 'x');
		}
	    }
	}
    }

    public void rebondProjectilesStructuresLoop() {
	for (int j = 0; j < module.getListStructures().size(); j++) {
	    for (int i = 0; i < module.getListProjectiles().size(); i++) {

		rebondProjectilesStructures(module.getListProjectiles().get(i), module.getListStructures().get(j));
	    }
	}
    }

    //Cibles
    public void addCible(int x, int y) throws SlickException {
	module.getListCibles().add(new Cibles(x, y, this));
    }

    public void enleverCible(Cibles cible) {
	module.getListCibles().remove(cible);
	engineScreenMenu.getListAnimationCibles().remove(0);
    }

    public double positionCiblesX(int i) {
	return module.getListCibles().get(i).getPosition().getX();
    }

    public double positionCiblesY(int i) {
	return module.getListStructures().get(i).getPosition().getY();
    }

    public ArrayList<Cibles> getListCibles() {
	return module.getListCibles();
    }
    
    //Mettre un objet affichable dans la variable
    public void afficher(Affichable nouvelleItemAffichable) {
	this.nouvelleItemAffichable = nouvelleItemAffichable;
    }

    //Sauvegarde
    public void sauvegarderFichier(int nbreProjectile) {

	module.sauvegarde(nbreProjectile);
    }

    public void chargerFichier() {

	module.charger();
    }

    //getters and setters
    public Module getModule() {
	return module;
    }

    public EngineScreen getEngineScreenMenu() {
	return engineScreenMenu;
    }

    public MainMenu getMainMenu() {
	return mainMenu;
    }

    public int getMenu() {
	return menu;
    }

    public int getEngineScreen() {
	return engineScreen;
    }

    public Affichable getNouvelleItemAffichable() {
	return nouvelleItemAffichable;
    }

    public void setNouvelleItemAffichable(Affichable nouvelleItemAffichable) {
	this.nouvelleItemAffichable = nouvelleItemAffichable;
    }
}
