# encoding: iso-8859-1

@fcamara @dasa
Feature: Dasa

  Background: 
    Given I navigate to DASA website

  Scenario: Brand navigation
    Given I navigate to menu "Somos Dasa" option "Nossas Marcas"
    When I filter "Regi?es" and select option "S?o Paulo"
    Then I print all results
    When I select "delboniauriemo.com.br" brand
    Then I verify if I navigated to "https://delboniauriemo.com.br/"
