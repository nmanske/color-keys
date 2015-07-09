public class KeyPress {

	private static final int PIANO_KEY_COUNT = 8;
	private static final String[] WHITE_PIANO_KEYS = {"C", "D", "E", "F", "G", "A", "B", "C_OCTAVE"};
	private static final String[] INSTRUMENTS = {"PIANO", "CHURCH_ORGAN", "GUITAR", "FRETLESS BASS", "VIOLIN", "FRENCH_HORN", "SITAR", "BAGPIPE"}

	private enum whitePianoKeys { C, D, E, F, G, A, B, C_OCTAVE }

	private int currentOctave = 4;	//DEFAULT VALUE
	private String currentInstrument = INSTRUMENTS[0];

	private boolean reset = false;
	private boolean[] pianoKeyPressed = new boolean [PIANO_KEY_COUNT]; // A-D and J-;
	private boolean blackKeyEnable = false; // SHIFT
	private boolean toggleRhythm = false; // U
	
	private long lastPressProcessed = 0;

	public String toMusicString() {
		String musicString = "I[" + currentInstrument + "] ";
		
		for (int note = 0; note < PIANO_KEY_COUNT; note++) {
		
			if (pianoKeyPressed[note] == true) 
				musicString += WHITE_PIANO_KEYS[note] + currentOctave;
				
			if (blackKeyEnable == true && (note == D || note == E || note == G || note == A || note == B)) 
				musicString += "b";
			
			musicString += " ";
		}
		
		return musicString;
	}

	public void keyPressed(KeyEvent e) {
		
		int keys = e.getKeyCode();
		
		if (keys == KeyEvent.VK_ESCAPE)		
			System.exit(0);
			
		if (keys == KeyEvent.VK_R)			/* RESET BUTTON */
			reset = true;
			
		if (keys == KeyEvent.VK_SHIFT)
			blackKeyToggle = true;
		
		if (keys == KeyEvent.VK_A) 			/* WHITE PIANO KEYS */
			whiteKeyPressed[C] = true;
		if (keys == KeyEvent.VK_S) 
			whiteKeyPressed[D] = true;
		if (keys == KeyEvent.VK_D) 
			whiteKeyPressed[E] = true;
		if (keys == KeyEvent.VK_F) 
			whiteKeyPressed[F] = true;
		if (keys == KeyEvent.VK_J) 
			whiteKeyPressed[G] = true;
		if (keys == KeyEvent.VK_K) 
			whiteKeyPressed[A] = true;
		if (keys == KeyEvent.VK_L)
			whiteKeyPressed[B] = true;
		if (keys == KeyEvent.VK_SEMICOLON)
			whiteKeyPressed[C_OCTAVE] = true;
			
		if(System.currentTimeMillis() - lastPressProcessed > 500) {
		
			if (keys == KeyEvent.VK_U)			/* TOGGLE RHYTHM */
				toggleRhythm = true;
		
			if (keys == KeyEvent.VK_I) {		/* CHANGE INSTRUMENT */
				if (INSTRUMENTS.indexOf(currentInstrument) == INSTRUMENTS.length - 1)
					currentInstrument = INSTRUMENTS[0];
				else
					currentInstrument = INSTRUMENTS[INSTRUMENTS.indexOf(currentInstrument) + 1];
			}
				
			if (keys == KeyEvent.VK_T)			/* DECREASE AND INCREASE OCTAVE */
				currentOctave--;
		
			if (keys == KeyEvent.VK_Y)
				currentOctave++;
			
			lastPressProcessed = System.currentTimeMillis();
		}
	}

	public void keyReleased(KeyEvent e) {

		int keys = e.getKeyCode();

		if (keys == KeyEvent.VK_R)
			reset = false;
			
		if (keys == KeyEvent.VK_SHIFT)
			blackKeyToggle = false;
		
		if (keys == KeyEvent.VK_A)
			whiteKeyPressed[A] = false;
		if (keys == KeyEvent.VK_S) 
			whiteKeyPressed[S] = false;
		if (keys == KeyEvent.VK_D) 
			whiteKeyPressed[D] = false;
		if (keys == KeyEvent.VK_F) 
			whiteKeyPressed[F] = false;
		if (keys == KeyEvent.VK_J) 
			whiteKeyPressed[J] = false;
		if (keys == KeyEvent.VK_K) 
			whiteKeyPressed[K] = false;
		if (keys == KeyEvent.VK_L)
			whiteKeyPressed[L] = false;
		if (keys == KeyEvent.VK_SEMICOLON)
			whiteKeyPressed[SEMICOLON] = false;
			
		if (keys == KeyEvent.VK_U)
			toggleRhythm = false;

	}
	
}
