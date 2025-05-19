import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    public AbbigliamentoUomo(ArrayList<String> carrello,ArrayList<Integer> conto) {
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
                    prezzo = 50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: felpa tinta unica con cappuccio");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
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
                                carrello.add(prodotto);
                                conto.add(prezzo);
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
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }

                    });
                }else if (prodotto.equals("Maglione lana")) {
                    prezzo = 55;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione lana pura");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if (prodotto.equals("Maglione con papera")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Maglione colorato con ricamo");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if (prodotto.equals("Maglia bianca")) {
                    prezzo = 30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: maglia tinta unita");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if (prodotto.equals("Maglia adidas")) {
                    prezzo = 25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: T-shirt adidas con logo sul retro");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if (prodotto.equals("Jeans skinny")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jeans versione stretta");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if (prodotto.equals("Jeans bianchi")) {
                    prezzo = 45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" + prezzo + "\nDescrizione: Jenas bianchi a palazzo");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto = (JButton) e.getSource();
                            if (premuto == agg) {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
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
                    for(Integer c:conto)
                    {
                        tot=tot+c;
                    }
                    contenuto.append("\nTOTALE: €").append(tot);

                    car.setText(contenuto.toString());
                    finestraCarrello.add(new JScrollPane(car), BorderLayout.CENTER);
                    finestraCarrello.setVisible(true);

                }
            }
        });

        tornaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(tornaMenu==c)
                {
                    new Menu();
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);
    }}
