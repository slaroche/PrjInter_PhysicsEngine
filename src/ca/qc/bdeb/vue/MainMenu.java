/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.vue;

import ca.qc.bdeb.controler.Controleur;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author Samuel
 */
//C'est la que tu dois faire de test d'affichage Amé ^^
public class MainMenu extends BasicGameState {

    int state;
    private Controleur controleur;
    Image img;

    public MainMenu(int state, Controleur controleur) throws SlickException {
	this.state = state;
	this.controleur = controleur;;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	img = new Image ("little_baby.jpg");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
<<<<<<< HEAD
<<<<<<< HEAD
	g.fillRect(100, 100, 100, 100);
	g.fillRect(200, 200, 200, 200);
         img.draw(100,100);
=======
=======
>>>>>>> 70533e482b4c9daacbc4c2d6edf9438e5de05476
//        Image img = new Image ("little_baby.jpg");
//	g.fillRect(100, 100, 100, 100);
//	g.fillRect(200, 200, 200, 200);
//         img.draw(100,100);
<<<<<<< HEAD
>>>>>>> 70533e482b4c9daacbc4c2d6edf9438e5de05476
=======
>>>>>>> 70533e482b4c9daacbc4c2d6edf9438e5de05476
    }

    @Override
    public int getID() {
	return state;
    }
}
