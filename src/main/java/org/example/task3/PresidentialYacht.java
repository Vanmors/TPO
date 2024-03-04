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
        }

        if (fakeStabilizers != null && state == YachtState.MOVING) {
            fakeStabilizers.riseFromTheWater(sea);
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

    public IonizedCushion getIonizedCushion(){
        return ionizedCushion;
    }

    public FakeStabilizers getFakeStabilizers(){
        return fakeStabilizers;
    }
}
