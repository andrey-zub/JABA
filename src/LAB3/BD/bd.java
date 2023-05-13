package LAB3.BD;

import java.sql.*;
import java.util.Properties;

public class bd {

    protected String url = "jdbc:postgresql://localhost:5432/emp"; // url �� ��
    protected String user = "user"; //
    protected String pass = "qwerty"; //
    protected Properties auth = new Properties(); //
    protected Connection conn; //
    protected ResultSet data;
    protected Statement db; //

    // ����������� � ��
    public bd(){

        try{
            Class.forName("org.postgresql.Driver");

            auth.put("user", this.user);
            auth.put("password", this.pass);

            conn = DriverManager.getConnection( url,auth );
//            if(conn !=null){
//                System.out.println("*** SERVER: [ START ] ***\n");
//            }


        } catch (Exception e) {
            this.err();
            e.printStackTrace();
        }
    }

    // �������� ����� � ���������� �� ��
    public void kill(){

        try {
            if (data != null) data.close();
            if (conn != null) conn.close();
            if (db != null) db.close();
            System.out.println("SESSION: {  CONNECTION [close] }\n ");
//          System.out.println("*** SERVER: [ STOP ] ***\n");
        } catch (SQLException e) {
            this.err();
            e.printStackTrace();

        }

    }


    // ������������ ����-������ � ������
   public void setAutoCommit(boolean auto_comit){

        try {
            this.conn.setAutoCommit(auto_comit);
//            System.out.println("SESSION: { AUTO_COMMIT "+ auto_comit +" }\n");
        } catch (SQLException e) {
            this.err();
            e.printStackTrace();

        }

    }

    // ��������� �� ������
    protected void err(){
        System.out.println("********************************");
        System.out.println("SERVER: !ERR!\n");
        System.out.println("********************************");
    }

}
