package africa.semicolon.mp3;

import java.util.ArrayList;

import static africa.semicolon.mp3.MusicState.*;

public class Mp3Player {

    private boolean isOn;
    private ArrayList<Music> musicList = new ArrayList<>();
    //private Music[] musicList; [for fixed length]
    private int totalNumberOfMusic;
    private Music currentlyPlayingMusic;
    private MusicState currentMusicState = STOPPED;

   /* public Mp3Player(int numberOfMusic) {
        musiclist = new Music[numberOfMusic]; [Constructor}

    }*/

   /* public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }*/

    public boolean isOn() {
        return isOn;
    }


    public void flipPowerButton() {

        isOn = !isOn;
    }

    public void download(Music music) {
        if (isOn)
           if (!musicList.contains(music));
           musicList.add(music);
    }

    public int getTotalNumberMusic() {

        return musicList.size();
    }

    public void delete(Music music) {
        if(isOn)
       musicList.remove(music);
    }

    public void play(Music ajibole) {
        currentlyPlayingMusic = ajibole;
        currentMusicState = PLAYING;

    }

    public MusicState getMusicState() {

        return currentMusicState;
    }

    public Music getCurrentlyPlayingMusic() {
        return currentlyPlayingMusic;
    }

    public void pauseMusic(Music ajibole) {

        currentMusicState = PAUSED;
    }

    public void stopMusic() {

        currentMusicState = STOPPED;
    }
}