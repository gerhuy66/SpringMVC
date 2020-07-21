/**
 * 
 */
function clickOrder(){
	document.cookie = "TotalItem=0"+";path=/MvcWeb";

	
	
}
function loadCart(){
	var bodyContent = document.getElementById("itemList");
	var listItem = getCookie("ItemInCart");
	var items = listItem.split(",");
	var lines ="";
	lines +="<h3 style=\"display:inline;\">"+"Product ID"+"</h3>"+"<b>"+"Product Name"+"</b>"+"<b>"+"Product Image"+"</b>"+"<b>"+"Price"+"</b><br>";
	for(var i = 0; i < items.length; i++){
		data = items[i].split("-");
		lines += "<h3 style=\"display:inline;\">"+data[0]+"</h3>"+"<b>"+data[1]+"</b>"+"<img src=\""+data[2]+"\">"+"<b>"+data[3]+"</b><br>";
	}
	console.log(lines);

	bodyContent.innerHTML = "<div id = \"boxLine\">"+lines+"</div>";
	
	
}

function clickBuyEvent(productId,productName,img,price){
	
	var totalCount = document.getElementById("TotalItemCart");
	totalCount.textContent = parseInt(totalCount.textContent,10)+1;
	document.cookie = "TotalItem="+totalCount.textContent+";path=/MvcWeb";
	if(getCookie("ItemInCart")==null){
		document.cookie = "ItemInCart="+productId+"-"+productName+"-"+img+"-"+price+";path=/MvcWeb";
		console.log("not found cookie ItemInCart");
	}
	else{
		console.log("found cookie ItemInCart,adding to cart");
		document.cookie = "ItemInCart="+getCookie("ItemInCart")+","+productId+"-"+productName+"-"+img+"-"+price+";path=/MvcWeb";
	}
}
function InitDataByCookies(){

	var totalItem = getCookie("TotalItem");
	if(totalItem ==null){
		document.getElementById("TotalItemCart").textContent =0;
	}else{
		document.getElementById("TotalItemCart").textContent = totalItem;
		
		
	}
		
}
function getCookie(name) {
    // Split cookie string and get all individual name=value pairs in an array
    var cookieArr = document.cookie.split(";");
    
    // Loop through the array elements
    for(var i = 0; i < cookieArr.length; i++) {
        var cookiePair = cookieArr[i].split("=");
        
        /* Removing whitespace at the beginning of the cookie name
        and compare it with the given string */
        if(name == cookiePair[0].trim()) {
            // Decode the cookie value and return
        	console.log("Found "+name+" value = "+cookiePair[1]);
            return cookiePair[1];
        }
    }
    
    // Return null if not found
    return null;
}