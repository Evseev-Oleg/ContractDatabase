package sample.serverAndClient;

/**
 * класс описывающий обьект 'Договор'
 */
public class Contract {
    private String numberContract;
    private String dateContract;

    public Contract(String numberContract, String dateContract) {
        this.numberContract = numberContract;
        this.dateContract = dateContract;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract(String dateContract) {
        this.dateContract = dateContract;
    }
}
