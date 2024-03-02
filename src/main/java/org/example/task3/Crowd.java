package org.example.task3;

// Объект, представляющий толпу
public class Crowd {
    private boolean dazzledBySun; // ослеплена солнцем

    // Конструктор
    public Crowd(boolean dazzledBySun) {
        this.dazzledBySun = dazzledBySun;
    }

    // Метод для реакции толпы на вход катера в залив
    public void reactToYachtEntry(PresidentialYacht yacht) {
        if (dazzledBySun) {
            // Толпа ослеплена солнцем
        }

        //yacht.glideOnWaves(); // Реакция толпы на движение катера по волнам
    }
}

/*
// Главный класс для демонстрации событий
public class Main {
    public static void main(String[] args) {
        // Создаем катер
        PresidentialYacht presidentialYacht = new PresidentialYacht(true);

        // Создаем толпу
        Crowd crowd = new Crowd(true);

        // Толпа реагирует на вход катера в залив
        crowd.reactToYachtEntry(presidentialYacht);

        // Опускаем фиктивные стабилизаторы
        presidentialYacht.deployFakeStabilizers();

        // Катер движется по волнам с опущенными стабилизаторами
        presidentialYacht.glideOnWaves();
    }
}
 */