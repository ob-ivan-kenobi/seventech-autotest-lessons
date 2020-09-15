package restassured.lesson4.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class ExampleStepdefs {

    public int x, y , actualResult;

    @Дано("^два числа (\\d+) и (\\d+)$")
    public void givenTwoNumber(int a, int b) {
        x = a;
        y = b;
        System.out.println("Первое число: " + a);
        System.out.println("Второе число: " + b);
    }

    @Когда("^происходит (.*)$")
    public void whenOperationWasChosen(String operation) {
        operation = operation.trim();
        System.out.println("Выбрана операция: " + operation);

        if (operation.equals("суммирование")) {
            actualResult = x + y;
        } else if (operation.equals("вычитание")) {
            actualResult = x - y;
        }

        System.out.println("Полученный результат: " + actualResult);
    }

    @Тогда("^ответ равен (\\d+)$")
    public void thenAnswerIs(int expectedResult) {
        System.out.println("Ожидаемый результат: " + expectedResult);

        Assert.assertTrue(actualResult == expectedResult);
    }

//    @After
//    public void getScenarioInfo(Scenario scenario) {
//        System.out.println(scenario.getId());
//        System.out.println(scenario.getName());
//        System.out.println(scenario.getStatus());
//        System.out.println(scenario.isFailed());
//        System.out.println(scenario.getSourceTagNames());
//    }
}
