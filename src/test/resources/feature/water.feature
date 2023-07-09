Feature: Вода

  @smoke
  @water
  Scenario: Создание воды
    Given Создать элемент вода "Water"

  @water
  Scenario Outline: Проверка комбинаций с водой
    Given Соединить воду с "<element>"
    Then Проверить результат соединения воды с "<element>": "<result>"

    Examples: Комбинации
      | element | result |
      | Air     | Rain   |
      | Fire    | Steam  |
      | Ground  | Mud    |
      | Water   | Sea    |
      | nUll    | null   |

