package by.belstu.it.shumskiy.basejava;
import static java.lang.Math.*;

public class JavaTest {

    private static int sing;

    final int aint = 10;
    public final int bint = 10;
    public static final int cint = 10;

    public static void main(String[] args) {
        char ichar = '1';
        String istr = "11";
        int iint = 11;
        short ishort = 11;
        byte ibyte = 11;
        long ilong = 11L;
        double idouble = 11;
        boolean ibool = true;

        String result = istr + iint;
        System.out.println(result);

        result = istr + ichar;
        System.out.println(result);

        result = istr + idouble;
        System.out.println(result);

        byte bresult = (byte) (ibyte + iint);
        System.out.println(bresult);

        int iresult = (int) (idouble + ilong);
        System.out.println(iresult);

        long lresult = 0 + 2147483647;
        System.out.println(lresult);


        System.out.println(sing);

        System.out.println(ibool && false);

        System.out.println(ibool ^ false);

//        System.out.println(false + true);

        long along = 9223372036854775807L;
        long blong = 0x7ffffffffffL;

        System.out.println(along);
        System.out.println(blong);

        char cchar = 'a';
        char dchar = '\u0061';
        char echar = 97;

        System.out.println(cchar);
        System.out.println(dchar);
        System.out.println(echar);

        System.out.println((char)(cchar + dchar + echar));

        System.out.println(3.45 % 2.4);
        System.out.println(1.0 / 0.0);
        System.out.println(0.0 / 0.0);

        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));

        System.out.println(PI);
        System.out.println(E);

        System.out.println(min(PI, E));



        Boolean newBool = true;
        Character newChar = 'a';
        Integer newInt = 10;
        Byte newByte = 10;
        Short newShort = 10;
        Long newLong = 10L;
        Double newDouble = 10D;

        System.out.println(newInt>>2);
        System.out.println(newInt>>>2);
        System.out.println(~newInt);
        System.out.println(newInt&newShort);
        System.out.println(newInt * 2);
        System.out.println(newInt - newShort);
        System.out.println(newInt + newLong);

        System.out.println(Long.MAX_VALUE + " # LONG # " + Long.MIN_VALUE);
        System.out.println(Double.MAX_VALUE + " # DOUBLE # " + Double.MIN_VALUE);


    }
}
