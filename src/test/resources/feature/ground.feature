Feature: Земля

  @smoke
  @ground
  Scenario: Создание земли
    Given Создать элемент земля "Ground"

  @ground
  Scenario Outline: Проверка комбинаций с землёй
    Given Соединить землю с "<element>"
    Then Проверить результат соединения земли с "<element>": "<result>"

    Examples: Комбинации
      | element | result   |
      | Air     | Dust     |
      | Fire    | Lava     |
      | Ground  | Pressure |
      | Water   | Mud      |
      | nULL    | null     |
      | nll1    | null     |
