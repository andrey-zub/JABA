package emp_logic.emp_src;


import emp_logic.BD.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EMP extends bd {


    public EMP(boolean auto_commit) {
        try {

            this.setAutoCommit(auto_commit);
            this.db = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("SESSION: {  CONNECTION [open] }");

        } catch (Exception e) {
            this.err();
            e.printStackTrace();
        }

    }
        //--------------------------------------------EMP_SQL----------------------------------------------------------------------

        public void exec(String qr){

            String qr_info = "QUERY: ["+qr+"]\n";
            System.out.println(qr_info);
            try {
               db.execute(qr);
               System.out.println("///DONE\n");
            } catch (Exception e) {
                this.err();
                e.printStackTrace();
            }

        }

        public void selectPrepare(int start, int end)  {

            PreparedStatement prep = null;
            String qr = "select  * " +
                    "from java."+ '"' + "empFull" + '"' +
                    "where area between ? and ?";

            try {
                prep = conn.prepareStatement(qr);
                prep.setInt(1, start);
                prep.setInt(2, end);
                data = prep.executeQuery();

                    System.out.println(" ID | First name | Last name | Special |  Area | Salary");
                    while (data.next()){
                        System.out.println("____________________________________________");
                        System.out.print( data.getInt("id"));
                        System.out.print(" | " + data.getString("f_name"));
                        System.out.print(" | " + data.getString("l_name"));
                        System.out.print(" | " + data.getString("special"));
                        System.out.println(" | " + data.getInt("area"));
                        System.out.println(" | " + data.getDouble("salary"));
                    }
                prep.close();
            } catch (SQLException e) {   e.printStackTrace();   }
        }



        public void showEmpFull () {
            System.out.println("QUERY [ show all from empFull ]:");
            String quot = "'";
            char qut = '"';

            String qr = "select * from java." + qut +"empFull"+ qut +"\n";
            System.out.println(qr);

            try {
                data = db.executeQuery(qr);

                System.out.println(" ID | First name | Last name | Special |  Area | Salary");
                    while (data.next()){
                        System.out.println("____________________________________________");
                        System.out.print( data.getInt("id"));
                        System.out.print(" | " + data.getString("f_name"));
                        System.out.print(" | " + data.getString("l_name"));
                        System.out.print(" | " + data.getString("special"));
                        System.out.println(" | " + data.getInt("area"));
                        System.out.println(" | " + data.getDouble("salary"));

                    }
                System.out.println("///DONE\n");
            } catch (Exception e) {
                this.err();
                e.printStackTrace();
            }


        }

    public void showEmpPart () {
        System.out.println("QUERY [ show all from empPart ]:");
        String quot = "'";
        char qut = '"';

        String qr = "select * from java." + qut +"empPart"+ qut +"\n";
        System.out.println(qr);

        try {
            data = db.executeQuery(qr);
            System.out.println(" ID | First name | Last name | Special |  Area | Salary | Contract");
            while (data.next()){
                System.out.println("____________________________________________");
                System.out.print( data.getInt("id"));
                System.out.print(" | " + data.getString("f_name"));
                System.out.print(" | " + data.getString("l_name"));
                System.out.print(" | " + data.getString("special"));
                System.out.print(" | " + data.getInt("area"));
                System.out.print(" | " + data.getDouble("salary"));
                System.out.println(" | " + data.getString("Contract"));
            }
            System.out.println("///DONE\n");
        } catch (Exception e) {
            this.err();
            e.printStackTrace();
        }


    }


        public void create_new_empFull (String f_name, String l_name, String special,int area, double salary){

            int id = (int) (Math.random() * (area * 100 - area)) + area * 1000;

            String quot = "'";
            char qut = '"';

            String qr = "insert into java." + qut + "empFull" + qut + "(id,f_name,l_name,special,area,salary) \n" +
                    "values (" + id + "," + quot + f_name + quot + "," + quot + l_name + quot + "," + quot + special + quot + "," + area + "," + salary + ")\n";

            System.out.println("QUERY [ add new full-employee ]:");
            System.out.println(qr);
            try {

                this.db.execute(qr);

                System.out.println("///DONE\n");
            } catch (Exception e) {
                this.err();
                e.printStackTrace();
            }


        }


        public void create_new_empPart (String f_name, String l_name, String special,int area, double salary, int month)
        {

            int id = (int) (Math.random() * (area * 100 - area)) + area * 1000;

            String quot = "'";
            char qut = '"';

            String qr = "insert into java." + qut + "empPart" + qut + "(id,f_name,l_name,special,area,salary,contract) \n" +
                    "values (" + id + "," + quot + f_name + quot + "," + quot + l_name + quot + ",";
            qr += quot + special + quot + "," + area + "," + salary + ",";
            qr += quot + "for " + month + " month" + quot + ")";

            System.out.println("QUERY [ add new part-employee ]:");
            System.out.println(qr);
            try {

                this.db.execute(qr);

                System.out.println("///DONE");
            } catch (Exception e) {
                this.err();
                e.printStackTrace();
            }


        }


        public void add_empFull (emp_full emp,int col_num){

            int id = Integer.parseInt(emp.getRow(0).get(col_num).toString());
            String f_name = emp.getRow(1).get(col_num).toString();
            String l_name = emp.getRow(2).get(col_num).toString();
            String special = emp.getRow(3).get(col_num).toString();
            double area = Double.parseDouble(emp.getRow(4).get(col_num).toString());
            double salary = Double.parseDouble(emp.getRow(5).get(col_num).toString());

            String quot = "'";
            char qut = '"';

            String qr = "insert into java." + qut + "empFull" + qut + "(id,f_name,l_name,special,area,salary) \n" +
                    "values (" + id + "," + quot + f_name + quot + "," + quot + l_name + quot + "," + quot + special + quot + "," + area + "," + salary + ")\n";

            System.out.println("QUERY [ get data from csv about full-employee ]:");
            System.out.println(qr);
            try {

                this.db.execute(qr);

                System.out.println("///DONE");
            } catch (Exception e) {
                this.err();
                e.printStackTrace();
            }


        }


        public void add_empPart (emp_part emp,int col_num){

            int id = Integer.parseInt(emp.getRow(0).get(col_num).toString());
            String f_name = emp.getRow(1).get(col_num).toString();
            String l_name = emp.getRow(2).get(col_num).toString();
            String special = emp.getRow(3).get(col_num).toString();
            double area = Double.parseDouble(emp.getRow(4).get(col_num).toString());
            double salary = Double.parseDouble(emp.getRow(5).get(col_num).toString());
            String contract = emp.getRow(6).get(col_num).toString();

            String quot = "'";
            char qut = '"';

            String qr = "insert into java." + qut + "empPart" + qut + "(id,f_name,l_name,special,area,salary,contract)\n" +
                    "values (" + id + "," + quot + f_name + quot + "," + quot + l_name + quot + ",\n"
                    + quot + special + quot + "," + area + "," + salary + "," + quot + contract + quot + ")\n";

            System.out.println("QUERY [ get data from csv about part-employee ]:");
            System.out.println(qr);
            try {

                this.db.execute(qr);

                System.out.println("///DONE");
            } catch (Exception e) {
                this.err();
                e.printStackTrace();
            }

        }

    }

