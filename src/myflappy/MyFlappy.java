/**
 * Projekt: My Flappy
 * @author Group1: Miriam Bucken, Biana Eichentopf, Vincent Gottschling, Rebecca Marzahn
 * @version V1 08.03.2020
 */

package myflappy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MyFlappy implements ActionListener, KeyListener{
	
	/**
	 * Konstruktor MyFlappy ruft die Funktionalit�ten des Spiels auf, welche auf Konstruktoraufrufen und Objektaufrufen beruht
	 */
	public MyFlappy() {
		
		/**
		 * Ausgabefenster des Spiels und Objekte der Klasse JFrame werden erzeugt
		 */
		JFrame jframe = new JFrame();

		/**
		 * Objekt wird alle 20 Millisekunden aufgerufen und sorgt f�r die Aktualisierungsgeschwindigkeit/Anpassung aller Objekte
		 */
		Timer timer = new Timer(20, this);		
		
		/**
		 * Renderer, Random und Men� Konstruktoren der definierten Klasse werden aufgerufen
		 */
		Variablen.renderer = new Renderer();
		Variablen.rand = new Random();
		Variablen.menu = new Menu();
		
		// Reneder Components werden dem jframe hinzugef�gt
		jframe.add(Variablen.renderer);	
		// Titel des jframes wird auf My Flappy gesetzt
		jframe.setTitle("My Flappy");
		// Ausf�hrung des Spiels wird beendet, wenn das Ausgabefenster geschlossen wird
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// H�he und Breite des Ausgabefensters wird definiert
		jframe.setSize(Variablen.WIDTH, Variablen.HEIGHT);
		// Funktionalit�t der Leertastenbedienung wird im Ausgabefenster hinzugef�gt
		jframe.addKeyListener(this);
		// Funktionalit�t der Mausbedienung wird im Ausgabefenster hinzugef�gt
		jframe.addMouseListener(new MouseInput());
		// Gr��enver�nderung des Ausgabefensters wird deaktiviert
		jframe.setResizable(false);
		//Sichtbarkeit des Ausgabefensters wird aktiviert
		jframe.setVisible(true);
		
		
		/**
		 * Spielfigur wird initialisiert 
		 */
		Variablen.bird = new Rectangle(Variablen.birdx, Variablen.birdy, 40, 35);
		/**
		 * S�ulen des Spiels werden als dynamische ArrayList initialisiert
		 */
		Variablen.columns = new ArrayList<Rectangle>();
		
		//Vier Anfangss�ulen werden initialisiert
		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);
			
		//Timer wird gestartet
		timer.start();
	}
	
	/**
	 * Methode addColum definiert und setzt neue S�ulen im Spiel
	 * @param start setzt neue S�ulen, wenn das Spiel aktiv l�uft
	 */
	public static void addColumn(boolean start) {
			
			// H�he, Breite und Abstand der S�ulen wird festgelegt
			int space = 300;
			int width = 100;
			int height = 50 + Variablen.rand.nextInt(300);
			
			if (start) {
				// neue obere und untere S�ulen werden im festgelegten Abstand und Position hinzugef�gt, wenn das Spiel aktiv l�uft
				// S�ulen sind zu Beginn au�erhalb des Bildschirms, alle S�ulenpaare mit Abstand 2*300 Pixel
				Variablen.columns.add(new Rectangle(Variablen.WIDTH + width + Variablen.columns.size() * 300, Variablen.HEIGHT - height - 120, width, height));
				Variablen.columns.add(new Rectangle(Variablen.WIDTH + width + (Variablen.columns.size() -1) * 300, 0, width,  Variablen.HEIGHT - height - space));
			}
			else {
				// neue obere und untere S�ulen werden im festgelegten Abstand und Position hinzugef�gt, wenn das Spiel noch nicht aktiv l�uft
				// zur x-Position der letzten S�ule wird Abstand 600 addiert
				Variablen.columns.add(new Rectangle(Variablen.columns.get(Variablen.columns.size() - 1).x + 600, Variablen.HEIGHT - height - 120, width, height));
				Variablen.columns.add(new Rectangle(Variablen.columns.get(Variablen.columns.size() - 1).x, 0, width, Variablen.HEIGHT - height - space));
			}
	}
	
	/**
	 * Methode paintColumn zeichnet die S�ulen im Spiel
	 * @param g �bergibt Objekt g der Klasse Graphics 
	 * @param column beschreibt die zu zeichnende S�ule
	 */
	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
		
	}
	
	/**
	 * Methode jump bildet die Funktionalit�t des Sprungs der Spielfigur ab
	 */
	public static void jump() {
		
		// Pr�fung des Spielstatus		
		if (Variablen.gameOver) {
			
			/**
			 * Spielfigur wird initalisert, S�ulen und Score zur�ckgesetzt und Bewegung der Spielfigur unterbrochen
			 */
			Variablen.bird = new Rectangle(Variablen.birdx, Variablen.birdy, 40, 35); 
			Variablen.columns.clear();
			Variablen.yMotion = 0;
			Variablen.score = 0;
			
			// Vier Anfangss�ulen werden initialisiert
			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);
			
			Variablen.gameOver = false;
		}
		
		
		if (!Variablen.started) {
			Variablen.started = true;
		}
		else if (!Variablen.gameOver) {
			
			//Spielfigur beibt f�r einen Frame in der Luft stehen, wewnn sie vor dem Sprung im Fallen war
			if (Variablen.yMotion > 0) {
				Variablen.yMotion = 0;
			}
			//Spielfigur geht um 10 Einheiten nach oben pro Frame (und um speed Einheiten nach rechts)
			Variablen.yMotion -= 10;
		}
	}
	
	
	/**
	 * Methode actionPerformed bildet die Bewegung der Spieligur ab, wenn eine Spielfunktion im aktiven Spiel durch den Spieler ausgef�hrt wurde und steuert die Geschwindigkeitserh�hung
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (Variablen.start == true) {
			
			if (Variablen.started) {
			
			//Geschwindigkeit der S�ulen nach links (Einheiten pro Frame)
			int speed = 8;
			
			//Geschwindigkeitserh�hung bei Erreichen eines bestimmten Scores -> Ausgabe der Erh�hung als String im Ausgabefenster durch speedUp
			//INDIVIDUALISIERUNG: Hier kann der Speed der S�ulen ver�ndert werden 
			//(n�here Informationen: siehe Benutzerhandbuch)
			for (int i = 0; i < Variablen.columns.size(); i++) {
			
				if (Variablen.score < 20) {
					Rectangle column = Variablen.columns.get(i);
					speed = 8;
					column.x -= speed;
				}
				
				if (Variablen.score == 20) {
					Rectangle column = Variablen.columns.get(i);
					speed = 10;
					column.x -= speed;
					Variablen.speedUp = true;
				}
				
				if (Variablen.score > 20 && Variablen.score < 40) {
					Variablen.speedUp = false;
					Rectangle column = Variablen.columns.get(i);
					speed = 10;
					column.x -= speed;
				}
				
				if (Variablen.score == 40) {
					Rectangle column = Variablen.columns.get(i);
					speed = 15;
					column.x -= speed;
					Variablen.speedUp = true;
				}
				
				if (Variablen.score > 40) {
					Variablen.speedUp = false;
					Rectangle column = Variablen.columns.get(i);
					speed = 15;
					column.x -= speed;
				}
			}
			
			//Fallgeschwindigkeit wird beschleunigt			
			if (Variablen.yMotion < 15) {
				//bei jedem Frame nimmt Fallgeschwindigkeit um 1 zu
				Variablen.yMotion += 1;
			}
			
			//S�ule l�schen, wenn sie aus dem Bild verschwindet und neue hinzuf�gen
			for(int i = 0; i < Variablen.columns.size(); i++) {
				Rectangle column = Variablen.columns.get(i);
				
				if (column.x + column.width < 0) {
					Variablen.columns.remove(column);
					
					if (column.y == 0) {
						addColumn(false);
					}
				};
			}
			
			//Position von Spielfigur um yMotion Einheiten verschieben in yRichtung
			Variablen.bird.y += Variablen.yMotion;
			
			//Schleife �ber jeder S�ule
			for (Rectangle column : Variablen.columns) {
				
				//Score erh�hen, wenn Spielfigur unter der oberen S�ule ist
				if (!Variablen.gameOver && column.y== 0 && Variablen.birdx + 50 / 2 > column.x + column.width / 2 - 5 && Variablen.birdx + 50/ 2 < column.x + column.width / 2 + 5) {  //H�lfte Speed
					Variablen.score++;
					//INDIVIDUALISIERUNG: Hier kann der Score-Sound ver�ndert werden 
					//(n�here Informationen: siehe Benutzerhandbuch)
					Musik.music("audio/bing.wav");
				}
				
				//wenn Spielfigure auf eine S�ule trifft -> GameOver
				if (column.intersects(Variablen.bird)) {
					Variablen.gameOver = true;
					
					//Spielfigur soll links von de S�ule h�ngenbleiben
					if (Variablen.bird.x <= column.x) {
						Variablen.bird.x = column.x - Variablen.bird.width;
					}
					else {
						//Spielfigur soll au S�ule aufliegen und nicht durchfallen, wenn sie die untere S�ule trifft
						if (column.y != 0) {
							Variablen.bird.y = column.y - Variablen.bird.height;
						}
						//Spielfigur nicht weiter nach oben als untere Kante der oberen S�ule
						else if (Variablen.bird.y < column.height){
							Variablen.bird.y = column.height;
						}
					}
				}
			}
			
			//wenn Spielfigur den Boden oder die Decke trifft -> GameOver
			if (Variablen.bird.y > Variablen.HEIGHT - 150 || Variablen.bird.y < 0) {
				Variablen.gameOver = true;
			}
			
			if (Variablen.bird.y + Variablen.yMotion >= Variablen.HEIGHT - 130) {
				Variablen.bird.y = Variablen.HEIGHT - 120 - Variablen.bird.height;
			}
		}
		//gesamtes Frame wird neu gerendert und repainted
		Variablen.renderer.repaint();
		}
	}
	
	/**
	 * Methode repaint zeichnet Objekte des Frames durch die im Timer definierte Aktualisierungsgeschwindigkeit erneut
	 * @param g �bergibt Objekt g der Klasse Graphics 
	 */
	public void repaint(Graphics g) {
			
		//Boden
		g.setColor(Color.orange);
		g.fillRect(0, Variablen.HEIGHT - 120, Variablen.WIDTH, 100);
		
		//Gras
		g.setColor(Color.green);
		g.fillRect(0, Variablen.HEIGHT - 120, Variablen.WIDTH, 20);
		
		//Spieligur
		g.setColor(Color.yellow);
		g.fillOval(Variablen.bird.x, Variablen.bird.y, Variablen.bird.width, Variablen.bird.height);
		
		//S�ulen
		for (Rectangle column : Variablen.columns) {
			paintColumn(g, column);
		}
		
		//Men�punkt
		g.setColor(Color.red);
		g.fillOval(1145, 15, 30, 30);
		
		
		//Definition Schriftart/-gr��e
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 80));
		
		//wenn Game vorbei ist, Spielstand anzeigen
		if (Variablen.gameOver && Variablen.started) {
			g.drawString("Game Over!", 370, 150);
			g.drawString(String.valueOf(Variablen.score), Variablen.WIDTH / 2 - 30, 80);
		}
		
		
		//Score w�hrend des Games anzeigen -> wenn Speederh�hung, Ausgabe Erh�hung
		if (!Variablen.gameOver && Variablen.started) {
			g.drawString(String.valueOf(Variablen.score), Variablen.WIDTH / 2 - 25, 80);
			if (Variablen.speedUp) {
				g.setColor(Color.white);
				g.setFont(new Font("Arial", 1, 50));
				g.drawString("Speed up!", 500,  130);
			}
		}
	}

	/**
	 * Main Methode initialisiert die Objekte der Klassen und ruft die Konstruktoren auf
	 * Startpunkt des Programms
	 * @param args Argumente der Mainmethode
	 */
	public static void main(String[] args) {
		new Variablen();
		Variablen.flappybird = new MyFlappy();
		
	}

	/**
	 * Methode keyReleased steurert bei aktivem Spiel die Bewegung der Spielfigur, wenn die Leertaste durch den Spieler gedr�ckt wird und spielt dabei Sound ab
	 */
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (Variablen.started) {
			jump();
			//INDIVIDUALISIERUNG: Hier kann der Fl�gelschlag-Sound ver�ndert werden 
			//(n�here Informationen: siehe Benutzerhandbuch)
			Musik.music("audio/flap.wav"); 
			}
		}
	}

	
	
	
	
	
	
	//folgende Methoden werden f�r den direkten Spielverlauf ben�tigt, m�ssen aber f�r die Funktionalit�t bestimmter Klassen existieren

	/**
	 * Methode keyTyped wird f�r Spielverlauf nicht ben�tigt
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Methode keyPressed wird f�r Spielverlauf nicht ben�tigt
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}


