import org.jfugue.realtime.*;
import org.jfugue.rhythm.Rhythm;

public class ColorKeysSound {

	private RealtimePlayer player;
	private Rhythm rhythm;
    private String musicString;

    public Sound(String musicString) {
		this.player = new RealtimePlayer();
		this.rhythm = new Rhythm();
        this.musicString = musicString;
    }

    public static void play() {
		player.play(musicString);
    }

}
