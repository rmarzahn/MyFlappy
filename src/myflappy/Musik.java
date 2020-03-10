/**
 * Projekt: My Flappy
 * @author Group1: Miriam Bucken, Biana Eichentopf, Vincent Gottschling, Rebecca Marzahn
 * @version V1 08.03.2020
 */

package myflappy;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musik {	
	
	/**
	 * Methode music erm�glicht das Einlesen und Abspielen von Musikclips
	 * @param track speichert die URL des ausgew�hlten Musikclips
	 */
	public static synchronized void music(String track) {
		final String trackname = track;
		//initalisiert einen neuen Thread, um das Abspielen parallel zum Spielen zu erm�glichen
		new Thread (new Runnable() {
			/**
			 * Methode run definiert das Einlesen und Abspielen des Musikclips (sowie die Anzahl des Abspielens) 
			 */
			//INDIVIDUALISIERUNG: Hier k�nnen die Soundeffekte ver�ndert werden
			//(n�here Informationen: siehe Benutzerhandbuch)
			public void run() {
				//while (true) {
					try {
						//definiert einen clip, welche einen Audioclip enth�lt
						Clip clip = AudioSystem.getClip();
						//definiert einen inputStream, welcher einen Audioinput als neuen track speichert
						AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File (trackname));
						//�ffnet den inputStream
						clip.open(inputStream);
						//Loop 0 = keine Wiederholung, Loop 1 = eine Wiederholung also zwei mal abspielen
						clip.loop(0);
						//clip.loop(Clip.LOOP_CONTINUOUSLY);
						Thread.sleep(clip.getMicrosecondLength()/1000);						
					}
					catch (Exception e){
						System.out.println("Musikclip kann nicht geladen werden!");
						e.printStackTrace();
					}
				//}
			}
		}).start();
	}
}


