import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final int ZERO = 0;
    Calculator calculator;

    private int argument1;
    private int argument2;
    private int result;

    @Before
    public void setUp() {  // установка значений
        calculator = new Calculator();
    }

    @After
    public void tearDown() {  // очистка значений
        calculator = null;
    }

    @Test
    public void testSum() {         //В СЦЕНАРНОМ СТИЛЕ
        givenArguments(2,2);        //что дано
        whenCommandIs(Calculator.Command.SUM);         //что делаем
        thenResultIs(4);//ожидаемый результат
    }

    @Test
    public void testSumAbs() {
        givenArguments(3, -3);
        whenCommandIs(Calculator.Command.SUM);
        thenResultIs(6);
    }

    @Test
    public void testDiv() {
        givenArguments(20, 5);
        whenCommandIs(Calculator.Command.DIV);
        thenResultIs(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivOnZero() {
        givenArguments(100, ZERO);
        whenCommandIs(Calculator.Command.DIV);
        thenResultThrowException();

    }

    @Test
    public void testDivAbs() {
        givenArguments(10,-2);
        whenCommandIs(Calculator.Command.DIV);
        thenResultIs(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNewCommand(){
        givenArguments(10,10);
        whenCommandIs(Calculator.Command.NEW_COMMAND);
        thenResultThrowException();
    }




    private void givenArguments(int arg1, int arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    private void whenCommandIs(Calculator.Command command) {
        this.result = calculator.calculate(command, argument1, argument2);
    }

    private void thenResultIs(int expectedResult) {
        Assert.assertThat(result, Is.is(expectedResult));
    }

    private  void thenResultThrowException(){
        Assert.fail();
    }

}
