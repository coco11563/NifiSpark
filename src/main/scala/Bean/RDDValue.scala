package Bean

import java.sql.ResultSet

import scala.collection.immutable.HashMap

class RDDValue (args : Array[String], rs : ResultSet) {
  val map = new HashMap[String, String]
  args.foreach(arg => {
    map.mapValues((arg) => rs.getString(arg))
  })
}
