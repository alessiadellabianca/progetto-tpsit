import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbbigliamentoUomo extends JFrame{

    String[] abbigliamentoUomo = new String[]{"Felpe","Maglioni","T-Shirt","Jeans"};
    String[][] tutti= {
            {"Felpa nera","Felpa rossa","Felpa cappuccio"},
            {"Maglione lana","Maglione con papera"},
            {"Maglia bianca","Maglia adidas"},
            {"Jeans skinny","Jeans bianchi"},
    };

    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    int conto=0;
    String[] carrello=new String[25];
    int cont=0;
    public AbbigliamentoUomo() {
        JComboBox<String> abb = new JComboBox<>(abbigliamentoUomo);
        setTitle("Catalogo abbigliamento uomo");
        abb.setBounds(20, 20, 150, 25);
        add(abb);
        JList<String> listaProdotti = new JList<>();
        listaProdotti.setBounds(20, 60, 150, 100);
        add(listaProdotti);
        JTextArea dettagli = new JTextArea();
        dettagli.setBounds(200, 20, 450, 140);
        add(dettagli);
        agg.setBounds(20, 210, 200, 30);
        vis.setBounds(270, 210, 200, 30);
        add(agg);
        add(vis);

        abb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = abb.getSelectedIndex();
                listaProdotti.setListData(tutti[i]);
                dettagli.setText("");

            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int prezzo;
                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto.equals("Felpa nera")) {
                    prezzo = 50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                conto = conto + prezzo;
                                carrello[cont] = prodotto;
                                cont++;
                            }
                        }
                    });
                } else if (prodotto.equals("Felpa rossa")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                conto = conto + prezzo;
                                carrello[cont] = prodotto;
                                cont++;
                            }
                        }
                    });
                }else if (prodotto.equals("Felpa cappuccio")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa con stampa e cappuccio");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                conto = conto + prezzo;
                                carrello[cont] = prodotto;
                                cont++;
                            }
                        }
                    });
                }
            }
        });
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,300);
        setVisible(true);
    }}
