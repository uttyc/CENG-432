class IyteImmutableList{
	var myList = List.empty[Int]

	def add(item: Int): List[Int] ={
		item :: myList
		myList
	}
	override def toString() : String = {
		var str = ""
		for( i <- myList) {
			str += i
		}
		str
	}
}
object IyteImmutableList{
	def apply():IyteImmutableList = IyteImmutableList()
}