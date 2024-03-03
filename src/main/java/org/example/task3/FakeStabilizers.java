package org.example.task3;

// Объект, представляющий ложные стабилизаторы
public class FakeStabilizers {
    private boolean lowered;

    public void lowerIntoWater(Sea sea) {
        // Код для опускания стабилизаторов
        lowered = true;
        sea.createWaves();
    }

    public boolean isLowered() {
        return lowered;
    }
}
