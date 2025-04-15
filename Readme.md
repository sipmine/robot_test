
# Robot info (Пособие по роботу)

## Подключение к роботу

### Подключение к Wi-Fi
Это Wi-Fi сети самого робота.

**Название сети робота:** `"№_robot-1234"`  
_№ — написан на крышке, от 1 до 5._

**Пароль:** `"password"`

---

### Подключение по VNC
Запомни:

- **IP-адрес робота:** `10.12.34.2`
- **Имя пользователя:** `pi`
- **Пароль:** `raspberry`

Открываем VNC Viewer

...

---

## Подключение электроники

Будет подключение

---

## Сборка и загрузка кода, тестирование

Сборка ...

----

## Как настроить моторы

Открой файл `Constants.java`:

```java
public static final int MOTOR_L_ID = 0;
public static final int MOTOR_R_ID = 1;
```

Здесь нужно заменить ID на номера портов, к которым подключены моторы.  
Номер порта смотри на Titan:  
Например, `M0 => 0`, `M1 => 1`

➡️ **Замени на значения, соответствующие сборке.**

---

## Как заставить робота двигаться и выполнять команды

### 0) Базовый пример

Открой файл:  
`java/frc/robot/commands/example/FakeLampAndButtonCommandGroup.java`

Строки 12–13:

```java
new FakeLampCommand("green", false),
new FakeLampCommand("red", true),
```

Фейковая индикация — будет отображаться в ShuffleBoard.

---

_Рис_

---

Строки 14–15:

```java
new FakeButtonCommand("Start"),
new FakeLampCommand("green", true)
```

После нажатия кнопки **Start** в ShuffleBoard загорится зелёная лампочка.

---

### 1) Настройка PID-контроллера движения

Открой `frc/robot/commands/MoveForwardCommand.java`  
Найди:

```java
//TODO calibrate PID for move command
private final PIDController forward = new PIDController(f_kP,0,0);
private final PIDController rotation = new PIDController(r_kP,0,0);
```

Установи значения `f_kP` и `r_kP`, например: `3.14`, `1.0`, `0.5`

- `f_kP` — усилие движения вперёд
- `r_kP` — корректировка поворота/угла

---

### 2) Настройка поворота

Открой `frc/robot/commands/RotateCommand.java`  
Найди:

```java
//TODO calibrate PID for rotation command
private final PIDController rotation = new PIDController(r_kP,0,0);
```

Используй то же значение `r_kP`, что и в п.1

📌 Команда поворачивает на угол от -180 до 180 градусов.

---

### 3) Проверка движения на 1 метр

Открой `frc/robot/RobotContainer.java`

- Закомментируй строку 38:  
  `// ...`
- Раскомментируй строку 42

➡️ Это активирует тестовую команду движения вперёд.

Продолжай в **пункт тестирование**

---

### 4) Проверка поворота на 180°

Открой `frc/robot/RobotContainer.java`

- Закомментируй строки 38 и 42
- Раскомментируй строку 46

Продолжай в **пункт тестирование**

---

### 5) Проверка чтения QR/Barcode

Открой:  
`java/frc/robot/commands/example/ReadBarcodeCommandGroup.java`

Строка 15:

```java
"21" → "ваше значение"
```

Значение должно быть в формате строки.

Затем открой `frc/robot/RobotContainer.java`  
Раскомментируй строку 50 (`// ...`)

Продолжай в **пункт тестирование**

---
