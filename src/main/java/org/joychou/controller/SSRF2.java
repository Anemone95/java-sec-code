package org.joychou.controller;

import com.google.common.io.Files;
import com.squareup.okhttp.OkHttpClient;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.joychou.nonce.Passthrough1;
import org.joychou.nonce.Passthrough2;
import org.joychou.nonce.Passthrough4;
import org.joychou.nonce.Sink;
import org.joychou.security.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author  JoyChou (joychou@joychou.org)
 * @date    2017.12.28
 * @desc    Java ssrf vuls code.
 */

@Controller
@RequestMapping("/ssrf2")
public class SSRF2 {

    @RequestMapping("/urlConnection")
    @ResponseBody
    public static String ssrf_URLConnection(HttpServletRequest request)
    {
        try {
            String url = request.getParameter("url");
            url= Passthrough1.url(url);
            int a=1;
            int b=2;
            URL u=new Passthrough2().pass2(url);
            int c=3+a
                    +b;
            return Sink.sink(u);
        }catch(Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/urlConnection2")
    @ResponseBody
    public static String ssrf_URLConnection2(HttpServletRequest request)
    {
        try {
            String url = request.getParameter("url");
            url= Passthrough1.url(url);
            int a=1;
            int b=2;
            URL u=new Passthrough2().pass2(url);
            int c=3+a
                    +b;
            return Passthrough4.pass(u);
        }catch(Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/url2")
    @ResponseBody
    public static String ssrf_2(HttpServletRequest request)
    {
        try {
            String url = request.getParameter("url");
            return Sink.sink(new URL(url));
        }catch(Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
