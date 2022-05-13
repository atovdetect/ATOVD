package com.ato.agent;


import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtoHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private byte[] requestBody = null;//  Used to save streams

    public AtoHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
//        requestBody = StreamUtils.copyToByteArray(request.getInputStream());
        byte[] bytes = IOUtils.toByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //  Read  requestBody  Data in
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * description:  Provide access to requestBody Methods
     *
     * @return byte[]
     * @version v1.0
     * @author w
     * @date 2021 year 4 month 20 Japan   Afternoon 4:02:29
     */
    public byte[] getRequestBody() {
        return requestBody;
    }
}
