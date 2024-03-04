package org.example.task3;


public class PresidentialYacht {
    private IonizedCushion ionizedCushion;
    private FakeStabilizers fakeStabilizers;
    private YachtState state;

    private int speed = 0;

    public PresidentialYacht(IonizedCushion ionizedCushion, FakeStabilizers fakeStabilizers, int speed) {
        this.ionizedCushion = ionizedCushion;
        this.fakeStabilizers = fakeStabilizers;
        this.state = YachtState.STOPPED;
        this.speed = speed;
    }

    // Метод для движения катера по волнам
    //todo ДОБАВИТЬ широкие дуги тут
    public void moveOnWaves(Sea sea) {
        if (ionizedCushion != null && state == YachtState.MOVING) {
            ionizedCushion.activate();
        }

        if (fakeStabilizers != null && state == YachtState.MOVING) {
            fakeStabilizers.lowerIntoWater(sea);
        }
    }

    //todo А тут широкие дуги убираются.
    //это гладь.
    public void moveOnSmoothWater(Sea sea){
        if (ionizedCushion != null && state == YachtState.MOVING) {
            ionizedCushion.deactivate();
            speed -= 20;
        }

        if (fakeStabilizers != null && state == YachtState.MOVING) {
            fakeStabilizers.riseFromTheWater(sea);
            speed += 20;
        }
    }

    // Метод для остановки катера
    public void stop() {
        state = YachtState.STOPPED;
        speed = 0;
    }

    // Метод для старта катера
    public void start() {
        state = YachtState.MOVING;
        speed = 100;
    }

    public YachtState getState() {
        return state;
    }

    public IonizedCushion getIonizedCushion(){
        return ionizedCushion;
    }

    public FakeStabilizers getFakeStabilizers(){
        return fakeStabilizers;
    }
}
