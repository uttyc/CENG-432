
class IyteMutableList{
   var head : Node = new Node(0,null);
   
   def add(item: Int): Unit = {
     var temp: Node = new Node(item,null)
     var curr: Node = head
     while(curr.next!= null){
       curr = curr.next
     }
     curr.next = temp
     
   }
    override def toString(): String = {
      var temp: Node = head.next
      var str = ""
      while(temp != null){
        if(temp.next != null) str += temp.item+","
        else str += temp.item
        temp = temp.next
      }
      str
   }
   
   
   
   
  class Node(var item:Int , var next:Node)
  
  
}
object IyteMutableList{
  def apply(): IyteMutableList = IyteMutableList()

}
