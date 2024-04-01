// 1. Object literal
const person = {
    firstName: "John",
    lastName: "Doe",
    age: 50,
};

console.log(person.firstName);
console.log(person.lastName);
console.log(person.age);
console.log("");


// 2. Object using new
const man = new Object();
man.firstName = "Seetharaman";
man.lastName = "S";
man.age = 50;
console.log(man);
console.log("");

// 3. Constructor function
function Person(name, age) {
    this.name = name;
    this.age = age;
}
const s = new Person('Seetharaman', 21);
console.log(s);
console.log("");

// 4. Object.create()
let Student = {
    name: "Lisa",
    age: 24,
    marks: 78.9,
    display() {
      console.log("Name:", this.name);
    }
};
  
let std1 = Object.create(Student);
std1.name = "Seetharaman";
std1.display();
console.log("");

// Array Slice
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log(arr.slice(1, 5));
console.log("");

// Array Splice
let fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.splice(2, 0, "Lemon", "Kiwi");
console.log(fruits);
fruits.splice(1, 1, "Strawberry");
console.log(fruits);
console.log("");

//Call can invoke a function with specified values
var car = {
    name: 'BMW'
};

function sayName(greeting){
    if(greeting){
        return `${greeting} It is a ${this.name} car!`;
    }
    return `It is a ${this.name} car!`
}
console.log(sayName.call(car), "\n");

//Apply (uses array like objects)
console.log(sayName.apply(car, ["Hey!"]), "\n")

//Bind method creates new function with "this" value
var newFunc = sayName.bind(car);
console.log(newFunc("Hey!"));
