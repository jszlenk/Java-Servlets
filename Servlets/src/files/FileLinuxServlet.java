package files;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FileLinuxServlet", urlPatterns = {"/FileLinuxServlet"},
        initParams = {@WebInitParam(name = "FILE_UPLOAD_PATH", value = "/home/jakub/")})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class FileLinuxServlet extends HttpServlet {

    private static final String SAVE_DIR = "Upload";
    private String fileUploadPath;

    public void init(ServletConfig config) {
        fileUploadPath = config.getInitParameter("FILE_UPLOAD_PATH");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        File fileSaveDir = new File(fileUploadPath, SAVE_DIR);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            if (part.getSubmittedFileName() != null) {
                String fileName = extractFileName(part);
                part.write(fileUploadPath + SAVE_DIR + File.separator + fileName);
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>File Upload Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>File Uploaded Successfully...");
        out.println("</body>");
        out.println("</html>");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Sorry!... GET method cant handle this request");
    }
}

//https://stackoverflow.com/questions/23452484/create-folder-and-upload-file-using-servlet