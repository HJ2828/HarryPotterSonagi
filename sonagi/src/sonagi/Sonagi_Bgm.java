package sonagi;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sonagi_Bgm {
	AudioInputStream bgm;
	static Clip clip;
	
	public Sonagi_Bgm() {
		try {
			bgm = AudioSystem.getAudioInputStream(new File("HarryPotterBGM.wav"));	// wav���� �ҷ�����
			
			clip = AudioSystem.getClip();
			clip.open(bgm);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void Play() {	// BGM On
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);	// â �ݱ� ������ �ݺ�
	}

	public static void Stop() {	// BGM Off
		clip.stop();
	}
}
