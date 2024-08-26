package org.example.exercises.oop;

public class MultimediaVideo extends MultimediaItem{

    public MultimediaVideo(String title) {
        super(title);
    }

    @Override
    public void play() {
        System.out.println("MultimediaVideo" + title + "plays");
    }

    @Override
    public void stop() {
        System.out.println("MultimediaVideo" + title + "stops");
    }
}
