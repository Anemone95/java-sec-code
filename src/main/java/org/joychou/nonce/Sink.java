package org.joychou.nonce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Sink {
    public static String sink(URL u) throws IOException {
        u=Passthrough3.retURL(u);
        URLConnection urlConnection = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); //send request
        String inputLine;
        StringBuffer html = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            html.append(inputLine);
        }
        in.close();
        return html.toString();
    }
}
