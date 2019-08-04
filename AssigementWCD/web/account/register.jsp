<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="assigment.entity.Account" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Register Form</h1>
<form action="<%= BlobstoreServiceFactory.getBlobstoreService().createUploadUrl("/account/register")%>"
      method="post"
      enctype="multipart/form-data">
    <div>
        email <input type="text" name="email">
    </div>
    <div>
        Password <input type="password" name="password">
    </div>
    <div>
        Name <input type="text" name="name">
    </div>
    <div>
        Phone <input type="text" name="phone">
    </div>
    <div>
        Avatar <input type="file" name="imgUrl">
    </div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>