package org.example.exercises.oop;

public class MultimediaAudio extends MultimediaItem{

    public MultimediaAudio(String title) {
        super(title);
    }

    @Override
    public void play() {
        System.out.println("MultimediaAudio" + title + " plays");
    }

    @Override
    public void stop() {
        System.out.println("MultimediaAudio" + title + " stops");
    }
}
