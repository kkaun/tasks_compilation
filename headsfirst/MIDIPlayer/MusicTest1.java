package HeadsFirst.MIDIPlayer;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * Created by Кира on 21.05.2016.
 */
public class MusicTest1 {

    public void play(){
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Успешно получили синтезатор");
        }
        catch(MidiUnavailableException e){
            System.out.println("Неудача");
        }
    }

}
