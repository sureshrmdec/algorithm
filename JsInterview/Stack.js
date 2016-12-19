"use strict"
const LinkedList = require('./LinkedList');

function Stack() {
	this.list = new LinkedList();
}

Stack.prototype.isEmpty = function() {
  return this.list.length === 0;
}

Stack.prototype.getNext = function() {
	return this.list.end.data;
}

Stack.prototype.clear = function() {
	this.list = new LinkedList();
}

Stack.prototype.push = function(data) {
	this.list.add(data);
}

Stack.prototype.pop = function() {
  if (this.isEmpty()) {
    throw new Error('The stack is empty');
  }
  const peek = this.isEmpty() ? null : this.getNext();
  this.list.remove(peek);
  return peek;
}

Stack.prototype.print = function() {
  this.list.print();
}

//for test
module.exports = Stack;

/*
//testing
let testStack = new Stack();
testStack.push(3);
testStack.push(5);
testStack.push(4);
testStack.push(2);
testStack.print();
testStack.pop();
testStack.pop();
testStack.print();
testStack.pop();
testStack.pop();
testStack.print();
*/



