package OrdinalNumberConvo;

public class OrdinalNumberConverter {
    public String convert(int number) {
        int onesDigit  = number %10;
        int tensDigit  = (number %100)/10;

        if(tensDigit==1)
            return number + "th";
        if(onesDigit==1)
            return number + "st";
        if(onesDigit==2)
            return number + "nd";
        if(onesDigit==3)
            return number + "rd";

        return number + "th";
    }
}
