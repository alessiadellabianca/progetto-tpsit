import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Registrazione extends JFrame {

    JLabel nome = new JLabel("Nome: ");
    JTextField nomeDainserire = new JTextField(20);
    JLabel cognome = new JLabel("Cognome: ");
    JTextField cognomeDainserire = new JTextField(20);
    JLabel email = new JLabel("Email: ");
    JTextField emailDainserire = new JTextField(20);
    JLabel nomeUtente = new JLabel("Nome utente: ");
    JTextField nomeUtenteDaInserire = new JTextField(20);
    JLabel password = new JLabel("Password: ");
    JTextField passwordDainserire = new JTextField(20);
    JLabel password2 = new JLabel("Rinserisci password: ");
    JTextField password2Dainserire = new JTextField(20);
    JButton registati = new JButton("REGISTRATI");
    JButton accedi = new JButton("ACCEDI");
    List<String> righe = new ArrayList<>();

    public Registrazione()
    {
        try {
            righe= Files.readAllLines(Paths.get("testo.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTitle("Registrazione");
        setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.gridx=0;
        b.gridy=0;
        b.insets = new Insets(5, 0, 5, 0);
        add(nome,b);
        b.gridx=1;
        b.gridy=0;
        add(nomeDainserire,b);
        b.gridx=0;
        b.gridy=1;
        b.insets = new Insets(5, 0, 5, 0);
        add(cognome,b);
        b.gridx=1;
        b.gridy=1;
        add(cognomeDainserire,b);
        b.gridx=0;
        b.gridy=2;
        b.insets = new Insets(5, 0, 5, 0);
        add(email,b);
        b.gridx=1;
        b.gridy=2;
        add(emailDainserire,b);
        b.gridx=0;
        b.gridy=3;
        b.insets = new Insets(5, 0, 5, 0);
        add(nomeUtente,b);
        b.gridx=1;
        b.gridy=3;
        add(nomeUtenteDaInserire,b);
        b.gridx=0;
        b.gridy=4;
        b.insets = new Insets(5, 0, 5, 0);
        add(password,b);
        b.gridx=1;
        b.gridy=4;
        add(passwordDainserire,b);
        b.insets = new Insets(5, 0, 5, 0);
        b.gridx=0;
        b.gridy=5;
        add(password2,b);
        b.gridx=1;
        b.gridy=5;
        add(password2Dainserire,b);
        b.gridx = 0;
        b.gridy = 6;
        b.insets = new Insets(50, 0, 50, 0);
        this.add(registati,b);
        b.gridx = 1;
        b.gridy = 6;
        this.add(accedi, b);

        pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        registati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton premuto = (JButton)e.getSource();

                if (nomeDainserire.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Dati non completi");
                } else if (cognomeDainserire.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Dati non completi");
                } else if (emailDainserire.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Dati non completi");
                } else if (nomeUtenteDaInserire.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Dati non completi");
                } else if (password.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Dati non completi");
                } else if (password2.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Dati non completi");}
                else if(registati==premuto)
                {

                    try {
                        StringBuilder sb = new StringBuilder();
                        righe.add(nomeUtenteDaInserire.getText());
                        righe.add(passwordDainserire.getText());
                        for (String riga : righe) {
                            sb.append(riga).append("\n");
                        }

                        Files.writeString(Paths.get("testo.txt"), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

                        JOptionPane.showMessageDialog(null, "Registrazione completata con successo!");
                        dispose();
                        new Login();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
                    }
                }

            }
        });

        accedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton premuto = (JButton)e.getSource();
                if(premuto==accedi)
                {
                    dispose();
                    new Login();
                }
            }
        });




    }



}
