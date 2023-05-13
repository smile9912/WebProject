var productName = document.getElementById("name")
var select = document.getElementById("select")
var price = document.getElementById("price")
var file = document.getElementById("file")
var img = document.getElementById("img")
var description = document.getElementById("description")

var error1 = document.getElementById("error1")
var error2 = document.getElementById("error2")
var error3 = document.getElementById("error3")
var error4 = document.getElementById("error4")

var submit = document.getElementById("submit")


// css设置
img.setAttribute('style', 'display:none')
error4.setAttribute('style', 'display:none')
description.setAttribute('style', 'resize:none')






productName.onblur=function() {
    if(productName.value != '') {
        error1.setAttribute('style', 'display:none')
    }
    else {
        error1.setAttribute('style', 'display:inline')
    }
}

price.onblur = function () {
    if (price.value != '') {
        error2.setAttribute('style', 'display:none')
    }
    else {
        error2.setAttribute('style', 'display:inline')
    }
}

file.onchange = function() {
    if(file.files.length==0) {
        error3.setAttribute('style', 'display:inline')
        img.setAttribute('style', 'display:none')
    }
    else {
        error3.setAttribute('style', 'display:none')
        img.setAttribute('style', 'display:inline')
        img.src = URL.createObjectURL(file.files[0])
    }
}



submit.addEventListener("click", function() {
    if(productName.value == '') {
        error4.setAttribute('style', 'display:inline')
        return
    }

    if(price.value == '') {
        error4.setAttribute('style', 'display:inline')
        return
    }

    if(file.files.length == 0) {
        error4.setAttribute('style', 'display:inline')
        return
    }
    
   

    var formData = new FormData()
    formData.append('file', file.files[0])
    var xhr = new XMLHttpRequest()
    
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            var imgPath = this.responseText

            

            var xhr2 = new XMLHttpRequest()
    

            xhr2.onreadystatechange = function() {
                if(this.status == 200 && this.readyState == 4) {
                    // 跳转
                    alert("添加成功")
                }
            }
        
            var json = {
                id:null,
                name:productName.value,
                kind:select.options[select.selectedIndex].text,
                price:price.value,
                img:imgPath,
                description:description.value
            }
        
            // 
            xhr2.open("POST", "http://localhost:8080/addProduct", false)
        
            // 先open再set
            xhr2.setRequestHeader('Content-Type', 'application/json')

            // 
            xhr2.send(JSON.stringify(json))

        }
    }

    xhr.open("POST", "http://localhost:8080/upload", false)
    xhr.send(formData)

})