package org.example.task3;

// Объект, представляющий ионизированную подушку
public class IonizedCushion {
    private boolean active;
    private YachtBottom yachtBottom;

    // Конструктор
    public IonizedCushion(YachtBottom yachtBottom) {
        this.active = false; // Изначально подушка неактивна
        this.yachtBottom = yachtBottom;
    }

    // Метод для активации подушки
    public void activate() {
        active = true;
        yachtBottom.BottomsUp();
        System.out.println("Ионизированная подушка активирована.");
    }

    public void deactivate() {
        active = false;
        yachtBottom.BottomsDown();
        System.out.println("Ионизированная подушка деактивирована.");
    }

    // Метод для проверки активности подушки
    public boolean isActive() {
        return active;
    }

    public YachtBottom getYachtBottom(){
        return yachtBottom;
    }
}