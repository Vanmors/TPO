package org.example.task3;


//todo добавить то, где находится катер - мыс, залив и т д.
public class PresidentialYacht {
    private IonizedCushion ionizedCushion;
    private FakeStabilizers fakeStabilizers;
    private YachtState state;

    // Конструктор
    public PresidentialYacht(IonizedCushion ionizedCushion, FakeStabilizers fakeStabilizers) {
        this.ionizedCushion = ionizedCushion;
        this.fakeStabilizers = fakeStabilizers;
        this.state = YachtState.STOPPED; // Изначально катер стоит
    }

    // Метод для движения катера по волнам
    public void moveOnWaves(Sea sea) {
        if (ionizedCushion != null && state == YachtState.MOVING) {
            // Катер держится на подушке из ионизированных атомов
        }

        if (fakeStabilizers != null && state == YachtState.MOVING) {
            fakeStabilizers.lowerIntoWater(sea); // Опускаем фиктивные стабилизаторы
        }
    }

    // Метод для остановки катера
    public void stop() {
        state = YachtState.STOPPED;
    }

    // Метод для старта катера
    public void start() {
        state = YachtState.MOVING;
    }
}
