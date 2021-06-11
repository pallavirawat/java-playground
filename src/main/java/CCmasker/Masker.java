package CCmasker;

class Masker {
    String MASKING_CHARACTER = "X";
    int MIN_MASKING_LENGTH = 6;

    public String mask(String creditCardInfo) {
        if (creditCardInfo.length() < MIN_MASKING_LENGTH)
            return creditCardInfo;

        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < creditCardInfo.length(); i++) {
            char currentCardDigit = creditCardInfo.charAt(i);
            if (positionCanBeMasked(i, creditCardInfo.length()) && characterIsNumeric(currentCardDigit)) {
                masked.append(MASKING_CHARACTER);
            } else {
                masked.append(currentCardDigit);
            }

        }
        return masked.toString();
    }

    private boolean characterIsNumeric(char charAt) {
        return Character.isDigit(charAt);
    }

    private boolean positionCanBeMasked(int position, int totalCardLength) {
        return position == 0 || (position >= (totalCardLength - 4) && position < (totalCardLength));
    }
}
