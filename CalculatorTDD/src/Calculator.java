/*
Калькулятор выполняет сложение и деление положительных чисел.
При делении на 0 выбрасывает исключение.

 */

public class Calculator {
    public enum Command {
        SUM,
        DIV,
        NEW_COMMAND
    }

    public int calculate(Command command, int argument1, int argument2) {
        int argumentAbs1 = Math.abs(argument1);
        int argumentAbs2 = Math.abs(argument2);
        switch (command) {
            case SUM:
                return sum(argument1, argument2);
            case DIV:
                return div(argument1, argument2);
            default:
                throw new UnsupportedOperationException("Unknown operation! - " + command);
        }
    }

    private int sum(int argument1, int argument2) {
        return argument1 + argument2;
    }

    private int div(int divined, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can not be zero");
        }
        return divined / divisor;
    }
}
