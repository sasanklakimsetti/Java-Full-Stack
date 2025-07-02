let str="this is a string in javascript";
console.log(str.substring(0,5))  // gives the substring within the indices
console.log(str.slice(5));  // gives the string by removing the n characters from start, if negative slicing starts from the end
console.log(str);

// numbers
var num=6+5
console.log(num)
num="6"+5
console.log(num)
num=6+5
console.log(num.toString())
num=6+5.5789
console.log(num.toFixed(2))  // round off to two decimal places
console.log(Number("123"))
console.log(Number("10 years"))  // return NaN
console.log(parseInt("10 years"))