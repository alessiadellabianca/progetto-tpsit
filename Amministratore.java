import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Amministratore extends JFrame {

    JLabel personale=new JLabel("Tipologia personale: ");
    String[] op=new String[]{"Amministratore","Magazziniere"};
    JComboBox<String> opzioni=new JComboBox<>(op);

    JLabel nomeUtente = new JLabel("Nome utente: ");
    JTextField nomeDainserire = new JTextField(20);
    JLabel password = new JLabel("Password: ");
    JTextField passwordDainserire = new JTextField(20);
    JButton accedi = new JButton("ACCEDI ");
    JButton registati = new JButton("REGISTRATI");
    JButton torna = new JButton("TORNA");

    public Amministratore() {
        setTitle("Accesso amministatore");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 0;
        this.add(personale, b);
        b.gridx = 1;
        b.gridy = 0;
        this.add(opzioni, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 1;
        this.add(this.nomeUtente, b);
        b.gridx = 1;
        b.gridy = 1;
        this.add(this.nomeDainserire, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 2;
        this.add(this.password, b);
        b.gridx = 1;
        b.gridy = 2;
        this.add(this.passwordDainserire, b);
        b.gridx = 0;
        b.gridy = 3;
        b.insets = new Insets(50, 5, 50, 0);
        this.add(registati,b);
        b.gridx = 1;
        b.gridy = 3;
        this.add(accedi, b);
        b.gridx = 2;
        b.gridy = 3;
        this.add(torna, b);
        this.pack();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);

        this.accedi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t= (String)opzioni.getSelectedItem();
                if(t.equals("Amministratore"))
                {
                    if(nomeDainserire.getText().equals("amministratore")||nomeDainserire.getText().equals("amministratore1"))
                    {
                        if(passwordDainserire.getText().equals("amministratore2025"))
                        {
                            new Menuamm();
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"accesso bloccato");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"accesso bloccato");
                    }
                }
                else if(t.equals("Magazziniere"))
                {
                    if(nomeDainserire.getText().equals("magazziniere")||nomeDainserire.getText().equals("magazziniere1"))
                    {
                        if(passwordDainserire.getText().equals("magazziniere2025"))
                        {
                            System.out.println("ei");
                        }else {
                            JOptionPane.showMessageDialog(null,"accesso bloccato");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"accesso bloccato");
                    }
                }

            }
        });

        registati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton premuto = (JButton)e.getSource();
                if(premuto==registati)
                {
                    dispose();
                    new Registrazione();
                }
            }
        });

        torna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton premuto = (JButton)e.getSource();
                if(premuto==torna)
                {
                    dispose();
                    new Login();
                }
            }
        });


    }
}