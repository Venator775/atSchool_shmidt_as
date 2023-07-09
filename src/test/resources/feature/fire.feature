Feature: Огонь

  @smoke
  @fire
  Scenario: Создание огня
    Given Создать элемент огонь "Fire"

  @fire
  Scenario Outline: Проверка комбинаций с огнём
    Given Соединить огонь с "<element>"
    Then Проверить результат соединения огня с "<element>": "<result>"

    Examples: Комбинации
      | element  | result |
      | Air      | Energy |
      | Fire     | Fire   |
      | Ground   | Lava   |
      | Water    | Steam  |
      | nUll     | null   |