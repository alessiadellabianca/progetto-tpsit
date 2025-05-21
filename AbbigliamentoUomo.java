import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AbbigliamentoUomo extends JFrame{

    String[] abbigliamentoUomo = new String[]{"Felpe","Maglioni","T-Shirt","Jeans"};
    String[][] tutti= {
            {"Felpa nera","Felpa rossa","Felpa cappuccio"},
            {"Maglione lana","Maglione con papera"},
            {"Maglia bianca","Maglia adidas"},
            {"Jeans skinny","Jeans bianchi"},
    };

    String[][] descrizioni = {
            {"felpa tinta unica con cappuccio", "felpa tinta unica con cappuccio", "felpa con stampa e cappuccio"},
            {"Maglione lana pura", "Maglione colorato con ricamo"},
            {"maglia tinta unita", "T-shirt adidas con logo sul retro"},
            {"Jeans versione stretta", "Jeans bianchi a palazzo"}
    };

    int[][] prezzi = {
            {50, 45, 30},
            {55, 45},
            {30, 25},
            {45, 45}
    };

    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    List<String> righe = new ArrayList<>();
    public AbbigliamentoUomo(ArrayList<String> carrello,ArrayList<Integer> conto) {

            try {
                righe= Files.readAllLines(Paths.get("listauomo.txt"));
            } catch (Exception e) {
                e.printStackTrace();
            }

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
        tornaMenu.setBounds(100, 270, 200, 30);
        add(agg);
        add(vis);
        add(tornaMenu);

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
                    if (righe.contains(prodotto)) {
                        prezzo = 50;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                } else if (prodotto.equals("Felpa rossa")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 45;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if (prodotto.equals("Felpa cappuccio")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa con stampa e cappuccio");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
              }else if (prodotto.equals("Maglione lana")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 55;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione lana pura");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }
               }else if (prodotto.equals("Maglione con papera")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 45;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione colorato con ricamo");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if (prodotto.equals("Maglia bianca")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 30;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: maglia tinta unita");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if (prodotto.equals("Maglia adidas")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 25;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: T-shirt adidas con logo sul retro");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if (prodotto.equals("Jeans skinny")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 45;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jeans versione stretta");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }else if (prodotto.equals("Jeans bianchi")) {
                    if (righe.contains(prodotto)) {
                        prezzo = 45;
                        dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jenas bianchi a palazzo");
                    } else {
                        dettagli.setText("Prodotto attualmente non disponibile");
                    }

                }
            }
        });

        vis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton premuto=(JButton)e.getSource();
                if(premuto==vis)
                {
                    int tot=0;
                    JFrame finestraCarrello = new JFrame("Carrello");
                    finestraCarrello.setSize(400, 300);
                    finestraCarrello.setLayout(new BorderLayout());
                    JButton t=new JButton("Torna alla zona acquisti");
                    JTextArea car = new JTextArea();
                    StringBuilder contenuto = new StringBuilder("PRODOTTI NEL CARRELLO:\n\n");
                    contenuto.append("- ").append(carrello).append("\n");
                    JButton termina=new JButton("CONCLUDI ORDINE");
                    for(Integer c:conto)
                    {
                        tot=tot+c;
                    }
                    contenuto.append("\nTOTALE: €").append(tot);

                    car.setText(contenuto.toString());
                    finestraCarrello.add(new JScrollPane(car), BorderLayout.CENTER);
                    finestraCarrello.add(termina,BorderLayout.NORTH);
                    finestraCarrello.setVisible(true);

                    termina.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton prem=(JButton)e.getSource();
                            if(prem==termina)
                            {
                                new GestioneOrdine(carrello,conto);
                            }
                        }
                    });

                }
            }
        });

        tornaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(tornaMenu==c)
                {
                    dispose();
                    new Menu();
                }
            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int catIndex = abb.getSelectedIndex();
                int prodIndex = listaProdotti.getSelectedIndex();

              if (catIndex>=0&&prodIndex>=0) {
                    String nome = tutti[catIndex][prodIndex];
                    int prezzo = prezzi[catIndex][prodIndex];
                    String descrizione = descrizioni[catIndex][prodIndex];

                    dettagli.setText("Prodotto: " + nome + "\nPrezzo: €" + prezzo + "\nDescrizione: " + descrizione);

                    for (ActionListener al : agg.getActionListeners()) {
                        agg.removeActionListener(al);
                    }

                    agg.addActionListener(ae -> {
                        carrello.add(nome);
                        conto.add(prezzo);
                        JOptionPane.showMessageDialog(null, nome + " aggiunto al carrello!");
                    });
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);
    }}
