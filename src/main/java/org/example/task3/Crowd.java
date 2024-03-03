package org.example.task3;

// Объект, представляющий толпу
public class Crowd {
    private boolean dazzledBySun; // ослеплена солнцем
    private boolean astonishment;
    // Конструктор
    public Crowd(boolean dazzledBySun) {
        this.dazzledBySun = dazzledBySun;
        this.astonishment = false;
    }

    public void reactToYachtEntry(PresidentialYacht yacht) {
        astonishment = true;
        if (dazzledBySun) {
            System.out.println("Толпа ослеплена солнцем.");
        }

        yacht.moveOnWaves(new Sea());
    }

    public boolean isAstonished() {
        return astonishment;
    }
}