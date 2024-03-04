package org.example.task3;

public class Sea {
    public boolean waves;

    public Sea() {
        waves = false;
    }

    public void createWaves() {
        waves = true;
    }

    public void removeWaves(){
        waves = false;
    }
}