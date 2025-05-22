import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JFrame {

    public ArrayList<String> carrello=new ArrayList<>();
    public ArrayList<Integer> conto=new ArrayList<>();


    JLabel cerca = new JLabel("Ricerca: ");
    JTextField ricerca = new JTextField(20);
    JButton bottoneCerca= new JButton("CERCA");
    String[] lista = new String[]{"Seleziona:","Abbigliamento donna","Abbigliamento uomo","Libri","Elettronica e Informatica"};

    JComboBox<String> tutto = new JComboBox<>(lista);

    public Menu()
    {
        setTitle("Catalogo Prodotti");
        setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.gridx=0;
        b.gridy=0;
        add(cerca,b);
        b.gridx=1;
        b.gridy=0;
        add(ricerca,b);
        b.gridx=2;
        b.gridy=0;
        b.insets = new Insets(0, 5, 0, 0);
        add(bottoneCerca,b);
        b.insets = new Insets(10,0,10,0);
        b.gridx=0;
        b.gridy=3;
        add(new JLabel("Catalogo: "),b);
        b.gridx=1;
        b.gridy=3;
        add(tutto,b);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);

        tutto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t= (String)tutto.getSelectedItem();
                 if(lista[1].equals(t))
                {
                    dispose();
                    new AbbigliamentoDonna(carrello,conto);

                } else if (lista[2].equals(t))
                 {
                     dispose();
                     new AbbigliamentoUomo(carrello,conto);

                 }
                 else if (lista[3].equals(t))
                 {

                 }
                 else if (lista[4].equals(t))
                 {

                 }
            }
        }

        );

        bottoneCerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(c==bottoneCerca)
                {
                    if(ricerca.getText().equals("abbigliamento donna")||ricerca.getText().equals("Abbigliamento donna"))
                    {
                        new AbbigliamentoDonna(carrello,conto);

                    }else if(ricerca.getText().equals("abbigliamento uomo")||ricerca.getText().equals("Abbigliamento uomo"))
                    {
                        new AbbigliamentoUomo(carrello,conto);

                    }else if(ricerca.getText().equals("libri")||ricerca.getText().equals("Libri"))
                    {

                    }else if(ricerca.getText().equals("informatica")||ricerca.getText().equals("Informatica"))
                    {


                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Ricerca non possibile,riprova");
                    }
                }
            }
        });

    }

    public void setCarrello(ArrayList<String> carrello) {
        this.carrello = carrello;
    }

    public void setConto(ArrayList<Integer> conto) {
        this.conto = conto;
    }
}
