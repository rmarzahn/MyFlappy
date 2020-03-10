/**
 * Projekt: My Flappy
 * @author Group1: Miriam Bucken, Biana Eichentopf, Vincent Gottschling, Rebecca Marzahn
 * @version V1 08.03.2020
 */

package myflappy;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Variablen {
	
	
	//static Objekte, damit in der Main den Kontruktor aufrufen zu k�nnen
	public static  MyFlappy flappybird;
	//H�he und Breite des jframes in Variablen festlegen, damit die Werte im Falle von �nderungen nur an einer Stelle angepasst werden m�ssen
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 700;
	//Variable Positionierung des Hintergrunds wird auf 0 gesetzt
	public static int backgroundX1 = 0;
	//Startkoordinaten der Spielfigur
	public static int birdx = 350, birdy = 350;
	//Objekt der Klasse renderer die genutzt wird, um die Components im Frame anzuzeigen
	public static Renderer renderer;
	//Anzeige der Geschwindigkeitserh�hung ist zu Beginn inaktiv
	public static boolean speedUp = false;
	
	//Spielfigur
	public static Rectangle bird;
	
	//yMotion legt die Bewegung der Spielfigur in yRichtung pro Frame fest
	public static int yMotion;
	// Score, Geschwindigkeit und Weltvariable wird definiert
	public static int score = 18;
	public static int speed = 8;
	public static int welt = 0;
	
	//Hilfsvariablen um zu pr�fen, ob das Game started oder over ist
	public static boolean gameOver;
	public static boolean started;
	public static boolean start;
	
	//ArrayList aller S�ulen
	public static ArrayList<Rectangle> columns;
	
	//Variablen rand und menu werden gesetzt
	public static Random rand;
	public static Menu menu;
	
}
