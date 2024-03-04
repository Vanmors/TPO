package org.example.task3;


public class PresidentialYacht {
    private IonizedCushion ionizedCushion;
    private FakeStabilizers fakeStabilizers;

    private YachtBottom yachtBottom;
    private YachtState state;

    public PresidentialYacht(IonizedCushion ionizedCushion, FakeStabilizers fakeStabilizers, YachtBottom yachtBottom) {
        this.ionizedCushion = ionizedCushion;
        this.fakeStabilizers = fakeStabilizers;
        this.yachtBottom = yachtBottom;
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

        if (yachtBottom != null && state == YachtState.MOVING) {
            yachtBottom.BottomsUp();
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

        if (yachtBottom != null && state == YachtState.MOVING) {
            yachtBottom.BottomsDown();
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

    public YachtBottom getYachtBottom() {
        return yachtBottom;
    }
}
