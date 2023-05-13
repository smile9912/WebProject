var register = document.getElementById("register")
var login = document.getElementById("login")

register.addEventListener('click', function(){
    location.href = "register.html"
})

login.addEventListener('click', function(){
    var xhttp = new XMLHttpRequest();
    var userName = document.getElementById("userName").value
    var passWord = document.getElementById("passWord").value
    xhttp.onload = function() {
        if (this.readyState == 4 && this.status == 200) {
            if(this.responseText == 'true'){
                localStorage.setItem('userName', userName)
                location.href = 'index.html'
            }
            else {
                alert("登录失败")
            }
        }
    };
    var url = 'http://localhost:8080/login?userName=' + userName + '&passWord=' + passWord
    xhttp.open("GET", url);
    xhttp.send();
})