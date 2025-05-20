import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestioneOrdine extends JFrame {

    JTextArea zona=new JTextArea();
    int tot;
    JLabel totale=new JLabel();



    GestioneOrdine(ArrayList<String> carrello,ArrayList<Integer> conto)
    {
        for(Integer c:conto) {
            tot = tot + c;
        }

        setTitle("Conferma ordine");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 0;

    }
}
