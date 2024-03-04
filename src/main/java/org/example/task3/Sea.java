package org.example.task3;

public class Sea {
    public boolean waves;
    public boolean walWaves;

    public Sea() {
        waves = false;
        walWaves = false;
    }

    public void createWaves() {
        waves = true;
    }

    public void madeWalWaves() {
        walWaves = true;
    }

    public void removeWalWaves() {
        walWaves = false;
    }
    public void removeWaves(){
        waves = false;
    }
}