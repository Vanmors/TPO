package org.example.task3;


public class PresidentialYacht {
    private IonizedCushion ionizedCushion;
    private FakeStabilizers fakeStabilizers;
    private YachtState state;

    public PresidentialYacht(IonizedCushion ionizedCushion, FakeStabilizers fakeStabilizers) {
        this.ionizedCushion = ionizedCushion;
        this.fakeStabilizers = fakeStabilizers;
        this.state = YachtState.STOPPED;
    }

    // Метод для движения катера по волнам
    public void moveOnWaves(Sea sea) {
        if (ionizedCushion != null && state == YachtState.MOVING) {
            ionizedCushion.activate();
        }

        if (fakeStabilizers != null && state == YachtState.MOVING) {
            fakeStabilizers.lowerIntoWater(sea);
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

    public YachtState getState() {
        return state;
    }
}
