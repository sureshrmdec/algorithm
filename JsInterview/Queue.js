const LinkedList = import('./LinkedList');

function Queue() {
	this.list = new LinkedList();
}

Queue.prototype.isEmpty = function() {
  return this.list.length === 0;
}

Queue.prototype.peek = function() {
  return this.isEmpty() ? null : this.getNext();
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
  const peek = this.peek();
  this.list.remove(peek);
  return peekNode;
}

module.exports = Queue;
