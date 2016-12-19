"use strict"
const LinkedList = require('./LinkedList');

function Queue() {
	this.list = new LinkedList();
}

Queue.prototype.isEmpty = function() {
  return this.list.length === 0;
}

Queue.prototype.getNext = function() {
  return this.list.start.data;
}

Queue.prototype.clear = function() {
	this.list = new LinkedList();
}

Queue.prototype.push = function(data) {
	this.list.add(data);
}

Queue.prototype.pop = function() {
  if (this.isEmpty()) {
    throw new Error('The Queue is empty');
  }
  const peek = this.isEmpty() ? null : this.getNext();
  this.list.remove(peek);
  return peek;
}

Queue.prototype.print = function() {
  this.list.print();
}

module.exports = Queue;

/*
//testing
let testQueue = new Queue();
testQueue.push(3);
testQueue.push(5);
testQueue.push(4);
testQueue.push(2);
testQueue.print();
testQueue.pop();
testQueue.pop();
testQueue.print();
testQueue.pop();
testQueue.pop();
testQueue.print();
*/