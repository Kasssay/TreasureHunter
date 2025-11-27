window.onload = function() {
	
	document.getElementById("submitBtn").onclick = doLogin;
}


function doLogin() {
	
	
	let userName = document.getElementById("userName").value;
	let userPwd = document.getElementById("userPassword").value;
	
	
	fetch(
		"http://localhost:8080/login",
		{
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify({
				name: userName,
				password: userPwd
			})
		}
	)
	.then(response => {
		
		if(!response.ok) {
			throw new Error("Error");
		}
		
		
		return response.json();
	})
	.then(data => {
		
		sessionStorage.setItem("password", userPwd);
		sessionStorage.setItem("id", data.id);
		sessionStorage.setItem("name", data.name);
		sessionStorage.setItem("life", data.life);
		sessionStorage.setItem("score", data.score);
		window.location.href ='game.html';
		
	})

	return false;
}

	
	
	


