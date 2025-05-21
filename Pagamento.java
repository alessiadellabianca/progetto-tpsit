import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class Pagamento extends JFrame{

    JLabel nom=new JLabel("Titolare carta: ");
    JLabel numerocarta=new JLabel("Numero carta: ");
    JLabel cvc=new JLabel("CVC: ");
    JLabel cod=new JLabel("Codice sconto: ");
    JTextField inserciTit=new JTextField(20);
    JTextField insercinum=new JTextField(20);
    JTextField inserciCvc=new JTextField(20);
    JTextField insercicodicesconto=new JTextField(20);

    JButton conf=new JButton("CONFERMA");
    JButton applica=new JButton("APPLICA");


    List<String> righe = new ArrayList<>();
    String conc;
    int tot;




    Pagamento(String nome,int cont)
    {

        this.tot=cont;
        JTextArea conto=new JTextArea("Il totale del conto da pagare è pari a "+tot);

        setTitle("Conferma ordine");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 1;
        b.gridy = 0;
        add(conto,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 1;
        add(nom,b);
        b.gridx = 1;
        b.gridy = 1;
        add(inserciTit,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 2;
        add(numerocarta,b);
        b.gridx = 1;
        b.gridy = 2;
        add(insercinum,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 3;
        add(cvc,b);
        b.gridx = 1;
        b.gridy = 3;
        add(inserciCvc,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 4;
        add(cod,b);
        b.gridx = 1;
        b.gridy = 4;
        add(insercicodicesconto,b);
        b.gridx = 2;
        b.gridy = 4;
        add(applica,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 2;
        b.gridy = 5;
        add(conf,b);

        conf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton prem=(JButton)e.getSource();
                if (insercinum.getText().isEmpty() || inserciCvc.getText().isEmpty() || inserciTit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campi non compilati correttamente");

                }
                else {
                    try {
                        conc=nome+"\n"+tot;
                        Files.writeString(Paths.get("ordine.txt"), conc, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,"Ordine confermato per un totale di"+20);

                }
            }
        });

        applica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton prem=(JButton)e.getSource();
                if(applica==prem)
                {
                    if (insercicodicesconto.getText().equals("Informatica25")) {
                        tot = tot - (tot * 10 / 100);
                        conto.setText("Il totale del conto da pagare è pari a " + tot + " euro.");
                        JOptionPane.showMessageDialog(null, "Codice sconto applicato!");
                    }
                }
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 700);
        pack();
        this.setVisible(true);


    }
}
