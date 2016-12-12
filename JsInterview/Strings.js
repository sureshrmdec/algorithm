/***********************************************************
String Reverse
Goal: reverse a string in JavaScript
How:  loop through the string and concatenate letters to a new string
************************************************************/
function reverse(str){
  if(!str || str.length <2) return str;
  
  return str.split('').reverse().join('');
}
        
console.log(reverse("reverse a string in javascript"));

/***********************************************************
Reverse in place
Goal: "I am the good boy" to "I ma eht doog yob". Please note that the words are in place but reverse.
************************************************************/
function reverseInPlace(str){
  return str.split(' ').reverse().join(' ').split('').reverse().join('');
}

reverseInPlace('I am the good boy');//"I ma eht doog yob"

/***********************************************************
Reverse in place
Goal: find the first non repeating char in a string
************************************************************/



