# EasyCooldown | NukkitX
Простой API для создания кулдаунов. 
<br/><br/>
Примеры использования:
-----------------------------------
<h4>Создание кулдауна</h4>

```java
//Получаем менеджер игрока
PlayerCooldownManager manager = PlayerCooldownManager.get(player);
 
//Запускаем кулдаун с ключем 'test' на 30 секунд
manager.addCooldown("test", new PlayerCooldown(target -> {
   //Действие, которое выполнится по истечению времени
   //TODO...
}, 30.0));
```

-----------------------------------
<h4>Получение оставшегося времени</h4>

```java
//Получаем объект кулдауна с ключем 'test' от менеджера игрока
PlayerCooldown cooldown = manager.getCooldown("test");

int left = cooldown.getSecondsLeft();
```
-----------------------------------
<h4>Добавление времени</h4>

```java
//Получаем объект кулдауна с ключем 'test' от менеджера игрока
PlayerCooldown cooldown = manager.getCooldown("test");

//Добавляем 10 секунд    
cooldown.addSeconds(10);
```
-----------------------------------
<h4>Принудительное завершение кулдауна</h4>

```java
//Получаем объект кулдауна с ключем 'test' от менеджера игрока
PlayerCooldown cooldown = manager.getCooldown("test");

//Завершить и выполнить действие
cooldown.close(); 

//Завершить и не выполнить действие
cooldown.closeAndDoNotExecute();
```
    
-----------------------------------
<h4>Проверка на наличие кулдауна</h4>
Есть 2 способа проверки: через метод `hasCooldown(key)` от менеджера или же получение кулдауна через `getCooldown(key)` и проверкой его на `null` значение.

```java
boolean result;

//Эти две записи делают одно и то же
result = manager.getCooldown("test") != null;
```
    
