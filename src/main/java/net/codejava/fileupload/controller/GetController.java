package net.codejava.fileupload.controller;

import net.codejava.fileupload.dao.FileGetDAO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

public class GetController<FileGetDAO> {

    @Autowired
    private FileGetDAO fileGetDao;

    @RequestMapping("/retrieve/{fileName}")
    public String download(@PathVariable("fileName")
                                   String fileName, HttpServletResponse response) {

        GetFile getFile = fileGetDao.get(fileName);
        try {
            response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(getFile.getContentType());
            IOUtils.copy(getFile.getContent().getBinaryStream(), out);
            out.flush();
            out.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
            //Handle exception here
        } catch (IOException e) {
            System.out.println(e.toString());
            //Handle exception here
        }

        return "Success";
    }
}

