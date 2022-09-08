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
			bgm = AudioSystem.getAudioInputStream(new File("HarryPotterBGM.wav"));	// wav파일 불러오기
			
			clip = AudioSystem.getClip();
			clip.open(bgm);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void Play() {	// BGM On
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);	// 창 닫기 전까지 반복
	}

	public static void Stop() {	// BGM Off
		clip.stop();
	}
}
