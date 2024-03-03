import org.example.task3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTest {
    @Test
    public void testPresidentialYachtInitialState() {
        PresidentialYacht presidentialYacht = new PresidentialYacht(null, null);

        assertEquals(YachtState.STOPPED, presidentialYacht.getState()); // Проверка начального состояния
    }

    @Test
    public void testYachtMovement() {
        IonizedCushion ionizedCushion = new IonizedCushion();
        FakeStabilizers fakeStabilizers = new FakeStabilizers();
        PresidentialYacht presidentialYacht = new PresidentialYacht(ionizedCushion, fakeStabilizers);
        Sea sea = new Sea();

        presidentialYacht.start(); // Тестирование запуска катера
        assertEquals(YachtState.MOVING, presidentialYacht.getState());

        presidentialYacht.moveOnWaves(sea); // Тестирование движения катера
        // Добавьте дополнительные проверки по необходимости

        presidentialYacht.stop(); // Тестирование остановки катера
        assertEquals(YachtState.STOPPED, presidentialYacht.getState());
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
        IonizedCushion ionizedCushion = new IonizedCushion();

        Assertions.assertFalse(ionizedCushion.isActive()); // Проверка начального состояния (неактивна)

        ionizedCushion.activate(); // Активация подушки
        Assertions.assertTrue(ionizedCushion.isActive()); // Проверка активности после активации
    }

    @Test
    public void testCrowd() {
        Crowd crowd = new Crowd(true); // толпа ослеплена солнцем
        PresidentialYacht yacht = new PresidentialYacht(null, null);

        Assertions.assertFalse(crowd.isAstonished()); // Проверка начального состояния (не поражена)

        crowd.reactToYachtEntry(yacht);

        Assertions.assertTrue(crowd.isAstonished()); // Проверка поражения толпы
    }
}