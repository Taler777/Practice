import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow game_window;
    private static long last_frame_time; //подсчет времени между кадрами
    private static Image background; // переменная класса Image
    private static Image drop;
    private static Image game_over;
    private static float drop_left = 200; //координата х левого верхнего угла капли
    private static float drop_top = -135; //координата у левого верхнего угла капли за пределами видимости
    private static float drop_v = 200; // скорость капли
    private static int score;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        game_window = new GameWindow();
        // создали объект класса GameWindow()
        // ссылку на созданный объект поместили в переменную game_window
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // настройка окна - при его закрытии программа завершится
        game_window.setLocation(0, 0); // координаты левого верхнего угла окна
        game_window.setSize(1366, 768); //размер окна
        game_window.setResizable(false); // запрет на изменение размеров
        last_frame_time = System.nanoTime(); // присваиваем текущее время в наносекундах
        GameField game_field = new GameField();
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { //метод вызывается при нажатии на кнопку мышки
                //получаем координаты x,y курсора мыши
                int x = e.getX();
                int y = e.getY();
                float drop_right = drop_left + drop.getWidth(null); // правый верхний угол капли
                float drop_bottom = drop_top + drop.getHeight(null); // правый нижний угол капли
                // определяем попад ли указатель мыши в каплю
                boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
                if (is_drop) {
                    // если в каплю попали, то выкидываем каплю за экран в случайную по оси х координату
                    drop_top = -135;
                    drop_left = (int) (Math.random() * (game_field.getWidth() - drop.getWidth(null)));
                    drop_v += 20; //увеличиваем скорость капли
                    score++;
                    game_window.setTitle("Score = " + score);
                }
            }
        });
        game_window.add(game_field);
        game_window.setVisible(true); // видимость окна
    }

    private static void onRepaint(Graphics g) {
        long current_time = System.nanoTime(); // присваиваем текущее время в наносекундах
        float delta_time = (current_time - last_frame_time) * 0.000000001f; //разница между кадрами

        last_frame_time = current_time;

        drop_top = drop_top + drop_v * delta_time;

        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
        if (drop_top > game_window.getHeight()) g.drawImage(game_over, 380, 200, null);
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // отрисовка панели
            onRepaint(g);
            repaint();
        }
    }
}
