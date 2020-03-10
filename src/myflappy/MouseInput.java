/**
 * Projekt: My Flappy
 * @author Group1: Miriam Bucken, Biana Eichentopf, Vincent Gottschling, Rebecca Marzahn
 * @version V1 08.03.2020
 */

package myflappy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	/**
	 * Methode mouseClicked steuert bei Klicken der Maus in bestimmtem Men�bereich der jeweiligen Buttons die Auswahl der Welt durch das Setzen der entsprechenden Weltenvariable
	 */
	public void mouseClicked(MouseEvent e) {
		
		//definiert die Koordinaten des Mausklicks
		int mx = e.getX();
		int my = e.getY();
		
		//Pr�fung der Koordinaten des Mausklicks
		if(mx >= 50 && mx <= 350) {
			//Setzen der Weltenvariablen bei Klick in bestimmtem Men�bereich
			//Setzen der Spielvariablen auf Start, GameOver auf false
			if(my >= 420 && my <= 500) {
				//PlayW1
				Variablen.welt = 1;
				Variablen.gameOver = false;
				Variablen.started= true;
				Variablen.start = true;
			}
		}
		
		if(mx >= 450 && mx <= 750) {
			if(my >= 420 && my <= 500) {
				//PlayW2
				Variablen.welt = 2;
				Variablen.gameOver = false;
				Variablen.started= true;
				Variablen.start = true;
			}
		}
		if(mx >= 850 && mx <= 1150) {
			if(my >= 420 && my <= 500) {
				//PlayW3
				Variablen.welt = 3;
				Variablen.gameOver = false;
				Variablen.started= true;
				Variablen.start = true;
			}
		}
		
		//Klick auf den Men�button setzt Spielvariablen auf false		
		if (mx >= 1100 && mx <= 1200) {
			if(my >= 0 && my <= 60) {
				Variablen.gameOver = false;
				Variablen.started = false;
				Variablen.start = false;
			}
		}
	}	

	/**
	 * Methode mousePressed wird f�r Spielverlauf nicht ben�tigt
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode mouseReleased wird f�r Spielverlauf nicht ben�tigt
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode mouseEntered wird f�r Spielverlauf nicht ben�tigt
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Methode mouseExited wird f�r Spielverlauf nicht ben�tigt
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
