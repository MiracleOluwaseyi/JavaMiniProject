package africa.semicolon.mp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static africa.semicolon.mp3.MusicState.*;
import static org.junit.jupiter.api.Assertions.*;

public class Mp3Test {

    Mp3Player myMp3Player;
    @BeforeEach
    void startWithThis(){
     myMp3Player = new Mp3Player();
    }
    @Test
    void mp3Player_canBeCreated(){

        assertNotNull(myMp3Player);
        }
    /*@Test
    void  mp3Player_canBeTurnedOn(){
        Mp3Player myMp3Player = new Mp3Player();
        assertFalse(myMp3Player.isOn());
        myMp3Player.turnOn();
        assertTrue(myMp3Player.isOn());
    }

    @Test
    void  mp3Player_canBeTurnedOff(){
        Mp3Player myMp3Player = new Mp3Player();
        myMp3Player.turnOn();
       assertTrue(myMp3Player.isOn());
        myMp3Player.turnOff();
        assertFalse(myMp3Player.isOn());
    }*/


    @Test
    void mp3Player_turnsOn_whenFlipPowerButtonIsPressed_onOnState(){
        //given
        myMp3Player.flipPowerButton();
        boolean isOn = myMp3Player.isOn();
        assertTrue(isOn);

        //When
        myMp3Player.flipPowerButton();
        //assert
        assertFalse(myMp3Player.isOn());
    }

    @Test
    void mp3Player_turnsOn_whenFlipPowerButtonIsPressed_onOffState(){
       boolean isOff = !myMp3Player.isOn();
        assertTrue(isOff);

        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
    }

    @Test
    void mp3Player_canDownloadMusic(){
        //given
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        assertNotNull(music);

        //when
        myMp3Player.download(music);
        //assert
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        Music  secondMusic = new Music();
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberMusic());
    }

    @Test
    void mp3Player_cantDownloadMusic_whenPlayerIsOff(){
        //given
        assertFalse(myMp3Player.isOn());
        Music music = new Music();
        assertNotNull(music);

        //when
        myMp3Player.download(music);

        //assert
        assertEquals(0, myMp3Player.getTotalNumberMusic());
        Music secondMusic = new Music();
        myMp3Player.download(secondMusic);
        assertEquals(0, myMp3Player.getTotalNumberMusic());
    }

    @Test
    void mp3Player_canDeleteDownloadedMusic(){
        //given
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        Music secondMusic = new Music();
        myMp3Player.download(music);
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberMusic());

        //when
        myMp3Player.delete(music);
        //assert
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        myMp3Player.delete(music);
        //assert
        assertEquals(0, myMp3Player.getTotalNumberMusic());
    }

    @Test
    void mp3Player_cantDelete_whenMusicIsEmpty(){
        //given
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        Music secondMusic = new Music();
        myMp3Player.download(music);
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberMusic());

        //when
        myMp3Player.delete(music);
        //assert
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        myMp3Player.delete(music);
        //assert
        assertEquals(0, myMp3Player.getTotalNumberMusic());

       }

    @Test
    void mp3Player_cantDelete_whenMusicPlayerIsOff(){
        //given
        myMp3Player.flipPowerButton();
        Music music = new Music();
        myMp3Player.download(music);
        myMp3Player.flipPowerButton();

        assertFalse(myMp3Player.isOn());
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        //when
        myMp3Player.delete(music);
        //assert
        assertEquals(1, myMp3Player.getTotalNumberMusic());
       }

    @Test
    void mp3Player_cannotDownloadSameSongTwice(){
        myMp3Player.flipPowerButton();
        Music music = new Music();
        myMp3Player.download(music);
        assertEquals(1, myMp3Player.getTotalNumberMusic());

        //when
        myMp3Player.download(music);
        //assert
        assertEquals(1, myMp3Player.getTotalNumberMusic());

    }

   @Test
   void mp3Player_canPlayMusic(){
       myMp3Player.flipPowerButton();
       Music ajibole = new Music();
       myMp3Player.download(ajibole);
       assertEquals(1, myMp3Player.getTotalNumberMusic());

       //when
       myMp3Player.play(ajibole);
       //assert
       assertEquals(PLAYING, myMp3Player.getMusicState());
       assertEquals(ajibole, myMp3Player.getCurrentlyPlayingMusic());
   }

    @Test
    void mp3Player_canPauseMusic(){
        myMp3Player.flipPowerButton();
        Music ajibole = new Music();
        myMp3Player.download(ajibole);
        assertEquals(1, myMp3Player.getTotalNumberMusic());
        myMp3Player.play(ajibole);


        //when
        myMp3Player.pauseMusic(ajibole);
        //assert
        assertEquals(PAUSED, myMp3Player.getMusicState());
        assertEquals(ajibole, myMp3Player.getCurrentlyPlayingMusic());
    }

    @Test
    void mp3Player_canStopMusic(){
          myMp3Player.flipPowerButton();
    Music ajibole = new Music();
        myMp3Player.download(ajibole);
    assertEquals(1, myMp3Player.getTotalNumberMusic());
    myMp3Player.play(ajibole);


    //when
        myMp3Player.stopMusic();
    //assert
    assertEquals(STOPPED, myMp3Player.getMusicState());
    }





}
