import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GestioneOrdine extends JFrame {

    JLabel intro=new JLabel("ZONA DI CONFERMA ORDINE");
    JLabel indi=new JLabel("Indirizzo: ");
    JLabel num=new JLabel("Numero civico: ");
    JLabel prov=new JLabel("Provincia: ");
    JLabel comune=new JLabel("Comune: ");
    JTextField insersciIndi=new JTextField(20);
    JTextField inserisciNum=new JTextField(20);
    JTextField inserisciProv=new JTextField(20);
    JTextField insersciComune=new JTextField(20);
    JLabel metodo=new JLabel("Seleziona metodo pagamento: ");
    JCheckBox pag=new JCheckBox("Carta di credito");
    JCheckBox pag2=new JCheckBox("Pagamento alla consegna");
    JButton conferma=new JButton("CONFERMA");

    int tot;
    List<String> righe = new ArrayList<>();
    String nome;
    String conc;


    GestioneOrdine(ArrayList<String> carrello,ArrayList<Integer> conto)
    {
            try {
                righe= Files.readAllLines(Paths.get("nomeaccesso.txt"));
                nome=righe.getLast();

            } catch (Exception e) {
                e.printStackTrace();
            }
        for(Integer c:conto) {
            tot = tot + c;
        }

        setTitle("Conferma ordine");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 1;
        b.gridy = 0;
        add(intro,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 1;
        add(indi,b);
        b.gridx = 1;
        b.gridy = 1;
        add(insersciIndi,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 2;
        add(num,b);
        b.gridx = 1;
        b.gridy = 2;
        add(inserisciNum,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 3;
        add(prov,b);
        b.gridx = 1;
        b.gridy = 3;
        add(inserisciProv,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 4;
        add(comune,b);
        b.gridx = 1;
        b.gridy = 4;
        add(insersciComune,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 5;
        add(metodo,b);
        b.gridx = 1;
        b.gridy = 5;
        add(pag,b);
        b.gridx = 1;
        b.gridy = 6;
        add(pag2,b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 2;
        b.gridy = 7;
        add(conferma,b);

        if(tot>50)
        {
            tot=tot-(tot/100*10); //Sconto del 10% se superiore a 50 euro
        }

        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton prem=(JButton)e.getSource();

                if(inserisciProv.getText().isEmpty()||insersciComune.getText().isEmpty()||inserisciNum.getText().isEmpty()||insersciIndi.getText().isEmpty()||(!pag.isSelected()&&!pag2.isSelected()))
                {
                    JOptionPane.showMessageDialog(null,"Campi non compilati correttamente");
                }else if(conferma==prem&&pag.isSelected())
                {
                    dispose();
                    new Pagamento(nome,tot);
                }
                else if(conferma==prem&&pag2.isSelected())
                {
                    try {
                        conc=nome+"\n"+tot;
                        Files.writeString(Paths.get("ordini.txt"), conc, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                        JOptionPane.showMessageDialog(null,"Ordine confermato, alla consegna si dovrà pagare");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
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
