import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
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
    List<String> righe = new ArrayList<>();

    public Login() {
        try {
            righe=Files.readAllLines(Paths.get("testo.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                } else{
                    for (int i=0;i<righe.size()-1;i+=2) {
                        String user = righe.get(i).trim();
                        String pass = righe.get(i + 1).trim();

                        if(user.equalsIgnoreCase(nomeDainserire.getText().trim()) && pass.equals(passwordDainserire.getText().trim()))
                        {
                            try {
                                Files.writeString(Paths.get("nomeaccesso.txt"),nomeDainserire.getText(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                                ex.printStackTrace();
                            }

                            dispose();
                            new Menu();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog((Component)null, "credenziali errate o effettua registrazione");
                }
            }
        });


    }

    public static void main(String[] args) {
        new Login();
    }
}