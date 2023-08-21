let customer=document.getElementById("customer")
console.log(customer);

customer.addEventListener("click",()=>{

   // console.log("hello")

   let demo = document.getElementById("sub-nav1")
   console.log(demo)
   let display= demo.classList.toggle("true")
   if(display){
    demo.style.display = "block"
   }
   else{
    demo.style.display = "none"
   }
})

// let str = "Rames123"

// let reg = /^[^\W_]{6,8}$/

// console.log(reg.test(str));
// function validatePassword(password) {
//    const minLength = 8;
//    const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;
 
//    if (!passwordRegex.test(password)) {
//      return "Password must be at least " + minLength + " characters long and contain both letters and numbers.";
//    }
 
//    return "Password is valid.";
//  }
 
//  // Example usage
//  const password1 = "abc123";
//  const password2 = "securePassword123";
 
//  console.log(validatePassword(password1));
//  console.log(validatePassword(password2));
 





let vendor=document.getElementById("vendor")
console.log(vendor);

vendor.addEventListener("click", ()=>{
  // console.log("hello")

  let demo=document.getElementById("sub-nav2")
  console.log(demo)
  let display=demo.classList.toggle("true")
if(display){
   demo.style.display="block"
}
else{
   demo.style.display="none"
}

})

// code starts for service funtionality


let service =document.getElementById("service")
console.log(service);

service.addEventListener("click",() =>{
   let drop_down=document.querySelector("#drop-down")
   console.log(drop_down);

   let display=drop_down.classList.toggle("none")
   if(display){
      drop_down.style.display="block"
   }
   else{
      drop_down.style.display="none"
   }
})

// service.addEventListener("mouseover",() =>{
//    let drop_down=document.querySelector("drop-down")
//    console.log(drop_down);

//    let display=drop_down.classList.toggle("none")
//    if(display){
//       drop_down.style.display="none"

//    }
// })