    let btn=document.getElementById('btn')
    console.log(btn)

    let cname=document.getElementById('cname')
    let email=document.getElementById('email')
    let phone=document.getElementById('phone')
    let password=document.getElementById('password')
    let familycount=document.getElementById('familycount')
    let doornumber=document.getElementById('doornumber')
    let street=document.getElementById('street')
    let landmark=document.getElementById('landmark')
    let state=document.getElementById('state')
    let district=document.getElementById('district')
    let pincode=document.getElementById('pincode')

      //REGULAR FUNCTIONS FOR PASSWORD TESTING

    function passwordval(){
    const password1=document.getElementById('password')
    const passwordval=document.getElementById('password').value
    let passwordreg=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,12}$/    
    if(passwordreg.test(passwordval)){
        return true;
    }
    else{
        return false;
    }
    }
     //REGULAR FUNCTIONS FOR EMAIL TESTING
    function emailValidate(){
        const email = document.getElementById("email")
        const emailVal = document.getElementById("email").value
        let emailReg = /^[a-zA-z0-9.`~!#$%^&*'+/-?_={|}]+@[a-zA-Z0-9-]+.+(?:\.[a-zA-Z0-9-]+)*$/;
        if((emailReg.test(emailVal))){
            return true;
        }
        else{
            return false;
        }   
    }
     //REGULAR FUNCTIONS FOR PHONE 
    function phoneValidate(){
        var phone = document.getElementById("phone");
        var phoneVal = document.getElementById("phone").value;
        let phoneReg = /^\d{10}$/;
        if((phoneReg.test(phoneVal))){
            return true
        }
        else{
            return false;
        }
    }


    btn.addEventListener("click",async (e)=>{
        let field=document.getElementsByClassName('field')
        console.log(field)
        let inputcolor=document.getElementsByClassName('inputcolor')
        console.log(inputcolor);
      
        e.preventDefault()            // preventDefault() The page reload will be stopped
        if(cname.value===''){
            field[0].style.display="block";
        }
        else if(email.value===''){
            field[1].style.display="block";     
        }
        else if(emailValidate()===false){
            let email=document.getElementById('emailval')   
            email.style.display="block"
            field[1].style.border="3px solid red"
        }
        else if(phone.value===''){
            field[2].style.display="block";       
        }
        else if(phoneValidate()===false){
            let phone=document.getElementById('phoneval')
            phone.style.display="block"
            field[2].style.border="3px solid red"
        }
        else if(password.value===''){
            field[3].style.display="block"; 
        }
        else  if(passwordval()===false){
            let val=document.getElementById('passwordval')
            val.style.display="block";
            field[3].style.border="3px solid red"
        } 
        else if(familycount.value===''){
            field[4].style.display="block";
        }
        else if(doornumber.value===''){
            field[5].style.display="block";
        }
        else if(street.value===''){
            field[6].style.display="block";
        }
        else if(landmark.value===''){
            field[7].style.display="block";
        }
        else if(state.value===''){
            field[8].style.display="block";
        }
        else if(district.value===''){
            field[9].style.display="block";
        }
        else if(pincode.value===''){
            field[10].style.display="block";
        }
        else{
            let color=document.getElementsByClassName('inputcolor')   
            for(var i=0;i<field.length;i++){
                field[i].style.display="none";

            }
            
        }
      // cheking the backend table if the data is already present in the backend table
    // for integration to the backend database  for REGISTARTION

    if(cname.value != '' && email.value != '' &&  password.value != '' &&  phone.value != '' && familycount.value != '' && doornumber.value != '' && street.value != '' && landmark.value != '' && district.value != '' && state.value != '' && pincode.value != '') {
      const customer = {
        'name' : cname.value,
        'email' : email.value,
        'phone' : phone.value,
        'password' : password.value,
        'familyCount' : familycount.value,
        'address' : {
          'dno' : doornumber.value,
          'street' : street.value,
          'district' :district.value,
          'landmark' : landmark.value,
          'state' : state.value,
          'pincode' : pincode.value
        }
      }
    
      try{
        const response = await fetch ("http://localhost:8080/customer",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(customer),
        });
        // console.log("try block");
        if(response.ok){
          const data = await response.json();
          console.log(data);
          window.alert("Congratulations you have successfully created a new customer Account 🥳🥳🥳");
          for(var i = 0; i< inputcolor.length; i++){
            inputcolor[i].style.border="3px solid";
            inputcolor[i].style.borderColor = 'green';
          }
          function o() {
            window.open("http://127.0.0.1:5501/customer/customerlogin.html")
         }
         setTimeout(() => {
          o();
       }, 2000);
          
        }   
        else if (response.status >= 400) {
          window.alert("You have Already Registered. Please Try To Login ");
          for(var i = 0; i< inputcolor .length; i++){
            inputcolor[i].style.border="3px solid";
            inputcolor[i].style.borderColor = 'red';
          } 
        }
        else{
          window.alert("Failed to save account");
        }

      }
      catch(error){
        window.alert("error check the proper url ", error);
      }
    }
    else {
        window.alert("Please enter valid details");
      }
    },false);



 