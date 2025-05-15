import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame {
    JLabel nomeUtente = new JLabel("Nome utente: ");
    JTextField nomeDainserire = new JTextField(20);
    JLabel password = new JLabel("Password: ");
    JTextField passwordDainserire = new JTextField(20);
    JButton accedi = new JButton("ACCEDI");
    JButton registati = new JButton("REGISTRATI");
    JButton amministatore = new JButton("PERSONALE");

    public Login() {
        setTitle("Login");
        this.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 0;
        this.add(this.nomeUtente, b);
        b.gridx = 1;
        b.gridy = 0;
        this.add(this.nomeDainserire, b);
        b.insets = new Insets(10, 0, 10, 0);
        b.gridx = 0;
        b.gridy = 1;
        this.add(this.password, b);
        b.gridx = 1;
        b.gridy = 1;
        this.add(this.passwordDainserire, b);
        b.gridx = 0;
        b.gridy = 2;
        b.insets = new Insets(50, 5, 50, 0);
        this.add(registati,b);
        b.gridx = 1;
        b.gridy = 2;
        this.add(this.accedi, b);
        b.gridx = 2;
        b.gridy = 2;
        this.add(amministatore,b);
        this.pack();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);

        this.amministatore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton premuto = (JButton)e.getSource();
              if(premuto==amministatore)
                {
                    dispose();
                    new Amministratore();
                }

            }
        });

        this.registati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton premuto = (JButton)e.getSource();
                if(premuto==registati)
                {
                    new Registrazione();
                }

            }
        });



        this.accedi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton premuto = (JButton)e.getSource();
                if (Login.this.nomeDainserire.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "inserisci nome utente");
                } else if (Login.this.passwordDainserire.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "inserisci password");
                } else if(premuto==accedi){
                    dispose();
                    new Menu();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}