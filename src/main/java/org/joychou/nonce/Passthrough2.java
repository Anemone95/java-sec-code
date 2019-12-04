package org.joychou.nonce;

import java.net.MalformedURLException;
import java.net.URL;

public class Passthrough2 {
    public URL pass2(String s) throws MalformedURLException {
        return new URL(s);
    }
}
