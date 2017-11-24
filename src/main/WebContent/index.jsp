<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Registration and Authorization</title>
    </head>
    <body>
        <h2>Sign in:</h2>
        <form action="FrontController" method='post'>
            <input type="hidden" name="command" value = "finduser"/>
            Enter your login:
            <input type="text" name ="login" value=""/>
            <br/>
            Enter your password:
            <input type="password" name="password" value=""/>
            <input type="submit" value="Sign in"/>
        </form>
        <br/>
        <h2>Or sign up:</h2>
        <form action="FrontController" method='post'>
            <input type="hidden" name="command" value = "adduser"/>
            Enter new login:
            <input type="text" name ="login" value=""/>
            <br/>
            Enter new password:
            <input type="password" name="password" value=""/>
            <input type="submit" value="Sing up"/>
        </form>
        <br/>
        <form action="FrontController" method='post'>
            <input type="hidden" name="command" value = "showusers"/>
            <input type="submit" value="SHOW ALL USERS"/>
        </form>
    </body>
</html>