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
First non repeating char
************************************************************/
function firstNonRepeatChar(str) {
  let len = str.length,
    char,
    charCount = {};

  for (let i = 0; i < len; i++) {
    char = str[i];
    if (!charCount[char])
      charCount[char] = 1;
    else
      charCount[char]++;
  }

  for (key in charCount) {
    if (charCount[key] == 1)
      return key;
  }
}

console.log(firstNonRepeatChar('the quick brown fox jumps then quickly blow air')); //f

/***********************************************************
remove duplicate char
Goal: remove duplicate characters from a sting, each character only show once.
************************************************************/
function removeDuplicateChar(str) {
  let len = str.length,
    char,
    charCount = {},
    newStr = [];
  for(let i =0; i<len; i++){
    char = str[i];
    if(charCount[char]){
      console.log("pass " + char);
    }
    else {
      charCount[char] = 1;
      newStr.push(char);
    }
      
  }
  return newStr.join('');
}

console.log(removeDuplicateChar('Learn more javascript dude')); //"Learn mojvsciptdu"

/***********************************************************
check palindrome
Goal: verify a word as palindrome
How:  reverse a word and it becomes same as the previous word, it is called palindrome.
************************************************************/
function isPalindrome(str){
  let i, len = str.length;
  for (i = 0; i < len; i++) {
    if (str[i] != str[len - 1 - i]) {
    return false;
    }
  }
  return true;
}


console.log(isPalindrome('madam'))    //true
console.log(isPalindrome('toyota'))   //false

/**********************Build In Method**************************/

function isPalindrome(str){
  return str == str.split('').reverse().join('');
}


console.log(isPalindrome('madam'))    //true
console.log(isPalindrome('toyota'))   //false


/***********************************************************
Find Substring
Goal: match substring of a sting
How:  reverse a word and it becomes same as the previous word, it is called palindrome.
************************************************************/
function subStringFinder(str, subStr){
  var idx = 0,
      i = 0,
      j = 0,
      len = str.length,
      subLen = subStr.length;

  for(; i<len; i++){
    idx = i;
    j = 0;
    while (str[idx] == subStr[j]) {

      if(j == (subStr.length - 1)) 
        return i;
      idx++;
      j++;
    }
  }

  return -1;
}

console.log(subStringFinder('abbcdabbbbbck', 'ab')) //0
console.log(subStringFinder('abbcdabbbbbck', 'bck')) //10

console.log(subStringFinder('abbcdabbbbbck', 'bbbck'))  //8
console.log(subStringFinder('sadbwesfwaeqherfdxzv', 'aeqhe'))  //9
