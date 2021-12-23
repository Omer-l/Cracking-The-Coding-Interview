public class Q01_09 {
    private String substring1;
    private String substring2;

    public Q01_09(String substring1, String substring2) {
        this.substring1 = substring1;
        this.substring2 = substring2;
    }

    //Gets the beginning index of the two strings.
    public boolean isRotation() {
        int lengthOfString = substring1.length();

        /* Checks that substring1 and substring2 are equal length and not empty */
        if(lengthOfString == substring2.length() && lengthOfString > 0) {
            /* Concatenate substring1 and substring 2 within new buffer */
            String substring1substring1 = substring1 + substring1;
            return substring1substring1.contains(substring2);
        }

        return false;
    }
}
