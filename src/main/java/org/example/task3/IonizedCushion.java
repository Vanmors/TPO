package org.example.task3;

// Объект, представляющий ионизированную подушку
public class IonizedCushion {
    private boolean active;

    // Конструктор
    public IonizedCushion() {
        this.active = false; // Изначально подушка неактивна
    }

    // Метод для активации подушки
    public void activate() {
        active = true;
        System.out.println("Ионизированная подушка активирована.");
    }

    public void deactivate() {
        active = false;
        System.out.println("Ионизированная подушка деактивирована.");
    }

    // Метод для проверки активности подушки
    public boolean isActive() {
        return active;
    }

}