/**
 * Projekt: My Flappy
 * @author Group1: Miriam Bucken, Biana Eichentopf, Vincent Gottschling, Rebecca Marzahn
 * @version V1 08.03.2020
 */

package myflappy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage img1;
	public static BufferedImage img2;
	public static BufferedImage img3;
	public static BufferedImage ibird;
	
	/**
	 * Konstruktor ImageLoader l�dt die f�r das Spiel ben�tigten Bilder ein (Hintergrund, Spielfigur), wenn das nicht m�glich ist, wird eine Fehlermeldung ausgegeben
	 */
	public ImageLoader() {
		try {
			//INDIVIDUALISIERUNG: Hier kann der Hintergrund der ersten Welt ver�ndert werden (n�here Informationen: siehe Benutzerhandbuch)
			img1 = ImageIO.read(new File("res/water.jpg"));
			//INDIVIDUALISIERUNG: Hier kann die Spielfigur der ersten Welt ver�ndert werden (n�here Informationen: siehe Benutzerhandbuch)
			ibird = ImageIO.read(new File("res/bird.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bilder k�nnen nicht geladen werden!");
		}			
		
		try {
			//INDIVIDUALISIERUNG: Hier kann der Hintergrund der zweiten Welt ver�ndert werden (n�here Informationen: siehe Benutzerhandbuch)
			img2 = ImageIO.read(new File("res/bg.png"));
			//INDIVIDUALISIERUNG: Hier kann die Spielfigur der zweiten Welt ver�ndert werden (n�here Informationen: siehe Benutzerhandbuch)
			ibird = ImageIO.read(new File("res/bird.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bilder k�nnen nicht geladen werden!");
		}
		try {
			//INDIVIDUALISIERUNG: Hier kann der Hintergrund der dritten Welt ver�ndert werden (n�here Informationen: siehe Benutzerhandbuch)
			img3 = ImageIO.read(new File("res/space2.jpeg"));
			//INDIVIDUALISIERUNG: Hier kann die Spielfigur der dritten Welt ver�ndert werden (n�here Informationen: siehe Benutzerhandbuch)
			ibird = ImageIO.read(new File("res/bird.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bilder k�nnen nicht geladen werden!");
		}
	}
		
}
	
