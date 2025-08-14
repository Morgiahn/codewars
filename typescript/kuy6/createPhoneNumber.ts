/*
Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.

Example

createPhoneNumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]) // => returns "(123) 456-7890"

The returned format must be correct in order to complete this challenge.

Don't forget the space after the closing parentheses!


*/

export function createPhoneNumber(numbers: number[]): string {
  const a = numbers.slice(0, 3).join("")
  const b = numbers.slice(3, 6).join("")
  const c = numbers.slice(6).join("")
  return "(" + a + ") " + b + "-" + c
}

/* solutions 

#1
export function createPhoneNumber(numbers: number[]): string {
  let phoneNumber:string = "(xxx) xxx-xxxx"
  
  for(let i=0; i<numbers.length; i++){
    phoneNumber = phoneNumber.replace("x", numbers[i].toString())
  }
    
  return phoneNumber
}


#2
export function createPhoneNumber(numbers: number[]): string {
  const codeOfCountry = numbers.slice(0,3).join('');
  const middleNumbers = numbers.slice(3,6).join('');
  const lastNumbers = numbers.slice(6,10).join('');
  
  return `(${codeOfCountry}) ${middleNumbers}-${lastNumbers}`
}

#3
export function createPhoneNumber(numbers: number[]): string {
    return numbers
        .join("")
        .replace(/(\d{3})(\d{3})(\d{4})/, "($1) $2-$3");
}
        
*/