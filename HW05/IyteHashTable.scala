class IyteHashTable {
  var SIZE : Int = 10000000
  var table : Array[Node] = new Array[Node](SIZE)

  def hash(key: String): Int = {
   var h: Long = 5381
    for(char <- key)
      h = ((h << 5) + h) + char
      h.toInt
  }

  def get(key : String ) : String = {
    var indexToPut : Int = hash(key) % SIZE
    if(table(indexToPut)== null) {
      null
    }else{
      var temp = table(indexToPut)
      while(temp  != null && temp.getKey() != key)
        temp = temp.getNext()
      if(temp == null) null
      else temp.getValue()
    }

  }

  def set(key : String , value : String ) : Unit = {
    var indexToPut : Int= hash(key) %SIZE
    if(table(indexToPut)== null){
      table(indexToPut) = new Node(key,value)
    }
    else{
      var temp = table(indexToPut)
      while(temp  != null && temp.getKey()!=key)
        temp = temp.getNext()
      if(temp.getKey() == key) temp.setValue(value)
      else temp.setNext(new Node(key,value))
    }    
   }
  }

object IyteHashTable{
  def apply () = new IyteHashTable()
}

class Node {

  var key : String = null
  var value : String = null
  var next: Node = null

  def this(key: String, value: String) {
    this()
    this.key = key
    this.value = value
  }

  def this(key : String , value : String  , next : Node){
    this(key, value)
    this.next = next
  }

  def getKey(): String = {
    this.key;
  }

  def setKey(key: String): Unit = {
    this.key = key;
  }

  def getValue(): String = {
    this.value;
  }

  def setValue(value: String): Unit = {
    this.value = value;
  }

  def getNext(): Node = {
    this.next;
  }

  def setNext(next: Node) : Unit = {
    this.next = next;
  }

}

object Node {
  def apply () = new Node()
}
