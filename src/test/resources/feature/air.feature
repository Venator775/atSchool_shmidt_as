Feature: Воздух

  @smoke
  @air
  Scenario: Создание воздуха
    Given Создать элемент воздух

  @air
  Scenario Outline: Проверка комбинаций с воздухом
    Given Соединить воздух с "<element>"
    Then Проверить результат соединения воздуха с "<element>" "<result>"

    Examples:
      | element  | result   |
      | Air      | Pressure |
      | Fire     | Energy   |
      | Ground   | Dust     |
      | Water    | Rain     |
      | null     | null     |
      | nulsdfgl | null     |

