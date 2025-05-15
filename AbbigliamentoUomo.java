import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

public class AbbigliamentoUomo extends JFrame {
    String[] abbigliamentoUomo = new String[]{"Felpe", "Maglioni", "T-Shirt", "Jeans"};
    String[][] tutti = new String[][]{{"Felpa nera", "Felpa rossa", "Felpa cappuccio"}, {"Maglione lana", "Maglione con papera"}, {"Maglia bianca", "Maglia adidas"}, {"Jeans skinny", "Jeans bianchi"}};
    JButton agg = new JButton("AGGIUNGI AL CARRELLO");
    JButton vis = new JButton("VISUALIZZA CARRELLO");
    int conto = 0;
    String[] carrello = new String[25];
    int cont = 0;

    public AbbigliamentoUomo(ArrayList<String> carrello, ArrayList<Integer> conto) {
        JComboBox<String> abb = new JComboBox(this.abbigliamentoUomo);
        this.setTitle("Catalogo abbigliamento uomo");
        abb.setBounds(20, 20, 150, 25);
        this.add(abb);
        JList<String> listaProdotti = new JList();
        listaProdotti.setBounds(20, 60, 150, 100);
        this.add(listaProdotti);
        JTextArea dettagli = new JTextArea();
        dettagli.setBounds(200, 20, 450, 140);
        this.add(dettagli);
        this.agg.setBounds(20, 210, 200, 30);
        this.vis.setBounds(270, 210, 200, 30);
        this.add(this.agg);
        this.add(this.vis);
        abb.addActionListener(new AbbigliamentoUomo(abb, listaProdotti, dettagli));
        listaProdotti.addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                String prodotto = (String)listaProdotti.getSelectedValue();
                byte prezzo;
                if (prodotto.equals("Felpa nera")) {
                    prezzo = 50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    this.agg.addActionListener(new AbbigliamentoUomo(this, conto, prezzo, carrello, prodotto));
                } else if (prodotto.equals("Felpa rossa")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    this.agg.addActionListener(new AbbigliamentoUomo(this, conto, prezzo, carrello, prodotto));
                } else if (prodotto.equals("Felpa cappuccio")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa con stampa e cappuccio");
                    this.agg.addActionListener(new AbbigliamentoUomo(this, conto, prezzo, carrello, prodotto));
                } else if (prodotto.equals("Maglione lana")) {
                    prezzo = 55;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: maglione lana vera");
                    this.agg.addActionListener(new AbbigliamentoUomo(this, conto, prezzo, carrello, prodotto));
                } else if (prodotto.equals("Maglione con papera")) {
                    prezzo = 40;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: maglione lana pura e ricamato con disegno");
                    this.agg.addActionListener(new AbbigliamentoUomo(this, conto, prezzo, carrello, prodotto));
                } else if (prodotto.equals("Maglia bianca")) {
                    prezzo = 20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa con stampa e cappuccio");
                    this.agg.addActionListener(new AbbigliamentoUomo(this, conto, prezzo, carrello, prodotto));
                }
            }

        });
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(3);
        this.setSize(700, 300);
        this.setVisible(true);
    }
}