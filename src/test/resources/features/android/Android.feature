@AndroidDemo
Feature: Inicio de sesión
  Yo como usuario del portal
  Quiero iniciar sesión con mi cuenta
  Para ver la información de mi perfil

  @smokeTest @regresion
  Scenario Outline: Iniciar Aplicación Demo
    Given Abrir BrowserStack App Demo
    And Buscar elemento Search Wikipedia
    Examples:
      | iteracion |
      | 1         |


