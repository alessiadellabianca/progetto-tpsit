import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
    JButton log=new JButton("LOGOUT");


    List<String> righe = new ArrayList<>();
    String conc;
    int tot;




    Pagamento(String nome,int cont,String indirizzo,String comune)
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
        b.insets = new Insets(0, 10, 0, 0);
        b.gridx = 2;
        b.gridy = 4;
        add(applica,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 5;
        add(conf,b);
        b.gridx = 1;
        b.gridy = 5;
        add(log,b);



        conf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton prem=(JButton)e.getSource();
                if (insercinum.getText().isEmpty() || inserciCvc.getText().isEmpty() || inserciTit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campi non compilati correttamente");

                }
                else {
                    try {
                        conc ="\n"+generaTracciamento()+"\n"+nome +"\n"+indirizzo+ "\n"+comune+"\n" + tot+"\n";
                        Files.writeString(
                                Paths.get("ordini.txt"),
                                conc,
                                StandardOpenOption.CREATE,
                                StandardOpenOption.APPEND
                        );   } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,"Ordine confermato per un totale di "+tot);

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


        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton prem=(JButton)e.getSource();

                if(prem==log)
                {
                    dispose();
                    new Login();
                }
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 700);
        pack();
        this.setVisible(true);
    }

    public int generaTracciamento()
    {
        Random rand = new Random();
        int numero;
        numero= rand.nextInt(301) + 200;
        return numero;
    }
}
