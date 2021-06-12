package ar.edu.unlp;

import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws ParseException {
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022"));

        System.out.println(new java.util.Date());

        System.out.println(new java.text.SimpleDateFormat("dd 'dias del mes de' MMMM 'de' yyyy", new java.util.Locale("es")).format(new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022")));

        System.out.println(new java.text.SimpleDateFormat("dd 'días del mes de' MMMM 'de' yyyy", new java.util.Locale("es")).format(new java.util.Date()));
    }

}
