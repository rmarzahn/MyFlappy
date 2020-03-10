/**
 * Projekt: My Flappy
 * @author Group1: Miriam Bucken, Biana Eichentopf, Vincent Gottschling, Rebecca Marzahn
 * @version V1 08.03.2020
 */

package myflappy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Menu {
	
	//Men�button f�r die drei Welten werden initalisiert
	public static Rectangle playButtonW1 = new Rectangle(50, 420, 300, 80);
	public static Rectangle playButtonW2 = new Rectangle(450, 420, 300, 80);
	public static Rectangle playButtonW3 = new Rectangle(850, 420, 300, 80);
		
	/**
	 * Methode render zeichnet die Bilder, Objekte und Schriftz�ge des Men�s
	 * @param g �bergibt Objekt g der Klasse Graphics
	 */
	public static void render(Graphics g) {
		
		
		Graphics2D g2d = (Graphics2D) g;
		
		//setzt den Hintergrund auf die Gr��e des Ausgabefensters in der Farbe grau
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1200, 700);
		
		//zeichnet die Weltenhintergr�nde und die Spielfigur im Men�
		g.drawImage(ImageLoader.img1, 50, 220, 300, 200, null);
		g.drawImage(ImageLoader.img2, 450, 220, 300, 200, null);
		g.drawImage(ImageLoader.img3, 850, 220, 300, 200, null);
		g.drawImage(ImageLoader.ibird, 130, 260, 150, 120, null);
		g.drawImage(ImageLoader.ibird, 530, 260, 150, 120, null);
		g.drawImage(ImageLoader.ibird, 930, 260, 150, 120,null);
		
		//definiert eine Schriftart und -gr��e und zeichnet die �berschrift des Men�s
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("My Flappy", 350, 120);
				
		//definiert eine Schriftart und -gr��e und zeichnet die Beschriftung der Men�button
		Font fnt1 = new Font("arial", Font.BOLD, 40);
		g.setFont(fnt1);
		g.drawString("Water World", playButtonW1.x+30, playButtonW1.y+55);
		g.drawString("Classic World", playButtonW2.x+15, playButtonW2.y+55);
		g.drawString("Space World", playButtonW3.x+30, playButtonW3.y+55);
		g2d.draw(playButtonW1);
		g2d.draw(playButtonW2);
		g2d.draw(playButtonW3);
		
		//definiert eine Schriftart und -gr��e und zeichnet den Hilfstext im Men�
		Font fnt2 = new Font("arial", Font.BOLD, 15);
		g.setFont(fnt2);
		g.drawString("Willkommen! - Klicke auf den Button der Welt, in welcher Du spielen m�chtest. Um deinen Bird springen zu lassen, dr�cke die Leertaste.", 50, 550);
		g.drawString("Bewege den Bird zwischen den Rohren hindurch, um den Score zu erh�hen. Ber�hrt der Bird dabei allerdings ein Rohr, den oberen oder den unteren", 50, 570);
		g.drawString("Spielrahmen, ist das Spiel beendet. Um das Spiel erneut zu starten, dr�cke die Leertaste. Wenn Du ins Men� zur�ckkehren m�chtest, klicke auf den", 50, 590);
		g.drawString("roten Button in der rechten oberen Ecke. Viel Erfolg und guten Flug!", 50, 610);
		
		//zeichnet den Men�button
		g.setColor(Color.red);
		g.fillOval(1145, 15, 30, 30);
		
		
	}
	
}
