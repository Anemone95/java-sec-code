package org.joychou.nonce;

import java.io.IOException;
import java.net.URL;

public class Passthrough4 {
    public static String pass(URL u) throws IOException {

        return Sink.sink(u);
    }

}
