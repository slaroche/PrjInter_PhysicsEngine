/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.vue;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Kururin
 */
public class Projectiles {

    private Image face = new Image("litte_baby.jpg");
    private String imageProj;
    private int vieProj;

    public int getVieProj() {
        return vieProj;
    }

    public void setVieProj(int vieProj) {
        this.vieProj = vieProj;
    }

    public boolean isEnVie() {
        return enVie;
    }

    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }
    boolean enVie;

    public Projectiles() throws SlickException {
    }
}