"use strict"
function Node(data) {
    this.next = null;
    this.data = data;
}

function LinkedList() {
    this.start = null;
    this.end = null;
    this.length = 0;
}

LinkedList.prototype.add = function(data) {
    if (data === undefined) {
        throw new Error('data must be valid to add');
    }

    const newNode = new Node(data);

    if(this.start === null) {
        this.start = newNode;
    } else {
        this.end.next = newNode;
    }

    this.length++;
    this.end = newNode; 
};

LinkedList.prototype.remove = function(data) {
  if (data === undefined) {
    throw new Error('data must be valid to add');
  }

  if(this.start === null) {
    return;
  }
  
  //only one node
  if(this.length === 1) {
    if(this.start.data !== data)
      return;
    else {
      this.start = null;
      this.end = null;
      this.length--;
      return;
    }
  }    

  let previous = null;
  let current = this.start;

  while(current !== null) {
    //found the node
    if(current.data === data) {
      //if it is the start node
      if(current === this.start) {
        this.start = this.start.next;
      }
      //if it is the end node
      else if (current === this.end ) { 
        this.end = previous;
        this.end.next = null;
      } else {
        //general case
        previous.next = current.next;
      }
      this.length--;
    }
    
    previous = current;
    if(current.next !== null)
      current = current.next;
    //can't find node
    else
      return;
    
  }
  
};

module.exports = LinkedList;

/*

//for testing
LinkedList.prototype.print = function() { 
  console.log("-------------"+this.length+"-------------")
  let current = this.start;
  while(current !== null) {
    console.log(current.data);
    if(current.next !== null)
      current = current.next;
    else
      return;
  }
};

LinkedList.prototype.restart = function() {
  this.start = null;
  this.end = null;
  this.length = 0;
}




//begin testing
let testlist = new LinkedList();


console.log("general test");
testlist.restart();
testlist.add(3);
testlist.add(5);
testlist.add(4);
testlist.add(2);
testlist.print();

testlist.remove(3);
testlist.print();
testlist.remove(5);
testlist.print();

console.log("cannot find a node");
testlist.restart();
testlist.add(3);
testlist.add(5);
testlist.add(4);
testlist.add(2);
testlist.print();

testlist.remove(6);
testlist.print();

console.log("remove the start");
testlist.restart();
testlist.add(3);
testlist.add(5);
testlist.add(4);
testlist.print();

testlist.remove(3);
testlist.print();

console.log("remove the end");
testlist.restart();
testlist.add(3);
testlist.add(4);
testlist.add(5);
testlist.print();

testlist.remove(5);
testlist.print();


//edge cases
console.log("only one node");
testlist.restart();
testlist.add(3);
testlist.print();

testlist.remove(3);
testlist.print();

console.log("only two nodes, remove the start");
testlist.restart();
testlist.add(3);
testlist.add(5);
testlist.print();

testlist.remove(3);
testlist.print();

console.log("only two nodes, remove the end");
testlist.restart();
testlist.add(3);
testlist.add(5);
testlist.print();

testlist.remove(5);
testlist.print();


*/