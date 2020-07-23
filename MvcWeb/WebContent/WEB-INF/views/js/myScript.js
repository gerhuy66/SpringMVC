/**
 * 
 */
function clickOrder(){
	document.cookie = "TotalItem=0"+";path=/MvcWeb";
	document.cookie ="OrderItem="+getCookie("ItemInCart")+";path=/MvcWeb";
	document.cookie = "ItemInCart=; expires=Thu, 01 Jan 1970 00:00:00"+";path=/MvcWeb";
	
	
}

function loadHistory(){
	
}
function loadCart(){
	var bodyContent = document.getElementById("itemList");
	var listItem = getCookie("ItemInCart");
	var totalPrice = 0;
	if(listItem != null){
		var items = listItem.split(",");
		var lines ="";
		lines +="<h3 style=\"display:inline;\">"+"Product ID---"+"</h3>"+"<b>"+"Product Name---"+"</b>"+"<b>"+"Product Image---"+"</b>"+"<b>"+"Price---"+"</b><b>Amount</><br>";
		for(var i = 0; i < items.length; i++){
			data = items[i].split("-");
			lines += "<span id=\"itemLine"+data[0]+"\"><h3 style=\"display:inline;\">"
				+data[0]+"</h3>"
				+"<b>"
					+data[1]
				+"</b>"
					+"<img src=\""+data[2]+"\">"
				+"<b id=\"price"+data[0]+"\">"
					+data[3]
				+"</b>"
				+"<div id = \"amountControl\">"
				+"<a class =\"btn btn-success\" onclick=\"clickMore("+"\'"+data[0]+"\')\">\+"+"</a>"
				+"<a class=\"amountValue\" id=\"amount"+data[0]+"\" style=\"margin:5px;\">1</a>"
				+"<a class =\"btn btn-success\" onclick=\"clickLess("+"\'"+data[0]+"\')\">\-"+"</a>"
				+"</div>"
				+"<a class = \"btn btn-danger\" onclick =\"clickDelete('"+data[0]+"')\">Delete"+"</a>"
				+"<br>"
				+"</span>";
			
			totalPrice+= parseInt(data[3]);
		
		}
		
		
		bodyContent.innerHTML = "<div id = \"boxLine\">"+lines+"</div>";
	}
	document.getElementById("totalPrice").textContent = totalPrice;
	
}
function clickDelete(id){
	var price = document.getElementById("price"+id);
	var totalPrice = document.getElementById("totalPrice");
	document.getElementById("itemLine"+id).outerHTML = "";
	var itemInCart = getCookie("ItemInCart");
	var items = itemInCart.split(",");
	for(var i = 0; i < items.length; i++) {
        var item_Attr = items[i].split("-");

        if(item_Attr[0].trim() == id) {
        	items.splice(i,1);
        }
    }
	
	totalPrice.textContent = parseInt(totalPrice.textContent,10)-parseInt(price.textContent,10);
	document.cookie ="TotalItem="+(parseInt(getCookie("TotalItem"),10)-1)
	document.cookie ="ItemInCart="+items.join(",");
}
function clickMore(id){
	var amount = document.getElementById("amount"+id);
	var price = document.getElementById("price"+id);
	var totalPrice = document.getElementById("totalPrice");
	amount.textContent = parseInt(amount.textContent,10)+1;
	totalPrice.textContent = parseInt(totalPrice.textContent,10)+parseInt(price.textContent,10);
}
function clickLess(id){
	var amount = document.getElementById("amount"+id);
	var price = document.getElementById("price"+id);
	var totalPrice = document.getElementById("totalPrice");
	if(parseInt(amount.textContent,10) >0){
		amount.textContent = parseInt(amount.textContent,10)-1;
		totalPrice.textContent = parseInt(totalPrice.textContent,10)-parseInt(price.textContent,10);
	}
	else
		alert("Stay Calm Man !");
}
function clickBuyEvent(productId,productName,img,price){
	if(IsExistProduct(productId)){
		alert("This item is Added to your Cart");
	}else
	{
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
		document.getElementById("but"+productId).textContent = "Added";
		document.getElementById("but"+productId).className = "btn btn-secondary";
	}
}
function IsExistProduct(productId){
	var itemInCart = getCookie("ItemInCart");
	if(itemInCart != null){
		var items= itemInCart.split(",");
		for(var i =0;i<items.length;i++){
			var proAtrr = items[i].split("-");
			if(proAtrr[0].trim()==productId)
				return true;
			
		}
	}
	return false;
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