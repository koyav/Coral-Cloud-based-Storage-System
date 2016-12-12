
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DOA_Service {

  public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
    public static double sz;

    public static Connection getConnection1() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/coral";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, "root", "");

        return con;
    }


     public static boolean  login(String  uname,String pwd)throws SQLException, ClassNotFoundException
    {
boolean res=false;
int chk=0;
        Connection con1 = getConnection1();
        stmt = con1.createStatement();
        String sql="SELECT * FROM `user` WHERE `uname`='"+uname+"' and  pass='"+pwd+"' ";
        System.out.println(sql);
       rs= stmt.executeQuery(sql);
       while(rs.next())
       {
         chk=1;

       }
       if(chk==1)
       {
           res=true;
       }
 else
       {
           res=false;
 }
        
         return  res;
    }


     public static int insertLink(String uname,String email,String fname,double size,String storage,String des,String tags) throws ClassNotFoundException, SQLException {
        Connection con1 = getConnection1();
        stmt = con1.createStatement();
        String sql = "INSERT INTO `coral`.`storageinfo` (`uname`, `email`, `filename`, `filesize`, `totalstorage`, `descrip`, `keywrds`)"
                + " VALUES ('"+uname+"', '"+email+"', '"+fname+"', '"+size+"', '"+storage+"', '"+des+"', '"+tags+"');";
        System.out.println(sql);
       int res= stmt.executeUpdate(sql);
       return res;
    }

      public static int insertLinkdetails(String tme,String dwnld,String bitsps,String rate,long size,String dat) throws ClassNotFoundException, SQLException {
        Connection con1 = getConnection1();
        stmt = con1.createStatement();
        String sql = "INSERT INTO `publicaudit`.`linkdetails` (`tme`,`dwn_ld`, `btspsec`, `rate`, `tot_size`, `trans_dat`) "
                + "VALUES ('"+tme+"'+'"+dwnld+"', '"+bitsps+"', '"+rate+"', '"+size+"', '"+dat+"');";
        System.out.println(sql);
       int res= stmt.executeUpdate(sql);
       return res;
    }

         public static int insertUser(String uname,String pwd,String email,String dob,String storage,String dbnc) throws ClassNotFoundException, SQLException {
        Connection con1 = getConnection1();
        stmt = con1.createStatement();
        String sql = "INSERT INTO `coral`.`user` ( `uname`, `pass`, `dob`, `email`, `storage`, `deb_card_num`)"
                + " VALUES ('"+uname+"', '"+pwd+"', '"+dob+"', '"+email+"', '"+storage+"', '"+dbnc+"');";
        System.out.println(sql);
       int res= stmt.executeUpdate(sql);
       return res;
    }

     public static String rule1(String protocol,String src,String src_prt,String des,String des_prt)throws ClassNotFoundException, SQLException
                 {
         String str="";
          Connection con = getConnection1();
                 System.out.println(""+protocol+src+src_prt+des+des_prt);
                 Statement st=con.createStatement();
                 String sql="select * from subpolicy where prototcol='"+protocol+"' and  src_IP='"+src+"' and src_port='"+src_prt+"'"
                         + " and des_IP='"+des+"'and des_Port='"+des_prt+"'";
                rs=st.executeQuery(sql);
                 System.out.println(sql);
                 while(rs.next())
                 {
                    str=rs.getString(2);

                 }
         return  str;
     }


      public ArrayList getRule() throws SQLException,ClassNotFoundException
{

Connection conn = getConnection1();
Statement statement = null;
 ArrayList results = new ArrayList();
	   statement = conn.createStatement();
	   String QueryString = "SELECT `rule`,action FROM `subpolicy`";
	   rs = statement.executeQuery(QueryString);
System.out.println(QueryString);

           while(rs.next())
           {

                                 results.add(rs.getString(2)+":"+rs.getString(1));
                               
           }
if(conn!=null)
conn.close();

return results;
}
      
      
      

    
    
    
    
   public static String getEmail(String uname,String pwd) throws SQLException,ClassNotFoundException
{

Connection conn = getConnection1();
Statement statement = null;
 String results = "";
	   statement = conn.createStatement();
	   String QueryString = "SELECT `email` FROM `user` WHERE uname='"+uname+"' and pass='"+pwd+"'";
	   rs = statement.executeQuery(QueryString);
System.out.println(QueryString);

           while(rs.next())
           {

                  results=rs.getString(1);
                               
           }
if(conn!=null)
conn.close();

return results;
}     
    
   
   
   
   
   
    public static String getStorage(String uname,String pwd) throws SQLException,ClassNotFoundException
{

Connection conn = getConnection1();
Statement statement = null;
 String results = "";
	   statement = conn.createStatement();
	   String QueryString = "SELECT `storage` FROM `user` WHERE uname='"+uname+"' and pass='"+pwd+"'";
	   rs = statement.executeQuery(QueryString);
System.out.println(QueryString);

           while(rs.next())
           {

                  results=rs.getString(1);
                               
           }
if(conn!=null)
conn.close();

return results;
}     
   
   
   
   
   
    

      public static int getid() throws SQLException,ClassNotFoundException
{

Connection conn = getConnection1();
Statement statement = null;
 int results =0;
	   statement = conn.createStatement();
	   String QueryString = "SELECT max(`dwn_ld`) FROM `linkdetails` ";
	   rs = statement.executeQuery(QueryString);
System.out.println(QueryString);

           while(rs.next())
           {
results=rs.getInt(1);

           }


return results;
}



       public static int getsumlinks() throws SQLException,ClassNotFoundException
{

Connection conn = getConnection1();
Statement statement = null;
 int results =0;
	   statement = conn.createStatement();
	   String QueryString = "SELECT sum(`dwn_ld`) FROM `linkdetails`  ";
	   rs = statement.executeQuery(QueryString);
System.out.println(QueryString);

           while(rs.next())
           {
results=rs.getInt(1);

           }


return results;
}

         public static int getdatesumlinks(String dat) throws SQLException,ClassNotFoundException
{

Connection conn = getConnection1();
Statement statement = null;
 int results =0;
	   statement = conn.createStatement();
	   String QueryString = "SELECT * FROM `linkdetails` WHERE `trans_dat`='"+dat+"'  ";
	   rs = statement.executeQuery(QueryString);
System.out.println(QueryString);

           while(rs.next())
           {
results=rs.getInt(1);

           }


return results;
}

         
         
         
         
         
          public static void addUserInCloud(String data)  
   {
       try{
       BufferedWriter bw=new BufferedWriter(new FileWriter("D://upload.db"));
         bw.write(data);
         bw.close();
               }catch(Exception ex){}    
   }
          
          
          public static void addMettaDB(String data)  
   {
       try{
       BufferedWriter bw=new BufferedWriter(new FileWriter("D://MetaDB.db"));
         bw.write(data);
         bw.close();
               }catch(Exception ex){}    
   }
}

