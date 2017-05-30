package com.company;

import java.util.Random;

/**
 * Created by Yk on 2017/5/30.
 */
public class Char {
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    int index = random.nextInt(str.length());
    char c = str.charAt(index);
    StringBuffer stringBuffer = new StringBuffer();
    int stringLength = (int) (Math.random() * 50);

    public String sss() {
        for (int j = 0; j < stringLength; j++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            stringBuffer.append(c);
        }
        String string = stringBuffer.toString();
        return string;
    }

    char[] Chars() {
        String s = sss();
        char[] in = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            in[i] = s.charAt(i);
        }

        return in;
    }
}
