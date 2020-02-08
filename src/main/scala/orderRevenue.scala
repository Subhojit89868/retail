import scala.io.Source

object orderRevenue{
  def main(args: Array[String])={
    val order_id=args(0).toInt
    val Order_Item=Source.fromFile("D:/workspace/data/retail_db/order_items/part-00000").getLines
    val order_item_list=Order_Item.filter(x=>x.split(",")(1).toInt==order_id).toList
    if(order_item_list.isEmpty) {
      println("Order Id not found")
    }
    else {
      val order_revenue_map = order_item_list.map(x => x.split(",")(4).toFloat)
      val order_revenue = order_revenue_map.reduce((a, b) => a + b)
      println(order_revenue)
    }
  }
}
