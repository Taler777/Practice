package src;
// Брюс Эккель Философия джава 4-е изд. 2015 перевод, стр 169
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Создание нового объекта Cupboard в main()");
        new Cupboard();
        System.out.println("Создание нового объекта Cupboard в main()");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
