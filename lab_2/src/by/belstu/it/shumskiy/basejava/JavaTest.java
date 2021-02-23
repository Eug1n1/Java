package by.belstu.it.shumskiy.basejava;
import java.nio.charset.StandardCharsets;

import static java.lang.Math.*;

public class JavaTest {

    private static int sing;

    /**
     * @value 10
     * @see 10
     */
    final int aint = 10;
    public final int bint = 10;
    public static final int cint = 10;

    /**
     * @param args
     * @return 0
     * @throws 1
     */
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

        long lresult = 10 + 2147483647;
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
        System.out.println(Math.log(-345));

        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));

        System.out.println(PI);
        System.out.println(E);

        System.out.println(min(PI, E));

        System.out.println(round(PI));
        System.out.println(round(E));



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

        //packing
        int a = 10;
        Integer aI = a;

        byte u = 10;
        Byte uB = u;

        //unpacking
        int bI = aI;

        byte oB = uB;


        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.toHexString(123));
        System.out.println(Integer.compare(12,45));
        System.out.println(Integer.toString(456));
        System.out.println(Integer.bitCount(123));
        System.out.println(Float.isNaN(bI));

        String hS = "376";
        int hI = Integer.valueOf(hS);
        hI = Integer.parseInt(hS);
        byte[] hB = hS.getBytes();

        System.out.println(hB);
        System.out.println(new String(hB));

        String v = "true";
        String vv = "false";

        System.out.println(Boolean.valueOf(v));
        System.out.println(Boolean.parseBoolean(vv));

        String t = "true";
        String tt = "true";

        System.out.println(t == tt);
        System.out.println(t.equals(tt));
        System.out.println(t.compareTo(tt));

//        tt = null;
        System.out.println(t == tt);
        System.out.println(t.equals(tt));
        System.out.println(t.compareTo(tt));

        System.out.println(t.split("123"));
        System.out.println(t.contains("tr"));
        System.out.println(t.hashCode());
        System.out.println(t.indexOf("u"));
        System.out.println(t.length());
        System.out.println(t.replace('t', 's'));

        char[][] jj;
        char [] j;
        char jjj[];

        jj = new char[3][];
        jj[0] = new char[3];
        jj[1] = new char[4];
        jj[2] = new char[5];

        System.out.println(jj.length);
        System.out.println(jj[0].length);
        System.out.println(jj[1].length);
        System.out.println(jj[2].length);

        j = new char[]{'1', '2', '3'};
        jjj = new char[]{'1', '2', '3'};

        System.out.println(j == jjj);

        j = jjj;
        System.out.println(j == jjj);

        for ( char k : jjj ) {
            System.out.println(k);
        }

//        for ( int i = 0; i < jjj.length + 1; i++ ) {
//            System.out.println(jjj[i]);
//        }

        WrapperString str = new WrapperString("tyuiop");
        str.replace('t', 'y');

        WrapperString str1 = new WrapperString("fyguhajids"){
          @Override
          public void replace(char oldChar, char newChar)
          {
              System.out.println("replace");
          }

          public void delete(char newChar)
          {
              System.out.println(newChar);
          }
        };

    }
}
