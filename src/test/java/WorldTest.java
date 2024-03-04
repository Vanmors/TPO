import org.example.task3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTest {
    @Test
    public void testPresidentialYachtInitialState() {
        PresidentialYacht presidentialYacht = new PresidentialYacht(null, null, 0);

        assertEquals(YachtState.STOPPED, presidentialYacht.getState()); // Проверка начального состояния
    }

    @Test
    public void testYachtMovementOnWaves() {
        YachtBottom yachtBottom = new YachtBottom();
        IonizedCushion ionizedCushion = new IonizedCushion(yachtBottom);
        FakeStabilizers fakeStabilizers = new FakeStabilizers();
        PresidentialYacht presidentialYacht = new PresidentialYacht(ionizedCushion, fakeStabilizers, 0);
        Sea sea = new Sea();

        presidentialYacht.start(); // Тестирование запуска катера
        assertEquals(YachtState.MOVING, presidentialYacht.getState());

        presidentialYacht.moveOnWaves(sea); // Тестирование движения катера

        Assertions.assertTrue(presidentialYacht.getIonizedCushion().isActive());
        Assertions.assertTrue(presidentialYacht.getFakeStabilizers().isLowered());
        Assertions.assertFalse(ionizedCushion.getYachtBottom().isDowned());

        presidentialYacht.stop(); // Тестирование остановки катера
        assertEquals(YachtState.STOPPED, presidentialYacht.getState());
    }

    @Test
    public void testYachtMovementOnSmoothWater() {
        YachtBottom yachtBottom = new YachtBottom();
        IonizedCushion ionizedCushion = new IonizedCushion(yachtBottom);
        FakeStabilizers fakeStabilizers = new FakeStabilizers();
        PresidentialYacht presidentialYacht = new PresidentialYacht(ionizedCushion, fakeStabilizers);
        Sea sea = new Sea();

        presidentialYacht.start(); // Тестирование запуска катера
        assertEquals(YachtState.MOVING, presidentialYacht.getState());

        presidentialYacht.moveOnSmoothWater(sea); // Тестирование движения катера

        Assertions.assertFalse(presidentialYacht.getIonizedCushion().isActive());
        Assertions.assertFalse(presidentialYacht.getFakeStabilizers().isLowered());
        Assertions.assertTrue(ionizedCushion.getYachtBottom().isDowned());

        presidentialYacht.stop(); // Тестирование остановки катера
        assertEquals(YachtState.STOPPED, presidentialYacht.getState());
    }

    @Test
    public void testYachtStopped() {
        YachtBottom yachtBottom = new YachtBottom();
        IonizedCushion ionizedCushion = new IonizedCushion(yachtBottom);
        FakeStabilizers fakeStabilizers = new FakeStabilizers();
        PresidentialYacht presidentialYacht = new PresidentialYacht(ionizedCushion, fakeStabilizers, 0);
        Sea sea = new Sea();

        presidentialYacht.moveOnWaves(sea);
        assertEquals(YachtState.STOPPED, presidentialYacht.getState());
        Assertions.assertFalse(presidentialYacht.getIonizedCushion().isActive());
        Assertions.assertFalse(presidentialYacht.getFakeStabilizers().isLowered());
        Assertions.assertTrue(ionizedCushion.getYachtBottom().isDowned());
    }

    @Test
    public void testFakeStabilizers() {
        FakeStabilizers fakeStabilizers = new FakeStabilizers();
        Sea sea = new Sea();

        Assertions.assertFalse(fakeStabilizers.isLowered()); // Проверка начального состояния

        fakeStabilizers.lowerIntoWater(sea); // Тестирование опускания стабилизаторов
        Assertions.assertTrue(fakeStabilizers.isLowered()); // Проверка опущенных стабилизаторов
    }

    @Test
    public void testIonizedCushion() {
        YachtBottom yachtBottom = new YachtBottom();
        IonizedCushion ionizedCushion = new IonizedCushion(yachtBottom);

        Assertions.assertFalse(ionizedCushion.isActive()); // Проверка начального состояния (неактивна)

        ionizedCushion.activate(); // Активация подушки
        Assertions.assertTrue(ionizedCushion.isActive()); // Проверка активности после активации
    }

    @Test
    public void testCrowdAstonishedTrue() {
        Crowd crowd = new Crowd(true);
        PresidentialYacht yacht = new PresidentialYacht(null, null, 0);

        Assertions.assertFalse(crowd.isAstonished());
        crowd.reactToYachtEntry(yacht);
        Assertions.assertTrue(crowd.isAstonished());
    }

    @Test
    public void testCrowdAstonishedFalse(){
        Crowd crowd = new Crowd(false);
        PresidentialYacht yacht = new PresidentialYacht(null, null, 0);
        Assertions.assertFalse(crowd.isAstonished());
        crowd.reactToYachtEntry(yacht);
        Assertions.assertTrue(crowd.isAstonished());

    }
}