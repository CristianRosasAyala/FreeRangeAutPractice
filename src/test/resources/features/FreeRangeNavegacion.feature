@Navigation
Feature: La barra de navegacion superior me permite navegar a todas las subsecciones
    To see the subpages
    Without loggin in
    I can click the navigation bar links

    Background: I am in www.freerangetesters.com without login in
        Given I navigate to www.freerangertesters.com

    Scenario Outline: Puedo acceder alas subsecciones haciendo click en la navegacion superior
       When I go to <section> using the navigation bar
       Examples:
           | section     |
           | 'Cursos'    |
           | 'Recursos'  |
           | 'Blog'      |
           | 'Mentorías' |
           | 'Udemy'     |
           | 'Academia'   |

    Scenario: Courses are presented correctly to potential customers
       When I go to 'Cursos' using the navigation bar
       And select Introduccion al Testing de Software

    @Plans
    Scenario: Users can select a plan when signin up
        When I go to 'Cursos' using the navigation bar
        And I select Elegir plan
        Then I can validate the options in the checkout page
        
    
    