import javax.swing.JFrame;

class Interface {

    public static void main(String[] args) {

        JFrame window = new JFrame("Temperature Converter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TempConverter panel = new TempConverter();
        window.getContentPane().add(panel);

        window.pack();
        window.setVisible(true);

    }

}