/**
 * 
 */
function clickCartEven(){
	

	
	
}
function loadCart(){
	var bodyContent = document.getElementById("itemList");
	var listItem = getCookie("ItemInCart");
	var items = listItem.split(",");
	var lines ="";
	for(var i = 0; i < items.length; i++){
		console.log(items[i]);
		lines += "<h3>"+items[i]+"</h3><br>"
	}
	console.log(lines);
	bodyContent.innerHTML = lines;
}

function clickBuyEvent(productId){
	
	var totalCount = document.getElementById("TotalItemCart");
	totalCount.textContent = parseInt(totalCount.textContent,10)+1;
	document.cookie = "TotalItem="+totalCount.textContent;
	if(getCookie("ItemInCart")==null){
		document.cookie = "ItemInCart="+productId;
		console.log("not found cookie ItemInCart")
	}
	else{
		
		console.log("found cookie ItemInCart")
		document.cookie = "ItemInCart="+getCookie("ItemInCart")+","+productId;
	}
}
function InitDataByCookies(){

	var totalItem = getCookie("TotalItem");
	if(totalItem ==null){
		document.getElementById("TotalItemCart").textContent =0;
	}else{
		document.getElementById("TotalItemCart").textContent = totalItem;
		document.cookie = "ItemInCart="+getCookie("ItemInCart")+";path=/";
		console.log("ItemInCart="+getCookie("ItemInCart")+";path=/");
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