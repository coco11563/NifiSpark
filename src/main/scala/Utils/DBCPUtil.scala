package Utils



import java.net.URI
import java.sql.Connection

import org.apache.commons.dbcp2._

class DBCPUtil(dburi: String, userName:String, password:String) {
  def apply(dburi: String): String = {
    System.setProperty("DATABASE_URL", dburi)
  }
  object Datasource {
    val dbUri = new URI(dburi)
    val dbUrl = s"jdbc:mysql://${dbUri.getHost}:${dbUri.getPort}${dbUri.getPath}"
    val connectionPool = new BasicDataSource()
    connectionPool.setUsername(userName)
    connectionPool.setPassword(password)
    connectionPool.setDriverClassName("com.mysql.jdbc.Driver")
    connectionPool.setUrl(dbUrl)
    connectionPool.setInitialSize(3)
  }

  def getConn: Connection = {
    Datasource.connectionPool.getConnection()
  }

}
object test {
  def main(args: Array[String]): Unit = {
    val db : DBCPUtil = new DBCPUtil("http://10.0.82.164:3306/nifi","root","root")
    val con = db.getConn
    val stmt = con.createStatement().execute("select * from export_is_pub4_jnl_full_old")
    print(stmt)
  }
}
