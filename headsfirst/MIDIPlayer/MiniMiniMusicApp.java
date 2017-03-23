package HeadsFirst.MIDIPlayer;

import javax.sound.midi.*;

/**
 * Created by Кира on 21.05.2016.
 */
public class MiniMiniMusicApp {

    public static void main(String[] args){

        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();



    }

    private void play() {

        try{
            Sequencer player = MidiSystem.getSequencer();

            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 38, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);


            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 38, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);


            player.setSequence(seq);

            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
