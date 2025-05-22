import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GestioneOrdine extends JFrame {

    JLabel intro = new JLabel("ZONA DI CONFERMA ORDINE");
    JLabel indi = new JLabel("Indirizzo: ");
    JLabel num = new JLabel("Numero civico: ");
    JLabel prov = new JLabel("Provincia: ");
    JLabel comune = new JLabel("Comune: ");
    JTextField insersciIndi = new JTextField(20);
    JTextField inserisciNum = new JTextField(20);
    JTextField inserisciProv = new JTextField(20);
    JTextField insersciComune = new JTextField(20);
    JLabel metodo = new JLabel("Seleziona metodo pagamento: ");
    JCheckBox pag = new JCheckBox("Carta di credito");
    JCheckBox pag2 = new JCheckBox("Pagamento alla consegna");
    JButton conferma = new JButton("CONFERMA");

    JButton log=new JButton("LOGOUT");

    int tot;
    List<String> righe = new ArrayList<>();

    List<String> ordini = new ArrayList<>();
    String nome;
    String conc;


    GestioneOrdine(ArrayList<String> carrello, ArrayList<Integer> conto) {
        try {
             righe = Files.readAllLines(Paths.get("nomeaccesso.txt"));
            nome = righe.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ordini = Files.readAllLines(Paths.get("ordini.txt"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Integer c : conto) {
            tot = tot + c;
        }

        setTitle("Conferma ordine");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 1;
        b.gridy = 0;
        add(intro, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 1;
        add(indi, b);
        b.gridx = 1;
        b.gridy = 1;
        add(insersciIndi, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 2;
        add(num, b);
        b.gridx = 1;
        b.gridy = 2;
        add(inserisciNum, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 3;
        add(prov, b);
        b.gridx = 1;
        b.gridy = 3;
        add(inserisciProv, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 4;
        add(comune, b);
        b.gridx = 1;
        b.gridy = 4;
        add(insersciComune, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 5;
        add(metodo, b);
        b.gridx = 1;
        b.gridy = 5;
        add(pag, b);
        b.gridx = 1;
        b.gridy = 6;
        add(pag2, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 7;
        add(conferma, b);
        b.gridx = 1;
        b.gridy = 7;
        add(log, b);


        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton prem = (JButton) e.getSource();

                tot = sconto(tot);

                if (inserisciProv.getText().isEmpty() || insersciComune.getText().isEmpty() || inserisciNum.getText().isEmpty() || insersciIndi.getText().isEmpty() || (!pag.isSelected() && !pag2.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Campi non compilati correttamente");
                } else if (conferma == prem && pag.isSelected()) {
                    dispose();
                    new Pagamento(nome, tot,insersciIndi.getText(),insersciComune.getText());
                } else if (conferma == prem && pag2.isSelected()) {

                    try {
                        conc="\n"+generaTracciamento()+"\n"+nome +"\n"+insersciIndi.getText()+ "\n"+insersciComune.getText()+"\n" + tot+"\n";
                        Files.writeString(
                                Paths.get("ordini.txt"),
                              conc,
                                 StandardOpenOption.CREATE,
                                StandardOpenOption.APPEND
                        );
                        JOptionPane.showMessageDialog(null,"Ordine cofermato");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
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
        this.setSize(900, 1000);
        pack();
        this.setVisible(true);

    }

    public int sconto(int prezzo) {
        if (prezzo > 50) {
            prezzo = prezzo - (prezzo / 100 * 10); //Sconto del 10% se superiore a 50 euro
            return prezzo;
        }
        else {
            return prezzo;
        }
    }

    public int generaTracciamento()
    {
        Random rand = new Random();
        int numero;
        numero= rand.nextInt(301) + 200;
        return numero;
    }

}
