var body = document.getElementsByTagName("body")
var normal = document.getElementById("normal")
var light = document.getElementById("light")
var dark = document.getElementById("dark")


// 背景模式
normal.addEventListener('click', function(){
    body[0].style.backgroundColor = 'rgb(209, 226, 255)'
})

light.addEventListener('click', function(){
    body[0].style.backgroundColor = 'white'
})

dark.addEventListener('click', function(){
    body[0].style.backgroundColor = 'black'
})







// 百度地图API功能
var map = new BMap.Map("map");    // 创建Map实例
// map.centerAndZoom(new BMap.Point(116.404, 39.915), 16);  // 初始化地图,设置中心点坐标和地图级别
map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放


var positionStatus=document.getElementById("information");

var options = {enableHighAccuracy:true, maximumAge:60000, timeout: 5000};


//获取经纬度并显示
function showPosition(position){
    positionStatus.innerHTML="纬度Latitude: " + position.coords.latitude.toFixed(2) + "<br />"+  
                "经度Longitude: " + position.coords.longitude.toFixed(2) + "<br />"
    map.centerAndZoom(new BMap.Point(position.coords.latitude.toFixed(2), position.coords.longitude.toFixed(2)), 16);
}


//错误处理函数  
function showError(error){  
    switch(error.code)  //错误码
     {  
      case error.PERMISSION_DENIED:  //用户拒绝
        positionStatus.innerHTML="位置服务被拒绝。"  
        break;  
      case error.POSITION_UNAVAILABLE:  //无法提供定位服务  
        positionStatus.innerHTML="暂时获取不到位置信息。"  
        break;  
      case error.TIMEOUT:  //连接超时  
        positionStatus.innerHTML="获取信息超时。"  
        break;  
      case error.UNKNOWN_ERROR:  //未知错误  
        positionStatus.innerHTML="未知错误。"  
        break;  
    }
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 16);
} 


window.onload = function(){  
    if (navigator.geolocation){  //判断是否支持地理定位  
        //如果支持，则运行getCurrentPosition()方法。  
        navigator.geolocation.getCurrentPosition(showPosition, showError,options);  
        
   }else{  
        //如果不支持，则向用户显示一段消息  
        positionStatus.innerHTML="您的浏览器不支持HTML5 Geolocation！";  
    }  
}  