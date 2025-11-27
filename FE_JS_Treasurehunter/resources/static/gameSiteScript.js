
let animationSpeed = 30;
let tableSize = 5;

let skullNum = 2;
let treasureNum = 1;

let fields = new Array(tableSize*tableSize).fill("x");  // ide mentsük le a kincs és koponya poziciokat.

let skullPicture ="url('../static/skull.png')";
let treasurePicture ="url('../static/gold.png')";
let grayPicture ="url('../static/gray.png')";
let cardSound = new Audio("../static/card1.ogg");
let goldSound = new Audio("../static/gold_sack.wav");
let skullSound = new Audio("../static/skull.mp3");


//játék menetéhez tartozó változók:
let win = false;
let lose = false; 
let life = 2;
let score = 0;


window.onload = function() {
	

	document.getElementById("name").innerHTML = sessionStorage.getItem("name");
	document.getElementById("life").innerHTML = sessionStorage.getItem("life");
	document.getElementById("score").innerHTML = sessionStorage.getItem("score");
	
	//---1 Pálya feltöltése kincsel és koponyával.

	fieldsUploadingWithElements();
	console.log(fields);
	
	//--2  Kattintás figyelés minden mezőre.
	squares = document.getElementsByClassName("square");
		
		for(let index = 0; index < squares.length; index++){
			
			squares[index].onclick = function(){
				squareClickHandler(squares[index],index);
				cardSound.play();
				
			};
			
			
			}
	}
	function fieldsUploadingWithElements(){
	
		let skullCounter = 0;
		while(skullCounter < skullNum){
			let randomIndex = Math.floor(Math.random() * fields.length); 
			if(fields[randomIndex] == "x"){
				fields[randomIndex] = "s";
				skullCounter++;
			}	
		}
		
		let treasureCounter= 0;
			while(treasureCounter < treasureNum){
				let randomIndex = Math.floor(Math.random() * fields.length); 
				if(fields[randomIndex] == "x"){
					
					fields[randomIndex] = "t";
					treasureCounter++;
				}	
			}
	}
	

	function squareClickHandler(actualSquare, squareIndex){
		
		
		score++;
		document.getElementById("actual-score").innerHTML = score;
		
		
		let growing = false; //növekedés
		let pictureSize = 100;
		

		let intervalid = setInterval(()=>{
		//animáció ahogy megfordul a négyzetben levő kép.
			
			if(growing == false){
				//-------csökken a  kép méret
				actualSquare.style["backgroundSize"] = pictureSize + "px 120px";
				pictureSize-=10;
			}
		
			if(pictureSize <= 0){
			//--------- a kép szélessége 0 és betöltödik az új kép.
				
				growing = true	
						 
				 if(fields[squareIndex] == "x"){
					actualSquare.style["backgroundImage"] = grayPicture;
					
				 }
				 
				 else if(fields[squareIndex] == "t"){
				 		actualSquare.style["backgroundImage"] = treasurePicture;
						win = true;
						gameOverExam();    //----3 játék vége ellenőrzés és kezelés
						goldSound.play();
				 	 }
				 
				else if(fields[squareIndex] == "s"){
				 	 	actualSquare.style["backgroundImage"] = skullPicture;
						
						life-=1;
						document.getElementById("actual-life").innerHTML = life;
						skullSound.play();
						if(life == 0){
							
							lose = true;
							gameOverExam();    //----3 játék vége ellenőrzés és kezelés
							
						}
						
				}
			}
			
				//------ növekszik a méret	
				if(growing == true){	
					 	
					actualSquare.style["backgroundSize"] = pictureSize + "px 120px";
					pictureSize+=10;
					
					if(pictureSize >= 100){
						 
						 clearInterval(intervalid);
					 }			 
				}
		
		},animationSpeed);
		
		
		
		
	}
	
	function gameOverExam(){
		if(lose == true){
			gameStop("You Lose");
		}
		
		else if(win == true){
			gameStop("You Win");
			saveNewScore();
		
		}
		
	}
	
	function saveNewScore() {
		

		fetch(
			"http://localhost:8080/save",
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify({
					life: life,
					score: score,
					userId: sessionStorage.getItem("id")
				})
			}
		)

	}


    function gameStop(endText) {
        document.getElementById("gameover").innerHTML = endText;

        let squares = document.getElementsByClassName("square");

        for (let index = 0; index < squares.length; index++) {
            squares[index].onclick = null;
        }
    }
	
	function reLoading() {
		
		let userName = sessionStorage.getItem("name");
		let userPwd = sessionStorage.getItem("password");
		
		
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
			window.location.href = 'game.html';
			sessionStorage.setItem("life", data.life);
			sessionStorage.setItem("score", data.score);
			
		})

		return false;
	}
	
	
	
