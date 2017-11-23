import org.swixml.SwingEngine;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.event.ActionEvent;

public class CurrencyController {

    JPanel preview;
    JTable curTable;

    CurrencyTable ct = new CurrencyTable();

    JRadioButton usd;
    JRadioButton eur;
    JRadioButton gbp;

    public Action view = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            preview.remove(curTable);

            if (usd.isSelected()) {

                curTable = ct.initCurrency(usd);
                preview.add(curTable);
                preview.updateUI();
            }

            if (eur.isSelected()) {

                curTable = ct.initCurrency(eur);
                preview.add(curTable);
                preview.updateUI();
            }

            if (gbp.isSelected()) {

                curTable = ct.initCurrency(gbp);
                preview.add(curTable);
                preview.updateUI();
            }
        }
    };

    private CurrencyController() throws Exception {
        /*SynthLookAndFeel synth = new SynthLookAndFeel();
        synth.load(CurrencyController.class.getResourceAsStream("mystyle"), CurrencyController.class);
        UIManager.setLookAndFeel(synth);*/
        new SwingEngine(this).render("currency_main_page.xml").setVisible(true);

    }

    public static void main(String[] args) throws Exception {

        new CurrencyController();

    }


}
