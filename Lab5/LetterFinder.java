public class LetterFinder {

    public static void main(String[] args) {
        String text = "bABBaM kApuT";

        String modifiedText = text.replaceAll("([a-z])([A-Z])", "!$2!");

        System.out.println(modifiedText);
    }
}
