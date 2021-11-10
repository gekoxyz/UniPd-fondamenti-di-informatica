public class IsLeapYear {
    public IsLeapYear() {

    }

    /**
     * Method to check if a year is a leap year
     * @param year
     * @return 1 if year is a leap year, -1 if it's not
     */
    public int isLeapYear(int year) {
        if (year > 1582 && !(year % 100 == 0) && (year % 400 == 0 || year % 4 == 0)) {
            return 1;
        }
        return -1;
    }
}
