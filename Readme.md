# Robot info (Пособие по роботу)
=============

## Позиции контейнеров

1 - Большой контейнер 
2 - Большой контейнер

3 - Маленький контейнер
4 - Маленький контейнер

ввид сверху

| 1 | | 2 |

| 3 | | 4 |


## Настрйка манипулятора
Повернуть манипулятор так чтобы он находился на тойже прямой что и 2 и 4 контейнер
это ноль по вращению (RevJoint) теперь установи 1 сустав манипулятора перпендикулярно основанию где она расположен это
сутсав (Joint1), второй сустав установи в спкойное состояние (ServoJoint2), перед запуском любого кода где есть манипулятор
**убери контейнеры!!!**

Выставление ограничений в телеуправлении задаются в этих переменых PsControl.java GpControl.java

    // Manipulator limits
    private final int revDegLimUp = -190;
    private final int revDegLimLow = 0;

    private final int joint1DegLimUp = 90;
    private final int joint1DegLimLow = -90;

    private final int joint2DegLimUp = 300;
    private final int joint2DegLimLow = 0;

    private final int grubLimUp = 280;
    private final int grubLimLow = 0; 

## Программирование Команд
В директории commands/exampleCommands находятся примеры команд

