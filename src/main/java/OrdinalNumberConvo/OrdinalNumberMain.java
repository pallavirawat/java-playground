package OrdinalNumberConvo;

public class OrdinalNumberMain {
    public static void main(String[] args) {
        int number = 12;
        String ordNumber = new OrdinalNumberConverter().convert(number);
        System.out.println("ord number is:" + ordNumber);
    }
}
