import org.json.JSONObject;

import javax.swing.*;

class CurrencyTable {


    private static final String DATE = "Date";
    private static final String VALUTE = "Valute";
    private static final String VALUE = "Value";
    private static final String PREVIOUS_URL = "PreviousURL";
    private static final String HTTPS = "https:";
    private static final String US_DOLLARS = "US Dollars";
    private static final String USD = "USD";
    private static final String EURO = "Euro";
    private static final String EUR = "EUR";
    private static final String UK_POUNDS = "UK Pounds";
    private static final String GBP = "GBP";
    private static final String PRICE = "Price";


    private JTable curTable;
    private Object[] columns = {DATE, PRICE};
    private Object[][] data = {
            {DATE, PRICE},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""}
    };

    public CurrencyTable() {}

    /*********************************/

    Thread getCurrencyPricesThread;
    JSONObject json;
    int count = 1;

    void getCurrencyPrices(final String currency) {
        getCurrencyPricesThread = new Thread() {
            public void run() {
                json = CurrencyLoader.getJSONData(CurrencyLoader.CURRENCY_API);
                if (json == null) {
                    System.out.println("Connection ERROR");
                } else {
                    while (count < 8) {
                        String date = json.getString(DATE);
                        double price = json.getJSONObject(VALUTE).getJSONObject(currency).getDouble(VALUE);
                        data[count][0] = date;
                        data[count++][1] = price;
                        String previousURL = json.getString(PREVIOUS_URL);
                        json = CurrencyLoader.getJSONData(HTTPS + previousURL);
                    }
                    count = 1;
                }
            }
        };
        getCurrencyPricesThread.start();
    }


    void getPrice(String currency) {

        getCurrencyPrices(currency);

        try {
            getCurrencyPricesThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.curTable = new JTable(data, columns);
    }


    public JTable initCurrency(JRadioButton radioButton) {

        if (radioButton.getText().equals(US_DOLLARS)) {
            getPrice(USD);
        }

        if (radioButton.getText().equals(EURO)) {
            getPrice(EUR);

        }
        if (radioButton.getText().equals(UK_POUNDS)) {
            getPrice(GBP);

        }
        return curTable;
    }
}
