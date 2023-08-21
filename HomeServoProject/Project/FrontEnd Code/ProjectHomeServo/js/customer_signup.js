let btn = document.getElementById("btn")
console.log(btn);

let regx = /^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,12}$/



btn.addEventListener("click" , (e) => {
    e.preventDefault()
    let span = document.getElementsByTagName("span")
    console.log(span);
   let user = document.getElementById("cname").value
   console.log(user);
   let email = document.getElementById("email").value
   console.log(email);
   let phone = document.getElementById("phone").value
   console.log(phone);
   let password = document.getElementById("pwd").value
   console.log(password);
    let pas = regx.test(password)
    console.log(pas);
    
   //  document.body.innerHTML += pas
   let family = document.getElementById("famcount").value
   console.log(family);
   let door = document.getElementById("dno").value
   console.log(door);
   let street = document.getElementById("street").value
   console.log(street);
   let land = document.getElementById("landmark").value
   console.log(land);
   let district = document.getElementById("district").value
   console.log(district);
   let state = document.getElementById("state").value
   console.log(state);
   let pin = document.getElementById("pincode").value
   console.log(pin);
   
   if(user === "")
   {
      span[1].style.display = "block"
   }else if(email === "")
   {
    span[3].style.display = "block"
   }else if(phone === ""){
    span[5].style.display = "block"
   }else if(password === ""){
    span[7].style.display = "block"
}else if(family === ""){
    span[9].style.display = "block"
   }else if(door === ""){
      span[11].style.display = "block"
   }else if(street === ""){
    span[13].style.display = "block"
   }else if(land === ""){
    span[15].style.display = "block"
   }else if(district === ""){
    span[17].style.display = "block"
   }else if(state === ""){
    span[19].style.display = "block"
   }else if(pin === ""){
    span[21].style.display = "block"
   }
   
})

const password= document.getElementById("pwd");
password.addEventListener("input", ()=>{
   const passText= document.querySelector(".passText");
   const passPattern= /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

   if(password.value.match(passPattern)){
      passText.innerHTML="your password is valid";
      passText.style.color="green";
   }
   else{
      passText.innerHTML= "your password must contain atleast 8 characters, one uppercase, one lowercase, one number and one special character";

   }
});

const user=document.getElementById("cname");

// for integration to the backend database 

if(cname != '' && email.value != '' &&  pwd.value != ''
 &&  phone.value != '' && famcount.value != '' && dno.value != ''
  && street.value != '' && landmark.value != '' && district.value != '' 
  && state.value != '' && pincode.value != '' &&  regx.test(pwd.value) === true) {
   const customer = {
     'name' : cname.value,
     'email' : email.value,
     'phone' : phone.value,
     'pwd' : pwd.value,
     'familyCount' : famcount.value,
     'address' : {
       'doorNo' : dno.value,
       'street' : street.value,
       'district' :district.value,
       'landMark' : landMark.value,
       'state' : state.value,
       'pincode' : pincode.value
     }
   }
   try{
     const response = await fetch("http://localhost:8080/customer",
     {
       method: "POST",
       headers: {
         "Content-Type": "application/json",
       },
       body: JSON.stringify(customer),
     });
     if(response.ok){
       const data = await response.json();
       console.log(data);
       window.alert("Congratulations you have successfully created a new customer Account 🥳🥳🥳");
     }
     
     if (response.status >= 400) {
       window.alert("Youre Already Registered Here Please Try To Login 😕😕😕");
      //  for(var i = 0; i< input.length; i++){
      //    input[i].style.borderColor = 'red';
      //  }
     }
   //   else{
   //     for(var i = 0; i< p.length; i++){
   //       input[i].style.borderColor = 'green';
   //     }
   //   }
 
   //   cname.value = '';
   //   email.value = '';
   //   phone.value = '';
   //   pwd.value = '';
   //   famcount.value = '';
   //   dno.value = '';
   //   street.value = '';
   //   landmark.value = '';
   //   district.value = '';
   //   state.value = '';
   //   pincode.value = '';
   //   for(var i = 0; i< p.length; i++){
   //     input[i].style.borderColor = 'none';
   //   }
 
   //   function o() {
   //     open(URL="./customersignin.html");
   //   }
   //   o();
   }
   catch(error){
     // console.error("error", error);
     window.alert("error", error);
   }
   }
   else {
     window.alert("Please enter valid details");
   }
 
