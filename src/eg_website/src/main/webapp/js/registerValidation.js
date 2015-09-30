function checkExist(){
                var xmlhttp = new XMLHttpRequest();
                var username = document.forms["registerForm"]["username"].value;
                var url = "/eg_website/UserRegisterValidation?username=" + username;
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                        if(xmlhttp.responseText == "Username is taken")
                            document.getElementById("username").style.color = "red";
                        else
                            document.getElementById("username").style.color = "green";
                        document.getElementById("username").innerHTML = xmlhttp.responseText;
                    }
                    
                };
                try{
                xmlhttp.open("GET",url,true);
                xmlhttp.send();
            }catch(e){alert("unable to connect to server");
            }
            }
            
            function checkExistEmail(){
                var xmlhttp = new XMLHttpRequest();
                var email = document.forms["registerForm"]["email"].value;
                var url = "/eg_website/RegisterUserEmailValidation?email=" + email;
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                        if(xmlhttp.responseText == "Email is taken")
                            document.getElementById("email").style.color = "red";
                        else
                            document.getElementById("email").style.color = "green";
                        document.getElementById("email").innerHTML = xmlhttp.responseText;
                    }
                    
                };
                try{
                xmlhttp.open("GET",url,true);
                xmlhttp.send();
            }catch(e){alert("unable to connect to server");
            }
            }