package org.joychou.nonce;

import java.net.URL;

public class Passthrough3 {
    public static URL retURL(URL u){
        String s=u.toString();
        u=Passthrough5.pass(u);
        return u;
    }
}
