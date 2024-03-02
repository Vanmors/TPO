package org.example.task3;

// Главный класс для демонстрации событий
public class Main {
    public static void main(String[] args) {
        // Создаем объекты
        IonizedCushion ionizedCushion = new IonizedCushion();
        FakeStabilizers fakeStabilizers = new FakeStabilizers();
        PresidentialYacht presidentialYacht = new PresidentialYacht(ionizedCushion, fakeStabilizers);
        Sea sea = new Sea();

        // Катер начинает движение
        presidentialYacht.start();

        // Катер движется по волнам с опущенными стабилизаторами
        presidentialYacht.moveOnWaves(sea);

        // Катер останавливается
        presidentialYacht.stop();
    }
}