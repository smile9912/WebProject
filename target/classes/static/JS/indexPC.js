window.onload=function(){
    var userName = localStorage.getItem("userName")
    var notLogin = document.getElementById("notLogin")
    var alreadyLogin = document.getElementById("alreadyLogin")
    if(userName != null){
        // 登录成功
        notLogin.style.display = 'none'
        alreadyLogin.style.display = 'inline'
    }
    else {
        notLogin.style.display = 'inline'
        alreadyLogin.style.display = 'none'
    }


    // 商品展示
    var xhr = new XMLHttpRequest()

    xhr.onload = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            var JsonArray = JSON.parse(this.responseText)
            for(var idx in JsonArray) {
                var main = document.getElementsByTagName("main")[0]
                var commodity = document.createElement("div")

                commodity.setAttribute("class", "commodity")
                commodity.setAttribute("id", JsonArray[idx].id)

                commodity.onclick = productINF

                main.appendChild(commodity)
                var img = document.createElement("img")


                img.src = JsonArray[idx].img


                commodity.appendChild(img)
                var div = document.createElement("div")
                div.innerHTML = JsonArray[idx].name + '<br>' + JsonArray[idx].description
                commodity.appendChild(div)
            }
        }
    }

    xhr.open('GET', 'http://localhost:8080/selectAll')
    xhr.send()
}




//退出
var logout = document.getElementById("logout")
logout.addEventListener('click', function(){
    localStorage.removeItem("userName");

    var notLogin = document.getElementById("notLogin")
    var alreadyLogin = document.getElementById("alreadyLogin")
    notLogin.style.display = 'inline'
    alreadyLogin.style.display = 'none'
})


// 个人资料
var person_inf = document.getElementById("person_inf")
person_inf.onclick = function() {
    var userName = localStorage.getItem("userName")
    if (userName != null) {
        location.href = "personINF.html"
    }
    else {

        alert("未登录")
        location.href = "login.html"
    }
}




// 购物车
var myCar = document.getElementById("myCar")
myCar.addEventListener('click', function(){
    var userName = localStorage.getItem("userName")
    if(userName != null){

    }
    else {
        alert('未登录！请登录')
        location.href = "login.html"
    }
})





//点击商品

function productINF() {
    localStorage.setItem('productId', this.id)
    window.open("productINF.html")
}



// 商品展示




