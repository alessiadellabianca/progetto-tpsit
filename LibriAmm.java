import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LibriAmm extends JFrame {
    String[] libri = new String[]{"Fantasy","Fantascienza","Giallo","Narrativa","Romanzo Storico"};

    String[][] tutti= {
            {"Il trono di spade","Il signore degli anelli","Le cronache di Narnia","Harry Potter","Lo Hobbit"},
            {"Frankenstein","Dune","1984","Le cronache marziane"},
            {"Pioggia per i bastardi di Pizzofalcone","Dieci piccoli indiani","Il padrino","Hannibal"},
            {"Istella mea","La prima regina","Onesto","L'Anniversario","I sette corvi"},
            {"I promessi sposi","Ivanhoe","Guerra e pace","Il gattopardo","I tre moschettieri"}
    };
   JButton elimina=new JButton("RENDI NON DISPONIBILE");
    JButton tornaMenu=new JButton("CAMBIA CATEGORIA");
    JButton logOut=new JButton("LOGOUT");
    List<String> righe = new ArrayList<>();

    JComboBox<String> lib = new JComboBox<>(libri);
    int prezzo=0;

    public LibriAmm()
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
        tornaMenu.setBounds(20, 210, 200, 30);
        elimina.setBounds(270, 210, 200, 30);
        logOut.setBounds(100, 270, 200, 30);
        add(logOut);
        add(elimina);
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
                } else if(prodotto.equals("Il signore degli anelli"))
                {
                    prezzo=25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantasy scritto da J. R. R. Tolkien");

                }  else if(prodotto.equals("Le cronache di Narnia"))
                {
                    prezzo=45;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:+"+prezzo+"\nDescrizione: Serie di libri fantasy per ragazzi scritti da C.S. Lewis");

                } else if(prodotto.equals("Harry Potter"))
                {
                    prezzo=50;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Serie di libri fantasy per ragazzi scritti da J.K. Rowling");
                } else if(prodotto.equals("Lo Hobbit"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantasy di J.R.R. Tolkien");
                } else if(prodotto.equals("Frankenstein"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantascientifico di Mary Shelley");

                }else if(prodotto.equals("Dune"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo:"+prezzo+"\nDescrizione: Romanzo fantascientifico di Frank Herbert");

                }else if(prodotto.equals("1984"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo fantascientifico di George Orwell");

                }else if(prodotto.equals("Le cronache marziane"))
                {
                    prezzo=30;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Raccolta di racconti di fantascienza di Ray Bradbury");

                }else if(prodotto.equals("Pioggia per i bastardi di Pizzofalcone"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Maurizio de Giovanni");

                }else if(prodotto.equals("Dieci piccoli indiani"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Agatha Christie");

                }else if(prodotto.equals("Il padrino"))
                {
                    prezzo=20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Mario Puzo");

                }else if(prodotto.equals("Hannibal"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo giallo di Thomas Harris");

                }else if(prodotto.equals("Istella mea"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo di narrativa di Ciriaco Offeddu");

                }else if(prodotto.equals("La prima regina"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: €"+prezzo+"\nDescrizione: Romanzo di narrativa di Alessandra Selmi");

                }else if(prodotto.equals("Onesto"))
                {
                    prezzo=10;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo di narrativa di Francesco Vidotto");

                }else if(prodotto.equals("L'Anniversario"))
                {
                    prezzo=15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: "+prezzo+"\nDescrizione: Romanzo di narrativa di Andrea Bajani");

                }else if(prodotto.equals("I sette corvi")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo di narrativa di Matteo Strukul");

                }else if(prodotto.equals("I promessi sposi")) {
                    prezzo = 25;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Alessandro Manzoni");

                }else if(prodotto.equals("Ivanhoe")) {
                    prezzo = 20;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Walter Scott");

                }else if(prodotto.equals("Guerra e pace")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Lev Tolstoj");

                }else if(prodotto.equals("Il gattopardo")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Giuseppe Tomasi di Lampedusa");

                }else if(prodotto.equals("I tre moschettieri")) {
                    prezzo = 15;
                    dettagli.setText("Prodotto: " + prodotto + "\nPrezzo: " + prezzo + "\nDescrizione: Romanzo storico di Alexandre Dumas");

                }
            }
        });

        elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prodotto = listaProdotti.getSelectedValue();
                if (prodotto != null && righe.contains(prodotto)) {
                    righe.remove(prodotto);
                    dettagli.setText("Prodotto non disponibile");

                    try {
                        StringBuilder sb = new StringBuilder();
                        for (String riga : righe) {
                            sb.append(riga).append("\n");
                        }
                        Files.writeString(Paths.get("listauomo.txt"), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Errore durante la scrittura sul file");
                        ex.printStackTrace();
                    }
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
                    new Menuamm();
                }
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton c=(JButton)e.getSource();
                if(logOut==c)
                {
                    dispose();
                    new Login();
                }
            }
        });


        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,350);
        setVisible(true);

    }
}

