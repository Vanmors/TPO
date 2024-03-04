package org.example.task3;

// Объект, представляющий ложные стабилизаторы
public class FakeStabilizers {
    private boolean lowered;

    public void lowerIntoWater(Sea sea) {
        lowered = true;
        sea.createWaves();
        sea.madeWalWaves();
    }

    public void riseFromTheWater(Sea sea) {
        lowered = false;
        sea.createWaves();
        sea.madeWalWaves();
    }

    public boolean isLowered() {
        return lowered;
    }
}
