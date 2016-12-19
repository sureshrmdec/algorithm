const LinkedList = import('./LinkedList');

function Stack() {
	this.list = new LinkedList();
}

Stack.prototype.isEmpty = function() {
  return this.list.length === 0;
}

Stack.prototype.peek = function() {
  return this.isEmpty() ? null : this.getNext();
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
  const peek = this.peek();
  this.list.remove(peek);
  return peekNode;
}

module.exports = Stack;
