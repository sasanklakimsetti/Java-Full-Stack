var names=["sasank","sai","lakimsetti"]
console.log(names.toString())
console.log(names.join('|'))  // content in the array will be joined using the delimiter given
names.pop()  // removes the last element of the array
console.log(names.toString())
names.push("lakimsetti") // push at last by increasing the length of array
console.log(names.toString())
names.shift()  // removes the first element
console.log(names.toString())
names.unshift("sasank")  // inserts the element at start
console.log(names.toString())
names.sort()  /// sort the array considering the elements as objects in dictionary order
console.log(names.toString())
names.reverse()
console.log(names.toString())


// splice(index, deleteCount, {item1, item2,....}) 
// index: at what index the insertion to be started(required)
// deleteCount: how many no.of items to be removed(optional). deletion starts from the index
// {items}:list of items to be inserted
names.splice(1,1,"sasank");
console.log(names.toString())

let fruits=['mango','banana','apple','grapes','dates']
console.log(fruits)
for(let i=0;i<fruits.length;i++) console.log(fruits[i])
for(let index in fruits) console.log(fruits[index])
for(let fruit of fruits) console.log(fruit)