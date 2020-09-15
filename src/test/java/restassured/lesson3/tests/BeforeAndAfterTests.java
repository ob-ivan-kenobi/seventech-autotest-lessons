package restassured.lesson3.tests;

import org.junit.*;

public class BeforeAndAfterTests {

    private int a = 5;
    private int b = 3;
    private int result;
    boolean testPassed = false;


    @BeforeClass
    public static void doBeforeAllTests() {
        System.out.println("Это выполняется до всех тестов");
        System.out.println("####################################################################################");
    }

    @Before
    public void doBeforeEveryTest() {
        System.out.println("Устанавливаем флаг тест в false");
        testPassed = false;
    }

    @Test
    public void addTest() {
        int result = a + b;
        if (result == 10) {
            testPassed = true;
        }
        System.out.println(a + " + " + b + " = " + result);
    }

    @Test
    public void minusTest() {
        int result = a - b;
        if (result == 2) {
            testPassed = true;
        }
        System.out.println(a + " - " + b + " = " + result);
    }

    @Test
    public void multiplicationTest() {
        int result = a * b;
        if (result == 15) {
            testPassed = true;
        }
        System.out.println(a + " * " + b + " = " + result);
    }

    @After
    public void doAfterEveryTest() {

        System.out.println("Проверка результата после теста:");
        if(testPassed) {
            System.out.println("Тест пройден успешно");
        } else {
            System.out.println("Тест не пройден");
        }
        System.out.println("####################################################################################");
    }

    @AfterClass
    public static void doAfterAllTests() {
        System.out.println("Это выполняется после всех тестов");
    }
}
