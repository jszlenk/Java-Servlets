package gzip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

class Gzip {
    static boolean isGzipSupported(HttpServletRequest request) {
        String encodings = request.getHeader("Accept-Encoding");
        return (encodings != null) && (encodings.contains("gzip"));
    }

    static boolean isGzipDisabled(HttpServletRequest request) {
        String flag = request.getParameter("disableGzip");
        return (flag != null);
    }

    static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
        return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
    }
}
