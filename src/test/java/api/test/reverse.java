package api.test;

public class reverse {

    public static void main(String[] args) {

        String base = "Toronto";

        String reverse = "";

        for (int i = base.length()-1 ; i >= 0 ; i--) {
            reverse+= base.charAt(i);

        }

        System.out.println(reverse);
    }
}
