package org.joychou.nonce;

import java.net.URL;

public class Passthrough5 {
    public static URL pass(URL u) {
        if (u.toString().startsWith("A"))
            return u;
        else
            return null;
    }
}
