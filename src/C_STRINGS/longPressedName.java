package C_STRINGS;

public class longPressedName {
    public boolean isLongPressedName(String name, String typed) {

        // CASE 2
        if (name.length() > typed.length())
            return false;

        int i = 0; // name string
        int j = 0; // typed string

        // CASE 1
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (0 <= i - 1 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        // CASE 3
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(i - 1)) {
                return false;
            }
            j++;
        }

        // CASE 4
        return i < name.length() ? false : true;
    }
}
