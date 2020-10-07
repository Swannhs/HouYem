package com.example.demo.admin.AdminController;

import com.example.demo.admin.configuration.PdfGeneratorUtil;
import com.example.demo.employee.entity.CertificateEntity;
import com.example.demo.employee.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/certificate/print")
public class PrintController {
    @Autowired
    private PdfGeneratorUtil pdfGeneratorUtil;
    @Autowired
    private CertificateService service;

    @GetMapping("/{name}")
    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
                                    @PathVariable("name") String name) throws Exception {
        Map<String, String> data = new HashMap<String, String>();
        CertificateEntity certificateEntity = service.findByName(name);
        data.put("date", certificateEntity.getDate().toString());
        data.put("name", certificateEntity.getName().toString().toUpperCase());
        data.put("from_date", certificateEntity.getFrom_date().toString());
        data.put("to_date", certificateEntity.getTo_date().toString());
        data.put("employee", certificateEntity.getEmployee().toString());

        File file = new File(pdfGeneratorUtil.createPdf("certificatePDF", data, name).getAbsolutePath());
        if (file.exists()) {

            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));


            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        }
    }
}
