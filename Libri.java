import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Libri extends JFrame {
    String[] libri = new String[]{"Fantasy","Fantascienza","Giallo","Narrativa","Romanzo Storico"};

    String[][] tutti= {
            {"Il trono di spade","Il signore degli anelli","Le cronache di Narnia","Harry Potter","Lo Hobbit"},
            {"Frankenstein","Dune","1984","Le cronache marziane"},
            {"Pioggia per i bastardi di Pizzofalcone","Dieci piccoli indiani","Il padrino","Hannibal"},
            {"Istella mea","La prima regina","Onesto","L'Anniversario","I sette corvi"},
            {"I promessi sposi","Ivanhoe","Guerra e pace","Il gattopardo","I tre moschettieri"}
    };
    JButton agg= new JButton("AGGIUNGI AL CARRELLO");
    JButton vis= new JButton("VISUALIZZA CARRELLO");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");

    JComboBox<String> lib = new JComboBox<>(libri);
    int prezzo=0;

    public Libri(ArrayList<String> carrello, ArrayList<Integer> conto)
    {
        setTitle("Catalogo libri");
        lib.setBounds(20, 20, 150, 25);
        add(lib);
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



        lib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i= lib.getSelectedIndex();
                listaProdotti.setListData(tutti[i]);
                dettagli.setText("");

            }
        });

        listaProdotti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto.equals("Il trono di spade")) {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:" +prezzo+"\nDescrizione: Romanzo fantasy scritto da George R. R. Martin");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Il signore degli anelli"))
                {
                    prezzo=25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantasy scritto da J. R. R. Tolkien");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });

                }  else if(prodotto.equals("Le cronache di Narnia"))
                {
                    prezzo=45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:+"+prezzo+"\nDescrizione: Serie di libri fantasy per ragazzi scritti da C.S. Lewis");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Harry Potter"))
                {
                    prezzo=50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Serie di libri fantasy per ragazzi scritti da J.K. Rowling");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Lo Hobbit"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantasy di J.R.R. Tolkien");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                } else if(prodotto.equals("Frankenstein"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantascientifico di Mary Shelley");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Dune"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantascientifico di Frank Herbert");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("1984"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo fantascientifico di George Orwell");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Le cronache marziane"))
                {
                    prezzo=30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Raccolta di racconti di fantascienza di Ray Bradbury");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Pioggia per i bastardi di Pizzofalcone"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Maurizio de Giovanni");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Dieci piccoli indiani"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Agatha Christie");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Il padrino"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Mario Puzo");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Hannibal"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Thomas Harris");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Istella mea"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo di narrativa di Ciriaco Offeddu");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("La prima regina"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Romanzo di narrativa di Alessandra Selmi");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("Onesto"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo di narrativa di Francesco Vidotto");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("L'Anniversario"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo di narrativa di Andrea Bajani");
                    agg.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton premuto=(JButton)e.getSource();
                            if(premuto==agg)
                            {
                                carrello.add(prodotto);
                                conto.add(prezzo);
                            }
                        }
                    });
                }else if(prodotto.equals("I sette corvi")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo di narrativa di Matteo Strukul");
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
                }else if(prodotto.equals("I promessi sposi")) {
                    prezzo = 25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Alessandro Manzoni");
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
                }else if(prodotto.equals("Ivanhoe")) {
                    prezzo = 20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Walter Scott");
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
                }else if(prodotto.equals("Guerra e pace")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Lev Tolstoj");
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
                }else if(prodotto.equals("Il gattopardo")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Giuseppe Tomasi di Lampedusa");
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
                }else if(prodotto.equals("I tre moschettieri")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Alexandre Dumas");
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

    }
}
