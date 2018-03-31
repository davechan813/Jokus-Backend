/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.persistencyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utility {

    public static void displayText(InputStream input) throws IOException{
        // Read one text line at a time and display.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println("    " + line);
        }
    }
}
