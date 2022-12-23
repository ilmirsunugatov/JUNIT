public class Tax {
    public static int taxEarning(int earning) {
        int tax = earning * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningMinusSpending(int earning, int spending) {
        int tax = (earning - spending) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }

    }
}
