package assigment.entity.controller;

import assigment.entity.ActiveCode;
import org.apache.commons.lang3.RandomStringUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ActiveController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ActiveController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String srtEmail = (String) req.getSession().getAttribute("account");

        ActiveCode activeCode = new ActiveCode();
        ofy().save().entity(activeCode).now();
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("doanncd00530@fpt.edu.vn", "Example.com Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(srtEmail, "Mr. User"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText(activeCode.getCode());
            Transport.send(msg);
        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            // ...
        }
        LOGGER.info("kiem tra acc = " + srtEmail);
        LOGGER.info("kt activecode = " + activeCode);
        LOGGER.info("Kt keycode == " + activeCode.getCode());
        req.getRequestDispatcher("/account/active.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");

    }

}
