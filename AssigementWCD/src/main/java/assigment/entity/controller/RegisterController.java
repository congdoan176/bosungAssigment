package assigment.entity.controller;

import assigment.entity.Account;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import static com.googlecode.objectify.ObjectifyService.ofy;
public class RegisterController extends HttpServlet {
    private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private static ImagesService imagesService = ImagesServiceFactory.getImagesService();
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");

        Account account = new Account();
        account.setEmail(email);
        account.setPassword(password);
        account.setName(name);
        account.setPhone(phone);
        account.setStatus(1);

        Map<String, List<BlobKey>> blobkeyMap = blobstoreService.getUploads(req);
        List<BlobKey> avatarKey = blobkeyMap.get("imgUrl");
        if (avatarKey.size() > 0) {
            account.setImgUrl(imagesService.getServingUrl(ServingUrlOptions.Builder.withBlobKey(avatarKey.get(0))));
        } else {
            account.setImgUrl("/default-image.jpeg");
        }
        if(ofy().load().type(Account.class).id(account. getEmail()).now() == null){
            ofy().save().entity(account).now();
            req.setAttribute("account", account.getEmail());
            HttpSession session = req.getSession();
            session.setAttribute("account", account.getEmail());
            resp.sendRedirect("/account/active");
        }else {
            resp.sendRedirect("/account/register");
        }

    }
}
