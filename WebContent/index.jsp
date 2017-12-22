<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Registration and Authorization</title>
 	<!--	<link rel="stylesheet" href="/WEB-INF/style/style.css"/> -->
  <style> 

  body{
	background: url("https://goo.gl/NFXGdL") no-repeat center top; 
	margin: 0px;
	padding: 0px;    
		}
  h1{
	font-size: 70px;
	color: skyblue; 
	font-family: arial; 
	font-weight: bold;  
	padding-left: 5%;
	margin-bottom: 0px;
		}          
  h3{
	margin-top: 170px;   
		}
  form>span{
	font-style: italic;  
		}
  .forms{                                      
	width: 500px;
	margin-left: auto;
	margin-right: auto;
		}
  hr{
	width: 95%;
		}                                         
  .form{
	text-align: left; 
	width: 45%; 
	margin-bottom: 20px;                                      
		}
  .signin{
	float: left;
		}     
  .signup{
	float: right;
		}
  input{
	margin-bottom: 10px;                                       
		}
  .showbutton{
  	width: 20%;
  	margin-left: auto;
  	margin-right: auto;
  		}
  .footer{
	position: absolute;
	bottom: 0px;
	width: 90%;
	height: 25px;
	background-color: skyblue;
	color: white;
	clear: both;
	text-align: right;
	padding-right: 5%;
	padding-left: 5%;
		}
  a:link { 
	text-decoration: underline;  
	color: white;
		}
  a:hover { 
	color: purple;
		}
  a:active { 
	color: green;
		}
  .footer>p{
	width: 100%;
	background-color: skyblue;
		}

  </style>  

</head>

    <body>

      <h1>LikeIT</h1>

      <hr>

      <div class="forms">    
                                   
          <div class = "form signin">

            <h3>Sign in:</h3>

            <form action="FrontController" method='post'>
                <input type="hidden" name="command" value = "finduser"/>
                <span>Enter your login:</span>
                <input type="text" name ="login" value=""/>
                <br/>
                <span>Enter your password:</span>
                <input type="password" name="password" value=""/>
                <input type="submit" value="Sign in"/>
            </form>

          </div>  
                                      
          <div class = "form signup">

            <h3>Or sign up:</h3>

            <form action="FrontController" method='post'>
                <input type="hidden" name="command" value = "adduser"/>
                <span>Enter new login:</span>
                <input type="text" name ="login" value=""/>
                <br/>
                <span>Enter new password:</span>
                <input type="password" name="password" value=""/>
                <input type="submit" value="Sing up"/>
            </form>

          </div>

      </div>  
      <form class="showbutton" action="FrontController" method='post'>
            <input type="hidden" name="command" value = "showusers"/>
            <input type="submit" value="SHOW ALL USERS"/>
      </form>
      <div class="footer">
	<span><a href="mailto:leta.rudzko@gmail.com">Olga Rudzko</a> 2017</span>
      </div>                                    
   </body>
 
 <!--   </head>
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
    </body> -->
</html>