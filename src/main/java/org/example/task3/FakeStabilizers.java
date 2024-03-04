package org.example.task3;

// Объект, представляющий ложные стабилизаторы
public class FakeStabilizers {
    private boolean lowered;

    public void lowerIntoWater(Sea sea) {
        lowered = true;
        sea.createWaves();
    }

    public void riseFromTheWater(Sea sea) {
        lowered = false;
        sea.createWaves();
    }

    public boolean isLowered() {
        return lowered;
    }
}
