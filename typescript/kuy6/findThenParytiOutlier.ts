export function findOutlier(integers: number[]): number {
 
  if (arrayIsEven(integers)) {
      return integers.find(n => isOdd(n))!;
    }
    else {
      return integers.find(n => isEven(n))!;
    }
}

const isEven = (num: number): boolean => num % 2 === 0;
const isOdd  = (num: number): boolean => num % 2 !== 0;

const arrayIsEven = (arr: number[]) : boolean => {
  if (isEven(arr[0]) && isEven(arr[1])) {
    return true;
  } 
  if (isEven(arr[1]) && isEven(arr[2])) {
    return true;
  } 
  if (isEven(arr[0]) && isEven(arr[2])) {
    return true;
  } 
  return false;
}

/* solutions 

#1
export function findOutlier(integers: number[]): number {
  if (integers.slice(0, 3).filter(i => i % 2 !== 0).length > 1) {
    return integers.find(v => v % 2 === 0) || 0;
  } else {
    return integers.find(v => v % 2 !== 0) || 0;
  }
}

#2
export function findOutlier(integers: number[]): number {
  const odds = integers.filter(v => v % 2);
  const evens = integers.filter(v => !(v % 2));

  return odds.length === 1 ? odds[0] : evens[0];
}

#3
const isEven = (n: number) => n % 2 === 0;
const isOdd = (n: number) => !isEven(n);


export function findOutlier(integers: number[]): number {
  const checkIntegers = integers.slice(0,3);
  const isMadeOfOdds = checkIntegers.filter(isOdd).length >= 2;
  const outlier = isMadeOfOdds ? isEven : isOdd;
  
  return integers.find(outlier) as number;
}
  

*/